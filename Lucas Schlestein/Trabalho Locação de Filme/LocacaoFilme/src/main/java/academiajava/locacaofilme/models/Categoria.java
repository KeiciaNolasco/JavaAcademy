package academiajava.locacaofilme.models;

import java.math.BigDecimal;

public class Categoria {

    private Integer id;
    private String nome;
    private BigDecimal valor;

    public Categoria() {
    }

    public Categoria(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Categoria(Integer id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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
