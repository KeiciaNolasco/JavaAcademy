package academiajava.exercicio01.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false,length=50,name="nome")
    private String nome;
    @Column(name = "salario")
    private Double salario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Departamento  departamento;

    @Override
    public String toString() {
        return nome + " " + salario+ " " + departamento.getNome();
    }

}
