# Apuntes de Curso – Desarrollo de Software (DOSW 201)

Registro personal de los temas, conceptos y prácticas cubiertos durante el curso **DOSW 201**, organizado de manera cronológica por semanas.

---

## Índice de Contenidos

- Semana 1 – Control de Versiones, Paradigma Funcional y Colecciones en Java
- Semana 2 – Patrones de Diseño de Software y Gestión de Proyectos
- Semana 3 – Requerimientos del Sistema, Modelado UML y Diseño de Experiencia
- Semana 4 – Usabilidad Web, Identidad de Marca y Estándares Visuales
- Semana 5 – Metodologías Ágiles y Framework Scrum

---

# Semana 1 – Control de Versiones, Paradigma Funcional y Colecciones

En esta primera semana exploramos los fundamentos de **Git** como sistema de control de versiones, los principios de la **programación funcional aplicada en Java** y las principales **estructuras de datos** del lenguaje.

---

## Git – Control de Versiones Distribuido

Git es una herramienta que registra el historial de cambios de un proyecto y facilita el trabajo colaborativo entre varios desarrolladores de forma simultánea.

### Arquitectura interna de Git

El sistema se divide en tres áreas clave:

**Directorio `.git`**  
Núcleo del sistema. Aquí se almacena todo el historial, los metadatos y la base de datos interna de objetos del proyecto.

**Directorio de trabajo**  
Representa el estado actual del proyecto en el disco del desarrollador. Es el espacio donde se crean, editan y eliminan archivos.

**Área de preparación (Staging)**  
Zona intermedia donde se seleccionan los cambios que formarán parte del próximo `commit`. Actúa como un filtro antes de guardar en el historial.

---

### Referencia de comandos Git

#### Iniciar o clonar un proyecto

| Comando | Función |
|---|---|
| `git init` | Crea un nuevo repositorio en el directorio actual |
| `git clone URL` | Descarga una copia de un repositorio remoto |

#### Registrar y sincronizar cambios

| Comando | Función |
|---|---|
| `git status` | Consulta el estado de los archivos en el proyecto |
| `git add .` | Envía todos los cambios al área de staging |
| `git add <archivo>` | Agrega únicamente un archivo específico |
| `git commit -m "msg"` | Crea un punto de guardado con los cambios preparados |
| `git push` | Publica los commits en el repositorio remoto |
| `git pull` | Trae los cambios remotos e integra con la copia local |

#### Gestión de ramas

| Comando | Función |
|---|---|
| `git branch` | Lista las ramas existentes |
| `git branch <nombre>` | Crea una rama nueva |
| `git branch -d <nombre>` | Borra una rama |
| `git checkout <rama>` | Cambia a una rama existente |
| `git checkout -b <rama>` | Crea y cambia a una nueva rama |

#### Integración de historial

| Comando | Función |
|---|---|
| `git merge <rama>` | Combina los cambios de otra rama en la actual |
| `git rebase` | Reescribe el historial para mantenerlo lineal |

#### Comandos adicionales

| Comando | Función |
|---|---|
| `git log` | Muestra el historial completo de commits |
| `git log --oneline` | Versión resumida del historial |
| `git diff` | Visualiza las diferencias entre versiones |
| `git stash` | Almacena temporalmente cambios sin commitear |
| `git stash pop` | Recupera los cambios guardados con stash |
| `git fetch` | Descarga cambios remotos sin aplicarlos |

---

### Git Flow – Estrategia de Ramas

Git Flow es un modelo de trabajo que define cómo organizar las ramas de un proyecto para facilitar el desarrollo, las pruebas y los lanzamientos.

**`main`** → Contiene el código de producción, siempre estable.

**`develop`** → Rama de integración donde confluyen los desarrollos antes de publicarlos.

**`feature/...`** → Ramas para desarrollar funcionalidades nuevas de forma aislada.  
_Ejemplo: `feature/carrito-compras`, `feature/notificaciones`_

**`release/...`** → Se usa para preparar y ajustar una nueva versión antes de publicarla.

**`hotfix/...`** → Correcciones urgentes aplicadas directamente sobre producción.

---

## Programación Funcional en Java

