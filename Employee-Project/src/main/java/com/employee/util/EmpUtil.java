package com.employee.util;

import java.util.ArrayList;
import java.util.List;

import com.employee.VO.response.AddressVO;
import com.employee.VO.response.EmployeeVO;
import com.employee.entity.Address;
import com.employee.entity.Employee;

public class EmpUtil {
	
	public static List<EmployeeVO> convertEmpEntityToVO(List<Employee> employees) {
		List<EmployeeVO> employeeVOs= new ArrayList<>();
		if(employees!=null) {
			for (Employee employee : employees) {
				EmployeeVO employeeVO = new EmployeeVO();
				employeeVO.setEmpId(employee.getEmpId().toString());
				employeeVO.setFirstName(employee.getFirstName());
				employeeVO.setLastName(employee.getLastName());
				employeeVO.setDesignation(employee.getDesignation());
				employeeVO.setDepartment(employee.getDepartment());
				employeeVO.setEmail(employee.getEmail());
				employeeVO.setSalary(employee.getSalary()+"");
				List<AddressVO> addressVoList=new ArrayList<>();
				
				for (Address address : employee.getAddresses()) {
					AddressVO addressVO=new AddressVO();
					addressVO.setAddId(address.getAddId().toString());
					addressVO.setHouseNo(address.getHouseNo().toString());
					addressVO.setAddressLine1(address.getAddressLine1());
					addressVO.setAddressline2(address.getAddressline2());
					addressVO.setCity(address.getCity());
					addressVO.setState(address.getState());
					addressVO.setCountry(address.getCountry());
					addressVO.setZipCode(address.getZipCode()+"");
					addressVoList.add(addressVO);
				}
				employeeVO.setAddresses(addressVoList);
				employeeVOs.add(employeeVO);
			}
		}
		return employeeVOs;
	}

}
