package fr.cnamts.ex.batch.rapport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PersonneRapport {
	/** logger */
	private static final Logger LOGGER_RAPPORT = LoggerFactory.getLogger("LOGGER_PERSONNE");
	
	private int nbrElementLus;
	private int nbrElementRejeter;
	private int nbrElementEnregidtrerBdd;

	public void afficherRapport() {
		LOGGER_RAPPORT.info("Le rapport de batch par saad :");
		LOGGER_RAPPORT.info( "Nombre d'Elements Lus par Job : "+this.nbrElementLus);	
		LOGGER_RAPPORT.info(" Nombre d'Elements rejet�s : "+this.nbrElementRejeter);
		LOGGER_RAPPORT.info("Nombre d'Elements Sauvegard�s dans DB : "+this.nbrElementEnregidtrerBdd);
	}

	@Override
	public String toString() {
		return "PersonneRapport [nbrElementLus=" + nbrElementLus + ", nbrElementRejeter=" + nbrElementRejeter
				+ ", nbrElementEnregidtrerBdd=" + nbrElementEnregidtrerBdd + "]";
	}

	public int getNbrElementLus() {
		return nbrElementLus;
	}

	
	public int getNbrElementRejeter() {
		return nbrElementRejeter;
	}

	
	public int getNbrElementEnregidtrerBdd() {
		return nbrElementEnregidtrerBdd;
	}

	public void incrementNbrElementRejeter() {
		this.nbrElementRejeter++;
	}
	public void incrementNbrElementLus() {
		this.nbrElementLus++;
	}
	
	public void setNbrElementLus(int nbrElementLus) {
		this.nbrElementLus = nbrElementLus;
	}

	public void setNbrElementRejeter(int nbrElementRejeter) {
		this.nbrElementRejeter = nbrElementRejeter;
	}

	public void setNbrElementEnregidtrerBdd(int nbrElementEnregidtrerBdd) {
		this.nbrElementEnregidtrerBdd = nbrElementEnregidtrerBdd;
	}

	public void incrementNbrElementEnregidtrerBdd() {
		this.nbrElementEnregidtrerBdd++;
	}
	
	
}
