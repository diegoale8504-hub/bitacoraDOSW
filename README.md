# bitacoraDOSW
Aqui se van a realizar los ejercicios que sean dejados en la clase de DOSW

## Semana 1 aprendizaje
### Qué entendía mal antes?
No sabia cómo usar bien los stream, mi conocimiento sobre estos era mas bien flojo. Pensé que solo eran para recorrer
listas pero veo que tienen muchas mas funcionalidades: como los map, sorted entre otros.
### Qué entiendo ahora?
Podemos procesar las colecciones declarativamente. Ahora entiendo como encadenar operaciones, aplicar filtros, convertir
tipo de una variable a otro tipo.
### Qué me falta reforzar?
Me falta mejorar todo el uso de estas metodologias ya que siento que es de lo mas importante para poder realizar proyectos.



---

## Semana 2
### Que entendia mal antes?
Ya que desde DOPO solo se veian a profundidad dos de los principios solid, ahora entiendo mucho mas la importancia
y lo necesario que son los demas principios SOLID. Veo que no son tan dificiles de aplicar siempre y cuando se sepa
como es la estructura de estos patrone.

### Qúe entiendo ahora?
Ya comprendo como se tienen que aplicar los principios SOLID en la practica, todo gracias a que he practicad
el como se deben de hacer en los ejercicios.

### Qué me falta reforzar?
Me falta saber bien como es el contexto de los problemas para saber exactamente que patron es el que debo de aplicar,
tambien deberia de empezar a mejor a al hora de ver si debo o no de usar mas de un patron en los problemas que se estan
desarrolando.



---

## Semana 3
### Qué entendía mal antes?
Antes no sabia muy bien si debia usar o no mas de un patron en el desarrolo de lo que estamos haciendo, ahora lo entiendo
un poco mejor.

### Qué entiendo mejor ahora?
Como lo mencionaba antes, soy mejor sabiendo que patron elegir a la hora de realizar ejercicios, pero siempre se puede mejorar.

### Me falta reforzar
identificar los patrones a usar.

### Ejercicios (patrón usado y por qué se usa)
**Nota:** El objetivo general fue desacoplar responsabilidades, facilitar extensiones y evitar código rígido o duplicado.

- **Ejercicio 1 — Factory Method (Comercio electrónico)**  
  **Descripción:** Permite crear objetos a través de un “método fábrica” sin depender de clases concretas.  
  **Por qué se usa:** En un e-commerce se pueden tener distintos tipos de productos/órdenes/pagos; el Factory Method ayuda a **instanciar el tipo correcto** según el caso sin llenar el código de `if/else` o `new` repetidos.

- **Ejercicio 2 — Abstract Factory (Videojuegos: Xbox / PlayStation)**  
  **Descripción:** Provee una familia de objetos relacionados (por ejemplo controles, consola, juegos) sin especificar sus clases concretas.  
  **Por qué se usa:** Porque Xbox y PlayStation son **familias completas** de objetos compatibles entre sí; Abstract Factory asegura que se creen objetos del mismo “ecosistema” sin mezclar componentes.

- **Ejercicio 3 — Builder (Fábrica de juguetes)**  
  **Descripción:** Construye objetos complejos paso a paso, separando el proceso de construcción de su representación final.  
  **Por qué se usa:** Un juguete puede tener muchas piezas/opciones; Builder permite **armar configuraciones diferentes** (por ejemplo juguete básico/premium) sin tener constructores enormes ni combinaciones infinitas.

- **Ejercicio 4 — Adapter (Gasolinería inteligente)**  
  **Descripción:** Convierte la interfaz de una clase en otra interfaz que el cliente espera.  
  **Por qué se usa:** Para integrar sistemas/dispositivos con interfaces distintas (sensores, bombas, APIs) sin cambiar el código existente; el Adapter permite **compatibilidad** entre componentes.

