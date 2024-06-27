package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departamento {

    @Id
    @Column(name="Id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, name="Nome", nullable=false)
    private String nome;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    @Override
    public String toString() {
        return "\nDEPARTAMENTO" +
                "\nId: " + id +
                "\nNome: " + nome;
    }

}

