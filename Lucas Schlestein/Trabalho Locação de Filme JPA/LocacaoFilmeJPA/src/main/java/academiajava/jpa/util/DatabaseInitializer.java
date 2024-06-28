package academiajava.jpa.util;

import academiajava.jpa.dao.*;
import academiajava.jpa.model.*;

import java.util.Arrays;
import java.util.List;

public class DatabaseInitializer {

    public static void initialize() {
        if (isInitialized()) {
            System.out.println("Database already initialized.");
            return;
        }

        GeneroDAO generoDAO = new GeneroDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        AtorDAO atorDAO = new AtorDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        DependenteDAO dependenteDAO = new DependenteDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();

        List<Genero> generos = Arrays.asList(
                new Genero("Ação"),
                new Genero("Aventura"),
                new Genero("Comédia"),
                new Genero("Drama"),
                new Genero("Fantasia"),
                new Genero("Ficção Científica"),
                new Genero("Super-herói")
        );
        generos.forEach(generoDAO::persist);

        List<Categoria> categorias = Arrays.asList(
                new Categoria("Lançamento", 5.00),
                new Categoria("Padrão", 2.50),
                new Categoria("Clássico", 1.00)
        );
        categorias.forEach(categoriaDAO::persist);

        List<Ator> atores = Arrays.asList(
                new Ator("Robert Downey Jr.", true, false),
                new Ator("Chris Evans", true, false),
                new Ator("Chris Hemsworth", true, false),
                new Ator("Mark Ruffalo", false, true),
                new Ator("Scarlett Johansson", true, false),
                new Ator("Jeremy Renner", true, false),
                new Ator("Tom Holland", true, false),
                new Ator("Chadwick Boseman", true, false),
                new Ator("Benedict Cumberbatch", true, false),
                new Ator("Paul Rudd", false, true),
                new Ator("Brie Larson", true, false),
                new Ator("Chris Pratt", true, false),
                new Ator("Zoe Saldana", true, false),
                new Ator("Dave Bautista", true, false),
                new Ator("Josh Brolin", true, false)
        );
        atores.forEach(atorDAO::persist);

        List<Filme> filmes = Arrays.asList(
                Filme.builder().tituloOriginal("Homem de Ferro").titulo("Homem de Ferro").quantidade(5).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(0))).build(),
                Filme.builder().tituloOriginal("O Incrível Hulk").titulo("O Incrível Hulk").quantidade(3).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(4))).build(),
                Filme.builder().tituloOriginal("Homem de Ferro 2").titulo("Homem de Ferro 2").quantidade(4).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(0))).build(),
                Filme.builder().tituloOriginal("Thor").titulo("Thor").quantidade(4).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(3))).build(),
                Filme.builder().tituloOriginal("Capitão América: O Primeiro Vingador").titulo("Capitão América: O Primeiro Vingador").quantidade(4).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(2))).build(),
                Filme.builder().tituloOriginal("Os Vingadores").titulo("Os Vingadores").quantidade(6).categoria(categorias.get(1)).genero(generos.get(4)).atores(Arrays.asList(atorDAO.findById(1))).build(),
                Filme.builder().tituloOriginal("Homem de Ferro 3").titulo("Homem de Ferro 3").quantidade(4).categoria(categorias.get(1)).genero(generos.get(4)).atores(Arrays.asList(atorDAO.findById(4))).build(),
                Filme.builder().tituloOriginal("Thor: O Mundo Sombrio").titulo("Thor: O Mundo Sombrio").quantidade(3).categoria(categorias.get(1)).genero(generos.get(4)).atores(Arrays.asList(atorDAO.findById(2))).build(),
                Filme.builder().tituloOriginal("Capitão América: O Soldado Invernal").titulo("Capitão América: O Soldado Invernal").quantidade(4).categoria(categorias.get(2)).genero(generos.get(5)).atores(Arrays.asList(atorDAO.findById(5))).build(),
                Filme.builder().tituloOriginal("Guardiões da Galáxia").titulo("Guardiões da Galáxia").quantidade(5).categoria(categorias.get(2)).genero(generos.get(5)).atores(Arrays.asList(atorDAO.findById(6))).build(),
                Filme.builder().tituloOriginal("Vingadores: Era de Ultron").titulo("Vingadores: Era de Ultron").quantidade(6).categoria(categorias.get(2)).genero(generos.get(5)).atores(Arrays.asList(atorDAO.findById(1))).build(),
                Filme.builder().tituloOriginal("Homem-Formiga").titulo("Homem-Formiga").quantidade(3).categoria(categorias.get(2)).genero(generos.get(5)).atores(Arrays.asList(atorDAO.findById(3))).build(),
                Filme.builder().tituloOriginal("Capitão América: Guerra Civil").titulo("Capitão América: Guerra Civil").quantidade(5).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(7))).build(),
                Filme.builder().tituloOriginal("Doutor Estranho").titulo("Doutor Estranho").quantidade(4).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(8))).build(),
                Filme.builder().tituloOriginal("Guardiões da Galáxia Vol. 2").titulo("Guardiões da Galáxia Vol. 2").quantidade(5).categoria(categorias.get(0)).genero(generos.get(0)).atores(Arrays.asList(atorDAO.findById(9))).build()
        );
        filmes.forEach(filmeDAO::persist);

        List<Endereco> enderecos = Arrays.asList(
                new Endereco("Rua das Flores", "Rua", "Apto 101", "São Paulo", "SP", 1001000, 100, "Centro"),
                new Endereco("Avenida Paulista", "Avenida", "Conj. 200", "São Paulo", "SP", 1311200, 2000, "Bela Vista"),
                new Endereco("Rua Augusta", "Rua", "Casa", "São Paulo", "SP", 1412100, 300, "Consolação"),
                new Endereco("Rua da Consolação", "Rua", "Apto 202", "São Paulo", "SP", 1303000, 400, "Consolação"),
                new Endereco("Rua Vergueiro", "Rua", "Bloco A", "São Paulo", "SP", 1504000, 500, "Liberdade"),
                new Endereco("Avenida Faria Lima", "Avenida", "Conj. 300", "São Paulo", "SP", 1451001, 6000, "Itaim Bibi"),
                new Endereco("Rua 25 de Março", "Rua", "Loja 10", "São Paulo", "SP", 1001010, 700, "Centro"),
                new Endereco("Avenida Ipiranga", "Avenida", "Sala 500", "São Paulo", "SP", 1002000, 800, "República"),
                new Endereco("Rua Oscar Freire", "Rua", "Casa", "São Paulo", "SP", 1426000, 900, "Jardins"),
                new Endereco("Rua Haddock Lobo", "Rua", "Apto 303", "São Paulo", "SP", 1414001, 1000, "Cerqueira César")
        );
        enderecos.forEach(enderecoDAO::persist);

        List<Profissao> profissoes = Arrays.asList(
                new Profissao("Engenheiro"),
                new Profissao("Médico"),
                new Profissao("Professor"),
                new Profissao("Advogado"),
                new Profissao("Arquiteto"),
                new Profissao("Programador"),
                new Profissao("Enfermeiro"),
                new Profissao("Farmacêutico"),
                new Profissao("Dentista"),
                new Profissao("Jornalista")
        );
        profissoes.forEach(profissaoDAO::persist);

        List<Cliente> clientes = Arrays.asList(
                Cliente.builder().cpf(12345678901L).nome("João Silva").telefone(11987654321L).profissao(profissoes.get(0)).endereco(enderecos.get(0)).build(),
                Cliente.builder().cpf(23456789012L).nome("Maria Souza").telefone(11976543210L).profissao(profissoes.get(1)).endereco(enderecos.get(0)).build(),
                Cliente.builder().cpf(34567890123L).nome("José Santos").telefone(11965432109L).profissao(profissoes.get(2)).endereco(enderecos.get(2)).build(),
                Cliente.builder().cpf(45678901234L).nome("Ana Oliveira").telefone(11954321098L).profissao(profissoes.get(3)).endereco(enderecos.get(2)).build(),
                Cliente.builder().cpf(56789012345L).nome("Carlos Pereira").telefone(11943210987L).profissao(profissoes.get(4)).endereco(enderecos.get(4)).build(),
                Cliente.builder().cpf(67890123456L).nome("Paula Lima").telefone(11932109876L).profissao(profissoes.get(5)).endereco(enderecos.get(4)).build(),
                Cliente.builder().cpf(78901234567L).nome("Rafael Costa").telefone(11921098765L).profissao(profissoes.get(6)).endereco(enderecos.get(6)).build(),
                Cliente.builder().cpf(89012345678L).nome("Fernanda Alves").telefone(11910987654L).profissao(profissoes.get(7)).endereco(enderecos.get(6)).build(),
                Cliente.builder().cpf(90123456789L).nome("Lucas Rodrigues").telefone(11909876543L).profissao(profissoes.get(8)).endereco(enderecos.get(8)).build(),
                Cliente.builder().cpf(11234567890L).nome("Juliana Fernandes").telefone(11998765432L).profissao(profissoes.get(9)).endereco(enderecos.get(8)).build()
        );
        clientes.forEach(clienteDAO::persist);

        List<Dependente> dependentes = Arrays.asList(
                Dependente.builder().cliente(clientes.get(0)).dependente(clientes.get(1)).parentesco("Esposa").build(),
                Dependente.builder().cliente(clientes.get(2)).dependente(clientes.get(3)).parentesco("Filho").build(),
                Dependente.builder().cliente(clientes.get(4)).dependente(clientes.get(5)).parentesco("Filha").build(),
                Dependente.builder().cliente(clientes.get(6)).dependente(clientes.get(7)).parentesco("Pai").build(),
                Dependente.builder().cliente(clientes.get(8)).dependente(clientes.get(9)).parentesco("Mãe").build()
        );
        dependentes.forEach(dependenteDAO::persist);

        List<Locacao> locacoes = Arrays.asList(
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-01-01")).dataDevolucao(java.sql.Date.valueOf("2022-01-04")).numeroDias(3).valor(10.00).desconto(5.00).multa(2.00).subTotal(50.00).cliente(clienteDAO.findById(1)).filmes(Arrays.asList(filmeDAO.findById(1))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-01-05")).dataDevolucao(java.sql.Date.valueOf("2022-01-09")).numeroDias(4).valor(15.00).desconto(0.00).multa(0.00).subTotal(30.00).cliente(clienteDAO.findById(2)).filmes(Arrays.asList(filmeDAO.findById(2))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-01-10")).dataDevolucao(java.sql.Date.valueOf("2022-01-15")).numeroDias(5).valor(20.00).desconto(10.00).multa(0.00).subTotal(40.00).cliente(clienteDAO.findById(3)).filmes(Arrays.asList(filmeDAO.findById(3))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-01-15")).dataDevolucao(java.sql.Date.valueOf("2022-01-21")).numeroDias(6).valor(25.00).desconto(0.00).multa(5.00).subTotal(50.00).cliente(clienteDAO.findById(4)).filmes(Arrays.asList(filmeDAO.findById(4))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-01-20")).dataDevolucao(java.sql.Date.valueOf("2022-01-27")).numeroDias(7).valor(30.00).desconto(5.00).multa(0.00).subTotal(60.00).cliente(clienteDAO.findById(5)).filmes(Arrays.asList(filmeDAO.findById(5))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-01-25")).dataDevolucao(java.sql.Date.valueOf("2022-02-02")).numeroDias(8).valor(35.00).desconto(0.00).multa(2.00).subTotal(70.00).cliente(clienteDAO.findById(6)).filmes(Arrays.asList(filmeDAO.findById(6))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-02-01")).dataDevolucao(java.sql.Date.valueOf("2022-02-08")).numeroDias(9).valor(40.00).desconto(0.00).multa(0.00).subTotal(80.00).cliente(clienteDAO.findById(7)).filmes(Arrays.asList(filmeDAO.findById(7))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-02-05")).dataDevolucao(java.sql.Date.valueOf("2022-02-14")).numeroDias(10).valor(45.00).desconto(10.00).multa(0.00).subTotal(90.00).cliente(clienteDAO.findById(8)).filmes(Arrays.asList(filmeDAO.findById(8))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-02-10")).dataDevolucao(java.sql.Date.valueOf("2022-02-20")).numeroDias(11).valor(50.00).desconto(0.00).multa(5.00).subTotal(100.00).cliente(clienteDAO.findById(9)).filmes(Arrays.asList(filmeDAO.findById(9))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-02-15")).dataDevolucao(java.sql.Date.valueOf("2022-02-26")).numeroDias(12).valor(55.00).desconto(0.00).multa(0.00).subTotal(110.00).cliente(clienteDAO.findById(10)).filmes(Arrays.asList(filmeDAO.findById(10))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-02-20")).dataDevolucao(java.sql.Date.valueOf("2022-03-04")).numeroDias(13).valor(60.00).desconto(5.00).multa(2.00).subTotal(120.00).cliente(clienteDAO.findById(1)).filmes(Arrays.asList(filmeDAO.findById(7))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-02-25")).dataDevolucao(java.sql.Date.valueOf("2022-03-10")).numeroDias(14).valor(65.00).desconto(0.00).multa(0.00).subTotal(130.00).cliente(clienteDAO.findById(2)).filmes(Arrays.asList(filmeDAO.findById(8))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-03-01")).dataDevolucao(java.sql.Date.valueOf("2022-03-16")).numeroDias(15).valor(70.00).desconto(10.00).multa(0.00).subTotal(140.00).cliente(clienteDAO.findById(3)).filmes(Arrays.asList(filmeDAO.findById(9))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-03-05")).dataDevolucao(java.sql.Date.valueOf("2022-03-22")).numeroDias(16).valor(75.00).desconto(0.00).multa(5.00).subTotal(150.00).cliente(clienteDAO.findById(4)).filmes(Arrays.asList(filmeDAO.findById(11))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-03-10")).dataDevolucao(java.sql.Date.valueOf("2022-03-28")).numeroDias(17).valor(80.00).desconto(5.00).multa(0.00).subTotal(160.00).cliente(clienteDAO.findById(5)).filmes(Arrays.asList(filmeDAO.findById(12))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-03-15")).dataDevolucao(java.sql.Date.valueOf("2022-04-04")).numeroDias(18).valor(85.00).desconto(0.00).multa(2.00).subTotal(170.00).cliente(clienteDAO.findById(6)).filmes(Arrays.asList(filmeDAO.findById(13))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-03-20")).dataDevolucao(java.sql.Date.valueOf("2022-04-10")).numeroDias(19).valor(90.00).desconto(0.00).multa(0.00).subTotal(180.00).cliente(clienteDAO.findById(7)).filmes(Arrays.asList(filmeDAO.findById(14))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-03-25")).dataDevolucao(java.sql.Date.valueOf("2022-04-15")).numeroDias(20).valor(95.00).desconto(10.00).multa(0.00).subTotal(190.00).cliente(clienteDAO.findById(8)).filmes(Arrays.asList(filmeDAO.findById(15))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-04-01")).dataDevolucao(java.sql.Date.valueOf("2022-04-20")).numeroDias(21).valor(100.00).desconto(0.00).multa(5.00).subTotal(200.00).cliente(clienteDAO.findById(9)).filmes(Arrays.asList(filmeDAO.findById(16))).build(),
                Locacao.builder().dataLocacao(java.sql.Date.valueOf("2022-04-05")).dataDevolucao(java.sql.Date.valueOf("2022-04-25")).numeroDias(22).valor(105.00).desconto(0.00).multa(0.00).subTotal(210.00).cliente(clienteDAO.findById(10)).filmes(Arrays.asList(filmeDAO.findById(17))).build()
        );
        locacoes.forEach(locacaoDAO::persist);
    }

    private static boolean isInitialized() {
        GeneroDAO generoDAO = new GeneroDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FilmeDAO filmeDAO = new FilmeDAO();
        AtorDAO atorDAO = new AtorDAO();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        DependenteDAO dependenteDAO = new DependenteDAO();
        LocacaoDAO locacaoDAO = new LocacaoDAO();

        try {
            return !generoDAO.findAll().isEmpty()
                    && !categoriaDAO.findAll().isEmpty()
                    && !filmeDAO.findAll().isEmpty()
                    && !atorDAO.findAll().isEmpty()
                    && !enderecoDAO.findAll().isEmpty()
                    && !profissaoDAO.findAll().isEmpty()
                    && !clienteDAO.findAll().isEmpty()
                    && !dependenteDAO.findAll().isEmpty()
                    && !locacaoDAO.findAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

}
