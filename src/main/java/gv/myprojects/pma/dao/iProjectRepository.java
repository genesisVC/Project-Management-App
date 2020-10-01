package gv.myprojects.pma.dao;

import org.springframework.data.repository.CrudRepository;

import gv.myprojects.pma.entities.Project;

public interface iProjectRepository extends CrudRepository<Project, Long> {

}
