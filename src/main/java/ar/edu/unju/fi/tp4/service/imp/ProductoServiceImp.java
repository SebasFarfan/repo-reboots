package ar.edu.unju.fi.tp4.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;

/**
 * clase que implementa la interface IProductoService
 */
@Service
public class ProductoServiceImp implements IProductoService {

    private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);

    private List<Producto> listaProducto = new ArrayList<Producto>();

    @Override
    public void agregarProducto(Producto producto) {
        listaProducto.add(producto);
        LOGGER.info("METHOD: agregarProducto(producto) - se agregó un producto al listado -->"
                + listaProducto.get(listaProducto.size() - 1));
        
    }

    @Override
    public Producto obtenerUltimoProducto() {
        Producto producto = listaProducto.get(listaProducto.size() - 1);
        LOGGER.info(
                "METHOD: obtenerUltimoProducto() - se obtiene el ultimo producto agregado a la lista -->" + producto);
        return producto;
    }

    @Override
    public List<Producto> getProductos() {
        Producto p1 = new Producto(555, "Mouse inalambrico", 600, "Noga", 20);
        Producto p2 = new Producto(555, "Disco SSD 250GB", 5600, "WD", 10);
        Producto p3 = new Producto(555, "Pendrive 32GB", 2500, "Kington", 20);
        listaProducto.add(p1);
        listaProducto.add(p2);
        listaProducto.add(p3);
        return listaProducto;
    }
    
}
