package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService AdminService;

	@CrossOrigin
	
	//GET 
	@GetMapping("/Admin")
	public List<Administrateur> SelectAdmin(){
		return AdminService.SelectAdmin();
		
	}
	

	//GET by ID
	@GetMapping("/Admin/{idAdmin}")
	public ResponseEntity<Administrateur> getAdminById(@PathVariable int idAdmin){	
		return 	AdminService.getAdminById(idAdmin);

	}
	 
	
	//DELETE
	@DeleteMapping( "/Admin/{idAdmin}")
	public ResponseEntity<Map<String,Boolean>> deleteAdmin(@PathVariable int idAdmin){
		return AdminService.deleteAdmin(idAdmin);
	}
	
	//UPDATE
	@PutMapping("/Admin/{idAdmin}")
	public void UpdateAdmin(@PathVariable int idAdmin,@RequestBody Administrateur admin) {
		AdminService.UpdateAdmin(idAdmin,admin);
		System.out.println("Admin modifié !");

	}
	
	//ADD
	
	@PostMapping("/Admin")
	public void AddAdmin(@RequestBody Administrateur admin) {
		AdminService.AddAdmin(admin);
		System.out.println("Admin ajouté !");

	}

//*

}