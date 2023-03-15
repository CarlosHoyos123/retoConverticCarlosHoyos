package com.ecoomerce.JPA.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ecoomerce.JPA.entitys.Country;
import com.ecoomerce.JPA.entitys.IdType;
import com.ecoomerce.JPA.entitys.PhoneType;
import com.ecoomerce.JPA.repositories.CountryRepository;
import com.ecoomerce.JPA.repositories.IdTypeRepository;
import com.ecoomerce.JPA.repositories.PhoneTypeRepository;
import com.ecoomerce.JPA.utils.FormsInfo;

@Service
public class FormsServices{
	
	private IdTypeRepository idTypeRepository;
	private CountryRepository countryRepository;
	private PhoneTypeRepository phoneTypeRepository;

	public FormsServices(IdTypeRepository idTypeRepository, CountryRepository countryRepository,
			PhoneTypeRepository phoneTypeRepository) {
		super();
		this.idTypeRepository = idTypeRepository;
		this.countryRepository = countryRepository;
		this.phoneTypeRepository = phoneTypeRepository;
	}

	public FormsInfo findAllItems() {

		List<Country> countries =  (List<Country>) countryRepository.findAll();
		List<IdType> docs = idTypeRepository.findAll();
		List<PhoneType> phone = (List<PhoneType>) phoneTypeRepository.findAll();
		FormsInfo configurations= new FormsInfo(docs, countries, phone);
		return configurations;
	}
}
