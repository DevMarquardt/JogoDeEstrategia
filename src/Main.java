import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("", 0, 0);
        Jogador jogador2 = new Jogador("", 0, 0);
        Jogador jogadorJogando = null;
        menuInicial(jogador1, jogador2, jogadorJogando);
    }

    private static void menuInicial(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
        int opcaoMenuInicial;
        System.out.println("<============================>");
        System.out.println("         1 - Jogar          ");
        System.out.println("         2 - Sair           ");
        System.out.println("<============================>");
        System.out.println(">");
        opcaoMenuInicial = sc.nextInt();
        switch (opcaoMenuInicial) {
            case 1:
                menuJogo(jogador1, jogador2, jogadorJogando);
                break;
            case 2:
                System.out.println("Finalizando");
                System.exit(0);
            default:
                System.out.println("Opção invalida");
                menuInicial(jogador1, jogador2, jogadorJogando);
        }
    }

    private static void menuJogo(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
        String jogador1Nome, jogador2Nome;

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n");
            System.out.println("<============================>");
            System.out.println("Qual o apelido do jogador 1?\n>");
            jogador1Nome = sc.next();
            jogador1.setNome(jogador1Nome);
            System.out.println("Qual o apelido do jogador 2?\n>");
            jogador2Nome = sc.next();
            jogador2.setNome(jogador2Nome);
            System.out.println("<============================> ");
        } while (jogador1.getNome().equals("") || jogador2.getNome().equals(""));
        menuTropas(jogador1, jogador2, jogadorJogando);
    }

    private static void menuTropas(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
        int tropaEscolhida;

        System.out.println("O jogador " + jogador1.getNome() + " possui " + jogador1.getVitorias() + " vitórias");
        System.out.println("O jogador " + jogador2.getNome() + " possui " + jogador2.getVitorias() + " vitórias");
        do {
            if (jogador1.getNumeroDeTropas() <= 2) {
                jogadorJogando = jogador1;
            } else {
                jogadorJogando = jogador2;
            }

            System.out.println("<============= " + jogadorJogando.getNome() + " =============>");
            System.out.println("Digite o número da tropa desejada");
            System.out.println("          1 - Arqueira");
            System.out.println("          2 - Cavaleiro");
            System.out.println("          3 - Esqueletos");
            System.out.println("          4 - Caçador");
            System.out.println("          5 - Lançador");
            System.out.println("          6 - Mosqueteira");
            System.out.println("<=================================>\n> ");
            tropaEscolhida = sc.nextInt();
            jogadorJogando.escolherTropaJogador(tropaEscolhida);

        } while (jogador1.getNumeroDeTropas() <= 2 || jogador2.getNumeroDeTropas() <= 2);

        menuInGameJogador(jogador1, jogador2, jogadorJogando);
    }

    private static void menuSelecionarTropa(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando, Jogador jogadorInimigo) {
        System.out.println("Tropas disponíveis:");

        ArrayList<Unidade> tropasDisponiveis = jogadorJogando.getUnidades();

        for (int i = 0; i < tropasDisponiveis.size(); i++) {
            Unidade tropa = tropasDisponiveis.get(i);
            System.out.println((i) + " - " + tropa.toString());
        }

        System.out.println("Selecione o número correspondente à tropa desejada:");
        int tropaSelecionada = sc.nextInt();
        Unidade unidade = jogadorJogando.getUnidades().get(tropaSelecionada);
        System.out.println(unidade.toString());

        if (tropaSelecionada < 0 || tropaSelecionada > tropasDisponiveis.size()) {
            System.out.println("Opção inválida, escolha novamente.");
            menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
            return;
        }

        Unidade tropa = tropasDisponiveis.get(tropaSelecionada);
        int opcaoTropa;
        System.out.println("Agora execute a ação da tropa:");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Analizar");
        opcaoTropa = sc.nextInt();
        boolean telaOpcaoTropa = true;
        do {
            switch (opcaoTropa) {
                case 1:
                    int i = 0;
                    if (jogadorJogando == jogador1) {
                        for (i = 0; i < jogador2.getNumeroDeTropas(); i++) {
                            Unidade tropa2 = jogador2.getUnidades().get(i);
                            System.out.println((i + 1) + " - " + tropa2.toString());
                        }
                    }

                    if (jogadorJogando == jogador2) {
                        for (i = 0; i < jogador1.getNumeroDeTropas(); i++) {
                            Unidade tropa1 = jogador1.getUnidades().get(i);
                            System.out.println((i + 1) + " - " + tropa1.toString());
                        }
                    }

                    System.out.println("Qual das tropas você deseja atacar?");
                    int opcao = sc.nextInt();
                    Unidade unidadeInimiga = jogadorInimigo.getUnidades().get(opcao);
                    System.out.println(unidadeInimiga.toString());
                    if (opcao < 1 || opcao > tropasDisponiveis.size()) {
                        System.out.println("Opção inválida, escolha novamente.");
                    }

                        telaOpcaoTropa = false;
                        break;
                        case 2:
                            //defender
                            break;
                        case 3:
                            //analizar
                            break;
                        default:
                            System.out.println("Opção invalida");
                    }
            }while (telaOpcaoTropa == true);
        }

    private static void desistir(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
        System.out.println("Fim de jogo");
        if (jogadorJogando.equals(jogador1)) {
            System.out.println("O jogador " + jogador1.getNome() + " desistiu da partida, vitória para o jogador " + jogador2.getNome());
            jogador2.incrementarVitorias();
        } else if (jogadorJogando.equals(jogador2)) {
            System.out.println("O jogador " + jogador2.getNome() + " desistiu da partida, vitória para o jogador " + jogador1.getNome());
            jogador1.incrementarVitorias();
        }
        jogador1.getUnidades().clear();
        jogador2.getUnidades().clear();
        jogador1.setNumeroDeTropas(0);
        jogador2.setNumeroDeTropas(0);

        menuTropas(jogador1, jogador2, jogadorJogando);

    }

    public static void menuInGameJogador(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
        boolean jogoRodando = true;
        boolean verJogador = true;

        while (jogoRodando) {
            int opcaoMenuInGame = 0;
            Jogador jogadorInimigo;
            do {
                if (verJogador) {
                    jogadorJogando = jogador1;
                    jogadorInimigo = jogador2;

                } else {
                    jogadorJogando = jogador2;
                    jogadorInimigo = jogador1;
                }
                verJogador = !verJogador;
                System.out.println("Turno do(a) " + jogadorJogando.getNome());
                System.out.println("Essas são suas tropas");
                for (int i = 0; i < jogadorJogando.getNumeroDeTropas(); i++) {
                    Unidade tropa2 = jogadorJogando.getUnidades().get(i);
                    System.out.println(("\n") + tropa2.toString() + ":" + "\n - " + "\uD83D\uDC8A : " + tropa2.getVida());
                    System.out.println(" - " + "⚔️ : " + tropa2.getAtaque());
                    System.out.println(" - " + "\uD83D\uDEE1 : " + tropa2.getAtaque());
                }
                System.out.println("\nSelecione a opção desejada");
                System.out.println("1 - Selecionar tropa");
                System.out.println("2 - Aceitar a morte\n>");
                opcaoMenuInGame = sc.nextInt();
                switch (opcaoMenuInGame) {
                    case 1:
                        menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                        break;
                    case 2:
                        desistir(jogador1, jogador2, jogadorJogando);
                        break;
                    default:
                        System.out.println("Selecione uma opção válida");
                        break;
                }
            } while (opcaoMenuInGame < 1 || opcaoMenuInGame > 2);

        }
    }

}