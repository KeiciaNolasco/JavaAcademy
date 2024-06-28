package academiajava.jpa.model;

import java.util.Date;
import java.util.List;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Locacao {

    @Id
    @Column(name="COD_LOC",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="DataLocacao", nullable=false)
    private Date dataLocacao;

    @Column(name="DataDevolucao", nullable=false)
    private Date dataDevolucao;

    @Column(name="NumeroDias", nullable=false)
    private Integer numeroDias;

    @Column(name="Valor", nullable=false)
    private Double valor;

    @Column(name="Desconto")
    private Double desconto;

    @Column(name="Multa")
    private Double multa;

    @Column(name="SubTotal", nullable=false)
    private Double subTotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_CLI")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "locacao_filme", joinColumns = @JoinColumn(name = "locacao_id"), inverseJoinColumns = @JoinColumn(name = "filme_id"))
    private List<Filme> filmes;

    @Override
    public String toString() {
        return "\nLOCAÇÃO" +
                "\nId: " + id +
                "\nData da Locação: " + dataLocacao +
                "\nData de Devolucao: " + dataDevolucao +
                "\nNumero de Dias: " + numeroDias +
                "\nValor: " + valor +
                "\nDesconto: " + desconto +
                "\nMulta: " + multa +
                "\nSubTotal: " + subTotal +
                cliente;
    }

}
