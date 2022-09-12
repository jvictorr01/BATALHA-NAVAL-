
import java.io.*;
import java.util.Random;

public class BatalhaNavalT1 {

    public static String tabuleiro[][] = new String[8][8];
    public static int posicao[][] = new int[8][8];
    public static int randomize[] = new int[71];

    public static void zeraPosicao() {
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                posicao[l][c] = 0;
            }
        }
    }

    public static void cls() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }

    public static void gerarPosicoes() {
        Random random = new Random();
        for (int i = 0; i < randomize.length; i++) {
            randomize[i] = random.nextInt(8);
        }
    }

    public static void posicaoDosSubmarinos() {

        posicao[randomize[1]][randomize[2]] = 1;
        posicao[randomize[3]][randomize[4]] = 1;
        posicao[randomize[5]][randomize[6]] = 1;
        posicao[randomize[7]][randomize[8]] = 1;
        posicao[randomize[9]][randomize[10]] = 1;
    }

    public static void posicaoDosDistroyers() {

        posicao[randomize[11]][randomize[12]] = 3;
        posicao[randomize[13]][randomize[14]] = 3;
        posicao[randomize[15]][randomize[16]] = 3;
        posicao[randomize[17]][randomize[18]] = 3;
        posicao[randomize[19]][randomize[20]] = 3;
        posicao[randomize[21]][randomize[22]] = 3;
        posicao[randomize[23]][randomize[24]] = 3;
        posicao[randomize[25]][randomize[26]] = 3;
    }

    public static void posicaoDosCruzadores() {

        posicao[randomize[27]][randomize[28]] = 5;
        posicao[randomize[29]][randomize[30]] = 5;
        posicao[randomize[31]][randomize[32]] = 5;
        posicao[randomize[33]][randomize[34]] = 5;
        posicao[randomize[35]][randomize[36]] = 5;
        posicao[randomize[37]][randomize[38]] = 5;
        posicao[randomize[39]][randomize[40]] = 5;
        posicao[randomize[41]][randomize[42]] = 5;
        posicao[randomize[43]][randomize[44]] = 5;
    }

    public static void posicaoDosNavios() {

        posicao[randomize[45]][randomize[46]] = 7;
        posicao[randomize[47]][randomize[48]] = 7;
        posicao[randomize[49]][randomize[50]] = 7;
        posicao[randomize[51]][randomize[52]] = 7;
        posicao[randomize[53]][randomize[54]] = 7;
        posicao[randomize[55]][randomize[56]] = 7;
        posicao[randomize[57]][randomize[58]] = 7;
        posicao[randomize[59]][randomize[60]] = 7;
    }

    public static void posicaoDoPortaAviao() {

        posicao[randomize[61]][randomize[62]] = 9;
        posicao[randomize[63]][randomize[64]] = 9;
        posicao[randomize[65]][randomize[66]] = 9;
        posicao[randomize[67]][randomize[68]] = 9;
        posicao[randomize[69]][randomize[70]] = 9;
    }

    public static int lerLinha() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int Linha = 0;
        try {
            System.out.print("Informe a Linha ->  ");
            Linha = Integer.parseInt(entrada.readLine());
            if (Linha >= 0 && Linha <= 7) {
                return (Linha);
            } else {
                System.out.println("Linha invalida!!!");
                return (lerLinha());
            }
        } catch (Exception e) {
            System.out.println("Linha invalida!!!");
            return (lerLinha());
        }
    }

    public static int lerColuna() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int Coluna = 0;
        try {
            System.out.print("Informe a Coluna ->  ");
            Coluna = Integer.parseInt(entrada.readLine());
            if (Coluna >= 0 && Coluna <= 7) {
                return (Coluna);
            } else {
                System.out.println("Coluna invalida!!!");
                return (lerColuna());
            }
        } catch (Exception e) {
            System.out.println("Coluna invalida!!!");
            return (lerColuna());
        }

    }

    public static void inicilizaMatriz() {
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                tabuleiro[l][c] = " ";
            }
        }
    }

    public static void imprimeTabuleiro() {
        System.out.println("----------------------------------");
        System.out.println("--------- LANÇANDO BOMBA!! ---------");
        System.out.println(" ");
        System.out.println("    0   1   2   3   4   5   6   7");
        System.out.println("  _________________________________");
        for (int l = 0; l < 8; l++) {
            System.out.print(l + " ");
            for (int c = 0; c < 8; c++) {
                System.out.print("| " + tabuleiro[l][c] + " ");
            }
            System.out.println("|");
            System.out.println("  _________________________________");
        }
    }

    public static void verificaPosicao() {

        int submarino = 5;
        int distroyer = 8;
        int cruzador = 9;
        int navio = 8;
        int portaAvioes = 5;
        int pontos = 0;
        
        int controladora = 0;

        while (controladora == 0) {
            int lin = lerLinha();
            int col = lerColuna();

            int escolha = posicao[lin][col];
            System.out.println(escolha);

            if (tabuleiro[lin][col] == " ") {
                cls();
                switch (escolha) {
                    case 0:
                        System.out.println("Você atirou na ÁGUA, tente novamente!");
                        tabuleiro[lin][col] = "~";
                        System.out.println("Pontos = " + pontos);
                        imprimeTabuleiro();
                        break;
                    case 1:
                        System.out.println("Você acertou um SUBMARINO! + 1");
                        tabuleiro[lin][col] = "1";
                        pontos = pontos + 1;
                        System.out.println("Pontos = " + pontos);
                        submarino--;
                        imprimeTabuleiro();
                        break;
                    case 3:
                        System.out.println("Você acertou um DISTROYER! +3");
                        tabuleiro[lin][col] = "3";
                        pontos = pontos + 3;
                        System.out.println("Pontos = " + pontos);
                        distroyer--;
                        imprimeTabuleiro();
                        break;
                    case 5:
                        System.out.println("Você acertou um CRUZADOR! +5");
                        tabuleiro[lin][col] = "5";
                        pontos = pontos + 5;
                        System.out.println("Pontos = " + pontos);
                        cruzador--;
                        imprimeTabuleiro();
                        break;
                    case 7:
                        System.out.println("Você acertou um NAVIO! +7");
                        tabuleiro[lin][col] = "7";
                        pontos = pontos + 7;
                        System.out.println("Pontos = " + pontos);
                        navio--;
                        imprimeTabuleiro();
                        break;
                    case 9:
                        System.out.println("Você acertou um PORTA-AVIÕES! +90");
                        tabuleiro[lin][col] = "90";
                        pontos = pontos + 90;
                        System.out.println("Pontos = " + pontos);
                        portaAvioes--;
                        imprimeTabuleiro();
                        break;
                }
            }

            if (submarino == 0 && distroyer == 0 && cruzador == 0 && navio == 0 && portaAvioes == 0) {
                controladora = 1;
            }

        }
    }

    public static void main(String[] args) {
        int linha, coluna;

        zeraPosicao();
        gerarPosicoes();
        posicaoDosSubmarinos();
        posicaoDosDistroyers();
        posicaoDosCruzadores();
        posicaoDosNavios();
        posicaoDoPortaAviao();

        inicilizaMatriz();
        imprimeTabuleiro();

        verificaPosicao();
        System.out.println("Parabéns você ganhou!!");

    }

}
