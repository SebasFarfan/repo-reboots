package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.IProductoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CompraController {
    
    @Autowired
    private Compra compra;

    @Autowired    
    private IProductoService productoService;

    @Autowired
    @Qualifier("compraUtilService")
    private ICompraService compraService;

    @GetMapping("/compra")
    public String getFormCompra(Model model) {
        model.addAttribute("compra", compra);
        model.addAttribute("productos", productoService.getProductos());        
        return "nuevoCompra";
    }
    
    @GetMapping("/compra/busqueda")
    public String resolverTotal(Model model, @RequestParam(name = "id") String id, @RequestParam(name = "cant") String cant){
        int cod = Integer.parseInt(id);
        int cantidad = Integer.parseInt(cant);
        double precio = 0;
        for (Producto p : productoService.getProductos()) {
            if(p.getCodigo()==cod){
                precio = p.getPrecio()*cantidad;
                break; 
            }
        }        
        model.addAttribute("total", precio);
        return "nuevoCompra :: totalCompra";
    }
    
    @PostMapping("/compra/guardar")
    public ModelAndView guardar(@ModelAttribute("compra") Compra compra){
        ModelAndView modelo = new ModelAndView("compras");
        //compra.setTotal(this.obtenerTotal(compra.getProducto().getCodigo(), compra.getCantidad()));
        this.compraService.agregarCompra(completarDatosCompra(compra.getProducto().getCodigo(), compra.getCantidad(), compra));
        modelo.addObject("compras", compraService.getCompra());
        return modelo;
    }

    private Compra completarDatosCompra(int cod, int cant, Compra compra){
        double total=0;
        for (Producto p : productoService.getProductos()) {
            if(p.getCodigo()==cod){        
                compra.getProducto().setNombre(p.getNombre());        
                total = p.getPrecio()*cant;
                compra.setTotal(total);
                break;
            }
        }
        return compra;
    }

}
