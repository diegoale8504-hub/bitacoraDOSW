package edu.dosw.bitacoraS3.ejercicio8;

public class Main {

    public static void main(String[] args) {
        ControlMigratorio pasaporte = new PasaporteControl();
        ControlMigratorio antecedentes = new ControlAntecedentes();
        ControlMigratorio motivo = new MotivoViajeControl();
        ControlMigratorio aprobacion = new AprobacionFinalControl();

        pasaporte.setSiguiente(antecedentes);
        antecedentes.setSiguiente(motivo);
        motivo.setSiguiente(aprobacion);

        // Ejemplo (como la diapositiva): true, true, false
        IngresoRequest persona = new IngresoRequest(
                false,
                true,
                true
        );

        pasaporte.procesar(persona);

        System.out.println("Resultado final (aprobado): " + persona.isAprobado());
    }
}