La programación funcional es un paradigma donde los programas se construyen mediante la **composición de funciones puras**, evitando estados mutables y efectos secundarios.

### Principios fundamentales

**Funciones puras**  
Una función es pura si:
- Devuelve el mismo resultado para los mismos argumentos, siempre.
- No produce efectos fuera de su alcance (no modifica variables externas, no hace I/O, etc.).

```java
int multiplicar(int x, int y) {
    return x * y;
}
```

**Inmutabilidad**  
Los datos no deben modificarse una vez creados. Esto simplifica las pruebas, mejora la legibilidad y evita errores en ambientes concurrentes.

**Funciones de orden superior**  
Funciones que aceptan otras funciones como argumento o las devuelven como resultado.

**Composición**  
Encadenar funciones de modo que la salida de una sea la entrada de la siguiente.

**Estilo declarativo**  
Se describe *qué* se quiere obtener, no *cómo* calcularlo paso a paso.

```java
lista.stream()
     .filter(x -> x % 2 == 0)
     .map(x -> x * 3)
     .collect(Collectors.toList());
```

---

### Expresiones Lambda

Representación compacta de una función anónima, asociada al método abstracto de una interfaz funcional.

```
(parámetros) -> cuerpo
```

```java
Comparator<String> comp = (a, b) -> a.compareTo(b);
```

---

### API de Streams

Permite encadenar operaciones sobre colecciones de datos de forma funcional y legible.

**Operaciones intermedias** (perezosas, no ejecutan hasta que hay una terminal):

| Operación | Efecto |
|---|---|
| `map()` | Aplica una transformación a cada elemento |
| `filter()` | Retiene solo los elementos que cumplen la condición |
| `sorted()` | Ordena los elementos |
| `distinct()` | Elimina valores duplicados |
| `limit(n)` | Toma solo los primeros `n` elementos |
| `skip(n)` | Omite los primeros `n` elementos |

**Operaciones terminales** (disparan la ejecución del pipeline):

| Operación | Efecto |
|---|---|
| `forEach()` | Ejecuta una acción para cada elemento |
| `collect()` | Materializa el stream en una colección |
| `reduce()` | Reduce todos los elementos a un único valor |
| `min()` / `max()` | Obtiene el menor o mayor elemento |
| `anyMatch()` / `allMatch()` | Verifica condiciones sobre los elementos |

---

## Estructuras de Datos en Java

### Array vs ArrayList

| | Array | ArrayList |
|---|---|---|
| Tamaño | Fijo al declararse | Crece dinámicamente |
| Tipos | Primitivos y objetos | Solo objetos (autoboxing) |
| Acceso | Por índice `[]` | Por métodos |
| Velocidad | Muy alto | Algo menor, más flexible |

```java
// Array
String[] colores = {"rojo", "verde", "azul"};

// ArrayList
ArrayList<String> colores = new ArrayList<>();
colores.add("rojo");
```

---

### HashMap vs Hashtable

| | HashMap | Hashtable |
|---|---|---|
| Hilo seguro | No | Sí (sincronizado) |
| Acepta `null` | Clave y valor | No acepta |
| Rendimiento | Mayor | Menor por sincronización |

> En la práctica moderna se prefiere `HashMap` o `ConcurrentHashMap`.

---

### HashSet vs TreeSet

| | HashSet | TreeSet |
|---|---|---|
| Mantiene orden | No | Sí (orden natural o comparator) |
| Implementación interna | Tabla hash | Árbol rojo-negro |
| Complejidad de operaciones | O(1) | O(log n) |

---

### String vs StringBuilder vs StringBuffer

| Tipo | Mutabilidad | Hilos seguros |
|---|---|---|
| `String` | Inmutable | Sí (no hace falta) |
| `StringBuilder` | Mutable | No |
| `StringBuffer` | Mutable | Sí (sincronizado) |

---

# Semana 2 – Patrones de Diseño y Gestión con Maven

Durante esta semana se trabajaron los **patrones de diseño creacionales, estructurales y de comportamiento**, además de introducir Maven como herramienta para la administración de proyectos Java.

---

## Maven

Herramienta de construcción y gestión de proyectos Java basada en convenciones. Automatiza la compilación, las pruebas y el manejo de dependencias externas.

### Campos clave del `pom.xml`

