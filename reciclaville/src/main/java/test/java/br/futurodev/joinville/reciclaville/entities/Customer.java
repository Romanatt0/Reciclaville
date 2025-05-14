package test.java.br.futurodev.joinville.reciclaville.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 55)
    private String name;

    @Column(nullable = false, unique = true, length = 11)
    private String cnpj;

    @Column(nullable = false, length = 120)
    private String economicActivity;

    @Column(nullable = false, length = 55)
    private String responsible;
}
