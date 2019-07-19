# Tarea1MicroServicios
Tarea 1 del curso de microservicios(Separar un monolito y hacerlo micro servicios)


# Tarea 1

El proyecto consta de dos microservicios que realizan un crud completo,
los microservicios son employee y workstation.
Cada microservicios tiene su base de datos con hibernate y se puede acceder a ella
con la ruta http://localhost:9090/employee/h2 o http://localhost:9090/workstation/h2 

# Compilar el proyecto!
Proyecto employee:
  - Descargar el proyecto com.microservicios8.employee en una ruta especifica, para ejecutarlo se realiza de la siguiente manera
  - 
  - Es importante levantar los dos microservicios ya que si uno no se levanta no se podran comunica.
  - El proyecto se compila asi
```sh
$ cd /ruta/com.microservicios8.employee/
$ mvn clean package -DskipTests
```
- El proyecto se ejecuta asi, siempre en la misma ruta donde lo compilaste antes
```sh
$ java -jar target/com.microservicios8.employee-0.0.1-SNAPSHOT.jar
```
Al final se levantara un servidor en el puerto 9090 para el proyecto employee

Proyecto workstation:
  - Descargar el proyecto com.microservicio.workstation en una ruta especifica, para ejecutarlo se realiza de la siguiente manera
  - 
  - Es importante levantar los dos microservicios ya que si uno no se levanta no se podran comunica.
  - El proyecto se compila asi
```sh
$ cd /ruta/com.microservicio.workstation/
$ mvn clean package -DskipTests
```
- El proyecto se ejecuta asi, siempre en la misma ruta donde lo compilaste antes
```sh
$ java -jar target/Acme-HR-System-0.0.1-SNAPSHOT.jar
```
Al final se levantara un servidor en el puerto 9091 para el proyecto workstation

### Uso de los microservicios

Las rutas para el uso de los microservicios son los siguientes.
* [Crea Employee]{Post}- http://localhost/employee/v1/employees/ 
* [Consulta Employee por id]{Get}- http://localhost/employee/v1/employees/{id}
* [Consulta todos los  Employee]{Get}- http://localhost/employee/v1/employees/ 
* [Actualiza un  Employee]{Put}- http://localhost/employee/v1/employees/{id}
* [Borra un  Employee]{Delete}- http://localhost/employee/v1/employees/ 

Se muestra a continuacion una tabla con los parametros que reciben los metodos

| Nombre | Parametros | Response|
| ------ | ------ |-----|
| Crear usuario | [Objeto Employee ][Objeto workstation] | Objeto creado
| Consulta Employee por id | no aplica |Objeto Employee/ Employee no encontrado
| Consulta todos los  Employee| No aplica |Lista de employee
| Actualiza un  Employee | [Objeto Employee ][Objeto workstation] | Objeto actualizado
|Borra un  Employee| No aplica| Objeto borrado

Adiconalmente se puede manipular la info de los workstation con la siguientes paths

* [Crea workstation]{Post}- http://localhost/workstation/v1/workstations
* [Consulta workstation por id]{Get}- http://localhost/workstation/v1/workstations/{id}
* [Consulta todos los  workstation]{Get}- http://localhost/workstation/v1/workstations/ 
* [Actualiza un  workstation]{Put}- http://localhost/workstation/v1/workstations/{id}
* [Borra un  workstation]{Delete}- http://localhost/workstation/v1/workstations/

Se muestra a continuacion una tabla con los parametros que reciben los metodos

| Nombre | Parametros | Response|
| ------ | ------ |-----|
| Crear worksttation | [Objeto workstation] | Objeto creado
| Consulta workstation por id | no aplica |Objeto workstation/ Employee no encontrado
| Consulta todos los  workstation| No aplica |Lista de workstations
| Actualiza un  workstation | [Objeto workstation] | Objeto actualizado
|Borra un  workstation| No aplica| Objeto borrado

