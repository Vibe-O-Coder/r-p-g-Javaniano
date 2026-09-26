package rpgJavaniano.projeto.rpg;
import java.lang.Math.*;
import java.util.Random;
import java.util.Random.*;


public class Personagem {
    private static final Random RANDOM = new Random();

    protected String nome;
    protected int maxHp;
    protected int hp;
    protected int atk;
    protected int def;
    protected int dex;
    protected int log;
    
    public Personagem(String nome, int maxHp, int atk, int def, int dex, int log) {
        this.nome = nome;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.atk = atk;
        this.def = def;
        this.dex = dex;
        this.log = log;
    }

    public double calcularDefesa(int enemyDex) {
        /* 
            método de suporte presente em toda sub-classe de Personagem
            utilizado para calcular a redução da armadura/defesa
        */

        // calcula a porcentagem da penetração com base na destreza do inimigo
        // com o máximo de 50%
        double penPercent = Math.min(0.50, enemyDex * 0.005);
        double defEfetiva = Math.max(0, def * (1.0 - penPercent));
        // aqui nós utilizamos uma constante fixa de 100.0, então caso
        // a defesa efetiva seja 100.0 (o mesmo), o dano é reduzido em 50%
        double armorDR = defEfetiva / (defEfetiva + 100.0);
        return armorDR;
    }

    public void atacar(Inimigo alvo) {
        /* 
            método de suporte feito para calcular o dano causado ao inimigo
            funciona somente em sub-classes da classe Personagem, utiliza
            uma curva de sino para aplicar uma variação ao dano final
        */
        double armorDR = alvo.calcularDefesa(this.dex);

        // calcula o crítico com base na diferença de destreza entre o objeto e o alvo
        // para cada ponto a mais que o alvo, maior é a chance de crítico, com o mínimo de 1%
        double diffDex = this.dex - alvo.dex;
        double chanceCritico = Math.max(0.01, 0.05 + (diffDex * 0.01));
        boolean isCrit = RANDOM.nextDouble() < chanceCritico; // gera um número aleatório e verifica se é menor que a chance de crítico
        double multCritico = isCrit ? 1.50 : 1.0; // crítico concede 50% de bônus
        // cria uma distribuição normal com uma variação de +-10%, com a maioria dos ataques batendo a média
        double variancia = Math.max(0.90, Math.min(1.10, 1.0 + (RANDOM.nextGaussian() * 0.033)));
        // cálculo final do dano físico
        double danoBruto = this.atk * (1.0 - armorDR) * multCritico;
        double danoFinal = danoBruto * variancia;
        
        alvo.receberDano(danoFinal);
    }

    public void receberDano(double danoFinal) {
        /*   
            recebe o danoFinal (do método de suporte) do inimigo e faz
            uma verificação para evitar hp negativo
        */
        double dano = Math.max(1.0, (int) Math.round(danoFinal));
        if (dano > hp) {
            hp = 0;
        } else {
            hp -= dano;
        }
    }

    public String toString() {
        /*
            Retorna os atributos do objeto em uma string formatada
        */
        String string = String.format("""
                       Statistics
                ------------------------
                |%-14s %3d/%-3d|
                ------------------------
                |ATK: %-17d|
                |DEF: %-17d|
                |AGI: %-17d|
                |LOG: %-17d|
                ------------------------
                """, nome, hp, maxHp, atk, def, dex, log);
        return string;
    }
}