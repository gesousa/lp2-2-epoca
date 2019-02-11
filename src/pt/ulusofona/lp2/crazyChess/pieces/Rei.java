package pt.ulusofona.lp2.crazyChess.pieces;

import java.util.List;
import java.util.Optional;
import pt.ulusofona.lp2.crazyChess.CrazyPiece;

public class Rei extends CrazyPiece {

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

        if (Math.abs(this.getXInicial() - xF) <= 1 && Math.abs(this.getYInicial() - yF) <= 1) {
            this.setXInicial(xF);
            this.setYInicial(yF);
            return true;
        } /*
        int resultX = xF - this.getXInicial();
        int resultY = yF - this.getYInicial();
        
        if (resultX == 1 || resultX == -1 || resultX == 0) {
            if (-1 == resultY || 1 == resultY || 0 == resultY) {
                this.setXInicial(xF);
                this.setYInicial(yF);
                return true;
            } else {
                return false;
            }
        }*/ else {
            return false;
        }
    }

}
