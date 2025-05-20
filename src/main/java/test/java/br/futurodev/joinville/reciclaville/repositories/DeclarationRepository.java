package test.java.br.futurodev.joinville.reciclaville.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import test.java.br.futurodev.joinville.reciclaville.entities.Declaration;

public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
}
