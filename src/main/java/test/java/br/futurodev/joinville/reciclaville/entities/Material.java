package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "materias")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 55)
    private String name;

    @Column(nullable = false)
    private Double compensationPercentage;

}
