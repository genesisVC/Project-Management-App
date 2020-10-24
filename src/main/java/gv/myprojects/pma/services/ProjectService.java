package gv.myprojects.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gv.myprojects.pma.dao.iProjectRepository;
import gv.myprojects.pma.dto.ChartData;
import gv.myprojects.pma.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	iProjectRepository proRepo;
	
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List <ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}
	
////	public List<TimeChartData> getTimeData(){
////		return proRepo.getTimeData();
//	}

}
