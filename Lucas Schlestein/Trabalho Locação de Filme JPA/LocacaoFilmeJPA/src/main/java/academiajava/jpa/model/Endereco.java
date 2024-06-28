package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco {

    @Id
    @Column(name="COD_END",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="Logradouro", nullable=false)
    private String logradouro;

    @Column(name="TipoLogradouro", nullable=false)
    private String tipoLogradouro;

    @Column(name="Complemento", nullable=false)
    private String complemento;

    @Column(name="Cidade", nullable=false)
    private String cidade;

    @Column(nullable=false, length=2, name="UF")
    private String uf;

    @Column(name="CEP", nullable=false)
    private Integer cep;

    @Column(name="Numero", nullable=false)
    private Integer numero;

    @Column(name="Bairro", nullable=false)
    private String bairro;

    @OneToMany(mappedBy = "endereco", fetch = FetchType.EAGER)
    private List<Cliente> clientes;

    public Endereco(String logradouro, String tipoLogradouro, String complemento, String cidade, String uf, Integer cep, Integer numero, String bairro) {
        this.logradouro = logradouro;
        this.tipoLogradouro = tipoLogradouro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "\nENDEREÇO" +
                "\nId: " + id +
                "\nLogradouro: " + logradouro +
                "\nTipo de Logradouro: " + tipoLogradouro +
                "\nComplemento: " + complemento +
                "\nCidade: " + cidade +
                "\nUF: " + uf +
                "\nCEP: " + cep +
                "\nNúmero: " + numero +
                "\nBairro: " + bairro;
    }

}
