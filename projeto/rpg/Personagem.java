package rpg;

public class Personagem {
    String nome;
    int maxHp;
    int hp;
    int atk;
    int def;
    int agi;
    int mag;
    
    public Personagem(String nome, int maxHp, int hp, int atk, int def, int agi, int mag) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.agi = agi;
        this.mag = mag;
    }

    String toString() {
        System.out.println(nome + hp + "/" +maxHp);
        System.out.println("------------------------");
        System.out.println("ATK: " + atk +
                           "DEF: " + def +
                           "AGI: " + agi +
                           "MAG: " + mag
        );
        System.out.println("------------------------");
    }
}
