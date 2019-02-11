package pt.ulusofona.lp2.crazyChess.pieces;

import java.util.List;
import java.util.Optional;
import pt.ulusofona.lp2.crazyChess.CrazyPiece;

public class TorreVertical extends CrazyPiece {

    @Override
    public boolean mover(List<CrazyPiece> lista, int xF, int yF) {

        Optional res = lista.stream()
                .filter(p -> !p.isCapturada())
                .filter(p -> p.getNomeEquipa().equals(this.getNomeEquipa()))//Filtra apenas a equipa activa
                .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
                .filter(p -> p.getXInicial() == xF && p.getYInicial() == yF)// retorna true se encontrar uma peca da mesma equipa nas coordenadas destino
                .findAny();
        if (res.isPresent()) {
            return false;
        }

        int distanciaX = xF - this.getXInicial();
        int distanciaY = yF - this.getYInicial();
        if (0 == distanciaX) {
            if (distanciaY > 0) {
                for (int i = 1; i < distanciaY; i++) {
                    int tempY = this.getYInicial() + i;//
                    Optional result = lista.stream()
                            .filter(p -> !p.isCapturada())
                            //.filter(p -> !p.getNomeEquipa().equals(this.getNomeEquipa()))//Filtra apenas a equipa diferentes
                            .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
                            .filter(p -> p.getXInicial() == this.getXInicial() && p.getYInicial() == tempY)// retorna true se encontrar uma peca do seu trageto
                            .findAny();
                    if (result.isPresent()) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i > distanciaY; i--) {
                    int tempY = this.getYInicial() + i;//
                    Optional result = lista.stream()
                            .filter(p -> !p.isCapturada())
                            //.filter(p -> !p.getNomeEquipa().equals(this.getNomeEquipa()))//Filtra apenas a equipa diferentes
                            .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
                            .filter(p -> p.getXInicial() == this.getXInicial() && p.getYInicial() == tempY)// retorna true se encontrar uma peca do seu trageto
                            .findAny();
                    if (result.isPresent()) {
                        return false;
                    }
                }
            }
            this.setYInicial(yF);
            return true;
        } else {
            return false;
        }
    }

}