| Campo | Descripción |
|---|---|
| `groupId` | Identificador del grupo u organización |
| `artifactId` | Nombre del módulo o proyecto |
| `version` | Versión actual del artefacto |
| `dependencies` | Declaración de librerías externas necesarias |

---

## Diagramación de Software

La diagramación es la representación visual de la arquitectura y estructura del sistema. Sirve para comunicar decisiones de diseño, planificar la implementación y facilitar el trabajo en equipo.

---

## Categorías de Patrones de Diseño

| Categoría | Propósito |
|---|---|
| Creacionales | Controlan la forma en que se instancian los objetos |
| Estructurales | Definen cómo se componen y relacionan las clases |
| Comportamiento | Regulan la comunicación y responsabilidades entre objetos |

---

## Patrones Creacionales

### Factory Method

Proporciona una interfaz para crear objetos en una clase base, dejando que las subclases determinen el tipo concreto a instanciar.

**Beneficios:** reduce acoplamiento, facilita extensión (cumple el principio abierto/cerrado), mejora la mantenibilidad.

**Pasos de implementación:**
1. Definir una interfaz para el producto.
2. La clase base declara el método fábrica.
3. Las subclases concretas implementan el método y devuelven el producto específico.

---

### Abstract Factory

Permite crear familias de objetos relacionados entre sí sin depender de sus implementaciones concretas.

**Beneficios:** garantiza compatibilidad entre productos de una familia, bajo acoplamiento con el cliente, fácil escalabilidad.

**Pasos de implementación:**
1. Declarar interfaces abstractas para cada tipo de producto.
2. Crear implementaciones concretas de cada producto.
3. Definir la fábrica abstracta con un método por cada tipo de producto.
4. Implementar fábricas concretas para cada familia de productos.

---

### Builder

Permite construir objetos complejos de forma incremental, separando la lógica de construcción de la representación final.

**Beneficios:** evita constructores con demasiados parámetros, permite crear distintas representaciones del mismo objeto, código más claro y mantenible.

**Roles:**
- **Builder**: declara los pasos de construcción.
- **Builder Concreto**: implementa cada paso.
- **Director**: coordina el orden de los pasos.
- **Producto**: el objeto resultante.

---

## Patrones Estructurales

### Adapter

Hace compatibles dos interfaces que originalmente no lo son, actuando como intermediario entre ellas.

**Beneficios:** permite reutilizar código existente, facilita integración con bibliotecas externas, reduce acoplamiento.

**Roles:** Cliente, Interfaz objetivo, Servicio incompatible, Adaptador.

---

### Bridge

Desacopla una abstracción de su implementación dividiéndolas en jerarquías independientes que pueden evolucionar por separado.

**Beneficios:** bajo acoplamiento, mayor flexibilidad para extender ambas jerarquías, mejor mantenibilidad.

---

### Composite

Organiza objetos en estructuras de árbol para tratar elementos individuales y compuestos de forma uniforme.

**Roles:**
- **Component**: interfaz que comparten hojas y contenedores.
- **Leaf**: elemento sin hijos.
- **Composite**: elemento que puede contener otros components.

**Beneficios:** simplifica el código del cliente, facilita trabajar con estructuras recursivas.

---

### Decorator

Añade responsabilidades adicionales a un objeto de manera dinámica, como alternativa flexible a la herencia.

**Beneficios:** permite combinar comportamientos en tiempo de ejecución, evita la explosión de subclases.

**Roles:** Componente (interfaz), Componente Concreto, Decorador Base, Decoradores Concretos.

---

## Patrones de Comportamiento

### Chain of Responsibility

Conecta una serie de manejadores en cadena. Cada uno puede procesar la solicitud o delegarla al siguiente.

**Beneficios:** desacoplamiento entre emisor y receptores, orden de procesamiento configurable.

---

### Command

Encapsula una solicitud como un objeto, lo que permite parametrizarla, encolarse, deshacerse o ejecutarla remotamente.

**Roles:** Command (interfaz), Comando Concreto, Receptor, Invocador, Cliente.

---

### Iterator

Provee una forma de recorrer los elementos de una colección sin exponer su estructura interna.

**Beneficios:** encapsula el algoritmo de recorrido, permite múltiples iteradores en paralelo.

