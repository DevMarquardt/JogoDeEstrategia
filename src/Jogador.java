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
                unidades.add(new Arqueira(10, 10, 30));
                numeroDeTropas++;
                break;
            case 2:
                unidades.add(new Cavaleiro(20, 50, 60));
                numeroDeTropas++;
                break;
            case 3:
                unidades.add(new Esqueletos(30, 60, 50));
                numeroDeTropas++;
                break;
            case 4:
                unidades.add(new Cacador(40, 20, 40));
                numeroDeTropas++;
                break;
            case 5:
                unidades.add(new Lancador(50, 30, 10));
                numeroDeTropas++;
                break;
            case 6:
                unidades.add(new Mosqueteira(60, 70, 20));
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

    public int getVitorias() {
        return vitorias;
    }

    public void incrementarVitorias() {
        vitorias++;
    }

    public ArrayList<Unidade> getUnidades() {
        return unidades;
    }

    public void setUnidades(ArrayList<Unidade> unidades) {
        this.unidades = unidades;
    }

    public void setNumeroDeTropas(int numeroDeTropas) {
        this.numeroDeTropas = numeroDeTropas;
    }

    @Override
    public String toString() {
        return unidades.toString();
    }
}