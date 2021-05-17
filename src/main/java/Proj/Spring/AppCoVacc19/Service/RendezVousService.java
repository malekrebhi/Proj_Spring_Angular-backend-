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
import Proj.Spring.AppCoVacc19.Entity.Rendez_vous;
import Proj.Spring.AppCoVacc19.Exception.AdminNotFoundException;
import Proj.Spring.AppCoVacc19.Exception.EmptyInputException;
import Proj.Spring.AppCoVacc19.Exception.NoArgumentsFoundException;
import Proj.Spring.AppCoVacc19.Exception.RdVNotFoundException;
import Proj.Spring.AppCoVacc19.Repository.RendezVousRepository;

@Service
public class RendezVousService {
	
	@Autowired
	private RendezVousRepository RendezVousRepository;
	
	//GET
	public List<Rendez_vous> SelectRendezVous(){
		List<Rendez_vous> rdvs=new ArrayList<>();
		RendezVousRepository.findAll().forEach(rdvs::add);
		if (rdvs.isEmpty()) {
			throw new NoArgumentsFoundException("600");
		}
		return rdvs;
	}
	
	
	// GET by ID
	public ResponseEntity<Rendez_vous> getRdvById(@PathVariable int idRDV){
		Rendez_vous rdv=RendezVousRepository.findById(idRDV).orElseThrow(() -> new RdVNotFoundException("Rendez-vous does not exist :"+idRDV));
		return ResponseEntity.ok(rdv);
		}



	//ADD
	public void AddRDV(Rendez_vous rdv) {
		if (rdv.getDateRDV().isEmpty()) {
			throw new EmptyInputException("601");
		}
		RendezVousRepository.save(rdv);
	}


	//UPDATE
	public ResponseEntity<Rendez_vous> UpdateRDV(int idRDV,Rendez_vous rdv) {
		Rendez_vous existingrdv= RendezVousRepository.findById(idRDV).orElseThrow(() -> new RdVNotFoundException("Rendez-Vous does not exist with cin :"+idRDV));
		existingrdv.setDateRDV(rdv.getDateRDV());
		existingrdv.setCitoyen(rdv.getCitoyen());
		Rendez_vous updatedRdV= RendezVousRepository.save(existingrdv);
		return ResponseEntity.ok(updatedRdV);
	}


	//DELETE
	public ResponseEntity<Map<String,Boolean>> deleteRdv(@PathVariable int idRDV){
		Rendez_vous rdv=RendezVousRepository.findById(idRDV).orElseThrow(() -> new RdVNotFoundException("Rendez-vous does not exist :"+idRDV));
		RendezVousRepository.delete(rdv);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
