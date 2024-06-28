package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ator {

    @Id
    @Column(name="COD_ATOR",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable=false, length=60, name="Nome")
    private String nome;

    @Column(name="EAtor", nullable=false)
    private Boolean eAtor;

    @Column(name="EDiretor", nullable=false)
    private Boolean eDiretor;

    @ManyToMany(mappedBy = "atores")
    private List<Filme> filmes;

    public Ator(String nome, Boolean eAtor, Boolean eDiretor) {
        this.nome = nome;
        this.eAtor = eAtor;
        this.eDiretor = eDiretor;
    }

    @Override
    public String toString() {
        return "\nATOR" +
                "\nId: " + id +
                "\nNome: " + nome;
    }
}
