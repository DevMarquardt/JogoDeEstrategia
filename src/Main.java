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
        System.out.println("<============================>\n>");
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
        verificarFimDeJogo(jogador1, jogador2, jogadorJogando);

        int opcaoTropa;
        ArrayList<Unidade> tropasDisponiveis = jogadorJogando.getUnidades();

        System.out.println("<============= " + jogadorJogando.getNome() + " =============>");
        System.out.println("O que você deseja fazer?");
        System.out.println("1 - Atacar tropa inimiga");
        System.out.println("2 - Analisar tropa inimiga");
        System.out.println("<=================================>\n>");
        opcaoTropa = sc.nextInt();

        switch (opcaoTropa) {
            case 1:
                System.out.println("<=======================================================================>");
                System.out.println("Selecione o número correspondente à tropa que deseja usar para atacar:");
                for (int i = 0; i < tropasDisponiveis.size(); i++) {
                    Unidade tropa = tropasDisponiveis.get(i);
                    System.out.println((i) + " - " + tropa.toString());
                }
                System.out.println("<=======================================================================>");
                System.out.println(">");
                int tropaSelecionada = sc.nextInt();

                if (tropaSelecionada < 0 || tropaSelecionada >= tropasDisponiveis.size()) {
                    System.out.println("Opção inválida, escolha novamente.");
                    menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                }

                Unidade unidade = jogadorJogando.getUnidades().get(tropaSelecionada);

                Unidade tropa = tropasDisponiveis.get(tropaSelecionada);
                int i = 0;
                System.out.println("<==========================================>");
                System.out.println("Qual das tropas inimigas você deseja atacar?");
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
                System.out.println("<==========================================>\n>");

                int opcao = sc.nextInt();
                if (jogadorJogando == jogador1) {
                    jogadorInimigo = jogador2;
                } else {
                    jogadorInimigo = jogador1;
                }
                if (opcao >= 0 && opcao < jogadorInimigo.getNumeroDeTropas()) {
                    Unidade unidadeInimiga = jogadorInimigo.getUnidades().get(opcao);
                    unidade.Atacar(tropa, unidadeInimiga, jogadorInimigo);

                    if (unidadeInimiga.getVida() <= 0) {
                        System.out.println("Tropa inimiga eliminada!");
                    }
                } else {
                    System.out.println("Opção inválida, escolha novamente.");
                    menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                }

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
                    System.out.println("💊: " + unidadeInimiga2.getVida());
                    System.out.println("⚔️: " + unidadeInimiga2.getAtaque());
                    System.out.println("🛡: " + unidadeInimiga2.getDefesa());
                    System.out.println("<==========================================>\n");
                    menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                } else {
                    System.out.println("Opção inválida, escolha novamente.");
                }
                break;

            default:
                System.out.println("Opção inválida, escolha novamente.");
                menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
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
                    menuTropas(jogador1, jogador2, jogadorJogando);
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

    private static void verificarFimDeJogo(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
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
                        menuTropas(jogador1, jogador2, jogadorJogando);
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

    private static void menuInGameJogador(Jogador jogador1, Jogador jogador2, Jogador jogadorJogando) {
        boolean verJogador = true;

        while (true) {
            int opcaoMenuInGame = 0;
            Jogador jogadorInimigo;
            do {
                verificarFimDeJogo(jogador1, jogador2, jogadorJogando);
                if (verJogador) {
                    jogadorJogando = jogador1;
                    jogadorInimigo = jogador2;
                } else {
                    jogadorJogando = jogador2;
                    jogadorInimigo = jogador1;
                }
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
                opcaoMenuInGame = sc.nextInt();
                if (opcaoMenuInGame == 1) {
                    verJogador = !verJogador;
                }
                switch (opcaoMenuInGame) {
                    case 1 -> menuSelecionarTropa(jogador1, jogador2, jogadorJogando, jogadorInimigo);
                    case 2 -> desistir(jogador1, jogador2, jogadorJogando);
                    default -> System.out.println("Selecione uma opção válida");
                }

            } while (opcaoMenuInGame < 1 || opcaoMenuInGame > 2);
        }
    }
}