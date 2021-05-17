package Proj.Spring.AppCoVacc19.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Personnel")
public class Personnel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersonnel" , unique=true)
	private int idPersonnel;
	

	@Column(name = "CIN_P" )
	private int CIN_P;
	
	@Column(name = "nom_P")
	private String nom_P;
	
	@Column(name = "prenom_P")
	private String prenom_P;
	
	@Column(name = "adresse_P")
	private String adresse_P;
	
	@Column(name = "dateNaiss_P")
	private String dateNaiss_P;
	
	@Column(name = "tel_P" , length=8)
	private int tel_P;
	
	@Column(name = "horaire_P")
	private String horaire_P;
	
	@Column(name = "salaire_P")
	private float salaire_P;
	
	@OneToOne
	private Centre_Vaccination centre;

	

	public Personnel(int CIN_P,String nom_P, String prenom_P, String adresse_P, String dateNaiss_P, int tel_P,
			String horaire_P, float salaire_P ) {
		super();
		this.CIN_P = CIN_P;
		this.nom_P = nom_P;
		this.prenom_P = prenom_P;
		this.adresse_P = adresse_P;
		this.dateNaiss_P = dateNaiss_P;
		this.tel_P = tel_P;
		this.horaire_P = horaire_P;
		this.salaire_P = salaire_P;
		
	}

	public Personnel() {
		super();
	}
	public int getIdPersonnel() {
		return idPersonnel;
	}
	public void setIdPersonnel(int idPersonnel) {
		this.idPersonnel = idPersonnel;
	}

	public int getCIN_P() {
		return CIN_P;
	}

	public void setCIN_P(int cIN_P) {
		CIN_P = cIN_P;
	}

	public String getNom_P() {
		return nom_P;
	}

	public void setNom_P(String nom_P) {
		this.nom_P = nom_P;
	}

	public String getPrenom_P() {
		return prenom_P;
	}

	public void setPrenom_P(String prenom_P) {
		this.prenom_P = prenom_P;
	}

	public String getAdresse_P() {
		return adresse_P;
	}

	public void setAdresse_P(String adresse_P) {
		this.adresse_P = adresse_P;
	}

	public String getDateNaiss_P() {
		return dateNaiss_P;
	}

	public void setDateNaiss_P(String dateNaiss_P) {
		this.dateNaiss_P = dateNaiss_P;
	}

	public int getTel_P() {
		return tel_P;
	}

	public void setTel_P(int tel_P) {
		this.tel_P = tel_P;
	}

	public String getHoraire_P() {
		return horaire_P;
	}

	public void setHoraire_P(String horaire_P) {
		this.horaire_P = horaire_P;
	}

	public float getSalaire_P() {
		return salaire_P;
	}

	public void setSalaire_P(float salaire_P) {
		this.salaire_P = salaire_P;
	}

	public Centre_Vaccination getCentre() {
		return centre;
	}

	public void setCentre(Centre_Vaccination centre) {
		this.centre = centre;
	}

	@Override
	public String toString() {
		return "Personnel [idPersonnel= "+ idPersonnel+", CIN_P=" + CIN_P + ", nom_P=" + nom_P + ", prenom_P=" + prenom_P + ", adresse_P=" + adresse_P
				+ ", dateNaiss_P=" + dateNaiss_P + ", tel_P=" + tel_P + ", horaire_P=" + horaire_P + ", salaire_P="
				+ salaire_P  + "]";
	}

}
