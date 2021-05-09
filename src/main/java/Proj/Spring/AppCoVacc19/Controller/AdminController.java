package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService AdminService;

	//SELECT
	@RequestMapping("/Admin")
	public List<Administrateur> SelectAdmin(){
		return AdminService.SelectAdmin();
		
	}
	
	//DELETE
	@RequestMapping(method= RequestMethod.DELETE , value="/Admin/{id}")
	public void DeleteAdmin(@PathVariable int id) {
		AdminService.DeleteAdmin(id);
		System.out.println("Admin supprimé !");
	}
	
	//UPDATE
	@RequestMapping(method= RequestMethod.PUT , value="/Admin")
	public void UpdateAdmin(@RequestBody Administrateur admin) {
		AdminService.UpdateAdmin(admin);
		System.out.println("Admin modifié !");

	}
	
	//ADD
	@RequestMapping(method= RequestMethod.POST , value="/Admin")
	public void AddAdmin(@RequestBody Administrateur admin) {
		AdminService.AddAdmin(admin);
		System.out.println("Admin ajouté !");

	}



}
