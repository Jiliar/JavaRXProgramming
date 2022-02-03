# PROGRAMACIÓN REACTIVA
-	Reactive Programming: Es programar con flujos de datos asíncronos.
-	Flujo de datos (Data Stream): Una secuencia de valores.
-	Modelo de programación basado en el principio push and pull.
-	Los valores se emiten cuando están listos, no cuando se solicitan de una forma no-bloqueante (non-blocking)
-	Se permite ejecutar operaciones en paralelo en lugar de forma serial.
-	Creado por Microsoft por Erik Meijer
-	RX Java es la implementación de ReactiveX.
-	Colección de funciones útiles para hacer programación reactiva.
-	ReactiveX esta implementado en mas de 10 lenguajes
-	RX Java fue escrita por el equipo de Netflix.
### RXJAVA
-	Proyecto Open Source con Licencia Apache
-	Implementación en Java de ReactiveX de Microsoft
-	El API de Netflix la usa para hacer la capa de servicio completamente asíncrona.
-	El objetivo es la JVM no el lenguaje.
### Características:
- Composable: Fácilmente se puede encadenar o combinar.
- Flexible: Se puede usar para emitir:
- Un valor ecalar (Network result)
- Secuencia (Elementos de una lista)
- Flujo infinitos (Sensores de clima)
- Mitiga el callback hell: Fácilmente se puede transformar un flujo asíncrono en otro.

### El fundamento de este concepto procede de los conceptos:
- Thread: Para trabajos de procesos asíncronos.
- Runneable Interface: Para crear instancias de clases independientes usando hilos.
- Callable: es usado para trabajar programación concurrente en Java.
- Executor: Para trabajar con diferentes hilos para definir un pool de Hilos en procesos específicos.

### ESPECIFICACIONES
- ReactiveX
- Project Reactor
  ¿CÓMO PROCESAR LOS DATOS CON LA PROGRAMACIÓN REACTIVA?
  Los tipos de datos que procesa son Streams (Flujos de datos), para operarlos y transformarlos. Existen operadores para operar estos flujos.
### OPERADORES
#### OPERADORES DE CREACIÓN DE OBSERVABLES (Creating Observables):
- Create
- Defer
- Empty/Never/Throw
- From
- Interval
- Just
- Range
- Repeat
- Start
- Timer
#### OPERADORES DE TRANSFORMACIÓN (Transforming Observables):
- Buffer
- FlatMap
- GroupBy
- Map
- Scan
- Window
#### OPERADORES DE FILTRADO (Filtering Operator):
- Debounce
- Distinct
- ElementAt
- Filter
- First
- IgnoreElements
- Last
- Sample
- Skip
- SkipLast
- Take
- TakeLast
#### BENEFICIOS
- Código legible
- Trabajo pensado en operadores
- Evita Callbacks
- Procesos Asíncronos
- Escalabilidad
- Consumo óptimo de recursos.
  SPRING MVC: Esta basado en Servlets, Imperative logic, procesos bloquantes (blocking deps),
  SPRING WEBFLUX: Functional endpoints, EventLoop coccurrency model (reemplaza los Threads), Netty.
  CLASES IMPORTANTES:
- Mono: Para representar un solo elemento en flujo de datos
- Flux: es una colección de Mono.
  RXJAVA: is a Java VM Implementation of Reactive Extensions: a library for composing asynchronous and event-based programs by using observable sequences.

#### PRINCIPÍOS IMPORTANTES: Heroes (The Three O’s)
-	Observable: Es quien empuja los datos hacia el Observer. Es la fuente de flujo de datos(sender).
-	Observer (Observador/Suscriber): Se suscribe (escucha) al Observable y recibe una notificación junto con los datos y luego puede tomar cualquier acción, es decir, los Observers reaccionan a cualquier elemento o secuencia de elementos que emita el Observable. (Escucha los valores emitidos (receiver))  Nota: Muchos Observers pueden suscribirse al mismo Observable
-	Operator (Operador): Puede realizar operación de manipulación, transformación y fusionar diferentes datos.
#### OBSERVABLE OBSERVER PATTERN:
Permite operaciones concurrentes: el Observer no necesita bloquear mientras espera que el Observable emita valores.
El Observer espera a recibir valores cuando el Observable está listo para emitirlos.

####  METODOLOGÍA DE USO DE OBSERVABLES:
1.	Definir un Observer que especifica que hacer con cada valor emitido.
2.	Invocar un método que regrese un Observable.
3.	Suscribirse el Observer al Observable. Esto le dice al Observable que tiene un subscriptor esperando a recibir valores cuando estén disponibles.
