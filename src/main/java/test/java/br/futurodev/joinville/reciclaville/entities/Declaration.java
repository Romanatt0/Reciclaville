package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "declaratios")
public class Declaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer Customer;

    @Column(nullable = false)
    private LocalDate declarationDate;

    @Column(nullable = false)
    private LocalDate periodStartDate;

    @Column(nullable = false)
    private LocalDate periodEndDate;

    @Column(nullable = false)
    private double totalMaterials;

    @Column(nullable = false)
    private double totalCompensation;
}
