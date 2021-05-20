package Proj.Spring.AppCoVacc19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Proj.Spring.AppCoVacc19.Entity.Rendez_vous;

public interface RendezVousRepository  extends JpaRepository<Rendez_vous,Integer>{
	
	public boolean existsRendezVousByDateRDV(String date);

}
