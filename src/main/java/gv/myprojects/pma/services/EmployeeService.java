package gv.myprojects.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gv.myprojects.pma.dao.iEmployeeRepository;
import gv.myprojects.pma.dto.EmployeeProject;
import gv.myprojects.pma.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	iEmployeeRepository empRepo;
	
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public Iterable<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}
	
	public Employee findByEmployeeId(Long Id) {
		return empRepo.findByEmployeeId(Id);
	}
	
	public void delete(Employee emp) {
		empRepo.delete(emp);
	}
	

}
