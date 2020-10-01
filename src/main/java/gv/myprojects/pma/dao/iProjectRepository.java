package gv.myprojects.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gv.myprojects.pma.entities.Project;

public interface iProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();
}
