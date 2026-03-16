## Ejercicio 1
![img.png](parte1/img.png)
### Patrón 1

Nombre del patrón: Strategy
Tipo: Comportamiento
Justificación técnica:
Permite cambiar dinámicamente el algoritmo de envío de notificaciones dependiendo del canal (Email, SMS, Push) sin modificar el código del cliente.

### Patrón 2

Nombre del patrón: Singleton
Tipo: Creacional
Justificación técnica:
Garantiza que el servicio de notificaciones tenga una sola instancia en todo el sistema.

## parte 2
Ejercicio 2 – Sistema de Pagos
![img.png](img.png)

### Adapter

Tipo: Estructural
Justificación: Permite adaptar APIs externas como PayPal o Stripe al sistema interno.

### Chain of Responsibility

Tipo: Comportamiento
Justificación: Permite ejecutar validaciones en cadena antes de procesar el pago.

### Strategy

Tipo: Comportamiento
Justificación: Permite cambiar el proveedor de pago dinámicamente.