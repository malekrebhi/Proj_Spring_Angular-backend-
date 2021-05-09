package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.List;

import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Repository.CitoyenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitoyenService {
	
	@Autowired
	private CitoyenRepository  CitoyenRepository;

	//SELECT
	public List<Citoyen> SelectCitoyen(){
		List<Citoyen> citoyns=new ArrayList<>();
		CitoyenRepository.findAll().forEach(citoyns::add);
		return citoyns;
	}

	//ADD
	public void AddCitoyen(Citoyen citoyen) {
		CitoyenRepository.save(citoyen);
	}

	//UPDATE
	public Citoyen UpdateCitoyen(Citoyen citoyen) {
		Citoyen existingCentre= CitoyenRepository.findById(citoyen.getCIN_C()).orElse(null);
		existingCentre.setCIN_C(citoyen.getCIN_C());
		existingCentre.setNom_C(citoyen.getNom_C());
		existingCentre.setPrenom_C(citoyen.getPrenom_C());
		existingCentre.setDateNaiss_C(citoyen.getDateNaiss_C());
		existingCentre.setTel_C(citoyen.getTel_C());
		existingCentre.setEtat(citoyen.isEtat());
		return CitoyenRepository.save(existingCentre);
	}

	//DELETE
	public void DeleteCitoyen(int id) {
		CitoyenRepository.deleteById(id);	
		System.out.println("Citoyen removed "+id);

	}
}
