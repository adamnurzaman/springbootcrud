package test.astralife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.astralife.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
