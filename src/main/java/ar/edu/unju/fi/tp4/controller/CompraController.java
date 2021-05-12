package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.service.ICompraService;

@Controller
public class CompraController {

	@Autowired
	private Compra compra;
	
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;

    @GetMapping("/compra/nuevo")
	public String nuevoCompra(Model model) {
		model.addAttribute(compra);
		return "compraForm";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView Guardar(@ModelAttribute("compra") Compra compra) {
		ModelAndView model = new ModelAndView("compras");		
		compraService.agregarCompra(compra);		
		//model.addObject("compras",compraService.listadoCargado());
		model.addObject("compra", compraService.getCompra());
		return model;		
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView mostrarListado() {
		ModelAndView model = new ModelAndView("listado");
		model.addObject("compra", compraService.getCompra());
		return model;
	}
		
}
