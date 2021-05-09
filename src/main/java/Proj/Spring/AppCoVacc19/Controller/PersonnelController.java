package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Entity.Personnel;
import Proj.Spring.AppCoVacc19.Service.PersonnelService;

@RestController
public class PersonnelController {

	@Autowired
	private PersonnelService PersonnelService;

	//SELECT
	@RequestMapping("/Personnel")
	public List<Personnel> SelectPersonnel(){
		return PersonnelService.SelectPersonnel();
		
	}
	
	//DELETE
	@RequestMapping(method= RequestMethod.DELETE , value="/Personnel/{id}")
	public void DeletePersonnel(@PathVariable int id) {
		PersonnelService.DeletePersonnel(id);
		System.out.println("Personnel supprimé !");

	}
	
	//UPDATE
	@RequestMapping(method= RequestMethod.PUT , value="/Personnel")
	public void UpdatePersonnel(@RequestBody Personnel personnel) {
			PersonnelService.UpdatePersonnel(personnel);
			System.out.println("Personnel modifié !");

	}
	
	//ADD
	@RequestMapping(method= RequestMethod.POST , value="/Personnel")
	public void AddPersonnel(@RequestBody Personnel personnel) {
			PersonnelService.AddPersonnel(personnel);
			System.out.println("Personnel ajouté !");

	}

}
