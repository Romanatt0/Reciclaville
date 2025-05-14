package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "declarationItems")
public class DeclarationItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "declaration_id", nullable = false)
    private Declaration declaration;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    @Column(nullable = false)
    private double compensationPercentage;

    @Column(nullable = false)
    private double declaredTonnage;

    @Column(nullable = false)
    private double compensatedTonnage;


}
