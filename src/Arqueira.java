class Arqueira extends Unidade {

    public Arqueira(int vida, int ataque, int defesa) {
        super(vida, ataque, defesa);
    }

    @Override
    public int bonusAtaque(Unidade unidadeInimiga) {
        if (unidadeInimiga instanceof Cavaleiro) {
            return (int) (getAtaque() * 0.5);
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Arqueira";
    }

}