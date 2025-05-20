package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "declaration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeclarationItem> items;

    public Declaration() {
        this.declarationDate = LocalDate.now();    }

    public Declaration(List<DeclarationItem> items) {

        this.items = items;
        this.totalMaterials = 0.0;
        this.totalCompensation = 0.0;

        if (items != null) {
            for (DeclarationItem item : items) {
                this.totalMaterials += item.getDeclaredTonnage();
                this.totalCompensation += item.getCompensatedTonnage();
            }
        }

        this.declarationDate = LocalDate.now();
    }

}
