import java.util.ArrayList;

public class Jogo {
    ArrayList <Jogador> jogadores = new ArrayList<>();
    int rodada=1;

    public Jogo(String nomeJogador1, String nomeJogador2 ) {
        this.jogadores.add(new Jogador(nomeJogador1));
        this.jogadores.add(new Jogador(nomeJogador2));
        this.rodada = rodada;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void proximaRodada(){
        rodada++;
    }

    public Jogador getJogadorAtivo() {
        return jogadores.get((rodada+1)%2);
    }
    public Jogador getJogadorInimigo() {
        return jogadores.get((rodada)%2);
    }
}
