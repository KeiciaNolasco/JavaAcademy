package academiajava.locacaofilme.models;

import java.math.BigDecimal;
import java.util.Date;

public class LocacaoFilme {

    private Locacao locacao;
    private Filme filme;

    private BigDecimal valor;
    private Integer numeroDias;
    private Date dataDevolucao;

    public LocacaoFilme() {
    }

    public LocacaoFilme(Locacao locacao, Filme filme, BigDecimal valor, Integer numeroDias, Date dataDevolucao) {
        this.locacao = locacao;
        this.filme = filme;
        this.valor = valor;
        this.numeroDias = numeroDias;
        this.dataDevolucao = dataDevolucao;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(Integer numeroDias) {
        this.numeroDias = numeroDias;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "\nLOCAÇÃO FILME" +
                locacao +
                filme +
                "\nValor: " + valor +
                "\nNúmero de Dias: " + numeroDias +
                "\nData de Devolução: " + dataDevolucao;
    }
}
