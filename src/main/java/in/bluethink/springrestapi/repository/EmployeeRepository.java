package in.bluethink.springrestapi.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.bluethink.springrestapi.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String name);
	
//	Select * from table where name = "ramesh" And location="indai" 
	List<Employee> findByNameAndLocation(String name, String location);
	
	
	
	// Select * from table Where name like "%ram%"
	List<Employee> findByNameContaining(String keyword, Sort sort);
	
	
	
	//
	@Query("FROM Employee WHERE name =:name OR location=:location")
	List<Employee> getEmployeesByNameAndLocation(String name, String location);
}