- **Ejercicio 5 — Bridge (Figuras y Colores)**  
  **Descripción:** Separa una abstracción de su implementación para que ambas puedan variar independientemente.  
  **Por qué se usa:** Figuras (círculo, cuadrado) y colores (rojo, azul) cambian por separado; Bridge evita una explosión de clases como `CirculoRojo`, `CuadradoAzul`, etc.

- **Ejercicio 6 — Composite (Bodega de productos)**  
  **Descripción:** Trata objetos individuales y composiciones de objetos de manera uniforme (estructura en árbol).  
  **Por qué se usa:** Una bodega puede tener cajas, paquetes y lotes; Composite permite **operar igual** sobre un producto simple o un conjunto (por ejemplo calcular total, listar contenido).

- **Ejercicio 7 — Decorator (Simulador de batalla naval)**  
  **Descripción:** Agrega responsabilidades/funcionalidades a un objeto dinámicamente envolviéndolo con “decoradores”.  
  **Por qué se usa:** Un barco puede tener múltiples mejoras (blindaje, radar, misiles) combinables; Decorator permite **sumar capacidades en runtime** sin crear subclases para cada combinación.

- **Ejercicio 8 — Chain of Responsibility (Control migratorio / Embajada)**  
  **Descripción:** Pasa una solicitud por una cadena de handlers; cada handler decide si procesa o la pasa al siguiente.  
  **Por qué se usa:** El ingreso requiere varios controles (pasaporte, antecedentes, motivo, aprobación); la cadena permite **validaciones en pasos** y detenerse al primer rechazo sin acoplar todo en una sola clase.

- **Ejercicio 9 — Command (Personajes de videojuegos)**  
  **Descripción:** Encapsula una acción como un objeto con un método `execute()`.  
  **Por qué se usa:** El controlador del juego ejecuta acciones (caminar, saltar, atacar, defender) sin conocer detalles internos; Command permite **desacoplar** invocación y ejecución (y facilita colas/historial si se necesitara).

- **Ejercicio 10 — Iterator (Viaje a Roma / diagrama)**  
  **Descripción:** Permite recorrer una colección sin exponer su estructura interna.  
  **Por qué se usa:** Para iterar lugares del itinerario de forma controlada; Iterator ayuda a **separar el recorrido** de la estructura de datos y permite varios recorridos si hiciera falta.

- **Ejercicio 11 — Strategy (Aplicación de navegación)**  
  **Descripción:** Define una familia de algoritmos y los encapsula para poder intercambiarlos en tiempo de ejecución.  
  **Por qué se usa:** La app puede calcular rutas por “más rápida”, “más barata” o “panorámica”; Strategy permite **cambiar el algoritmo** sin modificar la clase principal de la aplicación.

---

## Semana 4
### Qué entendia mal antes?
No sabia bien como deberia de ser la paqueteria de los proyectos

### Qué entiendo mejor ahora?
Ya sé como crear bien proyectos con Maven, entiendo como funciona y para qué es utilizado

### Me falta reforzar
Me falta reforzar los requerimientos



---

## Semana 5
### Qué entendía mal antes?
Pensaba que con solo tener en cuenta cuando se hacian las cosas ere suficiente para poder tener una oganizacion a
la hora de hacer trabajos.

### Qué entiendo ahora?
Ahora entiend que si hacemos una correcta division de lo que se tiene que hacer podemos tener una organizacion y
cumplimiento aun mayor, separandolo por:
- Epica: explicamos a gran escala lo que se quiere con el proyecto
- Feature: Funcionalidades que se quieren tener en el proyecto
- Historias de usuario: El como quiero para poder del proyecto, el cómo nos organizamos para poder hacer lo que planeamos
- tareas: Lo que tenemos que hacer para cumolir con la historia de usuario.

### Qué me falta reforzar?
Entender bien cómo se dividen y cómo se unen las tareas en Jira para
poder asignar bien todo lo que es la dependencia de los trabajos.
