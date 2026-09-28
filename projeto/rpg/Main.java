package rpgJavaniano.projeto.rpg;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(testeP);
        System.out.println(testeI);

        System.out.println("Um " + testeI.nome + " selvagem barra o caminho!");
        while (true) {
            if (testeI.getHp() == 0) {
                System.out.println("Parabéns, você ganhou a batalha contra " + testeI.nome + "!");
                break;
            }
            if (testeP.getHp() == 0) {
                System.out.println("Você infelizmente foi subjulgado por " + testeI.nome + ".");
                break;
            }
            System.out.println(testeI.nome + " " + testeI.getFormatHp() + "\n");
            System.out.println(testeP.nome + " " + testeP.getFormatHp());
            System.out.println("1 - Atacar");
            int escolha = scanner.nextInt();
            if (escolha == 1) {
                testeP.atacar(testeI);
                continue;
            } else {
                System.out.println("Entrada inválida\n");
            }
            testeI.atacar(testeP);
            
        }
    }
}
