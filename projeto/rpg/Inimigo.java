package rpgJavaniano.projeto.rpg;

public class Inimigo extends Personagem {
    public Inimigo(String nome, int maxHp, int atk, int def, int dex, int log) {
        super(nome, maxHp, atk, def, dex, log);
    }

    @Override
    public String toString() {
        return "It's an enemy.";
    }
}
