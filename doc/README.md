
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<2022\>/\<2023\>)
Autor: Manuel Triguero Espejo    uvus:mantriesp

El proyecto trata sobre un csv de prestamos, que inicialmente estaba hecho para usarlo para predecir si un prestamo se iba a dar o no, pero le he hecho unas modificaciones para que sea apto para trabajar con el en el proyecto entregable, tales como añadirle una columna tipo LocalDate o transformar algunas columnas int a float.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Esta estructurado en los siguentes paquetes
  * **fp.\<prestamos\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<prestamos\>.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
* **\<prestamos.csv\>**: Es un dataset que va sobre prestamos.
    
    
## Estructura del *dataset*

URL: https://www.kaggle.com/datasets/shaijudatascience/loan-prediction-practice-av-competition?resource=download&select=train_csv.csv

El dataset está compuesto por \<13\> columnas, con la siguiente descripción:

* **\<prestamoId>**: de tipo String, representa un identificador único de cada fila
* **\<persona>**: de tipo Persona, propiedad auxiliar que proporciona el genero de una persona (MALE o FEMALE) aparte de su nombre y apellidos
* **\<dependientes>**: de tipo Integer, representa las personas las cuales tienen dependencia de la persona que pide el prestamo (hijos, etc...)
* **\<graduado>**: de tipo Boolean, representa si se ha graduado de los estudios basicos o no
* **\<autonomo>**: de tipo Boolean, representa si la persona es autonoma o no
* **\<ingApl>**: de tipo Float, representa el ingreso de la persona que pide el prestamo
* **\<ingCoapl>**: de tipo Float, representa el ingreso de un coaplicante al prestamo
* **\<cantidadPrestamos>**: de tipo Integer, representa la cantidad del prestamo en miles de dolares
* **\<plazo>**: de tipo Integer, representa el plazo que tienen para devolver el prestamo en meses
* **\<histCred>**: de tipo Boolean, representa si el usuario ha cumplido con el historial crediticeo o no
* **\<area>**: de tipo Area, representa el area en el que reside el aplicante (URBAN, RURAL, SEMIURBAN)
* **\<fechaPres>**: de tipo LocalDate, representa el dia el mes y el año en el que fue pedido el prestamo
* **\<listaActivos>**: de tipo List<Integer>, representa los activos del aplicante en este orden: vivienda, coche, segunda vivienda. Si no cuenta con alguno de estos, se señaliza con un 0


## Tipos implementados

Los tipos que se han implementado son los siguientes:

### Tipo Prestamo
El tipo base consiste en los diferentes atributos de los prestamos, anteriormente mencionados con todos los metodos que pueden tener los mismos

**Propiedades**:

Todas las propiedades de este tipo son consultables y modificables y son:

- String prestamoId
- Persona persona
- Integer dependientes
- Boolean graduado
- Boolean autonomo
- Float ingApl
- Float ingCoapl
- Integer cantidadPrestamos
- Integer plazo
- Boolean histCred
- Area area
- LocalDate fechaPres
- List<Integer> listaActivos

Sus funcionalidades estan explicads en el apartado "estructura del dataset".

**Constructores**: 

- C1: Constructor con todas las propiedades básicas
- C2: Constructor que posee todas las propiedades basicas pero  se omiten la fecha de préstamo y el atributo presAcept.

**Restricciones**:
 
- R1: Hacer que el ingreso del aplicante no pueda ser menor que 0

**Criterio de igualdad**: El criterio de igualdad se determina por los atributos prestamoId y por fechaPres.

**Criterio de ordenación**: El criterio de ordenacion se determina primero por la fecha del prestamo y despues por los dependientes del usuario.

**Otras operaciones**:
 
-	getIngresoTotal(): se agrega un método getIngresoTotal que devuelve la suma del ingreso del aplicante (ingApl) y el ingreso del coaplicante (ingCoapl).


#### Tipos auxiliares

**Enums:**

- Area: Es un enumerado añadido para el atributo area, está formado por URBAN, RURAL, SEMIURBAN.

**Clases auxiliares:**

- Persona: Es una clase auxiliar que cuenta con tres atributos(genero, nombre, apellido). Además cuenta con un constructor con todas las propiedades básicas de la clase y sus correspondientes getters y toString.

## Factoría - Prestamos

Clase factoria para construir objetos tipo prestamos

- Prestamos leerPrestamos(String ruta): Crea un objeto de tipo Prestamos a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.

- Prestamo parsearPrestamo(String linea): Parsea el archivo csv para que pueda ser legible por la funcion leerPrestamos

## Tipo Contenedor - Prestamos

Clase contenedora de los objetos tipo prestamo

**Propiedades**:

prestamos, de tipo Set<Prestamo>, consultable y modificable. Lista de prestamos

**Constructores**: 

C1: Constructor por defecto. Crea un objeto de tipo Prestamos sin ninguna partida almacenada.

C2: Constructor que crea un objeto de tipo contenedor con todos los elementos de la colección.

**Criterio de igualdad**:

Dos prestamos son iguales si lo son sus propiedades prestamos.

**Otras Operaciones**:

Cuenta con las operaciones get (Para obtener el valor del objeto en ese momento), set (Para cambiar el valor del objeto en ese momento), add (Para añadir un objeto al Set) y remove (Para quitar un objeto del Set.

Aparte de estas operaciones básicas, cuenta con otras más avanzadas de tratamientos secuenciales, tales como:

-  public boolean existePrestamoParaTodoGraduado(Boolean graduado): Te dice si existe algún prestamo para alguien que este graduado o no, eso lo eliges pasandole el parametro true o false.

- public int contarPrestamosConPlazoMayorOIgualQue(int plazo): Cuenta los prestamos que hay con plazo mayor al int que le pases como parametro.

- public double calcularMediaCantidadPrestamosParaAutonomos(Boolean autonomo): Calcula una media de la cantidad de prestamos que hay para los autonomos o los no autonomos, esto ultimo depende del boolean que le pases como parametro.

- public List<Prestamo> seleccionarPrestamosConIngresosSuperioresA(float ingresos): Selecciona y muestra una lista de los prestamos que tienen un ingreso del aplicante mayor al int que le pases como parametro.

- public Map<Area, Set<Prestamo>> agruparPrestamosPorArea(): Crea un map que ordena los prestamos que existen dependiendo del parametro area, que es un enum y cuenta con los valores: RURAL, URBAN, SEMIURBAN.

	
