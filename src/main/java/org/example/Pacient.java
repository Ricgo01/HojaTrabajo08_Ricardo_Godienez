package org.example;

/**
 * La clase Pacient representa a un paciente que será atendido en la sección de emergencias de un hospital.
 * Contiene información sobre el nombre del paciente, su síntoma y un código de emergencia que determina la prioridad de atención.
 */

public class Pacient implements Comparable <Pacient> {

    private String nombre;
    private String sintoma;
    private char codigoEmergencia; // De A (máxima prioridad) a E (mínima prioridad)

    public Pacient(String nombre, String sintoma, char codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    // Métodos getter
    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public char getCodigoEmergencia() {
        return codigoEmergencia;
    }

    @Override
    public int compareTo(Pacient o) {
        return this.codigoEmergencia - o.codigoEmergencia;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %c", nombre, sintoma, codigoEmergencia);
    }
}
