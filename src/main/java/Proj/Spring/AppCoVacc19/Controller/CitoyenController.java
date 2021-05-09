package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Service.CitoyenService;

@RestController
public class CitoyenController {

	@Autowired
	private CitoyenService CitoyenService;

	//SELECT
	@RequestMapping("/Citoyen")
	public List<Citoyen> SelectCitoyen(){
		return  CitoyenService.SelectCitoyen();
		
	}
	
	//DELETE
	@RequestMapping(method= RequestMethod.DELETE , value="/Citoyen/{id}")
	public void DeleteCitoyen(@PathVariable int id) {
		CitoyenService.DeleteCitoyen(id);
		System.out.println("Citoyen supprimé !");
		
	}
	
	//UPDATE
	@RequestMapping(method= RequestMethod.PUT , value="/Citoyen")
	public void UpdateCitoyen(@RequestBody Citoyen citoyen) {
		CitoyenService.UpdateCitoyen(citoyen);
		System.out.println("Citoyen modifié !");

	}
	
	//ADD
	@RequestMapping(method= RequestMethod.POST , value="/Citoyen")
	public void AddCitoyen(@RequestBody Citoyen citoyen) {
		CitoyenService.AddCitoyen(citoyen);
		System.out.println("Citoyen ajouté !");

	}
}
