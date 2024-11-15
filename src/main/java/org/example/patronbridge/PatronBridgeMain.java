package org.example.patronbridge;


import org.example.factory.EncriptacionFactory;
import org.example.encriptacion.InterfaceEncriptar;
import org.example.implementacion.PuenteMensajeEncriptacion;
import org.example.implementacion.InterfaceMensajeEncriptacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PatronBridgeMain {

    public static void main(String[] args) {
        try {
            // Load configuration
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/java/org/example/config/config/config.properties"));
            String encryptionType = properties.getProperty("encryption.type");

            // Create encryption process using the factory
            InterfaceEncriptar proceso = EncriptacionFactory.getEncriptacionProceso(encryptionType);

            // Use the bridge
            InterfaceMensajeEncriptacion puente = new PuenteMensajeEncriptacion(proceso);

            // Example message
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String encryptedMessage = puente.EncryptarMensaje(message, "HG58YZ3CR9123456");

            System.out.println("Mensaje Encriptado (" + encryptionType + "): " + encryptedMessage);

        } catch (IOException e) {
            System.err.println("Error cargando el archivo de configuración: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error en el proceso de encriptación: " + e.getMessage());
        }
    }
}
