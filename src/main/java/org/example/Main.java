package org.example;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Pacient> pacientes = new ArrayList<>();
        boolean continuar = true;
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("pacientes.txt");
        if (inputStream == null) {
            throw new IllegalArgumentException("Archivo pacientes.txt no encontrado");
        }
        Scanner scanner = new Scanner(inputStream);
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length < 3) {
                    System.out.println("Línea no válida: " + line);
                    continue;
                }
                Pacient paciente = new Pacient(data[0].trim(), data[1].trim(), data[2].trim().charAt(0));
                pacientes.add(paciente);
            }
        } finally {
            scanner.close();
        }
        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("Bienvenido doctor/a, por favor seleccione la implementación de PriorityQueue que quiera");
        System.out.println("1. Vector Heap");
        System.out.println("2. Java PriorityQueue");
        int election = consoleScanner.nextInt();

        IPriorityQueue<Pacient> colaDeEmergencias = null;

        switch (election) {
            case 1:
                colaDeEmergencias = QueueFactory.crearQueue(VectorHeap.class);
                System.out.println("Se ha creado la lista con la implementación VectorHeap.");
                break;
            case 2:
                colaDeEmergencias = QueueFactory.crearQueue(JavaPriorityQueue.class);
                System.out.println("Se ha creado la lista con la implementación Java PriorityQueue.");
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }
        for (Pacient paciente : pacientes) {
            colaDeEmergencias.add(paciente);
        }
        while (continuar) {
            System.out.println("Seleccione lo que desea hacer:");
            System.out.println("1. Añadir un paciente");
            System.out.println("2. Atender a un paciente");
            System.out.println("3. Ver qué paciente es el siguiente en la lista de prioridad");
            System.out.println("4. Ver toda la lista de pacientes");
            System.out.println("5. Para salir");
            int election1 = consoleScanner.nextInt();
            consoleScanner.nextLine();

            switch (election1) {
                case 1:
                    System.out.println("Ingrese el nombre del paciente:");
                    String nombre = consoleScanner.nextLine();

                    System.out.println("Ingrese el padecimiento del paciente:");
                    String padecimiento = consoleScanner.nextLine();

                    System.out.println("Ingrese el nivel de prioridad del paciente (A-E, A siendo muy prioritario y E menos prioritario):");
                    String codigoStr = consoleScanner.nextLine().toUpperCase();
                    if (codigoStr.isEmpty() || codigoStr.charAt(0) < 'A' || codigoStr.charAt(0) > 'E') {
                        System.out.println("Nivel de prioridad inválido.");
                        break;
                    }
                    char prioridad = codigoStr.charAt(0);

                    Pacient nuevoPaciente = new Pacient(nombre, padecimiento, prioridad);
                    colaDeEmergencias.add(nuevoPaciente);

                    System.out.println("Paciente añadido exitosamente.");
                    break;
                case 2:
                    if (!colaDeEmergencias.isEmpty()) {
                        Pacient pacienteAtendido = colaDeEmergencias.remove();
                        System.out.println("Se esta ateniendo al paciente: " + pacienteAtendido.getNombre());
                        System.out.println();
                    } else {
                        System.out.println("No hay pacientes en espera.");
                    }
                    break;
                case 3:
                    if (!colaDeEmergencias.isEmpty()) {
                        Pacient siguientePaciente = colaDeEmergencias.peeck();
                        System.out.println("El siguiente paciente en la lista es: " + siguientePaciente.getNombre());
                        System.out.println();
                    } else {
                        System.out.println("No hay pacientes en espera.");
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Los pacientes que siguen en la cola son:" + colaDeEmergencias.toString());
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println();
                    continuar = false;
            }
        }
        consoleScanner.close();
    }
}