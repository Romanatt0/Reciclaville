package test.java.br.futurodev.joinville.reciclaville.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@Entity
@Table(name = "declarationItems")
public class DeclarationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "declaration_id", nullable = false)
    @JsonIgnore
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

    public DeclarationItem (Material material, double declaredTonnage){

        this.material = material;

        this.declaredTonnage = declaredTonnage;

        this.compensationPercentage = material.getCompensationPercentage();

        this.compensatedTonnage = declaredTonnage * this.compensationPercentage / 100;

    }




}
