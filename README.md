# Usuario_Test 
--> gitHub https://github.com/omar-napoleon/usuario_test.git

Usuario, donde se exponen los metodo de la API REST FULL. se uso como lenguaje de desarrollo Java con el framework Spring Boot y como base de datos H2(EL script de la estructura y los datos se encuentra dentro del código fuente en una archivo llamado data.sql). Al levantar el proyecto localmente, se crea y se inicializa la bd con datos de prueba automáticamene.

# SWAGGER (Documentación de la API)
La API cuenta con Swagger como medio de documentación relacionada al funcionamiento y descripción de los métodos expuestos por la API, es decir, muestra todo lo necesario para poder consumir dicha API.
Para acceder al swagger de la API, se debe desplegar el micro servicio de forma local. Luego abrir una ventana con el navegador de su preferencia con la siguiente URL:
•http://localhost:8080/swagger-ui.html#/persons-controller

## Métodos expuestos
Los métodos con los que cuenta la API son los siguientes:

```
•POST http://localhost:8080/persons
``` 
crea una nueva persona

```
•GET http://localhost:8080/persons/{email} 
``` 
Devuelve los datos de la persona si existe








