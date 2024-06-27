package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @Column(name="Id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false, length=60, name="Nome")
    private String nome;

    @Column(unique=true, name="Cargo", nullable=false)
    private String cargo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Departamento_Id")
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Projeto_Id")
    private Projeto projeto;

    @Override
    public String toString() {
        return "\nFUNCIONÁRIO" +
                "\nId: " + id +
                "\nNome: " + nome +
                "\nCargo: " + cargo +
                departamento +
                projeto;
    }

}
