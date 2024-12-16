package projects.java.computers_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projects.java.computers_shop.models.Computer;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
