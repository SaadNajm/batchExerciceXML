package fr.cnamts.ex.batch.item.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cnamts.ex.batch.bo.PersonneBO;
import fr.cnamts.ex.batch.rapport.PersonneRapport;

public class ImportPersonneReader extends FlatFileItemReader<PersonneBO> {
	@Autowired
	 private PersonneRapport personneRapport;
    private static final String NB_ENREG_LUS = "NB_ENREG_LUS";
	/** Nombre de lignes lues. */
    private transient int   nbLignesLues;
	
	
    @Override
    public void open(final ExecutionContext pExecutionContext) throws ItemStreamException {
      //  this.nbLignesLues = pExecutionContext.getInt(NB_ENREG_LUS, 0);
        super.open(pExecutionContext);
    }
    @Override
    public void update(final ExecutionContext pExecutionContext) throws ItemStreamException {
    	//personneRapport.incrementNbrElementLus();
        super.update(pExecutionContext);
    }
}
