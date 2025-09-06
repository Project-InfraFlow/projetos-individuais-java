package projeto.utilitarios;
import java.util.*;

public class Main {

    static Double calcularModa(List<Double> lista){
        List<Integer> vezes = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            vezes.add(0);
        }
        int indexMaisVisto = 0;
        for (int i = 0; i < lista.size(); i++) {
            for (int i1 = 0; i1 < lista.size(); i1++) {
                if (lista.get(i).equals(lista.get(i1))){
                    vezes.set(i, (vezes.get(i) + 1));
                }
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            if (vezes.get(indexMaisVisto) < vezes.get(i)) {
                indexMaisVisto = i;
            }
        }
        return lista.get(indexMaisVisto);
    }

    static Double calcularMediana(List<Double> lista){
        Collections.sort(lista);

        double mediana;
        int n = lista.size();

        if (n % 2 == 1) {
            mediana = lista.get(n / 2);
        } else {
            mediana = (lista.get((n / 2) - 1) + lista.get(n / 2)) / 2.0;
        }
        return mediana;
    }

    static Double calcularDesvioPadrao(List<Double> lista, Double media){
        Double resultado = 0.0;
        for (int i = 0; i < lista.size(); i++) {
            resultado += Math.pow(lista.get(i) - media, 2);
        }
        resultado = Math.pow(resultado / lista.size(), 0.5) ;
        return resultado;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Double> listaValores = new ArrayList<>();
        Integer opcao, decimal, tamanho = 0;
        Double valor, taxa, media = 0.0;

        while (true) {
            try {
                System.out.println("""
                        Projeto Utilitários V1.0 por Wendel Sousa
                        Qual Operação Você deseja realizar?
                        1 - Conversão de Valores
                        2 - Operações de Estatística Básica
                        3 - Encerrar Programa""");
                opcao = entrada.nextInt();
                if (opcao == 1) {
                    System.out.println("""
                            Qual Operação de Conversão Você deseja realizar?
                            1 - Conversão Cambial
                            2 - Conversão de Temperatura (Graus Celsius para Fahrenheit e Kelvin)
                            3 - Conversão de Bases Númericas (Decimal inteiro para Binário, Octal, Hexadecimal)""");
                    opcao = entrada.nextInt();
                    if (opcao == 1) {
                        System.out.println("Digite o valor em moeda que você quer converter:");
                        valor = entrada.nextDouble();
                        System.out.println("Digite a taxa cambial vigente entre as duas moedas em questão:");
                        taxa = entrada.nextDouble();
                        System.out.printf("Valor Convertido: %.2f\n\n", valor * taxa);
                    } else if (opcao == 2) {
                        System.out.println("Digite o valor em graus Celsius :");
                        valor = entrada.nextDouble();
                        System.out.printf("""
                                Em Graus Celsius: %.2f°C
                                Em Fahrenheit: %.2f°F
                                Em Kelvin: %.2fK
                                \n""", valor, (valor * 9 / 5) + 32, valor + 273.15);
                    } else if (opcao == 3) {
                        System.out.println("Digite um valor decimal inteiro:");
                        decimal = entrada.nextInt();
                        System.out.printf("""
                                Em Decimal: %d
                                Em Binário: %s
                                Em Octal: %s
                                Em Hexadecimal: %s
                                \n""", decimal, Integer.toBinaryString(decimal), Integer.toOctalString(decimal), Integer.toHexString(decimal).toUpperCase());
                    } else {
                        System.out.println("Instrução Inválida");
                    }
                } else if (opcao == 2) {
                    System.out.println("Digite o tamanho da lista de valores:");
                    tamanho = entrada.nextInt();
                    listaValores.clear();
                    for (int i = 0; i < tamanho; i++) {
                        System.out.printf("Digite o %d° valor da lista\n", i + 1);
                        valor = entrada.nextDouble();
                        listaValores.add(valor);
                        media += valor;
                    }
                    media = media / listaValores.size();
                    System.out.println("Lista: " + listaValores);
                    System.out.printf("""
                                    Maior Valor: %.2f
                                    Menor Valor: %.2f
                                    Amplitude: %.2f
                                    Media: %.2f
                                    Mediana: %.2f
                                    Moda: %.2f
                                    Variância: %.2f
                                    Desvio Padrão: %.2f
                                    \n""", Collections.max(listaValores), Collections.min(listaValores),
                            Collections.max(listaValores) - Collections.min(listaValores),
                            media, calcularMediana(listaValores), calcularModa(listaValores), Math.pow(calcularDesvioPadrao(listaValores, media), 2),
                            calcularDesvioPadrao(listaValores, media));

                } else if (opcao == 3) {
                    System.out.println("Encerrando");
                    break;
                } else {
                    System.out.println("Instrução Inválida\n\n");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e);
                break;
            }
        }
    }
}


