package gv.myprojects.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gv.myprojects.pma.dao.iProjectRepository;
import gv.myprojects.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	iProjectRepository proRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
	List<Project> projects = proRepo.findAll();
	model.addAttribute("projects",projects);
	
	return "main/home";
	}
}
