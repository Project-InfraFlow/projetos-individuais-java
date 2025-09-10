package school.sptech;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Funcoes {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerText = new Scanner(System.in);
    Double valorPrato;
    String nomePrato;
    List<String> pratosIniciais = new ArrayList<>(List.of("Manti", "Nachos", "Samosa","Sushi Arco-Íris", "Bruschetta", "Avocado", "Salada Caesar"));
    List<Double> precoPratosIniciais = new ArrayList<>(List.of(7.00, 5.00, 6.00, 16.00, 11.00, 13.00, 14.00));
    List<String> pratosPrincipais = new ArrayList<>(List.of("Ramem", "Feijoada", "Paella", "Carbonara", "Sopa de Salmão", "Koshari", "Katsu Curry", "Ratatouille"));
    List<Double> precoPratosPrincipais = new ArrayList<>(List.of(11.00, 7.00, 21.00, 15.00, 14.00, 12.00, 21.00, 9.00));
    List<String> pratosSobremesa = new ArrayList<>(List.of("Brigadeiro", "Mochi", "Rolo Suíço", "Pavlova", "Crème Brûlée", "Trifle", "Panquecas"));
    List<Double> precoPratosSobremesas = new ArrayList<>(List.of(14.00, 5.00, 12.00, 9.00, 11.00, 16.00, 8.00));

    void carregamento() throws InterruptedException {
        String[] emotes = {"🍱", "🌮","🥞", "🍣", "🍝", "🍛", "🍰", "🧁", "🍨", "🍮"};
        System.out.print("Preparando pratos ");

        for (int i = 0; i < emotes.length; i++) {
            TimeUnit.MILLISECONDS.sleep(900);
            if (i == 9){
                System.out.print(emotes[i] + "\r");

            } else {
                System.out.print(emotes[i]);

            }
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.print("Tudo pronto, aproveite 😊🍠\r");
        TimeUnit.SECONDS.sleep(3);
    }

    void encerramento() throws InterruptedException {
        System.out.print("Encerrando programa ");

        for (int i = 1; i <= 3; i++) {
            TimeUnit.SECONDS.sleep(1);

                System.out.print("🍽");
        }
    }


    void interfaceInicial() throws InterruptedException {
        String mensagemInicial = """
                O que você precisa hoje?
                1 - Ver todos os pratos e preços
                2 - Ver todos os pratos de uma categoria(Pratos Iniciais, Pratos Principais ou Pratos de Sobremesa)
                3 - Top 3 pratos mais caros atualmente de cada categoria
                4 - Top 3 pratos depois de um prato específico
                5 - Pesquisar um prato específico
                6 - Encerrar
                """;


        System.out.printf(mensagemInicial);
        System.out.println("Coloque o número da opção desejada: ");
        Integer opcao = scanner.nextInt();
        switch (opcao){
            case 1-> {
                System.out.println("\n".repeat(9));
                visualizarTudo();
            }
            case 2 -> {
                System.out.println("\n".repeat(9));
                visualizarPorCategoria();
            }
            case 3 -> {
                System.out.println("\n".repeat(9));
                rankingTudo();
            }
            case 4 -> {
                System.out.println("\n".repeat(9));
                top3APartirDe();
            }
            case 5 -> {
                System.out.println("\n".repeat(9));
                pesquisarPrato();
            }
            case 6 -> {
                System.out.println("\n".repeat(9));
                encerramento();
            }
            default ->{
                System.out.println("Opção inválida, coloque uma opção disponível");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("\n".repeat(9));
                interfaceInicial();
            }
        }


    }

    void ordenarPratosEMostrar(List<String> pratos, List<Double> precos){
        List<String> pratosOrdenados = new ArrayList<>(pratos);
        List<Double> precosPratosOrdenados = new ArrayList<>(precos);

        for (int i = 0; i < precosPratosOrdenados.size(); i++) {
            for (int j = 0;  j < precosPratosOrdenados.size() - i - 1; ++j) {
                if(precosPratosOrdenados.get(j) > precosPratosOrdenados.get(j + 1)){
                    valorPrato = precosPratosOrdenados.get(j);
                    precosPratosOrdenados.set(j, precosPratosOrdenados.get(j + 1));
                    precosPratosOrdenados.set(j + 1, valorPrato);

                    nomePrato = pratosOrdenados.get(j);
                    pratosOrdenados.set(j, pratosOrdenados.get(j + 1));
                    pratosOrdenados.set(j + 1, nomePrato);
                }
            }
        }

        for (int i = 0; i < pratosOrdenados.size(); i++) {
            System.out.printf("%dº - Prato:%-25s Preço:%.2f \n", (i + 1), pratosOrdenados.get(i), precosPratosOrdenados.get(i));

        }
    }


        void visualizarTudo() throws InterruptedException {
        System.out.println("Todos os pratos do menor para o maior preço:");

        System.out.print("--- Pratos Iniciais🍞🥐 ---\n");
        ordenarPratosEMostrar(pratosIniciais, precoPratosIniciais);
        System.out.println();

        System.out.print("--- Pratos Principais🍝🍱--- \n");
        ordenarPratosEMostrar(pratosPrincipais, precoPratosPrincipais);
        System.out.println();

        System.out.print("--- Pratos de Sobremesa 🍨🧁 ---\n");
        ordenarPratosEMostrar(pratosSobremesa, precoPratosSobremesas);

            System.out.println("\n1 - Voltar ao menu");
            Integer opcao = scanner.nextInt();
            if (opcao.equals(1)){
                interfaceInicial();

            } else {


            }
        }

    void visualizarPorCategoria() throws InterruptedException {

        System.out.println("""
                Qual categoria você quer visualizar?
                1 - Pratos Iniciais 🍞🥐
                2- - Pratos Principais 🍝🍱
                3 - Pratos de Sobremesa 🍨🧁
                4 - Voltar
                """);

        Integer escolhaCategoria = scanner.nextInt();

        if (escolhaCategoria.equals(1)){
            ordenarPratosEMostrar(pratosIniciais, precoPratosIniciais);
            System.out.println("1 - Voltar ao menu");
            Integer opcao = scanner.nextInt();
            if (opcao.equals(1)){
                interfaceInicial();

            }

        } else if (escolhaCategoria.equals(2)) {
            ordenarPratosEMostrar(pratosPrincipais, precoPratosPrincipais);
            System.out.println("1 - Voltar ao menu");
            Integer opcao = scanner.nextInt();
            if (opcao.equals(1)){
                interfaceInicial();

            }

        } else if (escolhaCategoria.equals(3)) {
            ordenarPratosEMostrar(pratosSobremesa, precoPratosSobremesas);
            System.out.println("1 - Voltar ao menu");
            Integer opcao = scanner.nextInt();
            if (opcao.equals(1)){
                interfaceInicial();

            }

        } else if (escolhaCategoria.equals(4)) {
            interfaceInicial();

        } else {
            System.out.println("Escolha de as opções de 1 a 4.");
            TimeUnit.SECONDS.sleep(2);
            visualizarPorCategoria();

        }
    }

    void rankearPratos(List<String> pratos, List<Double> precos){
        Double preco1 = 0.0;
        Double preco2 = 0.0;
        Double preco3 = 0.0;
        String prato1 = "";
        String prato2 = "";
        String prato3 = "";
        for (int i = 0; i < pratos.size(); i++) {
            if (precos.get(i) > preco1){
                preco3 = preco2;
                prato3 = prato2;

                preco2 = preco1;
                prato2 = prato1;

                preco1 = precos.get(i);
                prato1 = pratos.get(i);

            } else if (precos.get(i) > preco2) {
                preco3 = preco2;
                prato3 = prato2;

                preco2 = precos.get(i);
                prato2 = pratos.get(i);

            } else if (precos.get(i) > preco3){
                preco3 = precos.get(i);
                prato3 = pratos.get(i);

            }
        }
        System.out.printf("1🥇 - Prato:%-25s Preço:%.2f \n", prato1, preco1);
        System.out.printf("2🥈 - Prato:%-25s Preço:%.2f \n", prato2, preco2);
        System.out.printf("3🥉 - Prato:%-25s Preço:%.2f \n", prato3, preco3);
    }

    void rankingTudo() throws InterruptedException {
        System.out.println("--- Top 3 Pratos Iniciais 🥯🥖 ---");
        rankearPratos(pratosIniciais, precoPratosIniciais);
        System.out.println("\n");

        System.out.println("--- Top 3 Pratos Principais 🍜🍙 ---");
        rankearPratos(pratosPrincipais, precoPratosPrincipais);
        System.out.println("\n");

        System.out.println("--- Top 3 Pratos de Sobremesa 🍩🍪 ---");
        rankearPratos(pratosSobremesa, precoPratosSobremesas);
        System.out.println("\n");

        System.out.println("1 - Voltar ao menu");
        Integer opcao = scanner.nextInt();
        if (opcao.equals(1)){
            interfaceInicial();

        }
    }

    void top3APartirDe() throws InterruptedException {
        List<String> todosPratos = new ArrayList<>();
        todosPratos.addAll(pratosIniciais);
        todosPratos.addAll(pratosPrincipais);
        todosPratos.addAll(pratosSobremesa);

        List<Double> todosPrecos = new ArrayList<>();
        todosPrecos.addAll(precoPratosIniciais);
        todosPrecos.addAll(precoPratosPrincipais);
        todosPrecos.addAll(precoPratosSobremesas);

        Double preco = 0.0;
        String prato = "";

        for (int i = 0; i < todosPrecos.size(); i++) {
            for (int j = 0; j < todosPrecos.size() - i - 1; ++j) {
                if (todosPrecos.get(j) > todosPrecos.get(j + 1)) {
                    preco = todosPrecos.get(j);
                    todosPrecos.set(j, todosPrecos.get(j + 1));
                    todosPrecos.set(j + 1, preco);

                    prato = todosPratos.get(j);
                    todosPratos.set(j, todosPratos.get(j + 1));
                    todosPratos.set(j + 1, prato);
                }
            }
        }

        System.out.println("A partir de qual prato você gostaria de ver o ranking dos mais caros?");
        System.out.println("Digite o nome do prato:");
        String pratoReferencia = scannerText.nextLine();

        Integer posicaoPratoReferencia = -1;
        for (int i = 0; i < todosPratos.size(); i++) {
            if (todosPratos.get(i).equalsIgnoreCase(pratoReferencia)) {
                posicaoPratoReferencia = i;
                break;
            }
        }

        if (posicaoPratoReferencia != -1) {
            System.out.printf("\nPrato base: %-25s Preço: R$%.2f\n", todosPratos.get(posicaoPratoReferencia), todosPrecos.get(posicaoPratoReferencia));
            System.out.println("--- Os 3 pratos seguintes é ---");

            int pratosMostrados = 0;
            for (int i = posicaoPratoReferencia + 1; i < todosPratos.size() && pratosMostrados < 3; i++) {
                System.out.printf("%dº - Prato:%-25s Preço: R$%.2f\n", (pratosMostrados + 1), todosPratos.get(i), todosPrecos.get(i));
                pratosMostrados++;
            }

            if (pratosMostrados == 0) {
                System.out.println("O prato mencionado é o mais caro.");
            } else if (pratosMostrados < 3) {
                System.out.printf("Apenas %d prato mais caro foi encontrado(s).\n", pratosMostrados);
            }

        } else {
            System.out.println("Prato não encontrado no guia.");
        }

        System.out.println("\n1 - Voltar ao menu");
        Integer opcao = scanner.nextInt();
        if (opcao.equals(1)) {
            interfaceInicial();
        } else {
            interfaceInicial();
        }
    }

    void pesquisarPrato() throws InterruptedException {
        System.out.println("Digite o nome do prato que deseja pesquisar:");
        String pratoPesquisado = scannerText.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < pratosIniciais.size(); i++) {
            if (pratosIniciais.get(i).equalsIgnoreCase(pratoPesquisado)) {
                System.out.printf("\nCategoria: Pratos Iniciais 🍞🥐\nPrato: %s\nPreço: R$%.2f\n", pratosIniciais.get(i), precoPratosIniciais.get(i));
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            for (int i = 0; i < pratosPrincipais.size(); i++) {
                if (pratosPrincipais.get(i).equalsIgnoreCase(pratoPesquisado)) {
                    System.out.printf("\nCategoria: Pratos Principais 🍝🍱\nPrato: %s\nPreço: R$%.2f\n", pratosPrincipais.get(i), precoPratosPrincipais.get(i));
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            for (int i = 0; i < pratosSobremesa.size(); i++) {
                if (pratosSobremesa.get(i).equalsIgnoreCase(pratoPesquisado)) {
                    System.out.printf("\nCategoria: Pratos de Sobremesa 🍨🧁\nPrato: %s\nPreço: R$%.2f\n", pratosSobremesa.get(i), precoPratosSobremesas.get(i));
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Prato não encontrado no guia.");
        }

        System.out.println("\n1 - Voltar ao menu");
        Integer opcao = scanner.nextInt();
        if (opcao.equals(1)) {
            interfaceInicial();
        } else {
            interfaceInicial();
        }
    }
}
