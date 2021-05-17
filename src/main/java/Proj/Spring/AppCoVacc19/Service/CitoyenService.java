package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Proj.Spring.AppCoVacc19.Entity.Administrateur;
import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Exception.AdminNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.CitoyenNotFoundException;
import Proj.Spring.AppCoVacc19.Repository.CitoyenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CitoyenService {
	
	@Autowired
	private CitoyenRepository  CitoyenRepository;

	//GET
	public List<Citoyen> SelectCitoyen(){
		List<Citoyen> citoyns=new ArrayList<>();
		CitoyenRepository.findAll().forEach(citoyns::add);
		return citoyns;
	}

	
	//GET by ID
	public ResponseEntity<Citoyen> getCitoyenById(@PathVariable int idCitoyen){
		Citoyen citoyen=CitoyenRepository.findById(idCitoyen).orElseThrow(() -> new CitoyenNotFoundException("Citoyen does not exist :"+idCitoyen));
	    return ResponseEntity.ok(citoyen);
	}
	
	
	//ADD
	public void AddCitoyen(Citoyen citoyen) {
		CitoyenRepository.save(citoyen);
	}

	//UPDATE
	public  ResponseEntity<Citoyen> UpdateCitoyen(int idCitoyen,Citoyen citoyen) {
		Citoyen existingCentre= CitoyenRepository.findById(idCitoyen).orElseThrow(() -> new CitoyenNotFoundException("Citoyen does not exist with cin :"+idCitoyen));
		existingCentre.setCIN_C(citoyen.getCIN_C());
		existingCentre.setNom_C(citoyen.getNom_C());
		existingCentre.setPrenom_C(citoyen.getPrenom_C());
		existingCentre.setDateNaiss_C(citoyen.getDateNaiss_C());
		existingCentre.setTel_C(citoyen.getTel_C());
		existingCentre.setEtat(citoyen.isEtat());
		Citoyen updatedCitoyen= CitoyenRepository.save(existingCentre);
		return  ResponseEntity.ok(updatedCitoyen);
	}

	//DELETE
	public ResponseEntity<Map<String,Boolean>> deleteCitoyen(@PathVariable int idCitoyen){
		Citoyen citoyen=CitoyenRepository.findById(idCitoyen).orElseThrow(() -> new CitoyenNotFoundException("Citoyen does not exist :"+idCitoyen));
		CitoyenRepository.delete(citoyen);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
