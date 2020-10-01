package gv.myprojects.pma.dao;

import org.springframework.data.repository.CrudRepository;

import gv.myprojects.pma.entities.Employee;

public interface iEmployeeRepository extends CrudRepository <Employee,Long>{

}
