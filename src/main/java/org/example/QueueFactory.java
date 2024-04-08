package org.example;

public class QueueFactory {

    public static <T extends IPriorityQueue> T crearQueue (Class<T> tipoDeImplementacion){
        try {
            return tipoDeImplementacion.getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            throw new RuntimeException("Tipo de Implementacion no admitida", e);
        }
    }

}
