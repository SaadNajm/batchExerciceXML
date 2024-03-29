package fr.cnamts.ex.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cnamts.ex.batch.rapport.PersonneRapport;


public class FinitionJobListener implements JobExecutionListener {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(FinitionJobListener.class);
	@Autowired
	 private PersonneRapport personneRapport;
	@Override
	public void afterJob(JobExecution pJobExecution) {
		/*	if (BatchStatus.FAILED.equals(pJobExecution.getStatus())
		|| BatchStatus.STOPPED.equals(pJobExecution.getStatus())) {

	final String msgErreurBloq = (String) pJobExecution.getExecutionContext().get("ERREUR_BLOQUANTE");
	// Op�ration effectu�e par le script de lancement du batch, a
	// supprim�.

	if (null != msgErreurBloq) {

		LOGGER.error(msgErreurBloq);
	}
}*/  String fileName = (String) pJobExecution.getExecutionContext().get("fileName");
         LOGGER.info(fileName);
		 LOGGER.info("le job a termin� a  {}", pJobExecution.getEndTime());
		 String nom = pJobExecution.getJobParameters().getString("nom");
	        LOGGER.info("Value of 'nom' parameter: {}", nom);
	      personneRapport.afficherRapport();
	}

	@Override
	public void beforeJob(JobExecution pJobExecution) {
		 LOGGER.info("le job a commenc� a  {}", pJobExecution.getStartTime());

	}

}
