package in.bluethink.springrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.bluethink.springrestapi.model.Employee;
import in.bluethink.springrestapi.service.EmployeeService;

//@Controller
//@ResponseBody 
//place of 2 annotation we use ->

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;  
	
	

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee> (eService.saveEmployee(employee), HttpStatus.CREATED);
	}

//	@RequestMapping(value = "/employees",method = RequestMethod.GET)
//	at the place of that use can use ->
	// note - pageNumber start with = 0
	@GetMapping("/employees")
	public ResponseEntity< List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
		return  new ResponseEntity<List<Employee>>(eService.getEmployee(pageNumber, pageSize),HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity< Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

			employee.setId(id);
		return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.OK);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id) {
		eService.deleteEmployee(id);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
	
	
	
	// finding by name
	@GetMapping("/employees/name/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable () String name ){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
	}
	
	
	
	
	// finding by name & location
	@GetMapping("/employees/nameandlocation")
	public ResponseEntity<List<Employee>> getEmployeeByNameAndLocation(@RequestParam String name, @RequestParam String location ){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name,location), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/employees/getByKeyword/{name}")
	public ResponseEntity<List<Employee>> getEmployeeBykeyword(@PathVariable () String name ){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
	}

	
	
	@GetMapping("/employees/{name}/{location}")
	public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@PathVariable String name, @PathVariable String location  ){
		
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameOrLocation(name, location), HttpStatus.OK);
	}
	
	
}
