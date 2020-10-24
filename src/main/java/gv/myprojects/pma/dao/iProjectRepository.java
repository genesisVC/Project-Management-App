package gv.myprojects.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import gv.myprojects.pma.dto.ChartData;
import gv.myprojects.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel = "apiprojects", path = "apiprojects")
public interface iProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();
	
	//used to display info on chart
	@Query(nativeQuery = true, value = "Select stage as label, COUNT(*) as value " + 
			"FROM project " + 
			"GROUP BY stage")
	public List<ChartData> getProjectStatus();
	
//	@Query(nativeQuery = true, value = "Select name as projectName, start_date as startDate, end_date as endDate"
//			+ " From project Where start_date is not null")
	//public List<TimeChartData> getTimeData();
	
}
