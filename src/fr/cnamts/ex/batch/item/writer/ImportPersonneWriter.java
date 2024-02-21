package fr.cnamts.ex.batch.item.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.cnamts.ex.batch.bo.PersonneDetailleBO;
import fr.cnamts.ex.batch.rapport.PersonneRapport;

public class ImportPersonneWriter implements ItemWriter<PersonneDetailleBO> {
	private static final Logger LOGGER = LoggerFactory.getLogger(ImportPersonneWriter.class);
	@Autowired
	 private PersonneRapport personneRapport;

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	public ImportPersonneWriter (
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		
	}

	@Override
	public void write(List<? extends PersonneDetailleBO> personnes) throws Exception {
		// TODO Auto-generated method stub


		
		for (PersonneDetailleBO personneDetailleBO : personnes) {
			LOGGER.info(personneDetailleBO.toString());
			sauvegarderDB( personneDetailleBO );
			
		}
		
	}
	private void sauvegarderDB(PersonneDetailleBO personneDetailleBO) {
		 MapSqlParameterSource params = new MapSqlParameterSource();
		 params.addValue("NOM", personneDetailleBO.getNom());
		 params.addValue("PRENOM", personneDetailleBO.getPrenom());
		 params.addValue("AGE", personneDetailleBO.getAge());
		 params.addValue("DATE_NAISSANCE", personneDetailleBO.getDateNaissace());
		 String query = "INSERT INTO BATCH_PERSONNE (nom, prenom, age, DATE_NAISSANCE) VALUES (:NOM, :PRENOM, :AGE, :DATE_NAISSANCE)";
		 namedParameterJdbcTemplate.update(query, params);
		 personneRapport.incrementNbrElementEnregidtrerBdd();
	}

}
