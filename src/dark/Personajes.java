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
public class Personajes {
    
    private int id;
    private String nombre;
    private int fuerza;
    private int velocidad;
    private int energia;
    private int agilidad;
    private int magia;
    private int vida;
    private String rango;
    private int oro;
    private int posX;
    private int posY;
    private int mov;

    public Personajes(int id, String nombre, int fuerza, int velocidad, int energia, int agilidad, int magia, int vida, String rango, int oro, int posX, int posY, int mov) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.velocidad = velocidad;
        this.energia = energia;
        this.magia = magia;
        this.vida = vida;
        this.rango = rango;
        this.oro = oro;
        this.posX = posX;
        this.posY = posY;
        this.mov = mov;
    }

    public int getMov() {
        return mov;
    }

    public void setMov(int mov) {
        this.mov = mov;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
}
