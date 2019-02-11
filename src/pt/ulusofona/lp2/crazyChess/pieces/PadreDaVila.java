package pt.ulusofona.lp2.crazyChess.pieces;

import java.util.List;
import java.util.Optional;
import pt.ulusofona.lp2.crazyChess.CrazyPiece;

public class PadreDaVila extends CrazyPiece {

    @Override
    public boolean mover(List<CrazyPiece> lista, int xF, int yF) {
        int distanciaX = xF - this.getXInicial();
        int distanciaY = yF - this.getYInicial();
        if (Math.abs(distanciaX) == Math.abs(distanciaY) && Math.abs(distanciaX) <= 3 && Math.abs(distanciaY) <= 3) {

            for (int i = 0; i < Math.abs(distanciaX); i++) {
                int tempX = Math.abs(xF) + i;//
                int tempY = Math.abs(yF) + i;//
                System.out.println("Math abs X " + Math.abs(xF) + " : " + tempX);
                System.out.println("Math abs Y " + Math.abs(yF) + " : " + tempY);
                Optional result = lista.stream()
                        .filter(p -> !p.isCapturada() && p.getId() != this.getId()
                        && !p.getNomeEquipa().equals(this.getNomeEquipa()))
                        .filter(p -> p.getPecaDesignacao().equals("Rainha"))
                        .filter(p -> Math.abs(p.getXInicial()) == tempX && Math.abs(p.getYInicial()) == tempY)
                        .findAny();
                if (result.isPresent()) {
                    System.out.println("Encontrou rainha");
                }
            }

            this.setXInicial(xF);
            this.setYInicial(yF);
            return true;
        }
        return false;
    }

}
