package pt.ulusofona.lp2.crazyChess;

import java.util.List;
import java.util.Optional;

public abstract class CrazyPiece {

    private int idPeca;
    private int idPecaTipo;
    private int idEquipa;
    private String alcunha;
    private boolean capturada = false;
    protected int xInicial;
    private int yInicial;
    protected TipoDePeca tipoDePeca;

    public CrazyPiece() {
    }

    public CrazyPiece(int idPersonagem, int idPeca, int idEquipa, String alcunha) {
        this.idPeca = idPersonagem;
        this.idPecaTipo = idPeca;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;

    }

    public String getImagePNG() {
        if (this.tipoDePeca.getImg() != null) {
            return this.tipoDePeca.getImg();
        }
        return null;
    }

    public int getIdEquipa() {
        return this.idEquipa;
    }

    public int getIdPecaTipo() {
        return this.idPecaTipo;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public int getId() {
        return idPeca;
    }

    public int getXInicial() {
        return xInicial;
    }

    public int getYInicial() {
        return yInicial;
    }

    public String getPecaDesignacao() {
        return this.tipoDePeca.getDesignacao();
    }

    public void setId(int id) {
        this.idPeca = id;
    }

    public void setIdPecaTipo(int idPecaTipo) {
        this.idPecaTipo = idPecaTipo;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNomeEquipa() {
        String nome;
        if (this.idEquipa == 10) {
            nome = "Preta";
        } else {
            nome = "Branca";
        }
        return nome;
    }

    public boolean isCapturada() {
        return this.capturada;
    }

    public void setCapturada() {
        this.capturada = true;
    }

    public void setAlcunha(String alcunha) {
        this.alcunha = alcunha;
    }

    public void setXInicial(int xInicial) {
        this.xInicial = xInicial;
    }

    public void setYInicial(int yInicial) {
        this.yInicial = yInicial;
    }

    public void setTipoDePeca() {
        TipoDePeca tipoDePeca = new TipoDePeca();
        switch (this.idPecaTipo) {
            case 0:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("Rei");
                tipoDePeca.setValorRelativo(Integer.MAX_VALUE);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("black.png");
                } else {
                    tipoDePeca.setImg("white.png");
                }   break;
            case 1:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("Rainha");
                tipoDePeca.setValorRelativo(8);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("rainha_black.png");
                } else {
                    tipoDePeca.setImg("rainha_white.png");
                }   break;
            case 2:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("Ponei Mágico");
                tipoDePeca.setValorRelativo(5);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("ponei_magico_black.png");
                } else {
                    tipoDePeca.setImg("ponei_magico_white.png");
                }   break;
            case 3:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("Padre Vila");
                tipoDePeca.setValorRelativo(3);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("padre_vila_black.png");
                } else {
                    tipoDePeca.setImg("padre_vila_white.png");
                }   break;
            case 4:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("TorreH");
                tipoDePeca.setValorRelativo(3);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("torre_h_black.png");
                } else {
                    tipoDePeca.setImg("torre_h_white.png");
                }   break;
            case 5:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("TorreV");
                tipoDePeca.setValorRelativo(3);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("torre_v_black.png");
                } else {
                    tipoDePeca.setImg("torre_v_white.png");
                }   break;
            case 6:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("Lebre");
                tipoDePeca.setValorRelativo(2);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("lebre_black.png");
                } else {
                    tipoDePeca.setImg("lebre_white.png");
                }   break;
            case 7:
                tipoDePeca.setId(this.idPecaTipo);
                tipoDePeca.setDesignacao("Joker");
                tipoDePeca.setValorRelativo(4);
                if (this.getNomeEquipa().equals("Preta")) {
                    tipoDePeca.setImg("joker_black.png");
                } else {
                    tipoDePeca.setImg("joker_white.png");
                }   break;
            default:
                break;
        }
        this.tipoDePeca = tipoDePeca;
    }

    public abstract boolean mover(List<CrazyPiece> lista, int xF, int yF);

    public boolean validarEquipa(List<CrazyPiece> lista, int xF, int yF) {
        Optional res = lista.stream()
                .filter(p -> !p.isCapturada())
                .filter(p -> p.getNomeEquipa().equals(this.getNomeEquipa()))//Filtra apenas a equipa activa
                .filter(p -> p.getId() != this.getId()) // Ignoramos a peca que tem o ID igual ao da peca que pretendemos mover
                .filter(p -> p.getXInicial() == xF && p.getYInicial() == yF)// retorna true se encontrar uma peca da mesma equipa nas coordenadas destino
                .findAny();
        return !res.isPresent();
    }

    public boolean moveNaDiagonal(int xI, int yI, int xF, int yF) {
        // O movimento é na diagonal se abs(dx) == abs(dy)
        return (Math.abs(xF - xI) == Math.abs(yF - yI));
    }

    public  boolean moveHorizontal(int xI, int yI, int xF, int yF) {
        //
        return (yI == yF && xI != xF);
    }

    public boolean moveVertical(int xI, int yI, int xF, int yF) {
        //
        return (xI == xF && yI != yF);
    }

    @Override
    public String toString() {
        String text = getId() + " | " + this.tipoDePeca.getDesignacao() + " | "
                + this.tipoDePeca.getValorRelativo() + " | "
                + +getIdEquipa() + " | " + getAlcunha() + " @ ";

        if (this.isCapturada()) {
            text += " ( n / a )";
        } else {
            text += " (" + this.getXInicial() + ", " + this.getYInicial() + ")";
        }
        return text;
    }
}
