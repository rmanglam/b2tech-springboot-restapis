package in.bluethink.springrestapi.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity   
@Table(name = "tbl_employeespring")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull(message = "name not should be null")
// @NotEmpty (message = "name not should be null")
	@NotBlank (message = "name not should be null")
	private String name;
	
	private Long age = 0L;	
	
	private String location;
	
	@Email(message ="please enter the valid message address")
	private String email;
	
//	@NotNull(message = "department not should be null")  // "name":"",   it will take not throw error, 
//	@NotEmpty (message = "department not should be null") //"name":"   ",   it will take not throw error, 
	@NotBlank (message = "department not should be null")
	private String department;
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date createAt;
	@UpdateTimestamp
	private Date updateAt;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", location=" + location + ", email=" + email
				+ ", department=" + department + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
}
