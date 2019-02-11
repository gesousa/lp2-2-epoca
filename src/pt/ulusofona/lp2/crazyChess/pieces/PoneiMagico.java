/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ulusofona.lp2.crazyChess.pieces;

import java.util.List;
import java.util.Optional;
import pt.ulusofona.lp2.crazyChess.CrazyPiece;

/**
 *
 * @author hackone
 */
public class PoneiMagico extends CrazyPiece {
    
    @Override
    public boolean mover(List<CrazyPiece> lista, int xD, int yD) {
        if (Math.abs(xD - this.getXInicial()) == 2 || Math.abs(yD - this.getYInicial()) == 2) {
            if (!this.validarEquipa(lista, xD, yD)) {
                return false;
            }
            this.setXInicial(xD);
            this.setYInicial(yD);
            return true;
            
        } else {
            return false;
        }
        
    }
}
