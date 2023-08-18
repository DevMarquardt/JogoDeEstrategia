import java.util.ArrayList;

class Jogador {
    private String nome;
    private int vitorias;
    private ArrayList<Unidade> unidades;

    public Jogador(String nome) {
        this.nome = nome;
        this.vitorias = 0;
        this.unidades = new ArrayList<>();
    }

    public void adicionarTropa(int tropaEscolhida) {

        switch (tropaEscolhida) {
            case 1:
                unidades.add(new Arqueira());
                break;
            case 2:
                unidades.add(new Cavaleiro());
                break;
            case 3:
                unidades.add(new Esqueletos());
                break;
            case 4:
                unidades.add(new Cacador());
                break;
            case 5:
                unidades.add(new Lancador());
                break;
            case 6:
                unidades.add(new Mosqueteira());
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
        return unidades.size();
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