package pt.ulusofona.lp2.crazyChess.pieces;

import java.util.List;
import java.util.Optional;
import pt.ulusofona.lp2.crazyChess.CrazyPiece;

public class Rainha extends CrazyPiece {

    @Override
    public boolean mover(List<CrazyPiece> lista, int xD, int yD) {
        if (this.moveNaDiagonal(this.getXInicial(), this.getYInicial(), xD, yD)) {
            System.out.println("Movimento na diagonal");
            for (int i = 0; i < Math.abs(yD - this.getYInicial()); i++) {

                int tempX = Math.abs(xD - this.getXInicial()) + i;//
                System.out.println("tempX: " + tempX);
                System.out.println("Math X: " + Math.abs(xD - this.getXInicial()));
                System.out.println("Math y: " + Math.abs(yD - this.getYInicial()));
                Optional result = lista.stream()
                        .filter(p -> !p.isCapturada())
                        .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
                        .filter(p -> Math.abs(xD - p.getXInicial()) == tempX)// retorna true se encontrar uma peca do seu trageto
                        .findAny();
                if (!result.isPresent()) {
                    System.out.println("Encontrou uma peca no caminho");
                    return false;
                }
            }
            this.setXInicial(xD);
            this.setYInicial(yD);
            return true;
        }
//      else if (this.moveHorizontal(this.getXInicial(), this.getYInicial(), xD, yD)) {
//            if ((xD - this.getXInicial()) > 0) {
//                System.out.println("Distancia positiva: " + (xD - this.getXInicial()));
//                int distanciaX = xD - this.getXInicial();
//                for (int i = 1; i < distanciaX; i++) {
//                    int tempX = this.getXInicial() + i;//
//                    Optional result = lista.stream()
//                            .filter(p -> !p.isCapturada())
//                            //.filter(p -> !p.getNomeEquipa().equals(this.getNomeEquipa()))//Filtra apenas a equipa diferentes
//                            .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
//                            .filter(p -> p.getXInicial() == tempX && p.getYInicial() == this.getYInicial())// retorna true se encontrar uma peca do seu trageto
//                            .findAny();
//                    if (result.isPresent()) {
//                        return false;
//                    }
//                }
//            } else {
//                System.out.println("Distancia negativa: " + (xD - this.getXInicial()));
//                int distanciaX = xD - this.getXInicial();
//                for (int index = 0; index > distanciaX; index--) {
//                    int tempX = this.getXInicial() + index;//
//                    Optional result = lista.stream()
//                            .filter(p -> !p.isCapturada())
//                            //.filter(p -> !p.getNomeEquipa().equals(this.getNomeEquipa()))//Filtra apenas a equipa diferentes
//                            .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
//                            .filter(p -> p.getXInicial() == tempX && p.getYInicial() == this.getYInicial())// retorna true se encontrar uma peca do seu trageto
//                            .findAny();
//                    if (result.isPresent()) {
//                        return false;
//                    }
//
//                }
//            }
//
//            System.out.println("Movimento na Horizontal");
//        } else if (this.moveVertical(this.getXInicial(), this.getYInicial(), xD, yD)) {
//            System.out.println("Movimento na Vertical");
//        } else {
//        }

        /*
        int distanciaX = xD - this.getXInicial();
        int distanciaY = yD - this.getYInicial();
        if ((this.getXInicial() == xD && this.getYInicial() != yD)
                || (this.getYInicial() == yD && this.getXInicial() != xD)) {
            if (this.getXInicial() == xD && this.getYInicial() != yD
                    && !(Math.abs(distanciaY) <= 5)) {
                return false;
            } else if (this.getYInicial() == yD && this.getXInicial() != xD
                    && !(Math.abs(distanciaX) <= 5)) {
                return false;
            }
            if (!this.validarEquipa(lista, xD, yD)) {
                return false;
            }
            this.setXInicial(xD);
            this.setYInicial(yD);
            return true;
        } else if (Math.abs(distanciaX) == Math.abs(distanciaY)
                && Math.abs(distanciaX) <= 5 && Math.abs(distanciaY) <= 5) {
            if (!this.validarEquipa(lista, xD, yD)) {
                return false;
            }
            this.setXInicial(xD);
            this.setYInicial(yD);
            return true;
        }
        return false;*/
        return true;
    }

}
