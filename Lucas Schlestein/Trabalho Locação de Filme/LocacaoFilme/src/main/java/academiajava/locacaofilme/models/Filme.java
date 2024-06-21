package academiajava.locacaofilme.models;

public class Filme {

    private Integer id;
    private String tituloOriginal;
    private String titulo;
    private Integer quantidade;

    private Categoria categoria;
    private Genero genero;

    public Filme() {
    }

    public Filme(String tituloOriginal, String titulo, Integer quantidade, Categoria categoria, Genero genero) {
        this.tituloOriginal = tituloOriginal;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.genero = genero;
    }

    public Filme(Integer id, String tituloOriginal, String titulo, Integer quantidade, Categoria categoria, Genero genero) {
        this.id = id;
        this.tituloOriginal = tituloOriginal;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "\nFILME" +
                "\nId: " + id +
                "\nTitulo Original: " + tituloOriginal +
                "\nTitulo: " + titulo +
                "\nQuantidade: " + quantidade +
                categoria +
                genero;
    }
}
