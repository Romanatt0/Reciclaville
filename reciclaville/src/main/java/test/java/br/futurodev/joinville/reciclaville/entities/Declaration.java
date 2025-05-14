package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "declaratios")
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    
    private Customer Customer;

    //A ver
    private String declarationDate;
    //A ver
    private String periodStartDate;

    //A ver
    private String periodEndDate;

    @Column(nullable = false)

    private double totalMaterials;

    @Column(nullable = false)
    private double totalCompensation;
}
