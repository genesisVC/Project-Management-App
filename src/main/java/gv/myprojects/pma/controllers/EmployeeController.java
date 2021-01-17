package gv.myprojects.pma.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import gv.myprojects.pma.entities.Employee;
import gv.myprojects.pma.entities.Project;
import gv.myprojects.pma.services.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		Iterable<Employee> employees =empService.getAll();
		Employee newEmployee = new Employee();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", newEmployee);
		return "employees/list-employees";
	}
	
	@PostMapping("/employeeNameSearch") 
	  public String studentSearch(Model model, Project project, @RequestParam (value = "lastName", required = false) String lastName) {
	  
		 Iterable<Employee> foundEmployee = empService.getEmployeeNameIgnoreCase(lastName);
		  
		  model.addAttribute("foundEmployees", foundEmployee);

		  return "employees/employeeNameSearch";
	}
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		Employee newEmployee = new Employee();
		
		model.addAttribute("employee", newEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createProject(Model model, @Valid Employee employee,  Errors errors) {
		
	
		if(errors.hasErrors()) {
			
			
			return "employees/new-employee";
		}
			
			empService.save(employee);
			
		//use redirect to prevent duplicate submissions
		return "redirect:/employees";

	}
	
	@GetMapping ("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long Id, Model model) {
		Employee theEmp = empService.findByEmployeeId(Id);
		model.addAttribute("employee", theEmp);
		return "employees/new-employee";
	}
	
	@GetMapping ("/delete")
	public String deleteEmployeeUpdateForm(@RequestParam("id") long Id, Model model) {
		Employee theEmp = empService.findByEmployeeId(Id);
		empService.delete(theEmp);
		
		return "redirect:/employees";
	}
	
}
