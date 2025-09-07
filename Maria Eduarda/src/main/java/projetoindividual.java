import java.util.Scanner;

public class projetoindividual {

    static class ControladorPortico {
        Integer id;
        String localizacao;
        String status;
        Integer faixas;

        ControladorPortico(Integer i, String l, String s, Integer f) {
            id = i;
            localizacao = l;
            status = s;
            faixas = f;
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        ControladorPortico[] controlador = new ControladorPortico[10];
        Integer contador = 0;

        Integer opcao = -1;

        while (opcao != 0) {
            System.out.println("\n------- MENU CONTROLADOR PÓRTICO -------");
            System.out.println("1 - Cadastrar controlador");
            System.out.println("2 - Listar controladores");
            System.out.println("3 - Atualizar status");
            System.out.println("4 - Remover controlador");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine();

            // CREATE
            if (opcao == 1) {
                if (contador < controlador.length) {
                    System.out.print("ID do controlador: ");
                    Integer id = leitor.nextInt();
                    leitor.nextLine();
                    System.out.print("Localização (Rodovia / Km): ");
                    String localizacao = leitor.nextLine();
                    System.out.print("Status (Ativo / Manutenção): ");
                    String status = leitor.nextLine();
                    System.out.print("Número de faixas: ");
                    Integer faixas = leitor.nextInt();
                    leitor.nextLine();

                    controlador[contador] = new ControladorPortico(id, localizacao, status, faixas);
                    contador++;
                    System.out.println("Controlador cadastrado!");
                } else {
                    System.out.println("Limite de controladores atingido.");
                }
            }

            // READ
            else if (opcao == 2) {
                System.out.println("\n--- LISTA DE CONTROLADORES ---");
                for (int i = 0; i < contador; i++) {
                    System.out.println("ID: " + controlador[i].id +
                            " | Localização: " + controlador[i].localizacao +
                            " | Status: " + controlador[i].status +
                            " | Faixas: " + controlador[i].faixas);
                }
                if (contador == 0) {
                    System.out.println("Nenhum controlador cadastrado.");
                }
            }

            // UPDATE
            else if (opcao == 3) {
                System.out.print("Digite o ID do controlador para atualizar: ");
                Integer idUpdate = leitor.nextInt();
                leitor.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < contador; i++) {
                    if (controlador[i].id.equals(idUpdate)) {
                        System.out.print("Novo status (Ativo / Manutenção): ");
                        controlador[i].status = leitor.nextLine();
                        System.out.println("Status atualizado!");
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Controlador não encontrado.");
                }
            }

            // DELETE
            else if (opcao == 4) {
                System.out.print("Digite o ID do controlador para remover: ");
                Integer idDelete = leitor.nextInt();
                leitor.nextLine();
                boolean encontrado = false;
                for (int i = 0; i < contador; i++) {
                    if (controlador[i].id.equals(idDelete)) {
                        controlador[i] = controlador[contador - 1];
                        controlador[contador - 1] = null;
                        contador--;
                        System.out.println("Controlador removido!");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("Controlador não encontrado.");
                }
            }

            // SAIR
            else if (opcao == 0) {
                System.out.println("Encerrando o sistema...");
            }

            // OPÇÃO INVÁLIDA
            else {
                System.out.println("Opção inválida.");
            }
        }

        leitor.close();
    }
}
