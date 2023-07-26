import java.util.ArrayList;

class Jogador {
    private String nome;
    private int numeroDeTropas;
    private int vitorias;
    private ArrayList<Unidade> unidades;

    public Jogador(String nome, int numeroDeTropas, int vitorias) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.numeroDeTropas = numeroDeTropas;
        this.unidades = new ArrayList<>();
    }

    public void escolherTropaJogador(int tropaEscolhida) {

        switch (tropaEscolhida) {
            case 1:
                unidades.add(new Arqueira(59, 19, 25));
                numeroDeTropas++;
                break;
            case 2:
                unidades.add(new Cavaleiro(84, 17, 20));
                numeroDeTropas++;
                break;
            case 3:
                unidades.add(new Esqueletos(46, 11, 30));
                numeroDeTropas++;
                break;
            case 4:
                unidades.add(new Cacador(67, 21, 15));
                numeroDeTropas++;
                break;
            case 5:
                unidades.add(new Lancador(96, 22, 10));
                numeroDeTropas++;
                break;
            case 6:
                unidades.add(new Mosqueteira(78, 24, 15));
                numeroDeTropas++;
                break;
            default:
                System.out.println("Tropa inválida, escolha novamente");
                break;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeTropas() {
        return numeroDeTropas;
    }

    public void setNumeroDeTropas(int numeroDeTropas) {
        this.numeroDeTropas = numeroDeTropas;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void incrementarVitorias() {
        vitorias++;
    }

    public ArrayList<Unidade> getUnidades() {
        return unidades;
    }
}