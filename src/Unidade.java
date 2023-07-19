abstract public class Unidade {

    private int vida;
    private int ataque;

    Unidade unidade;

    public Unidade(int vida, int ataque) {
        this.vida = vida;
        this.ataque = ataque;
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

    public void Atacar(Unidade tropa, Unidade unidadeInimiga, Jogador jogador1, Jogador jogador2, Jogador jogadorJogando, Jogador jogadorInimigo) {
        int i = jogadorInimigo.getNumeroDeTropas();
        int valorAtaque = tropa.getAtaque();
        int valorVida = unidadeInimiga.getVida();
        unidadeInimiga.setVida(valorVida - valorAtaque);
        if (unidadeInimiga.getVida() <= 0) {
            jogadorInimigo.getUnidades().remove(unidadeInimiga);
            jogadorInimigo.setNumeroDeTropas(--i);
        }
    }
}
