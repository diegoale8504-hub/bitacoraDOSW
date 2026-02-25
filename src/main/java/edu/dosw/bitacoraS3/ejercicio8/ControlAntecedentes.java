package edu.dosw.bitacoraS3.ejercicio8;

public class ControlAntecedentes extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("[Control Antecedentes] Verificando antecedentes...");

        if (!request.isAntecedentesLimpios()) {
            System.out.println("[Control Antecedentes] RECHAZADO: Antecedentes no limpios.");
            request.setAprobado(false);
            return;
        }

        System.out.println("[Control Antecedentes] OK.");
        pasarAlSiguiente(request);
    }
}