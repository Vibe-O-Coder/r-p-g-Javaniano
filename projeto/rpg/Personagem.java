package rpg;

public class Personagem {
    protected String nome;
    protected int maxHp;
    protected int hp;
    protected int atk;
    protected int def;
    protected int agi;
    protected int log;
    
    public Personagem(String nome, int maxHp, int hp, int atk, int def, int agi, int log) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.log = log;
    }

    public String toString() {
        String string = String.format("""
                       Statistics
                ------------------------
                |%-10s %3d/%-3d|
                ------------------------
                |ATK: %-15d|
                |DEF: %-15d|
                |AGI: %-15d|
                |LOG: %-15d|
                ------------------------
                """, nome, hp, maxHp, atk, def, agi, log);
        return string;
    }
}