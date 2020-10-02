package gv.myprojects.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import gv.myprojects.pma.entities.Employee;
import gv.myprojects.pma.entities.Project;

public interface iEmployeeRepository extends CrudRepository <Employee,Long>{
	@Override
	public List<Employee> findAll();
}
