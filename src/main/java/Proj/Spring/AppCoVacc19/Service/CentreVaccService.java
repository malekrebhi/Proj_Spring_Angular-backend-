package Proj.Spring.AppCoVacc19.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proj.Spring.AppCoVacc19.Entity.Centre_Vaccination;
import Proj.Spring.AppCoVacc19.Repository.CentreVaccRepository;

@Service
public class CentreVaccService {
	
	@Autowired
	private CentreVaccRepository CentreVaccRepository;
	
	public List<Centre_Vaccination> SelectCentre(){
		List<Centre_Vaccination> centres=new ArrayList<>();
		CentreVaccRepository.findAll().forEach(centres::add);
		return centres;
	}

	//ADD
	public void AddCentre(Centre_Vaccination centre) {
		CentreVaccRepository.save(centre);
	}

	//UPDATE
	public Centre_Vaccination UpdateCentre(Centre_Vaccination centre) {
		Centre_Vaccination existingCentre= CentreVaccRepository.findById(centre.getIdCentre()).orElse(null);
		existingCentre.setNomCentre(centre.getNomCentre());
		existingCentre.setAdresseCentre(centre.getAdresseCentre());
		existingCentre.setNbPersonnel(centre.getNbPersonnel());
		existingCentre.setAdmin(centre.getAdmin());
		existingCentre.setStockVacc(centre.getStockVacc());
		return CentreVaccRepository.save(existingCentre);
	}

	//DELETE
	public void DeleteCentre(int id) {
		CentreVaccRepository.deleteById(id);	
		System.out.println("Centre removed "+id);

	}
	

}
