package fr.cnamts.ex.batch.tasklet;

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
import fr.cnamts.ex.batch.util.UFichier;


public class ValiderExistReperTasklet  implements Tasklet, StepExecutionListener{
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ValiderExistReperTasklet.class);

	//	TODO -verifier exsitences de repertoires
	//	UFichier.isNonexiste(this.repertoireEntree)
	//	-verifier existence et le format de fichier entree

	/** Step execution du batch. */
	private transient StepExecution stepExecution;
private String repertoireSortie;
private String repertoireEntree;
	public String getRepertoireSortie() {
	return repertoireSortie;
}





public void setRepertoireSortie(String repertoireSortie) {
	this.repertoireSortie = repertoireSortie;
}





	public String getRepertoireEntree() {
		return repertoireEntree;
	}





	public void setRepertoireEntree(String repertoireEntree) {
		this.repertoireEntree = repertoireEntree;
	}





	/** Job execution du batch. */
	private transient JobExecution jobExecution;





	/**
	 * permet d'arreter le batch
	 */
	private void arreterBatch() {
		this.stepExecution.getExecutionContext().put("ERREUR_BLOQUANTE", Boolean.TRUE);
		this.stepExecution.setTerminateOnly();
	}


	private void checkFile(String filePath,String type) {
	    if (UFichier.isNonexiste(filePath)) {
	        System.out.println("le fichier"+ type+  " n'existe pas");
	        try {
	            arreterBatch();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    } else {
	    	  System.out.println("le fichier"+ type+  " existe");
	    }
	}


	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		// TODO Auto-generated method stub
		String anneRef=	(String)arg1.getStepContext().getJobParameters().get("nom");
		LOGGER.info(anneRef);
		this.stepExecution.getJobExecution().getExecutionContext().put("ERREUR_BLOQUANTE", Boolean.TRUE);
		checkFile(repertoireEntree," d'entrée");
	    checkFile(repertoireSortie," de sortie");

		return RepeatStatus.FINISHED;

	}





	@Override
	public ExitStatus afterStep(StepExecution arg0) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public void beforeStep(StepExecution pStepExecution) {
		
		this.stepExecution= pStepExecution;
		
	}





}
