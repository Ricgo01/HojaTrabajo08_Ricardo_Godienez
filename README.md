# Sistema de Colas con Prioridad para Atención de Pacientes

## Descripción
Este proyecto implementa un sistema de colas con prioridad para gestionar la atención de pacientes en la sección de emergencias de un hospital. Utiliza una estructura de datos de tipo Priority Queue, implementada a través de un heap, para determinar el orden de atención basado en la gravedad de las condiciones reportadas.

## Características
- **Gestión de Prioridades**: Los pacientes son atendidos según la urgencia de su condición, desde A (máxima prioridad) hasta E (mínima prioridad).
- **Flexibilidad**: Implementa dos versiones del sistema de colas, una utilizando `VectorHeap` propio y otra utilizando la `PriorityQueue` del Java Collection Framework.
- **Eficiencia**: Optimiza el tiempo de atención mediante el uso eficiente de colas con prioridad.
