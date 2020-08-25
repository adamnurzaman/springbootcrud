package test.astralife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.astralife.model.Division;

@Repository
public interface DivisionRepository extends JpaRepository<Division, Long>{

}
