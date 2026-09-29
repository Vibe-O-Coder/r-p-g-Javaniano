package rpgJavaniano.projeto.rpg;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
            75,
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11)
        ));
        testeInimigos.add(new Inimigo(
            "Inimigo2",
            50,
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11),
            ThreadLocalRandom.current().nextInt(5, 11)
        ));
        System.out.println(testePlayer);
        ArrayList<Personagem> order = new ArrayList<>();
        order.add(testeInimigos.get(0));
        order.add(testeInimigos.get(1));
        order.add(testePlayer);
        int n = order.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (order.get(j).getDex() < order.get(j + 1).getDex()) {
                    Personagem temp = order.get(j);
                    order.set(j, order.get(j + 1));
                    order.set(j + 1, temp);
                }
            }
        }
        while (true) {
            order.removeIf(item -> item.getHp() <= 0);
            n = order.size();
            if (testeInimigos.isEmpty()) {
                System.out.println("Parabéns, você venceu!");
                break;
            }
            if (testePlayer.getHp() <= 0) {
                System.out.println("Infelizmente você perdeu!");
                break;
            }
            for (int i = 0; i < n; i++) {
                System.out.println(testePlayer.nome + testePlayer.getFormatHp());
                if (order.get(i) instanceof Inimigo) {
                    order.get(i).atacar(testePlayer);
                } else {
                    boolean sucess = false;
                    while (!sucess) {
                        System.out.println("1) Atacar");
                        try {
                            int choice = scanner.nextInt();
                            if (choice == 1) {
                                int c = 1;
                                System.out.println("Escolha um para atacar:");
                                for (Personagem coisa : testeInimigos) {
                                    System.out.println(c + coisa.nome);
                                    c++;
                                }
                                choice = scanner.nextInt();
                                try {
                                    testePlayer.atacar(testeInimigos.get(choice-1));
                                    if (testeInimigos.get(choice-1).hp <= 0) {
                                        testeInimigos.remove(choice-1);
                                        System.out.println("Inimigo " + c + " derrotado");
                                    }
                                    sucess = true;
                                } catch (IndexOutOfBoundsException e) {
                                    testePlayer.atacar(testeInimigos.get(testeInimigos.size() - 1));
                                }
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Tente novamente.");
                            scanner.next();
                        }
                    }
                    
                }
            }
        }
    }
}