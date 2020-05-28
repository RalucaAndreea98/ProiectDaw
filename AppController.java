package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
	@Autowired
private ProductService service;
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Produs> listProducts=service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		
		return "index";
	}
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Produs produs=new Produs();
		model.addAttribute("produs", produs);
		
		return "new_produs";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("produs") Produs produs) {
		service.save(produs);
		
		return "redirect:/";
	}
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable (name= "id") Long id){
	ModelAndView mav= new ModelAndView("edit_produs");
	
	Produs produs =service.get(id);
	mav.addObject("produs", produs);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable (name= "id") Long id) {
		service.delete(id);
		
		return "redirect:/";
	}
	
	
	}
	

