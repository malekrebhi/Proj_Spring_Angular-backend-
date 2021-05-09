package Proj.Spring.AppCoVacc19.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Proj.Spring.AppCoVacc19.Entity.Administrateur;


public interface AdminRepository  extends JpaRepository<Administrateur,Integer> {

	
}
