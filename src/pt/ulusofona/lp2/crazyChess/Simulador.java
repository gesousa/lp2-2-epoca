package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pt.ulusofona.lp2.crazyChess.pieces.Lebre;
import pt.ulusofona.lp2.crazyChess.pieces.PadreDaVila;
import pt.ulusofona.lp2.crazyChess.pieces.PoneiMagico;
import pt.ulusofona.lp2.crazyChess.pieces.Rainha;
import pt.ulusofona.lp2.crazyChess.pieces.Rei;
import pt.ulusofona.lp2.crazyChess.pieces.TorreHorizontal;
import pt.ulusofona.lp2.crazyChess.pieces.TorreVertical;

public class Simulador {

    enum Equipa {
        Preta, Branca
    };
    static Equipa equipa;

    int tamanhoTabuleiro;
    int numPecas;
    int turno = 0;
    boolean houveCaptura;
    int equipaActiva = 10;
    int[] equipaBranca = new int[3];
    int[] equipaPreta = new int[3];
    final List<CrazyPiece> listaPecas = new ArrayList<>();
    List<CrazyPiece> tempListaPecas = listaPecas;

    public static void mudarEquipa(Equipa nome) {
        equipa = nome;
    }

    public void validarCaptura(CrazyPiece peca, int xD, int yD) {
        tempListaPecas.removeIf(p -> {
            if (!(p.getNomeEquipa().equals(peca.getNomeEquipa()))) {
                if (p.getXInicial() == peca.getXInicial()
                        && p.getYInicial() == peca.getYInicial()) {
                    if (peca.getNomeEquipa().equals("Preta")) {
                        equipaPreta[0] += 1;
                    } else {
                        equipaBranca[0] += 1;
                    }
                    p.setCapturada();
                    houveCaptura = true;
                    listaPecas.stream().filter(piece -> {
                        if (piece.getId() == p.getId()) {
                            piece.setCapturada();
                            return true;
                        }
                        return false;
                    });
                    return true;
                }

            }
            return false;
        });
    }
    
