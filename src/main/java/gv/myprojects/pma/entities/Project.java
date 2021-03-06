package gv.myprojects.pma.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long projectId;
	
	@NotBlank(message = "Please enter first name.")
	@Size(min = 2, max = 50)
	private String name;
	
	@NotBlank(message = "Please enter project name.")
	@Size(min = 2, max = 50)
	private String stage;
	
	@NotBlank(message = "Please enter project description.")
	@Size(min = 2)
	private String description;
	
	//@NotNull(message = "Please select date from calendar.")
	private Date startDate;
	
	//@NotNull((message = "Please select date from calendar.")
	private Date endDate;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST },
			fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee",
	joinColumns = @JoinColumn(name = "project_id"),
	inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	
	private List<Employee> employees;
	



	public Project() {
		
	}
	
	
	

	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}


	public List<Employee> getEmployees() {
		return employees;
	}




	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



	



	public long getProjectId() {
		return projectId;
	}




	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}




	public String getStage() {
		return stage;
	}



	public void setStage(String stage) {
		this.stage = stage;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}




	public Date getStartDate() {
		
		return startDate;
	}




	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}




	public Date getEndDate() {
		
		
		return endDate;
	}




	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
