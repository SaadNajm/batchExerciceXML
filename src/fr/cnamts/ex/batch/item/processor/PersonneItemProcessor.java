package fr.cnamts.ex.batch.item.processor;



import org.dozer.DozerBeanMapper;
import org.joda.time.LocalDateTime;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cnamts.ex.batch.bo.PersonneBO;
import fr.cnamts.ex.batch.bo.PersonneDetailleBO;
import fr.cnamts.ex.batch.rapport.PersonneRapport;

public class PersonneItemProcessor implements ItemProcessor<PersonneBO, PersonneDetailleBO> {
	
	@Autowired
	private DozerBeanMapper dozerBeanMapper;
	@Autowired
	private  PersonneRapport personneRapport;
	

	@Override
	public PersonneDetailleBO process(PersonneBO personneBO) throws Exception {
		// TODO Auto-generated method stub

	    PersonneDetailleBO personneDetail = dozerBeanMapper.map(personneBO,PersonneDetailleBO.class);
	    
	    if(personneDetail.getAge() == null || personneDetail.getAge().isEmpty() ||  !isLong(personneDetail.getAge())) {
			System.out.println("erreur");
			personneRapport.incrementNbrElementRejeter();
		}
	    else {
	    LocalDateTime nowcurrentDate = new LocalDateTime();
        int year = nowcurrentDate.getYear();
		String DateNaissance = String.valueOf(Integer.valueOf(year)- Integer.valueOf(personneDetail.getAge()));
		personneDetail.setDateNaissace(DateNaissance);
		
	    }
		
		
		return personneDetail;
	}
	
	
	public boolean isLong(String age) {
		boolean isLong = true;
		try {
			Long.valueOf(age);
		}catch(NumberFormatException ex) {
			isLong = false;
		}
		return isLong;
	}
}
