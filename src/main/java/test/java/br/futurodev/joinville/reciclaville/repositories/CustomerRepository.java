package test.java.br.futurodev.joinville.reciclaville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE " +
            "UPPER(c.name) LIKE CONCAT('%', UPPER(:search), '%') OR " +
            "UPPER(c.responsible) LIKE CONCAT('%', UPPER(:search), '%')")
    List<Customer> searchByNameOrResponsible(@Param("search") String search);

}
