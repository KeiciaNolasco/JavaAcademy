package academiajava.locacaofilme.models;

public class Cliente {

    private Integer id;
    private String cpf;
    private String nome;
    private String telefone;

    private Profissao profissao;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String telefone, Profissao profissao) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.profissao = profissao;
    }

    public Cliente(Integer id, String cpf, String nome, String telefone, Profissao profissao) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.profissao = profissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    @Override
    public String toString() {
        return "\nCLIENTE" +
                "\nId: " + id +
                "\nCPF: " + cpf +
                "\nNome: " + nome +
                "\nTelefone: " + telefone +
                profissao;
    }

}
