package fr.cnamts.ex.batch.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.dozer.DozerBeanMapper;

import fr.cnamts.ex.batch.bo.PersonneBO;
import fr.cnamts.ex.batch.bo.PersonneDetailleBO;

public class PersonneAdapter {
	
	private static final Locale LOCALE_FRANCE = Locale.FRANCE;
	private  DozerBeanMapper dozerMapper;
	
	public  PersonneDetailleBO fromPersonneToPersonneDetailleBO(PersonneBO personne){
		PersonneDetailleBO personneDetail = new PersonneDetailleBO();
		dozerMapper.map(personne,personneDetail);
		if(!personne.isErreur()){
			Date currentdate= new Date();
			String date= formatteDate(currentdate, "dd-MM-yyyy");
			String[] d = date.split("-");
			String year = d[2];
			String DateNaissance = String.valueOf(Integer.valueOf(year)- Integer.valueOf(personneDetail.getAge()));
			personneDetail.setDateNaissace(DateNaissance);
		}
		
		return personneDetail;
	}

	public void setDozerMapper(DozerBeanMapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}
	
	public  String formatteDate(final Date pDate, final String pFormat) {
		  String retour;
		  if (pDate == null) {
		   retour = "";
		  } else {
		   final SimpleDateFormat formatter = new SimpleDateFormat(pFormat,
		     LOCALE_FRANCE);
		   retour = formatter.format(pDate);
		  }
		  return retour;
		 }
	
	

}
