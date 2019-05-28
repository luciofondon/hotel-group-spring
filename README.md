
## Hotel group

Hotel group es una supuesta cadena hotelera que consta de un conjunto de hoteles y habitaciones.

# Tecnologías empleadas
En el desarrollo del back de la aplicación se ha empleado el framework **Spring Boot** con **Java 8**. 

Por otra parte, se ha configurado diferentes entornos para poder apuntar a las Bases de Datos correspondientes. Además, para la configuración de la bases de datos se ha empleado **Liquibase**. Destacar que en el entorno por defecto (desarrollo) se ha empleado la Bases de Datos embebida (H2).


Por último, la API REST definida con Spring se ha documenta utilizando el framework **Swagger**. 



# Configuración Bases de Datos embebida H2

http://localhost:8080/h2-console

# SWAGGER

http://localhost:8080/swagger-ui.html

# Instalacción

```
mvn install liquibase:update
```

# Aplicar modificaciones Bases de datos

```
mvn  liquibase:update
```