package Proj.Spring.AppCoVacc19.Controller;

import Proj.Spring.AppCoVacc19.Entity.Centre_Vaccination;
import Proj.Spring.AppCoVacc19.Service.CentreVaccService;

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

@RestController
public class CentreVaccController {
	
	@Autowired
	private CentreVaccService  CentreVaccService;
	
	@CrossOrigin


	//GET
	@GetMapping("/Centre")
	public List<Centre_Vaccination> SelectCentre(){
		return CentreVaccService.SelectCentre();
		
	}
	
	//GET by ID
	@GetMapping("/Centre/{idCentre}")
	public ResponseEntity<Centre_Vaccination> getCentreById(@PathVariable int idCentre){	
		return 	CentreVaccService.getCentreById(idCentre);

	}
	
	//DELETE
	@DeleteMapping("/Centre/{idCentre}")
	public ResponseEntity<Map<String,Boolean>> deleteCentre(@PathVariable int idCentre){
		return CentreVaccService.deleteCentre(idCentre);
	}
	
	//UPDATE
	@PutMapping("/Centre/{idCentre}")
    public void UpdateCentre(@PathVariable int idCentre,@RequestBody Centre_Vaccination centre) {
		CentreVaccService.UpdateCentre(idCentre,centre);
		System.out.println("Centre modifié !");

	}

	
	//ADD
	@PostMapping("/Centre")
    public void AddCentre(@RequestBody Centre_Vaccination centre) {
		CentreVaccService.AddCentre(centre);
		System.out.println("Centre ajouté !");

	}
//*
}
