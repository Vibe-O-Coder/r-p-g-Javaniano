package rpgJavaniano.projeto.rpg;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personagem testePlayer = new Personagem(
            "Wowzers",
             100,
             ThreadLocalRandom.current().nextInt(10, 26),
             ThreadLocalRandom.current().nextInt(10, 26),
             ThreadLocalRandom.current().nextInt(10, 26),
             ThreadLocalRandom.current().nextInt(10, 26)
            );
        ArrayList<Inimigo> testeInimigos = new ArrayList<>();
        testeInimigos.add(new Inimigo(
            "Inimigo1",
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11)
        ));
        testeInimigos.add(new Inimigo(
            "Inimigo2",
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11)
        ));
        System.out.println(testePlayer);
        ArrayList<Personagem> order = new ArrayList<>();
        for (Personagem coisa : order) {}
        while (true) {
            
        }
    }
}
