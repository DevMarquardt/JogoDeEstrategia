public abstract class Unidade {

    private int vida;
    private int ataque;
    private int defesa;

    public Unidade(int vida, int ataque, int defesa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public abstract int bonusAtaque(Unidade unidadeInimiga);

    public void atacar(Unidade unidadeInimiga, Jogador jogadorInimigo) {
        int i = jogadorInimigo.getNumeroDeTropas();
        int valorAtaque = this.getAtaque();
        valorAtaque+=bonusAtaque(unidadeInimiga);
        int valorVida = unidadeInimiga.getVida();
        unidadeInimiga.setVida(valorVida - valorAtaque);
        if (unidadeInimiga.getVida() <= 0) {
            jogadorInimigo.getUnidades().remove(unidadeInimiga);
        }
    }
}
