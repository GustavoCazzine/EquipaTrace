package app;

import app.model.Ferramenta;
import app.model.Laptop;
import app.model.Localizacao;
import app.service.AlmoxarifadoService;
import app.service.PersistenciaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlmoxarifadoService service = new AlmoxarifadoService();
        Scanner scanner = new Scanner(System.in);

        service.lerDados();

        while (true){
            System.out.println("1. Cadastrar Equipamento \n2. Listar Equipamentos \n3. Transferir Equipamentos \n4. Sair");
            int opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario){
                case 1:
                    System.out.println("--- Cadastrar Equipamento ---");
                    System.out.print("Digite o ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.println("Selecione a Localização: (1) Piracicaba | (2) Campo Largo");
                    int locEscolha = Integer.parseInt(scanner.nextLine());

                    Localizacao localizacaoSelecionada = null;
                    if (locEscolha == 1) {
                        localizacaoSelecionada = Localizacao.PIRACICABA;
                    } else if (locEscolha == 2) {
                        localizacaoSelecionada = Localizacao.CAMPO_LARGO;
                    } else {
                        System.out.println("Opção inválida! Usando Piracicaba como padrão.");
                        localizacaoSelecionada = Localizacao.PIRACICABA; // Fail-safe
                    }

                    // AQUI OCORRE A BIFURCAÇÃO
                    System.out.println("Qual o tipo? (1) Laptop | (2) Ferramenta");
                    int tipoEscolha = Integer.parseInt(scanner.nextLine());

                    if (tipoEscolha == 1) {
                        // É Laptop? Pergunto coisa de Laptop
                        System.out.print("Processador: ");
                        String proc = scanner.nextLine();

                        // Uso o CONSTRUTOR CHEIO do Laptop
                        Laptop novoNote = new Laptop(id, nome, marca, localizacaoSelecionada, proc);
                        service.adicionar(novoNote);

                    } else if (tipoEscolha == 2) {
                        // É Ferramenta? Pergunto coisa de Ferramenta
                        System.out.print("Voltagem: ");
                        double volt = Double.parseDouble(scanner.nextLine());

                        // Uso o CONSTRUTOR CHEIO da Ferramenta
                        Ferramenta novaFerr = new Ferramenta(id, nome, marca, localizacaoSelecionada, volt);
                        service.adicionar(novaFerr);

                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    service.listarTodos();
                    break;
                case 3:
                    System.out.println("ID: ");
                    String idItem = scanner.nextLine();

                    System.out.println("Selecione a Localização: (1) Piracicaba | (2) Campo Largo");
                    int locUser = Integer.parseInt(scanner.nextLine());

                    Localizacao novaLoc = null;
                    if (locUser == 1) {
                        novaLoc = Localizacao.PIRACICABA;
                    } else if (locUser == 2) {
                        novaLoc = Localizacao.CAMPO_LARGO;
                    } else {
                        System.out.println("Opção inválida! Usando Piracicaba como padrão.");
                        novaLoc = Localizacao.PIRACICABA; // Fail-safe
                    }

                    service.transferir(idItem, novaLoc);
                    break;
                case 4:
                    System.out.println("Finalizando sistema...");
                    service.salvarDados();
                    return;
            }
        }

    }
}
