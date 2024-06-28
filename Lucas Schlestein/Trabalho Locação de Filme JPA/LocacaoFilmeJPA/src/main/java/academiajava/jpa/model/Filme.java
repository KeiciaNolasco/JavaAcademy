package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filme {

    @Id
    @Column(name="COD_FILME",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="TituloOriginal", nullable=false)
    private String tituloOriginal;

    @Column(name="Titulo", nullable=false)
    private String titulo;

    @Column(name="Quantidade", nullable=false)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_CAT")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_GEN")
    private Genero genero;

    @ManyToMany
    @JoinTable(name = "filme_ator", joinColumns = @JoinColumn(name = "filme_id"), inverseJoinColumns = @JoinColumn(name = "ator_id"))
    private List<Ator> atores;

    @ManyToMany(mappedBy = "filmes")
    private List<Locacao> locacaos;

    public Filme(String tituloOriginal, String titulo, Integer quantidade) {
        this.tituloOriginal = tituloOriginal;
        this.titulo = titulo;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nFILME" +
                "\nId: " + id +
                "\nTitulo Original: " + tituloOriginal +
                "\nTitulo: " + titulo +
                "\nQuantidade: " + quantidade +
                categoria +
                genero;
    }

}
