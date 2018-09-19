/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dark;

/**
 *
 * @author manueljesusgarcialopez
 */
public class SubOrdenes {
    
    private int idPJ = 0;
    private int accion = 0;
    private int casillaX = 0;
    private int casillaY = 0;
    private String enemigo = "";
    private String objeto = "";
    private String bando = "";
    private String dominio = "";

    public SubOrdenes() {
    }

    public int getAccion() {
        return accion;
    }

    public int getCasillaX() {
        return casillaX;
    }

    public int getCasillaY() {
        return casillaY;
    }

    public String getEnemigo() {
        return enemigo;
    }

    public String getObjeto() {
        return objeto;
    }

    public String getBando() {
        return bando;
    }

    public String getDominio() {
        return dominio;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }

    public void setCasillaX(int casillaX) {
        this.casillaX = casillaX;
    }

    public void setCasillaY(int casillaY) {
        this.casillaY = casillaY;
    }

    public void setEnemigo(String enemigo) {
        this.enemigo = enemigo;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public int getIdPJ() {
        return idPJ;
    }

    public void setIdPJ(int idPJ) {
        this.idPJ = idPJ;
    }
    
}
