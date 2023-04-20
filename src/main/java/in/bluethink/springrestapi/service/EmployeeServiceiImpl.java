package in.bluethink.springrestapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.bluethink.springrestapi.model.Employee;
import in.bluethink.springrestapi.repository.EmployeeRepository;
@Service
public class EmployeeServiceiImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployee(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC,"id"); // at the place of id we can write name, location etc it will do sorting
		return eRepository.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return eRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
			Optional<Employee> employee = eRepository.findById(id);
			if (employee.isPresent()) {
					return employee.get();
			}
		throw new RuntimeException("Employee is not found for id "+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		
		eRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		return eRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {
		return eRepository.findByName(name);
	}

	@Override
	public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
		// TODO Auto-generated method stub
		return eRepository.findByNameAndLocation(name, location);
	}

	@Override
	public List<Employee> getEmployeesByKeyword(String name) {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		return eRepository.findByNameContaining(name, sort);
	}

	@Override
	public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
		// TODO Auto-generated method stub
		return eRepository.getEmployeesByNameAndLocation(name, location);
	}

}
