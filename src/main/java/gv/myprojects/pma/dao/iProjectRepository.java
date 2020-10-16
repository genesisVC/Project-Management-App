package gv.myprojects.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import gv.myprojects.pma.dto.ChartData;
import gv.myprojects.pma.entities.Project;

public interface iProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "Select stage as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();
}
