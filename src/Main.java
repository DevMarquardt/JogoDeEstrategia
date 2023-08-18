import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Jogo jogo;

    public static void main(String[] args) {

        menuInicial();
    }

    private static void menuInicial() {
        int opcaoMenuInicial;
        do {


            System.out.println("<============================>");
            System.out.println("         1 - Jogar          ");
            System.out.println("         2 - Sair           ");
            System.out.println("<============================>\n>");
            opcaoMenuInicial = sc.nextInt();
            switch (opcaoMenuInicial) {
                case 1:
                    iniciarJogo();
                    break;
                case 2:
                    System.out.println("Finalizando");
                    System.exit(0);
                default:
                    System.out.println("Opção invalida");
            }
        } while (opcaoMenuInicial != 1);
    }

    private static void iniciarJogo() {
        definirNomeJogadores();
        definirTropasJogadores();
        menuGame();
        int opcao;
        do {
            opcao = sc.nextInt();
        } while (opcao < 1 || opcao > 2);
        switch (opcao) {
            case 1 -> {
                int opcaoAcao = selecionarAcao();

            }
            case 2 -> desistir(jogador1, jogador2, jogadorJogando);
            default -> System.out.println("Selecione uma opção válida");
        }
        verificarFimDeJogo(jogador1, jogador2);


    }

    private static void definirNomeJogadores() {
        String jogador1Nome, jogador2Nome;

        do {
            System.out.println("<============================>");
            System.out.println("Qual o apelido do jogador 1?\n>");
            jogador1Nome = sc.next();
            System.out.println("Qual o apelido do jogador 2?\n>");
            jogador2Nome = sc.next();
            System.out.println("<============================> ");
        } while (jogador1Nome.equals("") || jogador2Nome.equals(""));
        jogo = new Jogo(jogador1Nome, jogador2Nome);
    }

    private static void definirTropasJogadores() {
        int tropaEscolhida;
        for (Jogador jogador : jogo.getJogadores()) {
            System.out.println("O jogador " + jogador.getNome() + " possui " + jogador.getVitorias() + " vitórias");
            do {
                System.out.println("<============= " + jogador.getNome() + " =============>");
                System.out.println("Digite o número da tropa desejada");
                System.out.println("          1 - Arqueira");
                System.out.println("          2 - Cavaleiro");
                System.out.println("          3 - Esqueletos");
                System.out.println("          4 - Caçador");
                System.out.println("          5 - Lançador");
                System.out.println("          6 - Mosqueteira");
                System.out.println("<=================================>\n> ");
                tropaEscolhida = sc.nextInt();
                jogador.adicionarTropa(tropaEscolhida);
            } while (jogador.getNumeroDeTropas() <= 2);
        }
    }

    private static void menuGame() {
        Jogador jogadorJogando = jogo.getJogadorAtivo();
        System.out.println("<============= Turno do(a) " + jogadorJogando.getNome() + " =============>");
        System.out.println("Essas são suas tropas");
        for (int i = 0; i < jogadorJogando.getNumeroDeTropas(); i++) {
            Unidade tropa2 = jogadorJogando.getUnidades().get(i);
            System.out.println(("\n") + tropa2.toString() + ":" + "\n - " + "\uD83D\uDC8A : " + tropa2.getVida());
            System.out.println(" - " + "⚔️ : " + tropa2.getAtaque());
            System.out.println(" - " + "\uD83D\uDEE1 : " + tropa2.getAtaque());
        }
        System.out.println("\nSelecione a opção desejada");
        System.out.println("1 - Selecionar tropa");
        System.out.println("2 - Aceitar a morte");
        System.out.println("<=================================>\n>");
    }

    private static int selecionarAcao() {
        int opcaoTropa;
        String menuAcao = "<============= " + jogo.getJogadorAtivo().getNome() + " =============>";
        menuAcao+="O que você deseja fazer?";
        menuAcao+="1 - Atacar tropa inimiga";
        menuAcao+="2 - Analisar tropa inimiga";
        menuAcao+="<=================================>\n>";
        System.out.println(menuAcao);
        do{
            opcaoTropa = sc.nextInt();
        }while(opcaoTropa != 1 && opcaoTropa!=2);
        return opcaoTropa;
    }

    private static Unidade escolherUnidade(ArrayList<Unidade> tropas){
        for (int i = 0; i < tropas.size(); i++) {
            Unidade tropa = tropas.get(i);
            System.out.println((i) + " - " + tropa.toString());
        }
        System.out.println("<=======================================================================>");
        System.out.println(">");
        int tropaSelecionada;
        do {
            tropaSelecionada = sc.nextInt();
        }while(tropaSelecionada<0 || tropaSelecionada>tropas.size());
        return tropas.get(tropaSelecionada);
    }
            private static void acao(int opcaoAcao) {
                ArrayList<Unidade> tropasDisponiveis = jogo.getJogadorAtivo().getUnidades();
                switch (opcaoAcao) {
                    case 1:
                        System.out.println("<=======================================================================>");
                        System.out.println("Selecione o número correspondente à tropa que deseja usar para atacar:");
                        Unidade unidade=escolherUnidade(tropasDisponiveis);
                        System.out.println("<==========================================>");
                        System.out.println("Qual das tropas inimigas você deseja atacar?");
                        Unidade unidadeInimiga=escolherUnidade(jogo.getJogadorInimigo().getUnidades());
                        System.out.println("<==========================================>\n>");
                        if(unidade.bonusAtaque(unidadeInimiga)!=0){
                            System.out.println("BONUS DE ATAQUE");
                        }
                            unidade.atacar(unidadeInimiga, jogo.getJogadorInimigo());
                            if (unidadeInimiga.getVida() <= 0) {
                                System.out.println("Tropa inimiga eliminada!");
                            }
                            jogo.proximaRodada();
                        break;
                    case 2:
                        System.out.println("<============================================>");
                        System.out.println("Qual das tropas inimigas você deseja analisar?");
                        if (jogadorJogando == jogador1) {
                            for (i = 0; i < jogador2.getNumeroDeTropas(); i++) {
                                Unidade tropa2 = jogador2.getUnidades().get(i);
                                System.out.println((i) + " - " + tropa2.toString());
                            }
                        } else {
                            for (i = 0; i < jogador1.getNumeroDeTropas(); i++) {
                                Unidade tropa1 = jogador1.getUnidades().get(i);
                                System.out.println((i) + " - " + tropa1.toString());
                            }
                        }
                        System.out.println("<============================================>\n>");
                        int opcao2 = sc.nextInt();
                        if (opcao2 >= 0 && opcao2 < tropasDisponiveis.size()) {
                            Unidade unidadeInimiga2 = jogadorInimigo.getUnidades().get(opcao2);
                            System.out.println("<==========================================>");
                            System.out.println("Informações da tropa inimiga selecionada");
                            System.out.println("Tropa: " + unidadeInimiga2.toString());
                            System.out.println("💊: " + unidadeInimiga2.getVida());
                            System.out.println("⚔️: " + unidadeInimiga2.getAtaque());
                            System.out.println("🛡: " + unidadeInimiga2.getDefesa());
                            System.out.println("<==========================================>\n");
                            selecionarAcao(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                        } else {
                            System.out.println("Opção inválida, escolha novamente.");
                        }
                        break;

                    default:
                        System.out.println("Opção inválida, escolha novamente.");
                        selecionarAcao(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                        break;
                }
            }

            private static void desistir(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
                System.out.println("<======================================>");
                System.out.println("Fim de jogo");
                Jogador vencedor;
                if (jogadorJogando == jogador1) {
                    vencedor = jogador2;
                } else {
                    vencedor = jogador1;
                }
                System.out.println("O jogador " + jogadorJogando.getNome() + " desistiu da partida, vitória para o jogador " + vencedor.getNome());
                System.out.println("<======================================>\n");
                vencedor.incrementarVitorias();

                int opcao;
                do {
                    System.out.println("<======================================>");
                    System.out.println("""
                    Deseja jogar novamente?
                    1 - Sim
                    2 - Não""");
            System.out.println("<======================================>\n>");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    jogador1.getUnidades().clear();
                    jogador2.getUnidades().clear();
                    jogador1.setNumeroDeTropas(0);
                    jogador2.setNumeroDeTropas(0);
                    definirTropasJogadores(jogador1, jogador2);
                    break;
                case 2:
                    System.out.println("Finalizando");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 1);
    }

    private static void verificarFimDeJogo(Jogador jogador1, Jogador jogador2) {
        boolean acabou = false;

        if (jogador1.getNumeroDeTropas() <= 0) {
            acabou = true;
            System.out.println("<==========================================>");
            System.out.println("Fim de jogo! Vitória para o jogador " + jogador2.getNome());
            jogador2.incrementarVitorias();
            System.out.println("<==========================================>\n");
        } else if (jogador2.getNumeroDeTropas() <= 0) {
            acabou = true;
            System.out.println("<==========================================>");
            System.out.println("Fim de jogo! Vitória para o jogador " + jogador1.getNome());
            jogador1.incrementarVitorias();
            System.out.println("<==========================================>\n");
        }

        if (acabou) {
            int opcao = 0;
            do {
                System.out.println("<====================================>");
                System.out.println("""
                        Deseja jogar novamente?
                        1 - Sim
                        2 - Não""");
                System.out.println("<====================================>\n>");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        jogador1.getUnidades().clear();
                        jogador2.getUnidades().clear();
                        jogador1.setNumeroDeTropas(0);
                        jogador2.setNumeroDeTropas(0);
                        definirTropasJogadores(jogador1, jogador2);
                        break;
                    case 2:
                        System.out.println("Finalizando");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (opcao != 1 && opcao != 2);
        }

    }
}