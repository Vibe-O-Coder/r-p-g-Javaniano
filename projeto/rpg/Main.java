package rpgJavaniano.projeto.rpg;

public class Main {
    public static void main(String[] args) {
        Personagem testeP = new Personagem("TestePersonagem", 100, 10, 10, 10, 10);
        Inimigo testeI = new Inimigo("TesteInimigo", 100, 10, 10, 10, 10);
        System.out.println(testeP);
        System.out.println(testeI);
    }
}
