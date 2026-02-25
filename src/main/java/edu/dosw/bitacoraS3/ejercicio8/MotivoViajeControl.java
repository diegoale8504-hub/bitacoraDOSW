package edu.dosw.bitacoraS3.ejercicio8;

public class MotivoViajeControl extends ControlMigratorioHandler {

    @Override
    public void procesar(IngresoRequest request) {
        System.out.println("[Control Motivo] Revisando motivo del viaje...");

        if (!request.isMotivoValido()) {
            System.out.println("[Control Motivo] RECHAZADO: Motivo no válido.");
            request.setAprobado(false);
            return;
        }

        System.out.println("[Control Motivo] OK.");
        pasarAlSiguiente(request);
    }
}