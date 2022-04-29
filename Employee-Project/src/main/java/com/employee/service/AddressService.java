package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Address;
import com.employee.repository.AddressRepository;

@Service
public class AddressService {
	
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address getAddressByAddId(Long id) {
		return addressRepository.getAddressByAddId(id);
	}

}
