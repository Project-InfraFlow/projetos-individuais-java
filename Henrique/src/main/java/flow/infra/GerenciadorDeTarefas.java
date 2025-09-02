package flow.infra;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GerenciadorDeTarefas {

    public List<String> cadastrarTarefas() throws InterruptedException {
        List<String> tarefas = new ArrayList<>();
        Integer contador = 0;

        while (!contador.equals(1)) {
            TimeUnit.SECONDS.sleep(1);
            Scanner leitorTexto = new Scanner(System.in);
            Scanner leitorNumero = new Scanner(System.in);

            System.out.println();
            System.out.print("""
                    GERENCIADOR DE TAREFAS
                    ----------------------
                    MENU:
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
                tarefas.add(nomeTarefa);
                System.out.println("Tarefa: " + nomeTarefa + " adicionado!");
            }

            if (escolha == 2) {
                System.out.println("Lista de tarefas: ");
                for (int i = 0; i < tarefas.size(); i++) {
                    System.out.println(i+1 + " - " + tarefas.get(i));
                }
                TimeUnit.SECONDS.sleep(3);
            }

            if (escolha == 3) {
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
