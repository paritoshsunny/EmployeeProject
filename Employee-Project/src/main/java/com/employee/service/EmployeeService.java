package com.employee.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.VO.response.CommonEmployeeResponse;
import com.employee.VO.response.EmployeeVO;
import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.employee.repository.AddressRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.util.EmpUtil;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressRepository addressRepository;

	public CommonEmployeeResponse saveEmployee(Employee emp) {
		try {
			if (emp != null && emp.getEmpId() == null) {
				List<Employee> empList = new ArrayList<>();
				Employee empl = employeeRepository.save(emp);
				empList.add(empl);
				List<EmployeeVO> employees = EmpUtil.convertEmpEntityToVO(empList);
				CommonEmployeeResponse employeeResponse = new CommonEmployeeResponse(employees, 200, "Employee Saved",
						LocalDateTime.now());
				return employeeResponse;
			}
			else {
				Employee empl = employeeRepository.findById(emp.getEmpId()).orElse(null);
				if (empl == null) {
					throw new NoSuchElementException();
				}
				empl.setEmpId(emp.getEmpId());
				empl.setDepartment(emp.getDepartment());
				empl.setDesignation(emp.getDesignation());
				empl.setEmail(emp.getEmail());
				empl.setFirstName(emp.getFirstName());
				empl.setLastName(emp.getLastName());
				empl.setSalary(emp.getSalary());

				List<Address> a = emp.getAddresses();
				List<Address> addrList = new ArrayList<>();
				for (Address address : a) {
					Address add = addressRepository.getAddressById(address.getAddId());
					add.setAddressLine1(address.getAddressLine1());
					add.setAddressline2(address.getAddressline2());
					add.setCity(address.getCity());
					add.setCountry(address.getCountry());
					add.setHouseNo(address.getHouseNo());
					add.setState(address.getState());
					add.setZipCode(address.getZipCode());
					addrList.add(add);
				}

				empl.setAddresses(addrList);
				List<Employee> empList = new ArrayList<>();
				empList.add(empl);
				List<EmployeeVO> employees = EmpUtil.convertEmpEntityToVO(empList);
				CommonEmployeeResponse employeeResponse = new CommonEmployeeResponse(employees, 200, "Employee Saved",
						LocalDateTime.now());
				return employeeResponse;

			}
		} catch (Exception e) {
			return new CommonEmployeeResponse(null, 403, "Forbidden", LocalDateTime.now());
		}
	}

}
