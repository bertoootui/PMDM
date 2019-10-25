package com.example.botonletranif.core;

public class CalcularLetraNIF {

    public static final String NIF_STRING_ASOCIATION
            = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static char calcularLetraNif(int dni)
    {
        return NIF_STRING_ASOCIATION.charAt(dni%23);
    }//end calcularLetraNif
}
