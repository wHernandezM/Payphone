# Payphone
TestAutomation

o Descripción general del API utilizado.
  No se pudo ver referencias acerca del API debido a que el enlace proporcionado (https://gorest.co.in/public/v2) estaba caído. Pero se realizó los escenarios solicitados dejando configurado el proyecto para el uso basado en los escenarios propuestos.
o Instrucciones de instalación del framework.
  1. Antes de comenzar se debe tener instalado Java JDK de su preferencia.
  2. Instalar Gradle 7 o superior
  3. El proyecto se generó IntellJ Idea, usarlo de preferencia.  
o Instrucciones para ejecutar las pruebas.
  1. Clonar el proyecto o descargar el zip.
  2. Compilar el código con ./gradlew clean build
  3. Realizar le ejecución con ./gradlew clean test (Previamente ingresar el token en UserApiTasks).
o Instrucciones para generar el reporte.
  El reporte se genera automáticamente después de cada ejecución, se puede encontrar en: target/site/serenity/index.html
o Respuesta a las preguntas planteadas en el punto anterior.

    1. ¿Qué aspectos mejorarías en tu solución si tuvieras más tiempo?
        El uso de tokens, quizas utilizar variables de entorno o inclusive utitlizar algunas herramientas para evitar colocar el token directamente en el código.
        La parametrización de entornos.
        Validaciones adicionales dependiendo de la estructura del API.
        Quizás utilizar un patron de diseño como Screenplay para hacer el proyecto más sostenible.
        Agregar casos de prueba negativos para probar campos vacíos o datos inválidos.
    2. ¿Cómo parametrizarías el test para poder ejecutarlo en distintos ambientes?
        Se pueden utilizar variables dentro del serenity.conf tanto para el url base como para el token. Al momento de ejecutar el proyecto por linea de comandos se especificaría el ambiente.
    3. En caso de manejar datos sensibles para las pruebas ¿cómo lo manejarías?
        Un dato sensible en este caso es el Token, habría que utizarlo dentro de una variable para no codificarlo directamente.Si se utiliza CI se podría utilizar herramientas como Azure Key Vault o AWS Secret Manager para gestionar esta información.
