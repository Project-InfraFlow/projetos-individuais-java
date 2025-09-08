package flow.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GerenciadorDeTarefas {

    public List<String> cadastrarTarefas() throws InterruptedException {
        List<String> tarefas = new ArrayList<>();
        List<String> prioridadeTarefas = new ArrayList<>();
        Integer contador = 0;

        while (!contador.equals(1)) {
            TimeUnit.SECONDS.sleep(1);
            Scanner leitorTexto = new Scanner(System.in);
            Scanner leitorNumero = new Scanner(System.in);

            System.out.println();
            System.out.print("""
                    GERENCIADOR DE TAREFAS
                    ----------------------
       
                    - 1. Cadastrar Tarefas
                    - 2. Listar Tarefas
                    - 3. Concluir Tarefa
                    - 4. Encerrar Programa
                    
                    ----------------------
                    """);
            System.out.println();
            System.out.print("Escolha: ");
            Integer escolha = leitorNumero.nextInt();
            if (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4) {
                System.out.println("Informe um valor correspondente ao menu!");
            }
            if (escolha == 1) {
                System.out.print("Qual tarefa deseja cadastrar: ");
                String nomeTarefa = leitorTexto.nextLine();

                if (nomeTarefa.equals("")) {
                    System.out.println("Informe uma tarefa com mais caracteres.");
                }

                System.out.println();
                System.out.print("Qual a prioridade dessa tarefa (Importante ou Essencial): ");
                String prioridadeTarefa = leitorTexto.nextLine().toLowerCase();

                if (!prioridadeTarefa.equals("Importante") && !prioridadeTarefa.equals("importante") &&
                        !prioridadeTarefa.equals("Essencial") && !prioridadeTarefa.equals("essencial")) {
                    System.out.println("Informe corretamente a prioridade da tarefa!");
                    TimeUnit.SECONDS.sleep(1);
                } else {
                    TimeUnit.SECONDS.sleep(1);
                    prioridadeTarefas.add(prioridadeTarefa);
                    tarefas.add(nomeTarefa);
                    System.out.println("Tarefa: " + nomeTarefa + " com prioridade (" + prioridadeTarefa + ") adicionado!");
                    TimeUnit.SECONDS.sleep(1);
                }
            }

            if (escolha == 2) {
                if (tarefas.isEmpty()) {
                    System.out.println("Cadastre para visualizar suas tarefas.");
                    TimeUnit.SECONDS.sleep(2);
                } else {
                    System.out.println("1. Listar com prioridade em essenciais.");
                    System.out.println("2. Listar com prioridade em importantes.");
                    System.out.println("3. Listar sem ordem de prioridade.");
                    System.out.print("Escolha: ");
                    Integer escolhaLista = leitorNumero.nextInt();
                    if (escolhaLista == 1) {
                        for (int i = 0; i < tarefas.size(); i++) {
                            if (prioridadeTarefas.get(i).equals("essencial")) {
                                System.out.println( i + 1 + ". " + tarefas.get(i));
                            }
                        }
                    }

                    else if (escolhaLista == 2) {
                        for (int i = 0; i < tarefas.size(); i++) {
                            if (prioridadeTarefas.get(i).equals("importante")) {
                                System.out.println( i + 1 + ". " + tarefas.get(i));
                            }
                        }
                    }

                    else if (escolhaLista > 3 && escolhaLista <= 0) {
                        System.out.println("Informe um número que corresponda!");
                    }

                    else {
                        System.out.println("Lista de tarefas: ");
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println(i+1 + " - " + tarefas.get(i));
                        }
                        TimeUnit.SECONDS.sleep(2);
                    }
                }
            }

            if (escolha == 3) {
                if (tarefas.isEmpty()) {
                    System.out.println("Cadastre antes para acessar essa opção.");
                    TimeUnit.SECONDS.sleep(2);
                } else {

                    System.out.println("Escolha qual tarefa deseja concluir: ");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println(i + 1 + ". " + tarefas.get(i));
                    }
                    System.out.print("Escolha (número): ");
                    Integer escolhaTarefa = leitorNumero.nextInt();

                    TimeUnit.SECONDS.sleep(2);
                    if (escolhaTarefa <= tarefas.size()) {
                        System.out.println("Tarefa: " + tarefas.get(escolhaTarefa - 1) + " concluida!");
                        tarefas.remove(escolhaTarefa - 1);

                    } else {
                        System.out.println("Informe um número correspondente.");
                    }
                }
            }

            if (escolha == 4) {
                System.out.println("Encerrando Gerenciador de Tarefa. Até mais!");
                TimeUnit.SECONDS.sleep(1);
                break;
            }

        }
        return tarefas;
    }

}
