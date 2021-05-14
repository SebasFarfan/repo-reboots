package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.IProductoService;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CompraController {
    
    @Autowired
    private Compra compra;

    @Autowired
    private IProductoService productoService;


    @GetMapping("/compra")
    public String getFormCompra(Model model) {
        model.addAttribute("compra", compra);
        model.addAttribute("productos", productoService.getProductos());
        return "nuevoCompra";
    }
    

}
