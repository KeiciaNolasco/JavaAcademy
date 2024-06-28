package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genero {

    @Id
    @Column(name="COD_GEN",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable=false, length=60, name="Nome")
    private String nome;

    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Filme> filmes;

    public Genero(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nGENERO" +
                "\nId: " + id +
                "\nNome: " + nome;
    }
}
