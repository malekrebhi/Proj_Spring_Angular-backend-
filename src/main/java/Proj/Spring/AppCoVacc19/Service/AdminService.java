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
import Proj.Spring.AppCoVacc19.Exception.AdminNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository AdminRepository;
	
	//GET
	public List<Administrateur> SelectAdmin(){
		List<Administrateur> admins=new ArrayList<>();
		AdminRepository.findAll().forEach(admins::add);
		if (admins.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return admins;
	}
	
	
	// GET by ID
	public ResponseEntity<Administrateur> getAdminById(@PathVariable int idAdmin){
		Administrateur admin=AdminRepository.findById(idAdmin).orElseThrow(() -> new AdminNotFoundException("Admin does not exist :"+idAdmin));
		return ResponseEntity.ok(admin);
	}

	
	
	//ADD
	public void AddAdmin(Administrateur admin) {
		if(admin.getNom_A().isEmpty() ||admin.getPrenom_A().isEmpty() ||admin.getAdresse_A().isEmpty() ) {
			throw new EmptyInputException("601");}
		AdminRepository.save(admin);
	}

	//UPDATE
	public ResponseEntity<Administrateur> UpdateAdmin(int idAdmin, Administrateur admin) {
		Administrateur existingAdministrateur= AdminRepository.findById(idAdmin).orElseThrow(() -> new AdminNotFoundException("Admin does not exist with cin :"+idAdmin));
		existingAdministrateur.setCIN_A(admin.getCIN_A());
		existingAdministrateur.setNom_A(admin.getNom_A());
		existingAdministrateur.setPrenom_A(admin.getPrenom_A());
		existingAdministrateur.setAdresse_A(admin.getAdresse_A());
		existingAdministrateur.setDateNaiss_A(admin.getDateNaiss_A());
		existingAdministrateur.setTel_A(admin.getTel_A());
		existingAdministrateur.setMatricule(admin.getMatricule());
		Administrateur updatedAdmin= AdminRepository.save(existingAdministrateur);
		return ResponseEntity.ok(updatedAdmin);
	}

	//DELETE
	public ResponseEntity<Map<String,Boolean>> deleteAdmin(@PathVariable int idAdmin){
		Administrateur admin=AdminRepository.findById(idAdmin).orElseThrow(() -> new AdminNotFoundException("Admin does not exist :"+idAdmin));
		AdminRepository.delete(admin);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
} 

