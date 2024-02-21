package fr.cnamts.ex.batch.bo;

public class PersonneDetailleBO {

	private String nom;
	private String prenom;
	private String age;
	private String dateNaissace;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDateNaissace() {
		return dateNaissace;
	}
	public void setDateNaissace(String dateNaissace) {
		this.dateNaissace = dateNaissace;
	}
	@Override
	public String toString() {
		return "PersonneDetailleBO [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", DATE_NAISSANCE="
				+ dateNaissace + "]";
	}
	
	
}