---

### Strategy

Define una familia de algoritmos intercambiables y permite cambiar el que se usa en tiempo de ejecución.

**Beneficios:** elimina condicionales extensos, desacopla la lógica del algoritmo del contexto que lo usa.

---

## Ejercicios Prácticos de la Semana

- **Factory Method**: sistema de pagos con soporte para tarjeta de crédito, PayPal y transferencia bancaria.
- **Abstract Factory**: motor de videojuego multiplataforma (PlayStation y Xbox).
- **Builder**: configurador de personajes con distintos atributos.
- **Adapter**: estación de gasolina integrada con cargadores eléctricos de interfaz diferente.
- **Bridge**: formas geométricas independizadas de la jerarquía de colores.
- **Composite**: bodega con productos individuales y cajas que pueden contener otros productos o cajas.

---

# Semana 3 – Requerimientos, UML y Experiencia de Usuario

---

## Análisis de Requerimientos

### Definición

Un requerimiento es una condición o funcionalidad que el sistema debe satisfacer para cumplir con las necesidades del cliente o del negocio.

Todo buen requerimiento debe ser: claro, no ambiguo, medible, verificable y coherente con los demás.

---

### Tipos de Requerimientos

**Funcionales**  
Especifican qué debe *hacer* el sistema.

> El sistema debe permitir registrar nuevos usuarios.  
> El sistema debe generar reportes mensuales de ventas.

**No funcionales**  
Describen *cómo* debe comportarse el sistema.

> El tiempo de respuesta no debe superar los 3 segundos.  
> El sistema debe soportar 500 usuarios concurrentes.

---

### Técnicas para Recolectar Requerimientos

- Entrevistas con stakeholders
- Encuestas y cuestionarios
- Talleres de trabajo (workshops)
- Observación directa del proceso

---

### Proceso de Análisis

1. Identificar requerimientos a alto nivel.
2. Detallar cada uno con criterios concretos.
3. Agruparlos por módulo o funcionalidad.
4. Clasificar en funcionales y no funcionales.
5. Detectar contradicciones o ambigüedades.
6. Construir la matriz de trazabilidad.

---

### Estructura de un Requerimiento

Cada requerimiento documentado debe incluir:

- Código único (ej: `RF-001`, `RNF-002`)
- Nombre descriptivo
- Descripción del comportamiento esperado
- Actor que interactúa
- Precondiciones necesarias
- Datos de entrada y salida
- Flujo principal y flujos alternos (errores)
- Reglas de negocio relacionadas

---

### Reglas de Negocio

Restricciones propias del dominio del cliente, independientes del software.

> Un cliente no puede tener más de dos créditos activos simultáneamente.

---

### Matriz de Trazabilidad

Documento que vincula cada requerimiento con su estado, responsables y prioridad. Permite hacer seguimiento durante todo el ciclo de desarrollo.

Campos típicos: ID, nombre, responsable del cliente, prioridad, estado actual, equipo técnico asignado.

---

## Diagrama de Casos de Uso (UML)

Diagrama de comportamiento que ilustra las interacciones entre actores externos y el sistema.

### Elementos

- Actor (usuario o sistema externo)
- Caso de uso (funcionalidad del sistema)
- Límite del sistema
- Paquete (agrupación lógica)

### Tipos de relación

- `<<include>>` → funcionalidad siempre requerida por otro caso de uso.
- `<<extend>>` → funcionalidad opcional que amplía un caso de uso base.

> Regla general: cada requerimiento funcional debe tener al menos un caso de uso correspondiente.

---

## Modelo C4 – Diagrama de Contexto (Nivel 1)

Representa el sistema dentro de su entorno, mostrando:

- El sistema principal
- Los actores que interactúan con él
- Los sistemas externos conectados
- Los límites del sistema

Sirve como punto de entrada para comunicar la arquitectura a cualquier audiencia.

---

## UX vs UI

| | UX (Experiencia de Usuario) | UI (Interfaz de Usuario) |
|---|---|---|
| Enfoque | Cómo se siente y funciona el producto | Cómo se ve visualmente |
| Componentes | Usabilidad, flujos, satisfacción | Colores, tipografía, íconos |
| Pregunta clave | ¿Es fácil de usar? | ¿Se ve bien? |

