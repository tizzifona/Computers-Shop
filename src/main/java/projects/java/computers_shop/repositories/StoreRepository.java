package projects.java.computers_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projects.java.computers_shop.models.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
