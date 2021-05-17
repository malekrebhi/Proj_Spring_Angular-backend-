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

import  Proj.Spring.AppCoVacc19.Entity.Rendez_vous;
import  Proj.Spring.AppCoVacc19.Service.RendezVousService;

@RestController
public class RendezVousController {
	
	@Autowired
	private RendezVousService RendezVousService;

	@CrossOrigin
	
	//GET
	@GetMapping("/RendezVous")
	public List<Rendez_vous> SelectRendezVous(){
	    return RendezVousService.SelectRendezVous();
		
	}
	
	
	//GET by ID
	@GetMapping("/RendezVous/{idRDV}")
	public ResponseEntity<Rendez_vous> getRdvById(@PathVariable int idRDV){	
		return 	RendezVousService.getRdvById(idRDV);

		}
	
	
	//DELETE
	@DeleteMapping("/RendezVous/{idRDV}")
	public ResponseEntity<Map<String,Boolean>> deleteRdv(@PathVariable int idRDV){
		return RendezVousService.deleteRdv(idRDV);
	}
	
	//UPDATE
	@PutMapping("/RendezVous/{idRDV}")
	public void UpdateRDV(@PathVariable int idRDV,@RequestBody Rendez_vous rdv) {
		RendezVousService.UpdateRDV(idRDV,rdv);
		System.out.println("RdV modifié !");

	}
	
	//ADD
	@PostMapping("/RendezVous")
	public void AddRDV(@RequestBody Rendez_vous rdv) {
		RendezVousService.AddRDV(rdv);
		System.out.println("RdV ajouté !");

	}



//**
}