---

## Prototipos y Mockups

**Prototipo**: representación funcional (o semi-funcional) del sistema para validar requerimientos antes de desarrollar.

**Mockup**: boceto visual de alta fidelidad que representa la interfaz sin funcionalidad real. Incluye pantallas, botones, navegación y llamadas a la acción.

---

## Flujo Funcional

Esquema que representa la secuencia de pantallas y acciones que sigue el usuario para completar una tarea. Contempla éxitos, errores y decisiones intermedias.

---

## Las 10 Heurísticas de Nielsen

Principios de usabilidad definidos por Jakob Nielsen en 1995, usados para evaluar y mejorar interfaces:

1. Visibilidad del estado del sistema
2. Relación entre el sistema y el mundo real
3. Control y libertad del usuario
4. Consistencia y estándares
5. Prevención de errores
6. Reconocimiento antes que memorización
7. Flexibilidad y eficiencia de uso
8. Diseño estético y minimalista
9. Ayuda al usuario a reconocer y recuperarse de errores
10. Ayuda y documentación

---

## Leyes de UX

Conjunto de principios y patrones psicológicos aplicados al diseño de interfaces para crear experiencias más intuitivas y eficientes.

---

# Semana 4 – Usabilidad, Branding y Guías de Estilo

---

## Usabilidad Web

### ¿Qué es?

La usabilidad es la capacidad de un sistema digital para ser utilizado de manera eficiente, efectiva y satisfactoria por sus usuarios objetivo.

Evalúa la interacción entre:
- Navegación y estructura del contenido
- Funcionalidades disponibles
- Experiencia percibida por el usuario

---

### Errores Frecuentes de Usabilidad

1. Diseño inconsistente entre secciones.
2. Ausencia de diseño responsive para dispositivos móviles.
3. Arquitectura de contenidos confusa o mal jerarquizada.
4. Excesiva cantidad de pasos para completar acciones básicas.
5. Tipografías ilegibles o de bajo contraste.
6. Mala gestión de enlaces internos y externos.
7. Formularios mal diseñados: campos innecesarios, sin ejemplos ni validaciones claras.
8. Buscador interno poco efectivo.
9. URLs no descriptivas y falta de favicon.
10. Dificultad para regresar a la página principal.
11. Imágenes sin atributos `alt` descriptivos.
12. Velocidad de carga lenta y falta de accesibilidad.

---

## Manual de Identidad de Marca

Documento que establece los lineamientos para comunicar la marca de forma coherente en todos sus canales.

### Contenido típico

- Presentación de la marca (misión, visión, valores)
- Nombre oficial y eslogan
- Definición del público objetivo
- Paleta de colores corporativos
- Sistema tipográfico
- Uso correcto de imágenes y fotografía
- Elementos gráficos (botones, íconos, composiciones visuales)

---

## Benchmarking Visual

Análisis sistemático de competidores o referentes para identificar buenas prácticas, tendencias visuales y oportunidades de diferenciación.

Su propósito es incorporar estrategias exitosas adaptadas al propio producto o marca.

---

## Guía de Estilo

Documento de referencia que define las reglas visuales y de comunicación para mantener coherencia en la identidad de la marca.

Abarca:
- Paleta de colores y sus aplicaciones
- Jerarquía tipográfica
- Uso de íconos e ilustraciones
- Tono y voz de la comunicación
- Componentes UI reutilizables

---

## UX Writing

Disciplina que se encarga de los textos dentro de productos digitales con el objetivo de guiar al usuario de forma clara y directa.

Incluye:
- Mensajes de error y confirmación
- Etiquetas de botones y CTA
- Textos de onboarding e instrucciones
- Microcopys (textos breves de apoyo)

---

# Semana 5 – Agilismo y Scrum

---

## Modelos de Desarrollo de Software

### Modelo Waterfall (Cascada)

Enfoque tradicional y secuencial donde cada fase del proyecto (análisis, diseño, desarrollo, pruebas, despliegue) debe completarse antes de comenzar la siguiente.

Indicado cuando: los requerimientos son estables, el resultado es predecible y los cambios son poco probables.

---

## Metodologías Ágiles

