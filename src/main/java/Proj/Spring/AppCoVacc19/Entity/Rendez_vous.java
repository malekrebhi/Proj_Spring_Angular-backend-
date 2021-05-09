package Proj.Spring.AppCoVacc19.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//@Component

@Entity
@Table(name = "Rendez_vous")
public class Rendez_vous {
//Rendez-vous(idRDV, dateRDV, #CIN_C)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRDV" , unique=true)
	private int idRDV;
	@Column(name = "dateRDV")
	private Date dateRDV;
	@OneToOne
	private Citoyen citoyen;
	public Rendez_vous(Date dateRDV, Citoyen citoyen) {
		super();
		//this.idRDV = idRDV;
		this.dateRDV = dateRDV;
		this.citoyen = citoyen;
	}
	public Rendez_vous() {
		super();
	}
	public int getIdRDV() {
		return idRDV;
	}
	public void setIdRDV(int idRDV) {
		this.idRDV = idRDV;
	}
	public Date getDateRDV() {
		return dateRDV;
	}
	public void setDateRDV(Date dateRDV) {
		this.dateRDV = dateRDV;
	}
	public Citoyen getCitoyen() {
		return citoyen;
	}
	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
	@Override
	public String toString() {
		return "Rendez_vous [idRDV=" + idRDV + ", dateRDV=" + dateRDV + ", citoyen=" + citoyen + "]";
	}
}
