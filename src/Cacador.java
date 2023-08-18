class Cacador extends Unidade {

    public Cacador() {
        super(67, 21, 15);
    }

    @Override
    public int bonusAtaque(Unidade unidadeInimiga) {
        if (unidadeInimiga instanceof Esqueletos) {
            return (int) (getAtaque() * 0.5);
        }else
            return 0;
    }

    @Override
    public String toString() {
        return "Caçador";
    }

}