package academiajava.locacaofilme.models;

public class FilmeAtor {

    private Ator ator;
    private Filme filme;

    private Boolean isAtor;
    private Boolean isDiretor;

    public FilmeAtor() {
    }

    public FilmeAtor(Ator ator, Filme filme, Boolean isAtor, Boolean isDiretor) {
        this.ator = ator;
        this.filme = filme;
        this.isAtor = isAtor;
        this.isDiretor = isDiretor;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Boolean getIsAtor() {
        return isAtor;
    }

    public void setIsAtor(Boolean isAtor) {
        this.isAtor = isAtor;
    }

    public Boolean getIsDiretor() {
        return isDiretor;
    }

    public void setIsDiretor(Boolean isDiretor) {
        this.isDiretor = isDiretor;
    }

    @Override
    public String toString() {
        return "\nFILME ATOR" +
                ator +
                filme +
                "\nÉ Ator: " + isAtor +
                "\nÉ Diretor: " + isDiretor;
    }
}