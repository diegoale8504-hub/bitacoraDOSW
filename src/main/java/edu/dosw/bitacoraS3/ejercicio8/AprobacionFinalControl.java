package edu.dosw.bitacoraS3.ejercicio8;

public class AprobacionFinalControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("[Aprobación Final] Migración revisa el resultado...");
        request.setAprobado(true);
        System.out.println("[Aprobación Final] APROBADO: Puede ingresar a Estados Unidos.");
    }
}