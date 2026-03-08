package edu.dosw.corte1.bitacoraS3.ejercicio8;

public class PasaporteControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("[Control Pasaporte] Revisando pasaporte/visa...");

        if (!request.isPasaporteValido()) {
            System.out.println("[Control Pasaporte] RECHAZADO: Pasaporte/visa inválido.");
            request.setAprobado(false);
            return;
        }

        System.out.println("[Control Pasaporte] OK.");
        pasarAlSiguiente(request);
    }
}