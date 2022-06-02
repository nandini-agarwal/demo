package com.example.demo.Service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Address;
import com.example.demo.Repository.AddressRepository;

@Service
public class AddressService {
	private final AddressRepository addressRepository;
	Logger logger = LoggerFactory.getLogger(getClass());

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public Address createAddress(UUID personId, Address address){
		try{
			Address newAddress = new Address();
			newAddress.setPersonId(personId);
			newAddress.setAddressId(UUID.randomUUID());
			newAddress.setStreet(address.getStreet());
			newAddress.setCity(address.getCity());
			newAddress.setCountry(address.getCountry());
			newAddress.setPostalId(address.getPostalId());
			addressRepository.save(newAddress);
			return newAddress;
		}catch (Exception e) {
			logger.error("Error occurred: " + e);
			return null;
		}
	}
}