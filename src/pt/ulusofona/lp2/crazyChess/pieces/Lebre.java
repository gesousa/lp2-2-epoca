package pt.ulusofona.lp2.crazyChess.pieces;

import java.util.List;
import pt.ulusofona.lp2.crazyChess.CrazyPiece;

public class Lebre extends CrazyPiece {

    @Override
    public boolean mover(List<CrazyPiece> lista, int xD, int yD) {
        if (Math.abs(xD - this.getXInicial()) != 1 || Math.abs(yD - this.getYInicial()) != 1) {
            return false;
        } else {
            if (!this.validarEquipa(lista, xD, yD)) {
                return false;
            }
            this.setXInicial(xD);
            this.setYInicial(yD);
            return true;
        }

    }
}
