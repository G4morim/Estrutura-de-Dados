package trabalho2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class AlegreteLocacoes {
    private static Lista<Categoria> categorias = new Lista<>();
    private static Lista<Veiculo> veiculos = new Lista<>();
    private static Lista<Cliente> clientes = new Lista<>();
    private static Lista<Locacao> locacoes = new Lista<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) {
        carregarDadosIniciais();
        exibirMenuPrincipal();
    }

    private static void carregarDadosIniciais() {
        try {
            // Carregar categorias
            BufferedReader br = new BufferedReader(new FileReader("Categorias.csv"));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 2) {
                    categorias.adicionar(new Categoria(dados[0], Integer.parseInt(dados[1])));
                }
            }
            br.close();

            // Carregar veículos
            br = new BufferedReader(new FileReader("Veiculos.csv"));
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 7) {
                    Categoria cat = categorias.buscar(new Categoria("", Integer.parseInt(dados[6])));
                    if (cat != null) {
                        veiculos.adicionar(new Veiculo(
                                dados[0], dados[1], dados[2], Integer.parseInt(dados[3]),
                                Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), cat));
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados iniciais: " + e.getMessage());
        }
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== Alegrete Locações ===");
            System.out.println("1. Gerenciar Categorias");
            System.out.println("2. Gerenciar Veículos");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("4. Gerenciar Locações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    gerenciarCategorias();
                    break;
                case 2:
                    gerenciarVeiculos();
                    break;
                case 3:
                    gerenciarClientes();
                    break;
                case 4:
                    gerenciarLocacoes();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void gerenciarCategorias() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Categorias ===");
            System.out.println("1. Incluir Categoria");
            System.out.println("2. Excluir Categoria");
            System.out.println("3. Editar Categoria");
            System.out.println("4. Listar Categorias (crescente)");
            System.out.println("5. Listar Categorias (decrescente)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    incluirCategoria();
                    break;
                case 2:
                    excluirCategoria();
                    break;
                case 3:
                    editarCategoria();
                    break;
                case 4:
                    listarCategorias(true);
                    break;
                case 5:
                    listarCategorias(false);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirCategoria() {
        System.out.print("Nome da categoria: ");
        String nome = scanner.nextLine();
        System.out.print("Identificador: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Categoria novaCategoria = new Categoria(nome, id);
        if (categorias.buscar(novaCategoria) == null) {
            categorias.adicionar(novaCategoria);
            System.out.println("Categoria adicionada com sucesso!");
        } else {
            System.out.println("Já existe uma categoria com este identificador!");
        }
    }

    private static void excluirCategoria() {
        System.out.print("Identificador da categoria a excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = new Categoria("", id);
        Categoria encontrada = categorias.buscar(cat);

        if (encontrada == null) {
            System.out.println("Categoria não encontrada!");
            return;
        }

        // Verificar se há veículos usando esta categoria
        boolean podeExcluir = true;
        for (int i = 0; i < veiculos.tamanho(); i++) {
            Veiculo v = veiculos.obter(i);
            if (v.getCategoria().equals(encontrada)) {
                podeExcluir = false;
                break;
            }
        }

        if (podeExcluir) {
            categorias.remover(encontrada);
            System.out.println("Categoria excluída com sucesso!");
        } else {
            System.out.println("Não é possível excluir: existem veículos associados a esta categoria!");
        }
    }

    private static void editarCategoria() {
        System.out.print("Identificador da categoria a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = new Categoria("", id);
        Categoria encontrada = categorias.buscar(cat);

        if (encontrada == null) {
            System.out.println("Categoria não encontrada!");
            return;
        }

        System.out.print("Novo nome da categoria: ");
        String novoNome = scanner.nextLine();
        encontrada.setNome(novoNome);
        System.out.println("Categoria atualizada com sucesso!");
    }

    private static void listarCategorias(boolean ordemCrescente) {
        System.out.println("\n=== Lista de Categorias ===");
        categorias.listar(ordemCrescente);
    }

    private static void gerenciarVeiculos() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Veículos ===");
            System.out.println("1. Incluir Veículo");
            System.out.println("2. Excluir Veículo");
            System.out.println("3. Editar Veículo");
            System.out.println("4. Listar Veículos (crescente)");
            System.out.println("5. Listar Veículos (decrescente)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    incluirVeiculo();
                    break;
                case 2:
                    excluirVeiculo();
                    break;
                case 3:
                    editarVeiculo();
                    break;
                case 4:
                    listarVeiculos(true);
                    break;
                case 5:
                    listarVeiculos(false);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirVeiculo() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Potência: ");
        int potencia = scanner.nextInt();
        System.out.print("Número de lugares: ");
        int lugares = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nCategorias disponíveis:");
        listarCategorias(true);
        System.out.print("Identificador da categoria: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = new Categoria("", idCategoria);
        Categoria encontrada = categorias.buscar(cat);

        if (encontrada == null) {
            System.out.println("Categoria não encontrada!");
            return;
        }

        Veiculo novoVeiculo = new Veiculo(placa, modelo, marca, ano, potencia, lugares, encontrada);
        if (veiculos.buscar(novoVeiculo) == null) {
            veiculos.adicionar(novoVeiculo);
            System.out.println("Veículo adicionado com sucesso!");
        } else {
            System.out.println("Já existe um veículo com esta placa!");
        }
    }

    private static void excluirVeiculo() {
        System.out.print("Placa do veículo a excluir: ");
        String placa = scanner.nextLine();

        Veiculo veic = new Veiculo(placa, "", "", 0, 0, 0, null);
        Veiculo encontrado = veiculos.buscar(veic);

        if (encontrado == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        // Verificar se o veículo está em alguma locação ativa
        boolean podeExcluir = true;
        for (int i = 0; i < locacoes.tamanho(); i++) {
            Locacao l = locacoes.obter(i);
            if (l.getPlaca().equals(placa)) {
                podeExcluir = false;
                break;
            }
        }

        if (podeExcluir) {
            veiculos.remover(encontrado);
            System.out.println("Veículo excluído com sucesso!");
        } else {
            System.out.println("Não é possível excluir: veículo está em uma locação ativa!");
        }
    }

    private static void editarVeiculo() {
        System.out.print("Placa do veículo a editar: ");
        String placa = scanner.nextLine();

        Veiculo veic = new Veiculo(placa, "", "", 0, 0, 0, null);
        Veiculo encontrado = veiculos.buscar(veic);

        if (encontrado == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        System.out.print("Novo modelo: ");
        encontrado.setModelo(scanner.nextLine());
        System.out.print("Nova marca: ");
        encontrado.setMarca(scanner.nextLine());
        System.out.print("Novo ano: ");
        encontrado.setAno(scanner.nextInt());
        System.out.print("Nova potência: ");
        encontrado.setPotencia(scanner.nextInt());
        System.out.print("Novo número de lugares: ");
        encontrado.setLugares(scanner.nextInt());
        scanner.nextLine();

        System.out.println("\nCategorias disponíveis:");
        listarCategorias(true);
        System.out.print("Novo identificador da categoria: ");
        int idCategoria = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = new Categoria("", idCategoria);
        Categoria encontrada = categorias.buscar(cat);

        if (encontrada != null) {
            encontrado.setCategoria(encontrada);
        } else {
            System.out.println("Categoria não encontrada - mantendo a anterior.");
        }

        System.out.println("Veículo atualizado com sucesso!");
    }

    private static void listarVeiculos(boolean ordemCrescente) {
        System.out.println("\n=== Lista de Veículos ===");
        veiculos.listar(ordemCrescente);
    }

    private static void gerenciarClientes() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Clientes ===");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Listar Clientes (crescente)");
            System.out.println("5. Listar Clientes (decrescente)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    excluirCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    listarClientes(true);
                    break;
                case 5:
                    listarClientes(false);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void incluirCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CNH: ");
        String cnh = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, cnh, telefone, cpf);
        if (clientes.buscar(novoCliente) == null) {
            clientes.adicionar(novoCliente);
            System.out.println("Cliente adicionado com sucesso!");
        } else {
            System.out.println("Já existe um cliente com este CPF!");
        }
    }

    private static void excluirCliente() {
        System.out.print("CPF do cliente a excluir: ");
        String cpf = scanner.nextLine();

        Cliente cli = new Cliente("", "", "", cpf);
        Cliente encontrado = clientes.buscar(cli);

        if (encontrado == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        // Verificar se o cliente está em alguma locação ativa
        boolean podeExcluir = true;
        for (int i = 0; i < locacoes.tamanho(); i++) {
            Locacao l = locacoes.obter(i);
            if (l.getCNH().equals(encontrado.getCNH())) {
                podeExcluir = false;
                break;
            }
        }

        if (podeExcluir) {
            clientes.remover(encontrado);
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Não é possível excluir: cliente está em uma locação ativa!");
        }
    }

    private static void editarCliente() {
        System.out.print("CPF do cliente a editar: ");
        String cpf = scanner.nextLine();

        Cliente cli = new Cliente("", "", "", cpf);
        Cliente encontrado = clientes.buscar(cli);

        if (encontrado == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Novo nome: ");
        encontrado.setNome(scanner.nextLine());
        System.out.print("Nova CNH: ");
        encontrado.setCNH(scanner.nextLine());
        System.out.print("Novo telefone: ");
        encontrado.setTelefone(scanner.nextLine());

        System.out.println("Cliente atualizado com sucesso!");
    }

    private static void listarClientes(boolean ordemCrescente) {
        System.out.println("\n=== Lista de Clientes ===");
        clientes.listar(ordemCrescente);
    }

    private static void gerenciarLocacoes() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Locações ===");
            System.out.println("1. Locar Veículo");
            System.out.println("2. Devolver Veículo");
            System.out.println("3. Listar Locações Ativas");
            System.out.println("4. Consultar Veículos Disponíveis");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    locarVeiculo();
                    break;
                case 2:
                    devolverVeiculo();
                    break;
                case 3:
                    listarLocacoesAtivas();
                    break;
                case 4:
                    consultarVeiculosDisponiveis();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void locarVeiculo() {
        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cli = new Cliente("", "", "", cpf);
        Cliente encontrado = clientes.buscar(cli);

        if (encontrado == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("\nVeículos disponíveis:");
        listarVeiculosDisponiveis();

        System.out.print("\nPlaca do veículo a ser locado: ");
        String placa = scanner.nextLine();

        Veiculo veic = new Veiculo(placa, "", "", 0, 0, 0, null);
        Veiculo encontradoVeic = veiculos.buscar(veic);

        if (encontradoVeic == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        // Verificar se o veículo já está locado
        for (int i = 0; i < locacoes.tamanho(); i++) {
            Locacao l = locacoes.obter(i);
            if (l.getPlaca().equals(placa)) {
                System.out.println("Veículo já está locado!");
                return;
            }
        }

        try {
            System.out.print("Data de retirada (dd/MM/yyyy): ");
            Date retirada = sdf.parse(scanner.nextLine());
            System.out.print("Data de devolução (dd/MM/yyyy): ");
            Date devolucao = sdf.parse(scanner.nextLine());
            System.out.print("Valor a ser pago: ");
            double valor = scanner.nextDouble();
            scanner.nextLine();

            Locacao novaLocacao = new Locacao(encontrado.getCNH(), placa, retirada, devolucao, valor);
            locacoes.adicionar(novaLocacao);
            System.out.println("Locação registrada com sucesso!");
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
        }
    }

    private static void devolverVeiculo() {
        System.out.print("Placa do veículo a ser devolvido: ");
        String placa = scanner.nextLine();

        Veiculo veic = new Veiculo(placa, "", "", 0, 0, 0, null);
        Veiculo encontrado = veiculos.buscar(veic);

        if (encontrado == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        Locacao loc = new Locacao("", placa, null, null, 0);
        Locacao encontrada = locacoes.buscar(loc);

        if (encontrada == null) {
            System.out.println("Não há locação ativa para este veículo!");
            return;
        }

        locacoes.remover(encontrada);
        System.out.println("Veículo devolvido com sucesso!");
    }

    private static void listarLocacoesAtivas() {
        System.out.println("\n=== Locações Ativas ===");
        locacoes.listar(true);
    }

    private static void consultarVeiculosDisponiveis() {
        System.out.println("\n=== Filtros de Veículos Disponíveis ===");
        System.out.println("1. Sem filtro");
        System.out.println("2. Por potência");
        System.out.println("3. Por número de lugares");
        System.out.println("4. Por categoria");
        System.out.println("5. Múltiplos filtros");
        System.out.print("Escolha uma opção: ");

        int opcaoFiltro = scanner.nextInt();
        scanner.nextLine();

        int potenciaMin = 0;
        int lugaresMin = 0;
        int idCategoria = -1;

        switch (opcaoFiltro) {
            case 2:
                System.out.print("Potência mínima: ");
                potenciaMin = scanner.nextInt();
                scanner.nextLine();
                break;
            case 3:
                System.out.print("Número mínimo de lugares: ");
                lugaresMin = scanner.nextInt();
                scanner.nextLine();
                break;
            case 4:
                System.out.println("\nCategorias disponíveis:");
                listarCategorias(true);
                System.out.print("Identificador da categoria: ");
                idCategoria = scanner.nextInt();
                scanner.nextLine();
                break;
            case 5:
                System.out.print("Potência mínima (0 para ignorar): ");
                potenciaMin = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Número mínimo de lugares (0 para ignorar): ");
                lugaresMin = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\nCategorias disponíveis:");
                listarCategorias(true);
                System.out.print("Identificador da categoria (0 para ignorar): ");
                idCategoria = scanner.nextInt();
                scanner.nextLine();
                break;
        }

        System.out.println("\nOrdem de exibição:");
        System.out.println("1. Crescente");
        System.out.println("2. Decrescente");
        System.out.print("Escolha uma opção: ");
        boolean ordemCrescente = scanner.nextInt() == 1;
        scanner.nextLine();

        System.out.println("\n=== Veículos Disponíveis ===");

        // Criar lista temporária de veículos disponíveis que atendem aos filtros
        Lista<Veiculo> disponiveis = new Lista<>();

        for (int i = 0; i < veiculos.tamanho(); i++) {
            Veiculo v = veiculos.obter(i);
            boolean disponivel = true;

            // Verificar se o veículo está locado
            for (int j = 0; j < locacoes.tamanho(); j++) {
                if (locacoes.obter(j).getPlaca().equals(v.getPlaca())) {
                    disponivel = false;
                    break;
                }
            }

            if (disponivel) {
                // Aplicar filtros
                boolean atendeFiltros = true;
                if (potenciaMin > 0 && v.getPotencia() < potenciaMin) {
                    atendeFiltros = false;
                }
                if (lugaresMin > 0 && v.getLugares() < lugaresMin) {
                    atendeFiltros = false;
                }
                if (idCategoria > 0 && v.getCategoria().getIdentificador() != idCategoria) {
                    atendeFiltros = false;
                }

                if (atendeFiltros) {
                    disponiveis.adicionar(v);
                }
            }
        }

        disponiveis.listar(ordemCrescente);
    }

    private static void listarVeiculosDisponiveis() {
        // Criar lista temporária de veículos disponíveis
        Lista<Veiculo> disponiveis = new Lista<>();

        for (int i = 0; i < veiculos.tamanho(); i++) {
            Veiculo v = veiculos.obter(i);
            boolean disponivel = true;

            // Verificar se o veículo está locado
            for (int j = 0; j < locacoes.tamanho(); j++) {
                if (locacoes.obter(j).getPlaca().equals(v.getPlaca())) {
                    disponivel = false;
                    break;
                }
            }

            if (disponivel) {
                disponiveis.adicionar(v);
            }
        }

        disponiveis.listar(true);
    }
}

