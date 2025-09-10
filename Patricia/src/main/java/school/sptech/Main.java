package school.sptech;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Funcoes funcoes = new Funcoes();
        System.out.println("🍰🍒 - Seja bem vindo(a) ao seu guia de pratos culinários - 🍒🍝");
        funcoes.carregamento();
        funcoes.interfaceInicial();



    }
}