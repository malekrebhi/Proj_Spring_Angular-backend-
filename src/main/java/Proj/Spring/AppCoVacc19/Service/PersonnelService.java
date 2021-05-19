package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Proj.Spring.AppCoVacc19.Entity.Personnel;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Exception.PersonnelNotFoundException;
import Proj.Spring.AppCoVacc19.Repository.PersonnelRepository;

@Service
public class PersonnelService {

	@Autowired
	private PersonnelRepository PersonnelRepository;
	
	//GET
	public List<Personnel> SelectPersonnel(){
		List<Personnel> personnels=new ArrayList<>();
		PersonnelRepository.findAll().forEach(personnels::add);
		if (personnels.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return personnels;
	}
	
	//GET by ID
	public ResponseEntity<Personnel> getPersonnelById(@PathVariable int idPersonnel){
		Personnel personnel=PersonnelRepository.findById(idPersonnel).orElseThrow(() -> new PersonnelNotFoundException("Personnel does not exist :"+idPersonnel));
		return ResponseEntity.ok(personnel);
	}
		

	//ADD
	public void AddPersonnel(Personnel personnel) {
		if(personnel.getAdresse_P().isEmpty() || personnel.getDateNaiss_P().equals(null) || personnel.getNom_P().isEmpty() || personnel.getPrenom_P().isEmpty()) {
			throw new EmptyInputException("601");}
		PersonnelRepository.save(personnel);
	}

	//UPDATE
	public ResponseEntity<Personnel> UpdatePersonnel(int idPersonnel,Personnel personnel) {
		Personnel existingPersonnel= PersonnelRepository.findById(idPersonnel).orElseThrow(() -> new PersonnelNotFoundException("Personnel does not exist with cin :"+idPersonnel));
		existingPersonnel.setCIN_P(personnel.getCIN_P());
		existingPersonnel.setNom_P(personnel.getNom_P());
		existingPersonnel.setPrenom_P(personnel.getPrenom_P());
		existingPersonnel.setAdresse_P(personnel.getAdresse_P());
		existingPersonnel.setDateNaiss_P(personnel.getDateNaiss_P());
		existingPersonnel.setTel_P(personnel.getTel_P());
		existingPersonnel.setHoraire_P(personnel.getHoraire_P());
		existingPersonnel.setSalaire_P(personnel.getSalaire_P());
		Personnel updatedPersonnel= PersonnelRepository.save(existingPersonnel);
		return ResponseEntity.ok(updatedPersonnel);
	}

	//DELETE
	public ResponseEntity<Map<String,Boolean>> deletePersonnel(@PathVariable int idPersonnel){
		Personnel personnel=PersonnelRepository.findById(idPersonnel).orElseThrow(() -> new PersonnelNotFoundException("Personnel does not exist :"+idPersonnel));
		PersonnelRepository.delete(personnel);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
