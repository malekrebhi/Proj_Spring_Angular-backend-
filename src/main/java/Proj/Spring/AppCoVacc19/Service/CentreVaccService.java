package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Entity.Centre_Vaccination;
import Proj.Spring.AppCoVacc19.Exception.AdminNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.CentreVaccNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Repository.CentreVaccRepository;

@Service
public class CentreVaccService {
	
	@Autowired
	private CentreVaccRepository CentreVaccRepository;
	
	//GET
	public List<Centre_Vaccination> SelectCentre(){
		List<Centre_Vaccination> centres=new ArrayList<>();
		CentreVaccRepository.findAll().forEach(centres::add);
		if (centres.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return centres;
	}

	// GET by ID
	public ResponseEntity<Centre_Vaccination> getCentreById(@PathVariable int idCentre){
		Centre_Vaccination centre=CentreVaccRepository.findById(idCentre).orElseThrow(() -> new CentreVaccNotFoundException("Centre does not exist :"+idCentre));
	    return ResponseEntity.ok(centre);
	}

	
	//ADD
	public void AddCentre(Centre_Vaccination centre) {
		if(centre.getNomCentre().isEmpty() || centre.getAdresseCentre().isEmpty()) {
			throw new EmptyInputException("601");}
		CentreVaccRepository.save(centre);
	}

	//UPDATE
	public ResponseEntity<Centre_Vaccination> UpdateCentre(int idCentre,Centre_Vaccination centre) {
		Centre_Vaccination existingCentre= CentreVaccRepository.findById(idCentre).orElseThrow(() -> new CentreVaccNotFoundException("centre does not exist with cin :"+idCentre));
		existingCentre.setNomCentre(centre.getNomCentre());
		existingCentre.setAdresseCentre(centre.getAdresseCentre());
		existingCentre.setNbPersonnel(centre.getNbPersonnel());
		existingCentre.setAdmin(centre.getAdmin());
		existingCentre.setStockVacc(centre.getStockVacc());
		Centre_Vaccination updatedCentre= CentreVaccRepository.save(existingCentre);
		return ResponseEntity.ok(updatedCentre);
	}

	//DELETE
	public ResponseEntity<Map<String,Boolean>> deleteCentre(@PathVariable int idCentre){
		Centre_Vaccination centre=CentreVaccRepository.findById(idCentre).orElseThrow(() -> new CentreVaccNotFoundException("Centre does not exist :"+idCentre));
		CentreVaccRepository.delete(centre);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	

}
