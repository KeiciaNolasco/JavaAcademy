package academiajava.locacaofilme.models;

public class Dependente {

    private Cliente cliente;
    private Cliente dependente;
    private String parentesco;

    public Dependente() {
    }

    public Dependente(Cliente cliente, Cliente dependente, String parentesco) {
        this.cliente = cliente;
        this.dependente = dependente;
        this.parentesco = parentesco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getDependente() {
        return dependente;
    }

    public void setDependente(Cliente dependente) {
        this.dependente = dependente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    @Override
    public String toString() {
        return "\n" + cliente +
                "\nDEPENDENTE: " + dependente +
                "\nPARENTESCO: " + parentesco;
    }
}
