package academiajava.locacaofilme.services;

import academiajava.locacaofilme.daos.*;

public class DAOLoader {

    public static AtorDAO createAtorDAO() {
        return new AtorDAO();
    }

    public static CategoriaDAO createCategoriaDAO() {
        return new CategoriaDAO();
    }

    public static ClienteDAO createClienteDAO() {
        return new ClienteDAO();
    }

    public static ClienteEnderecoDAO createClienteEnderecoDAO() {
        return new ClienteEnderecoDAO();
    }

    public static DependenteDAO createDependenteDAO() {
        return new DependenteDAO();
    }

    public static EnderecoDAO createEnderecoDAO() {
        return new EnderecoDAO();
    }

    public static FilmeDAO createFilmeDAO() {
        return new FilmeDAO();
    }

    public static FilmeAtorDAO createFilmeAtorDAO() {
        return new FilmeAtorDAO();
    }

    public static GeneroDAO createGeneroDAO() {
        return new GeneroDAO();
    }

    public static LocacaoDAO createLocacaoDAO() {
        return new LocacaoDAO();
    }

    public static LocacaoFilmeDAO createLocacaoFilmeDAO() {
        return new LocacaoFilmeDAO();
    }

    public static ProfissaoDAO createProfissaoDAO() {
        return new ProfissaoDAO();
    }

}