    public boolean iniciaJogo(File ficheiroInicial) {
        try {
            int posicaoY = 0;

            int countLinha = 0;
            int countPecas = 0;
            int seccao = 1;
            int countSeccao = 0;
            boolean posicaoPecas = false;

            Scanner leitorFicheiro = new Scanner(ficheiroInicial);

            while (leitorFicheiro.hasNextLine()) {
                // ler uma linha do ficheiro
                String linha = leitorFicheiro.nextLine();
                // partir a linha no caractere separador          
                String dados[] = linha.split(":");

                if (countLinha == 0 && seccao == 1) {
                    int tempTamanho = Integer.parseInt(dados[0]);
                    if (4 <= tempTamanho && tempTamanho <= 12) {
                        tamanhoTabuleiro = tempTamanho;
                        countSeccao++;
                    } else {
                        System.out.println("O tabuleiro não pode ser inferior "
                                + "que 4 e nem maior que 12.");
                    }

                } else if (countLinha == 1) {
                    int temp = Integer.parseInt(dados[0]);
                    if (!(temp > tamanhoTabuleiro * tamanhoTabuleiro)) {
                        numPecas = temp;
                        posicaoPecas = true;
                        countSeccao++;
                    } else {
                        System.out.println("Não pode conter um num de pecas "
                                + "maior que o tabuleiro.");
                    }
                }
                /* Condição válida se estiver nas linhas das pecas, se a linha
                 for superior 1 e se num de pecas for  maior que as pecas contabilizadas
                 */
                if (posicaoPecas && countLinha > 1 && numPecas > countPecas) {

                    int idPersonagem = Integer.parseInt(dados[0]);
                    int idTipoPeca = Integer.parseInt(dados[1]);
                    int idEquipa = Integer.parseInt(dados[2]);
                    String alcunha = dados[3];

                    CrazyPiece newPiece;

                    if (idTipoPeca == 0) {
                        newPiece = new Rei();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    } else if (idTipoPeca == 1) {
                        newPiece = new Rainha();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    } else if (idTipoPeca == 2) {
                        newPiece = new PoneiMagico();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    } else if (idTipoPeca == 3) {
                        newPiece = new PadreDaVila();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    } else if (idTipoPeca == 4) {
                        newPiece = new TorreHorizontal();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    } else if (idTipoPeca == 5) {
                        newPiece = new TorreVertical();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    } else if (idTipoPeca == 6) {
                        newPiece = new Lebre();
                        newPiece.setId(idPersonagem);
                        newPiece.setIdPecaTipo(idTipoPeca);
                        newPiece.setIdEquipa(idEquipa);
                        newPiece.setAlcunha(alcunha);
                        newPiece.setTipoDePeca();
                        listaPecas.add(newPiece);
                    }

                    countPecas++;
                } else if (countLinha >= (numPecas + countSeccao)) {
                    int tempCount = 0;
                    for (String i : dados) {
                        int tempID = Integer.parseInt(i);
                        if (tempCount <= tamanhoTabuleiro - 1) {
                            if (tempID != 0) {
                                for (CrazyPiece p : listaPecas) {
                                    if (p.getId() == tempID) {
                                        p.setXInicial(tempCount);
                                        p.setYInicial(posicaoY);
                                    }
                                }
                            }
                            if (tempCount == tamanhoTabuleiro - 1) {
                                posicaoY++;
                            }
                        }
                        tempCount++;
                    }
                }
                countLinha++;
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getTamanhoTabuleiro() {
        return tamanhoTabuleiro;
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD) {
        for (CrazyPiece peca : tempListaPecas) {
            if (peca.getXInicial() == xO && peca.getYInicial() == yO && !peca.isCapturada()) {
                //Condição para verificar se a origem e o destino são iguais
                if (!((xD == xO) && (yD == yO))) {
                    // A primeira equipa activa é a das peças pretas
                    if (turno == 0) {
                        if (peca.getNomeEquipa().equals("Preta")) {
                            // A peca move se as coordenadas de destino não estiver 
                            //ocupada por uma peça da mesma cor e o movimento for válido
                            if (peca.mover(tempListaPecas, xD, yD)) {
                                this.validarCaptura(peca, xD, yD);
                                turno++;
                                equipaActiva = 20;
                                mudarEquipa(Equipa.Branca);
                                equipaPreta[1] += 1;
                                return true;
                            } else {
                                equipaPreta[2] += 1;
                                return false;
                            }
                        } else {
                            equipaBranca[2] += 1;
                        }
                    } else {
                        String tempEquipa = equipa.name();
                        //Apenas move se a equipa actual for a equipa activa
                        if (peca.getNomeEquipa().equals(tempEquipa)) {
                            // A peca move se as coordenadas de destino não estiver ocupada por uma peça da mesma cor
                            if (peca.mover(tempListaPecas, xD, yD)) {
                                //Verificamos a equipa activa e alteramos para que a outra equipa jogue no proximo turno
                                if (tempEquipa.equals("Branca")) {
                                    equipaActiva = 10;
                                    mudarEquipa(Equipa.Preta);
                                } else if (tempEquipa.equals("Preta")) {
                                    equipaActiva = 20;
                                    mudarEquipa(Equipa.Branca);
                                }

                                if (peca.getNomeEquipa().equals("Preta")) {
                                    equipaPreta[1] += 1;
                                } else {
                                    equipaBranca[1] += 1;
                                }
                                this.validarCaptura(peca, xD, yD);
                                turno++;
                                return true;
                            } else {
                                if (peca.getNomeEquipa().equals("Preta")) {
                                    equipaPreta[2] += 1;
                                } else {
                                    equipaBranca[2] += 1;
                                }
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                } else {
                    if (peca.getNomeEquipa().equals("Preta")) {
                        equipaPreta[2] += 1;
                    } else {
                        equipaBranca[2] += 1;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas() {
        return tempListaPecas;
    }

    public boolean jogoTerminado() {
        if (turno == 3 && (equipaPreta[0] > 0 || equipaBranca[0] > 0)) {
            return true;
        }
        return false;
    }

    public List<String> getAutores() {
        List<String> dados = new ArrayList<>();
        dados.add(" a21704669;Genesis Sousa");
        return dados;
    }

    public List<String> getResultados() {
        List<String> resultados = new ArrayList<>();
        resultados.add("JOGO DE CRAZY CHES");
        String res = "EMPATE";
        if (equipaBranca[0] > equipaPreta[0]) {
            res = "VENCERAM AS BRANCAS";
        } else if (equipaBranca[0] < equipaPreta[0]) {
            res = "VENCERAM AS PRETAS";
        }
        resultados.add("Resultado: " + res);
        resultados.add("---");
        resultados.add("Equipa das Pretas ");
        resultados.add("    Capturas: " + equipaPreta[0]);
        resultados.add("    Jogadas válidas: " + equipaPreta[1]);
        resultados.add("    Tentativas inválidas: " + +equipaPreta[2]);
        resultados.add("Equipa das Brancas");
        resultados.add("    Capturas: " + equipaBranca[0]);
        resultados.add("    Jogadas válidas: " + equipaBranca[1]);
        resultados.add("    Tentativas inválidas: " + equipaBranca[2]);

        return resultados;
    }

    public int getIDPeca(int x, int y) {
        for (CrazyPiece peca : listaPecas) {
            if (peca.getXInicial() == x && peca.getYInicial() == y) {
                return peca.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar() {
        return equipaActiva;
    }

    public boolean gravarJogo(File ficheiroDestino) {
        return false;
    }

    public void anularJogadaAnterior() {

    }

    public List<String> obterSugestoesJogada(int xO, int yO) {
        List<String> tempList = new ArrayList<>();
        return tempList;

    }
}

/*
    public boolean validarJogadaPeca(CrazyPiece peca, int xD, int yD, String tipo) {
        if (tipo.equals("validarEquipa")) {
            Optional res = tempListaPecas.stream()
                    .filter(p -> !p.isCapturada())
                    .filter(p -> p.getNomeEquipa().equals(peca.getNomeEquipa()))//Filtra apenas a equipa activa
                    .filter(p -> p.getId() != peca.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
                    .filter(p -> p.getXInicial() == xD && p.getYInicial() == yD)// retorna true se encontrar uma peca da mesma equipa nas coordenadas destino
                    .findAny();
            return res.isPresent();
        } else if (tipo.equals("validarMovimento")) {
            int resultX = xD - peca.getXInicial();
            int resultY = yD - peca.getYInicial();
            if (resultX == 1 || resultX == -1 || resultX == 0) {
                if (-1 == resultY || 1 == resultY || 0 == resultY) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;

    }
*/