package test.java.br.futurodev.joinville.reciclaville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import test.java.br.futurodev.joinville.reciclaville.entities.Material;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findByNameIgnoreCase( String name);
}
