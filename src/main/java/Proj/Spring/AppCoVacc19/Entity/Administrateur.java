package Proj.Spring.AppCoVacc19.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
	@Entity
	@Table(name = "Administrateur")
	public class Administrateur {
	//CIN_A,nom_A,prenom_A,adresse_A, dateNaiss_A, tel_A, matricule
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "CIN_A" , unique=true)
		private int CIN_A;
		
		@Column(name = "nom_A")
		private String nom_A;
		
		@Column(name = "prenom_A")
		private String prenom_A;
		
		@Column(name = "adresse_A")
		private String adresse_A;
		
		@Column(name = "dateNaiss_A")
		private Date dateNaiss_A;
		
		@Column(name = "tel_A" , length=8)
		private int tel_A;
		
		@Column(name = "matricule" , unique=true)
		private int matricule;

		public Administrateur(String nom_A, String prenom_A, String adresse_A, Date dateNaiss_A, int tel_A,
				int matricule) {
			super();
			//CIN_A = cIN_A;
			this.nom_A = nom_A;
			this.prenom_A = prenom_A;
			this.adresse_A = adresse_A;
			this.dateNaiss_A = dateNaiss_A;
			this.tel_A = tel_A;
			this.matricule = matricule;
		}

		public Administrateur() {
			super();
		}

		public int getCIN_A() {
			return CIN_A;
		}

		public void setCIN_A(int cIN_A) {
			CIN_A = cIN_A;
		}

		public String getNom_A() {
			return nom_A;
		}

		public void setNom_A(String nom_A) {
			this.nom_A = nom_A;
		}

		public String getPrenom_A() {
			return prenom_A;
		}

		public void setPrenom_A(String prenom_A) {
			this.prenom_A = prenom_A;
		}

		public String getAdresse_A() {
			return adresse_A;
		}

		public void setAdresse_A(String adresse_A) {
			this.adresse_A = adresse_A;
		}

		public Date getDateNaiss_A() {
			return dateNaiss_A;
		}

		public void setDateNaiss_A(Date dateNaiss_A) {
			this.dateNaiss_A = dateNaiss_A;
		}

		public int getTel_A() {
			return tel_A;
		}

		public void setTel_A(int tel_A) {
			this.tel_A = tel_A;
		}

		public int getMatricule() {
			return matricule;
		}

		public void setMatricule(int matricule) {
			this.matricule = matricule;
		}

		@Override
		public String toString() {
			return "Administrateur [CIN_A=" + CIN_A + ", nom_A=" + nom_A + ", prenom_A=" + prenom_A + ", adresse_A="
					+ adresse_A + ", dateNaiss_A=" + dateNaiss_A + ", tel_A=" + tel_A + ", matricule=" + matricule + "]";
		}

		
		
	
}
