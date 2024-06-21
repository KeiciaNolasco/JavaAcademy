package academiajava.locacaofilme.models;

import java.math.BigDecimal;
import java.util.Date;

public class Locacao {

    private Integer id;
    private Date dataLocacao;
    private BigDecimal desconto;
    private BigDecimal multa;
    private BigDecimal subTotal;

    private Cliente cliente;

    public Locacao() {
    }

    public Locacao(Date dataLocacao, BigDecimal desconto, BigDecimal multa, BigDecimal subTotal, Cliente cliente) {
        this.dataLocacao = dataLocacao;
        this.desconto = desconto;
        this.multa = multa;
        this.subTotal = subTotal;
        this.cliente = cliente;
    }

    public Locacao(Integer id, Date dataLocacao, BigDecimal desconto, BigDecimal multa, BigDecimal subTotal, Cliente cliente) {
        this.id = id;
        this.dataLocacao = dataLocacao;
        this.desconto = desconto;
        this.multa = multa;
        this.subTotal = subTotal;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Date dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getMulta() {
        return multa;
    }

    public void setMulta(BigDecimal multa) {
        this.multa = multa;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "\nLOCAÇÃO" +
                "\nId: " + id +
                "\nData da Locaçãoo: " + dataLocacao +
                "\nDesconto: " + desconto +
                "\nMulta: " + multa +
                "\nSubTotal: " + subTotal +
                cliente;
    }

}
