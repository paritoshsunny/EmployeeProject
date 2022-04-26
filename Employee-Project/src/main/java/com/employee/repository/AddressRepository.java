package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	Address getAddressById(Long addId);

}
