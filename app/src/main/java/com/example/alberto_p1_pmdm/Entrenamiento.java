package com.example.alberto_p1_pmdm;

import java.util.Date;

public class Entrenamiento {

    public Date fecha;
    public double tiempo;
    public double distancia;
    public double minkm;
    public double seckm;
    public double velocidadmedia;


    public Entrenamiento(Date fecha, double tiempo, double distancia, double minkm, double seckm, double velocidadmedia)

    {
        fecha = this.fecha;
        tiempo = this.tiempo;
        distancia = this.distancia;
        minkm = this.minkm;
        seckm = this.seckm;
        velocidadmedia = this.velocidadmedia;

    }

    public Entrenamiento(){}

    public void setDistancia(double Distancia){

        distancia = Distancia;

    }

    public double getDistancia()
    {
        return distancia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getMinkm() {
        return minkm;
    }

    public void setMinkm(double minkm) {
        this.minkm = minkm;
    }

    public double getSeckm() {
        return seckm;
    }

    public void setSeckm(double seckm) {
        this.seckm = seckm;
    }

    public double getVelocidadmedia() {
        return velocidadmedia;
    }

    public void setVelocidadmedia(double velocidadmedia) {
        this.velocidadmedia = velocidadmedia;
    }


    public String toString(){

          String Stiempo = String.valueOf(getTiempo());
          String sDistancia = String.valueOf(getDistancia());
          String sFecha = String.valueOf(fecha);



            String string = "Timpo: " + Stiempo + "\nDistancia: " +sDistancia + "\nFecha: " +sFecha;

        return string;
    }//end toString
}//end Entrenamiento
