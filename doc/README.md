
# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<XX\>/\<YY\>)
Autor: Manuel Triguero Espejo    uvus:mantriesp

El proyecto trata sobre un csv de prestamos, que inicialmente estaba hecho para usarlo para predecir si un prestamo se iba a dar o no, pero le he hecho unas modificaciones para que sea apto para trabajar con el en el proyecto entregable, tales como añadirle una columna tipo LocalDate o transformar algunas columnas int a float.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Esta estructurado en los siguentes paquetes
  * **fp.\<prestamos\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<prestamos\>.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<dataset1.csv\>**: Es un dataset que va sobre prestamos.
    
    
## Estructura del *dataset*

URL: https://www.kaggle.com/datasets/shaijudatascience/loan-prediction-practice-av-competition?resource=download&select=train_csv.csv

El dataset está compuesto por \<13\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo String, representa un identificador único de cada fila
* **\<columna 2>**: de tipo Genero, representa el genero de la persona que pide el prestamo ( MALE o FEMALE)
* **\<columna 3>**: de tipo Integer, representa las personas las cuales tienen dependencia de la persona que pide el prestamo (hijos, etc...)
* **\<columna 4>**: de tipo Boolean, representa si se ha graduado de los estudios basicos o no
* **\<columna 5>**: de tipo Boolean, representa si la persona es autonoma o no
* **\<columna 6>**: de tipo Float, representa el ingreso de la persona que pide el prestamo
* **\<columna 7>**: de tipo Float, representa el ingreso de un coaplicante al prestamo
* **\<columna 8>**: de tipo Integer, representa la cantidad del prestamo en miles de dolares
* **\<columna 9>**: de tipo Integer, representa el plazo que tienen para devolver el prestamo en meses
* **\<columna 10>**: de tipo Boolean, representa si el usuario ha cumplido con el historial crediticeo o no
* **\<columna 11>**: de tipo Area, representa el area en el que reside el aplicante (URBAN, RURAL, SEMIURBAN)
* **\<columna 12>**: de tipo LocalDate, representa el dia el mes y el año en el que fue pedido el prestamo
* **\<columna 13>**: de tipo Boolean, representa si se concedio el prestamo o no

## Tipos implementados

Los tipos que se han implementado son los siguientes:

### Tipo Prestamo
El tipo base consiste en los diferentes atributos de los prestamos, anteriormente mencionados con todos los metodos que pueden tener los mismos

**Propiedades**:

Todas las propiedades de este tipo son consultables y modificables y son:

- String prestamoId
- Genero genero
- Integer dependientes
- Boolean graduado
- Boolean autonomo
- Float ingApl
- Float ingCoapl
- Integer cantidadPrestamos
- Integer plazo
- Boolean histCred
- Area area
- Boolean presAcept

Sus funcionalidades estan explicads en el apartado "estructura del dataset".

**Constructores**: 

- C1: Constructor que posee todas las propiedades básicas
- C2: Constructor que posee todas las propiedades basicas pero  se omiten la fecha de préstamo y el atributo presAcept.

**Restricciones**:
 
- R1: Hace que la fecha de pedir el prestamo no pueda ser mayor a 2010
- R2: Hacer que el ingreso del aplicante no pueda ser menor que 0

**Criterio de igualdad**: El criterio de igualdad se determina por los atributos prestamoId y por fechaPres.

**Criterio de ordenación**: El criterio de ordenacion se determina primero por la fecha del prestamo y despues por los dependientes del usuario.

**Otras operaciones**:
 
-	getIngresoTotal(): se agrega un método getIngresoTotal que devuelve la suma del ingreso del aplicante (ingApl) y el ingreso del coaplicante (ingCoapl).


#### Tipos auxiliares
Por ahora los tipos auxiliares que he tenido que añadir al proyecto han sido 2 tipo enum, para poder definir los atributos area y genero
