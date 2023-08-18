class Mosqueteira extends Unidade {

    public Mosqueteira() {
        super(78, 24, 15);
    }

    @Override
    public int bonusAtaque(Unidade unidadeInimiga) {
        if (unidadeInimiga instanceof Lancador) {
            return (int) (getAtaque() * 0.5);
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Mosqueteira";
    }
}