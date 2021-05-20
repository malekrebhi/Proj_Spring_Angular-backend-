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

import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Service.CitoyenService;

@RestController
public class CitoyenController {

	@Autowired
	private CitoyenService CitoyenService;

	@CrossOrigin

	
	// GET
	@GetMapping("/Citoyen")
	public List<Citoyen> SelectCitoyen(){
		return  CitoyenService.SelectCitoyen();
		
	}
	
	//GET by ID
	@GetMapping("/Citoyen/{idCitoyen}")
	public ResponseEntity<Citoyen> getCitoyenById(@PathVariable int idCitoyen){
		return 	CitoyenService.getCitoyenById(idCitoyen);

	}
	
	//DELETE
	@DeleteMapping("/Citoyen/{idCitoyen}")
	public ResponseEntity<Map<String,Boolean>> deleteCitoyen(@PathVariable int idCitoyen){
		return CitoyenService.deleteCitoyen(idCitoyen);
	}
	
	//UPDATE
	@PutMapping("/Citoyen/{idCitoyen}")
	public void UpdateCitoyen(@PathVariable int idCitoyen,@RequestBody Citoyen citoyen) {
		CitoyenService.UpdateCitoyen(idCitoyen,citoyen);
		System.out.println("Citoyen modifié !");

	}
	
	//ADD
	@PostMapping("/Citoyen")
	public void AddCitoyen(@RequestBody Citoyen citoyen) {
		CitoyenService.AddCitoyen(citoyen);
		System.out.println("Citoyen ajouté !");

	}
	
}
