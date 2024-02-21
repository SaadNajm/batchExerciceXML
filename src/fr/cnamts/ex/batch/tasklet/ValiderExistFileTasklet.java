package fr.cnamts.ex.batch.tasklet;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;


public class ValiderExistFileTasklet implements Tasklet, StepExecutionListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ValiderExistFileTasklet.class);
	    @Value("#{jobParameters['nom']}")
	    private String nom;
	    @Value("${repertoire.entree}")
	    private String repertoireEntree2;
	    
	public String getNom() {
			return nom;
		}





		public void setNom(String nom) {
			this.nom = nom;
		}





	public String getRepertoireEntree() {
		return repertoireEntree;
	}





	private String repertoireEntree;
		

	private transient StepExecution stepExecution;
	private transient JobExecution jobExecution;





	/**
	 * permet d'arreter le batch
	 */
	private void arreterBatch() {
		this.stepExecution.getExecutionContext().put("ERREUR_BLOQUANTE", Boolean.TRUE);
		this.stepExecution.setTerminateOnly();
	}





	public void setRepertoireEntree(String repertoireEntree) {
		this.repertoireEntree = repertoireEntree;
	}





	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
	    File file = new File(repertoireEntree);
	    File[] files = file.listFiles();

	    if (files != null && files.length > 1) {
	        System.out.println("Beaucoup de fichiers. Erreur!");
	    } else if (files != null && files.length == 1) {
	        String fileName = files[0].getName();
	       this.stepExecution.getJobExecution().getExecutionContext().put("fileName", fileName);
	        if (fileName.endsWith(".csv")) {
	            System.out.println("Le fichier d'entrée existe et se termine avec .csv");
	            LOGGER.info(repertoireEntree2);

	            if ( Character.isLetter(fileName.charAt(0)) && Character.isLetter(fileName.charAt(1)) && fileName.charAt(2) == '_') {
	                System.out.println("Les deux premiers caractères du nom de fichier sont des lettres avant le tiret bas.");
	            } else {
	                System.out.println("Les deux premiers caractères du nom de fichier ne sont pas des lettres avant le tiret bas.");
	            }
	        } else {
	            System.out.println("Le fichier d'entrée ne se termine pas avec .csv.");
	        }
	    } else {
	        System.out.println("Aucun fichier dans le répertoire d'entrée.");
	  
	    }

	    return RepeatStatus.FINISHED;
	}






	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		// TODO Auto-generated method stub
	
		return ExitStatus.COMPLETED;
	}





	@Override
	public void beforeStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		this.stepExecution=arg0;
		
	}










	




}
