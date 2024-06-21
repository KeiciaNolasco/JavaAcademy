package academiajava.locacaofilme.models;

public class ClienteEndereco {

    private Endereco endereco;
    private Cliente cliente;

    public ClienteEndereco() {
    }

    public ClienteEndereco(Endereco endereco, Cliente cliente) {
        this.endereco = endereco;
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "\nCLIENTE ENDEREÇO" +
                endereco +
                cliente;
    }
}
