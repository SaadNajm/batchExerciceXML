package fr.cnamts.ex.batch.item.reader;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import fr.cnamts.ex.batch.bo.PersonneBO;

public class ExportPersonneReader  implements ItemStreamReader<PersonneBO> {

	private transient ItemReader<PersonneBO> readerJdbc;


	@Override
	public void close() throws ItemStreamException {
		((ItemStream) this.readerJdbc).close();
	}

	@Override
	public void open(final ExecutionContext pExecutionContext)
			throws ItemStreamException {
		((ItemStream) this.readerJdbc).open(pExecutionContext);
	}

	@Override
	public void update(final ExecutionContext pExecutionContext) throws ItemStreamException {
		((ItemStream) this.readerJdbc).update(pExecutionContext);

	}

	@Override
	public PersonneBO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

		final PersonneBO resultat = this.readerJdbc.read();

		return resultat;
	}

}
