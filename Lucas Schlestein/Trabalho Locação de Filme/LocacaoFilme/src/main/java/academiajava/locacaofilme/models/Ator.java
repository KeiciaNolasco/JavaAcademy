package academiajava.locacaofilme.models;

public class Ator {

    private Integer id;
    private String nome;

    public Ator() {
    }

    public Ator(String nome) {
        this.nome = nome;
    }

    public Ator(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "\nATOR" +
                "\nId: " + id +
                "\nNome: " + nome;
    }
}
