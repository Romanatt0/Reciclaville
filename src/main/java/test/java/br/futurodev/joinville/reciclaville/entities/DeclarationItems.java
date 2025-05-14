package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "declaationItems")
public class DeclarationItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //A ver
    private Declaration declaration;

    //A ver
    private Material material;

    @Column(nullable = false)

    private double compensationPercentage;
    @Column(nullable = false)

    private double declaredTonnage;

    @Column(nullable = false)
    private double compensatedTonnage;


}
