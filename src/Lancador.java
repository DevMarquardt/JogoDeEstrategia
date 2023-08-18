class Lancador extends Unidade {

    public Lancador() {
        super(96, 22, 10);
    }

    @Override
    public int bonusAtaque(Unidade unidadeInimiga) {
        if (unidadeInimiga instanceof Cacador) {
            return (int) (getAtaque() * 0.5);
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Lançador";
    }

}