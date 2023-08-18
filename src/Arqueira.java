class Arqueira extends Unidade {

    public Arqueira() {
        super(59, 19, 25);
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