package gv.myprojects.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gv.myprojects.pma.dao.iEmployeeRepository;
import gv.myprojects.pma.entities.Employee;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	iEmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees =empRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Employee newEmployee = new Employee();
		
		model.addAttribute("employee", newEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createProject(Employee employee, Model model) {
		empRepo.save(employee);
		
		//use redirect to prevent duplicate submissions
		return "redirect:/employees/new";

	}
}
