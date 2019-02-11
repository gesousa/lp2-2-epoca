package pt.ulusofona.lp2.crazyChess;

public class TipoDePeca {

    private int id;
    private String designacao;
    private Integer valorRelativo;
    private String img;

    public TipoDePeca() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getValorRelativo() {
        return valorRelativo;
    }

    public void setValorRelativo(int valorRelativo) {
        this.valorRelativo = valorRelativo;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
