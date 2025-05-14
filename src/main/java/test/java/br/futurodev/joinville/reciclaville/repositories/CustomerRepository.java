package test.java.br.futurodev.joinville.reciclaville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.java.br.futurodev.joinville.reciclaville.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
