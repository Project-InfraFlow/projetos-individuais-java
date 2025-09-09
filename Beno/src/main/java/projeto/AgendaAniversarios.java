package projeto;

import java.util.Scanner;

public class AgendaAniversarios {

    public static void cadastrarAniversarios(String[] nomes, String[] datas, Integer quantidade, Scanner scanner) {
        for (Integer i = 0; i < quantidade; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();

            String data = "";
            while (true) {
                System.out.print("Digite a data de aniversário (dd/MM): ");
                data = scanner.nextLine();
                String[] partes = data.split("/");
                if (partes.length == 2) {
                    try {
                        Integer dia = Integer.parseInt(partes[0]);
                        Integer mes = Integer.parseInt(partes[1]);
                        if (dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12) {
                            break;
                        } else {
                            System.out.println("Dia ou mês inválido. Tente novamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Formato inválido. Digite números.");
                    }
                } else {
                    System.out.println("Formato errado. Use dd/MM.");
                }
            }
            datas[i] = data;
        }
    }

    public static void listarAniversarios(String[] nomes, String[] datas, Integer quantidade) {
        System.out.println("\n Lista de Aniversários:");
        for (Integer i = 0; i < quantidade; i++) {
            System.out.println(nomes[i] + " - " + datas[i]);
        }
    }

    public static void buscarPorMes(String[] nomes, String[] datas, Integer quantidade, Integer mes) {
        Boolean encontrado = false;
        System.out.println("\n Aniversariantes do mês " + mes + ":");
        for (Integer i = 0; i < quantidade; i++) {
            String[] partes = datas[i].split("/");
            try {
                Integer mesData = Integer.parseInt(partes[1]);
                if (mesData.equals(mes)) {
                    System.out.println(nomes[i] + " - " + datas[i]);
                    encontrado = true;
                }
            } catch (NumberFormatException e) {
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum aniversário encontrado neste mês.");
        }
    }

    public static void iniciarAgenda() {
        Scanner scanner = new Scanner(System.in);

        Integer quantidade = 0;
        while (quantidade <= 0) {
            System.out.print("Quantas pessoas deseja cadastrar? ");
            if (scanner.hasNextInt()) {
                quantidade = scanner.nextInt();
                scanner.nextLine();
                if (quantidade <= 0) {
                    System.out.println("Digite um número maior que zero.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.nextLine();
            }
        }

        String[] nomes = new String[quantidade];
        String[] datas = new String[quantidade];

        cadastrarAniversarios(nomes, datas, quantidade, scanner);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar todos os aniversários");
            System.out.println("2. Buscar aniversários por mês");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            Integer opcao = null;
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine();
                continue;
            }

            if (opcao.equals(1)) {
                listarAniversarios(nomes, datas, quantidade);
            }
            if (opcao.equals(2)) {
                System.out.print("Digite o número do mês (1 a 12): ");
                Integer mes = null;
                if (scanner.hasNextInt()) {
                    mes = scanner.nextInt();
                    scanner.nextLine();
                    if (mes < 1 || mes > 12) {
                        System.out.println("Mês inválido!");
                        continue;
                    }
                } else {
                    System.out.println("Digite um número válido!");
                    scanner.nextLine();
                    continue;
                }
                buscarPorMes(nomes, datas, quantidade, mes);
            }
            if (opcao.equals(3)) {
                System.out.println("Encerrando programa...");
                break;
            }
            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        iniciarAgenda();
    }
}