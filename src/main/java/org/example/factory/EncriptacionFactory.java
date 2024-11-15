package org.example.factory;


import org.example.encriptacion.InterfaceEncriptar;
import org.example.encriptacion.ProcesoEncriptarAES;
import org.example.encriptacion.ProcesoEncriptarDES;
import org.example.encriptacion.ProcesoSinEncriptar;

public class EncriptacionFactory {

    public static InterfaceEncriptar getEncriptacionProceso(String tipo) throws Exception {
        switch (tipo) {
            case "AES":
                return new ProcesoEncriptarAES();
            case "DES":
                return new ProcesoEncriptarDES();
            case "NONE":
                return new ProcesoSinEncriptar();
            default:
                throw new IllegalArgumentException("Tipo de encriptación no soportado: " + tipo);
        }
    }
}
