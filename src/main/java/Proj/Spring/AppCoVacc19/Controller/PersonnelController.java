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

import Proj.Spring.AppCoVacc19.Entity.Personnel;
import Proj.Spring.AppCoVacc19.Service.PersonnelService;

@RestController
public class PersonnelController {

	@Autowired
	private PersonnelService PersonnelService;

	@CrossOrigin

	
	//GET
	@GetMapping("/Personnel")
	public List<Personnel> SelectPersonnel(){
		return PersonnelService.SelectPersonnel();
		
	}
	
	//GET by ID
	@GetMapping("/Personnel/{idPersonnel}")
	public ResponseEntity<Personnel> getPersonnelById(@PathVariable int idPersonnel){
		return 	PersonnelService.getPersonnelById(idPersonnel);

	}
	
	
	
	//DELETE
	@DeleteMapping("/Personnel/{idPersonnel}")
	public ResponseEntity<Map<String,Boolean>> deletePersonnel(@PathVariable int idPersonnel){
		return PersonnelService.deletePersonnel(idPersonnel);
	}
	
	//UPDATE
	@PutMapping("/Personnel/{idPersonnel}")
	public void UpdatePersonnel(@PathVariable int idPersonnel,@RequestBody Personnel personnel) {
			PersonnelService.UpdatePersonnel(idPersonnel,personnel);
			System.out.println("Personnel modifié !");

	}
	
	//ADD
	@PostMapping("/Personnel")
	public void AddPersonnel(@RequestBody Personnel personnel) {
			PersonnelService.AddPersonnel(personnel);
			System.out.println("Personnel ajouté !");

	}
	
	//*

}
