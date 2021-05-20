package Proj.Spring.AppCoVacc19.Entity;


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
	@Column(name = "idCitoyen" , unique=true)
	private int idCitoyen;
	
	
	@Column(name = "CIN_C" )
	private int CIN_C;
	
	@Column(name = "nom_prenom_C ")
	private String nom_prenom_C;
	
	@Column(name = "mail_C")
	private String mail_C;
	
	@Column(name = "dateNaiss_C")
	private String dateNaiss_C;
	
	@Column(name = "tel_C" , length=8)
	private int tel_C;
	
	@Column(name = "etat")
	private boolean etat=false;
	
	
	public Citoyen(int cIN_C, String nom_prenom_C, String mail_C, String dateNaiss_C, int tel_C, boolean etat) {
		super();
		CIN_C = cIN_C;
		this.nom_prenom_C = nom_prenom_C;
		this.mail_C = mail_C;
		this.dateNaiss_C = dateNaiss_C;
		this.tel_C = tel_C;
		this.etat = etat;
	}
	public Citoyen() {
		super();
	}
	public int getIdCitoyen() {
		return idCitoyen;
	}
	public void setIdCitoyen(int idCitoyen) {
		this.idCitoyen = idCitoyen;
	}
	public int getCIN_C() {
		return CIN_C;
	}
	public void setCIN_C(int cIN_C) {
		CIN_C = cIN_C;
	}
	

	public String getNom_prenom_C() {
		return nom_prenom_C;
	}
	public void setNom_prenom_C(String nom_prenom_C) {
		this.nom_prenom_C = nom_prenom_C;
	}
	public String getMail_C() {
		return mail_C;
	}
	public void setMail_C(String mail_C) {
		this.mail_C = mail_C;
	}
	public String getDateNaiss_C() {
		return dateNaiss_C;
	}
	public void setDateNaiss_C(String dateNaiss_C) {
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
		return "Citoyen [idCitoyen=" + idCitoyen + ", CIN_C=" + CIN_C + ", nom_prenom_C=" + nom_prenom_C + ", mail_C="
				+ mail_C + ", dateNaiss_C=" + dateNaiss_C + ", tel_C=" + tel_C + ", etat=" + etat + "]";
	}
	
}
