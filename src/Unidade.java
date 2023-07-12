abstract public class Unidade {

    private int vida;
    private int ataque;
    private int defesa;

    Unidade unidade;

    public Unidade(int vida, int ataque, int defesa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    abstract void Atacar();

    abstract void Defender();
}
