package fr.cnamts.ex.batch.mapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;

import fr.cnamts.ex.batch.bo.PersonneBO;
import fr.cnamts.ex.batch.rapport.PersonneRapport;

public class PersonneFieldSetMapper implements FieldSetMapper<PersonneBO> {
	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonneFieldSetMapper.class);

	@Autowired
	 private PersonneRapport personneRapport;

	@Override
	public PersonneBO mapFieldSet(final FieldSet pFieldset) throws BindException {
		if (pFieldset == null) {
			return null;
			
		}
		//		TODO mapping from pFieldset to Objet Personne
			final PersonneBO personneBO = new PersonneBO();
			personneBO.setNom(pFieldset.readString("NOM"));
			personneBO.setPrenom(pFieldset.readString("PRENOM"));
			personneBO.setAge(pFieldset.readString("AGE"));
			personneRapport.incrementNbrElementLus();
		return personneBO;
	}
	


}
