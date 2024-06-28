package academiajava.jpa.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @Column(name="COD_CLI",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="CPF", nullable=false)
    private Long cpf;

    @Column(unique=true, nullable=false, length=60, name="Nome")
    private String nome;

    @Column(name="Telefone", nullable=false)
    private Long telefone;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_PROF")
    private Profissao profissao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_END")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Dependente> dependentes;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Locacao> locacoes;

    public Cliente(Long cpf, String nome, Long telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\nCLIENTE" +
                "\nId: " + id +
                "\nCPF: " + cpf +
                "\nNome: " + nome +
                "\nTelefone: " + telefone +
                profissao +
                endereco;
    }

}
