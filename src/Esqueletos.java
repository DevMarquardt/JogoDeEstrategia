class Esqueletos extends Unidade {

    public Esqueletos() {
        super(46, 11, 30);
    }

    @Override
    public int bonusAtaque(Unidade unidadeInimiga) {
        if (unidadeInimiga instanceof Mosqueteira) {
            return (int) (getAtaque() * 0.5);
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Esqueletos";
    }

}