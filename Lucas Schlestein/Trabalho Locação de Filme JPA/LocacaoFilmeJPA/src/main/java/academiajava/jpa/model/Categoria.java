package academiajava.jpa.model;

import java.util.List;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categoria {

    @Id
    @Column(name="COD_CAT",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, name="Nome", nullable=false)
    private String nome;

    @Column(name="Valor", nullable=false)
    private Double valor;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
    private List<Filme> filmes;

    public Categoria(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "\nCATEGORIA" +
                "\nId: " + id +
                "\nNome: " + nome +
                "\nValor: " + valor;
    }
}