Enfoques de desarrollo que trabajan en ciclos iterativos e incrementales, con énfasis en la entrega de valor frecuente y la adaptación al cambio.

Características principales:
- Iteraciones cortas
- Entrega continua e incremental
- Colaboración estrecha con el cliente
- Respuesta rápida ante cambios
- Reducción de riesgos mediante retroalimentación temprana

---

## Manifiesto Ágil (2001)

Declaración de principios formulada por un grupo de profesionales de software como alternativa a los métodos pesados y rígidos.

Define **4 valores fundamentales** y **12 principios** que priorizan la flexibilidad, la colaboración y la entrega de valor sobre la documentación exhaustiva y la adherencia estricta a planes.

---

## Scrum

Framework ágil orientado a entregar valor de forma adaptativa en entornos complejos. Se fundamenta en el **empirismo**: las decisiones se toman a partir de lo que se observa y aprende durante el proceso.

---

### Pilares de Scrum

1. **Transparencia** – toda información relevante es visible para el equipo.
2. **Inspección** – el progreso se revisa regularmente.
3. **Adaptación** – el proceso se ajusta según lo inspeccionado.

---

### Valores de Scrum

Compromiso · Coraje · Enfoque · Respeto · Apertura

---

## Roles en Scrum

### Scrum Master
Responsable de que el equipo comprenda y aplique Scrum correctamente. Facilita las ceremonias, elimina impedimentos y protege al equipo de interrupciones externas.

### Product Owner
Voz del cliente dentro del equipo. Prioriza el backlog y define qué se construye primero para maximizar el valor del producto.

### Scrum Team (Equipo de Desarrollo)
Equipo multifuncional y autoorganizado (entre 3 y 9 personas) que ejecuta el trabajo técnico y entrega valor en cada sprint.

---

## Artefactos de Scrum

**Product Backlog**  
Lista ordenada por prioridad de todo lo que el producto podría necesitar. Es gestionado por el Product Owner.

**Sprint Backlog**  
Subconjunto del Product Backlog comprometido por el equipo para completar durante el sprint en curso.

**Incremento**  
Producto funcional y potencialmente entregable al final de cada sprint.

---

## Ceremonias de Scrum

| Ceremonia | Propósito |
|---|---|
| Sprint Planning | Planificar el trabajo del sprint |
| Daily Scrum | Sincronización diaria del equipo (máx. 15 min) |
| Sprint Review | Demostrar el incremento a los stakeholders |
| Sprint Retrospective | Reflexionar y mejorar el proceso del equipo |

---

## Herramientas de Gestión Ágil

- **Jira** – gestión de proyectos y seguimiento de issues.
- **Azure Boards** – tableros ágiles integrados en el ecosistema Microsoft.
- **GitLab** – gestión de código y CI/CD con soporte para tableros ágiles.

---

## Atributos de Calidad del Software

Criterios que permiten evaluar y garantizar la calidad de un sistema:

Funcionalidad · Rendimiento (Performance) · Compatibilidad · Usabilidad · Fiabilidad · Seguridad · Mantenibilidad · Portabilidad

---

## Jerarquía del Trabajo en Agile

### Épica
Iniciativa estratégica de gran alcance. Se divide en features.

### Feature
Funcionalidad concreta que aporta valor al usuario. Se descompone en historias de usuario.

### Historia de Usuario
Unidad de trabajo centrada en el usuario. Se escribe siguiendo el formato:

> **Como** [tipo de usuario], **quiero** [acción o funcionalidad], **para** [beneficio o valor obtenido].

Incluye criterios de aceptación que definen cuándo la historia se considera completada.

### Tarea
Acción técnica específica necesaria para completar una historia de usuario.

---

## Estimación en Scrum

Proceso colaborativo para asignar un valor de esfuerzo relativo a historias o tareas, usando **puntos de historia**.

### Planning Poker

Técnica de estimación en grupo donde cada integrante vota de forma simultánea usando la secuencia de Fibonacci:

> 0 · 1 · 2 · 3 · 5 · 8 · 13 · 21 · ?

Las diferencias en las estimaciones se discuten hasta alcanzar consenso, lo que mejora la calidad del estimado y el entendimiento compartido del trabajo.