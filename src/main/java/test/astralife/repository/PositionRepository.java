package test.astralife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.astralife.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{

}
