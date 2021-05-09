package Proj.Spring.AppCoVacc19.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Component

@Entity
@Table(name="Citoyen")
public class Citoyen  {
//CIN_C,nom_C,prenom_C,adresse_C, dateNaiss_C, tel_C, etat
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CIN_C" , unique=true)
	private int CIN_C;
	@Column(name = "nom_C")
	private String nom_C;
	@Column(name = "prenom_C")
	private String prenom_C;
	@Column(name = "dateNaiss_C")
	private Date dateNaiss_C;
	@Column(name = "tel_C" , length=8)
	private int tel_C;
	@Column(name = "etat")
	private boolean etat=false;
	public Citoyen(String nom_C, String prenom_C, Date dateNaiss_C, int tel_C) {
		super();
		//CIN_C = cIN_C;
		this.nom_C = nom_C;
		this.prenom_C = prenom_C;
		this.dateNaiss_C = dateNaiss_C;
		this.tel_C = tel_C;
	}
	public Citoyen() {
		super();
	}
	public int getCIN_C() {
		return CIN_C;
	}
	public void setCIN_C(int cIN_C) {
		CIN_C = cIN_C;
	}
	public String getNom_C() {
		return nom_C;
	}
	public void setNom_C(String nom_C) {
		this.nom_C = nom_C;
	}
	public String getPrenom_C() {
		return prenom_C;
	}
	public void setPrenom_C(String prenom_C) {
		this.prenom_C = prenom_C;
	}
	public Date getDateNaiss_C() {
		return dateNaiss_C;
	}
	public void setDateNaiss_C(Date dateNaiss_C) {
		this.dateNaiss_C = dateNaiss_C;
	}
	public int getTel_C() {
		return tel_C;
	}
	public void setTel_C(int tel_C) {
		this.tel_C = tel_C;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	@Override
	public String toString() {
		return "Citoyen [CIN_C=" + CIN_C + ", nom_C=" + nom_C + ", prenom_C=" + prenom_C + ", dateNaiss_C="
				+ dateNaiss_C + ", tel_C=" + tel_C + ", etat=" + etat + "]";
	}
}
