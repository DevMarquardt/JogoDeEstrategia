import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jogador jogador1 = new Jogador("", 0);
        Jogador jogador2 = new Jogador("", 0);
        menuInicial(jogador1, jogador2);
    }

    private static void menuInicial(Jogador jogador1, Jogador jogador2) {
        int opcaoMenuInicial;
        System.out.println("<============================>");
        System.out.println("         1 - Jogar          ");
        System.out.println("         2 - Sair           ");
        System.out.println("<============================>\n>");
        opcaoMenuInicial = sc.nextInt();
        switch (opcaoMenuInicial){
            case 1:
                menuJogo(jogador1, jogador2);
                break;
            case 2:
                System.out.println("Finalizando");
                System.exit(0);
            default:
                System.out.println("Opção invalida");
                menuInicial(jogador1, jogador2);
        }
    }

    private static void menuJogo(Jogador jogador1, Jogador jogador2) {
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



        menuTropas(jogador1, jogador2);
    }

    private static void menuTropas(Jogador jogador1, Jogador jogador2) {
        int tropaEscolhida;

        do {
            System.out.println("<============= " + jogador1.getNome() + " =============>");
            System.out.println("Digite o número da tropa desejada");
            System.out.println("          1 - Arqueira");
            System.out.println("          2 - Cavaleiro");
            System.out.println("          3 - Esqueletos");
            System.out.println("          4 - Caçador");
            System.out.println("          5 - Lançador");
            System.out.println("          6 - Mosqueteira");
            System.out.println("<=================================>\n> ");
            tropaEscolhida = sc.nextInt();
            jogador1.escolherTropaJogador1(tropaEscolhida);

        } while (jogador1.numeroDeTropas<=2);

        do {
            System.out.println("<============= " + jogador2.getNome() + " =============>");
            System.out.println("Digite o número da tropa desejada");
            System.out.println("          1 - Arqueira");
            System.out.println("          2 - Cavaleiro");
            System.out.println("          3 - Esqueletos");
            System.out.println("          4 - Caçador");
            System.out.println("          5 - Lançador");
            System.out.println("          6 - Mosqueteira");
            System.out.println("<=================================>\n> ");
            tropaEscolhida = sc.nextInt();
            jogador2.escolherTropaJogador2(tropaEscolhida);

        } while (jogador2.numeroDeTropas<=2);

        menuInGame(jogador1, jogador2);
    }

    public static void menuInGame(Jogador jogador1, Jogador jogador2) {
        boolean jogoRodando = true;
        int opcaoMenuInGame;
        do {
            System.out.println("<===============================>");
            System.out.println(jogador1.toString());
            System.out.println("|                               |");
            System.out.println("|               VS              |");
            System.out.println("|                               |");
            System.out.println(jogador2.toString());
            System.out.println("<===============================>");
            System.out.println("Turno do(a) " + jogador1.getNome());
            System.out.println("Selecione a opção desejada");
            System.out.println("1 - Selecionar tropa");
            System.out.println("2 - Propor acordo");
            System.out.println("3 - Aceitar a morte\n>");
            opcaoMenuInGame = sc.nextInt();
            switch (opcaoMenuInGame){
                case 1:
                    menuSelecionarTropa();
                    break;
                case 2:
                    proporEmpate();
                    break;
                case 3:
                    desistir();
                    break;
                default:
                    System.out.println("Selecione uma opção valida");
            }
        } while (jogoRodando);
    }

    private static void menuSelecionarTropa() {
    }

    private static void proporEmpate() {
    }

    private static void desistir() {

    }
}