package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profissao {

    @Id
    @Column(name="COD_PROF",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable=false, length=60, name="Nome")
    private String nome;

    @OneToMany(mappedBy = "profissao", fetch = FetchType.EAGER)
    private List<Cliente> clientes;

    public Profissao(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nPROFISSÃO" +
                "\nId: " + id +
                "\nNome: " + nome;
    }
}
