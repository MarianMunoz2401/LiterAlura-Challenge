LiterAlura - Challenge #Alura

Descripción
LiterAlura es una aplicación que permite a los usuarios interactuar con una base de datos de libros y autores. A través de una serie de opciones, los usuarios pueden consultar información sobre libros, autores, y estadísticas relacionadas con los libros, todo mediante una interfaz de consola en Java.

El proyecto es parte del Challenge #Alura, donde se pusieron en práctica habilidades de manejo de bases de datos, consultas SQL, y programación orientada a objetos en Java.

🌟 Características
Búsqueda de libros por título: Permite buscar libros mediante su nombre.
Listado de todos los libros: Muestra todos los libros disponibles en la base de datos.
Listado de autores: Permite ver todos los autores en la base de datos.
Autores vivos en un año específico: Filtra los autores que están vivos en un año dado.
Estadísticas de libros por idioma: Muestra el número de libros disponibles por idioma.
📋 Tecnologías Utilizadas
Java: Lenguaje de programación principal.
PostgreSQL: Base de datos relacional utilizada para almacenar la información de los libros y autores.
Hibernate: Framework de mapeo objeto-relacional utilizado para interactuar con la base de datos.
Maven: Herramienta de gestión de proyectos para la construcción y manejo de dependencias.
🚀 Instrucciones de Uso
1. Clonar el repositorio
Para comenzar a usar LiterAlura, clona este repositorio en tu máquina local:

bash
Copiar
Editar
git clone https://github.com/MarianMunoz2401/LiterAlura-Challenge.git
2. Configuración del proyecto
Este proyecto usa Maven, así que asegúrate de tenerlo instalado en tu máquina. Si no lo tienes, puedes descargarlo desde aquí.

3. Base de datos
Para que la aplicación funcione correctamente, necesitarás configurar una base de datos PostgreSQL. Asegúrate de tener el siguiente archivo application.properties correctamente configurado:

properties
Copiar
Editar
# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password
Importante: No subas tu contraseña de base de datos ni información sensible al repositorio. Usa variables de entorno o un archivo .env para manejar estos datos de manera segura.

⚙️ Comandos Disponibles
Una vez que hayas configurado la base de datos, ejecuta la aplicación con el siguiente comando:

bash
Copiar
Editar
mvn spring-boot:run
En la terminal aparecerá un menú donde podrás elegir las siguientes opciones:

Buscar libro por título
Listar todos los libros
Listar autores
Listar autores vivos en un año
Mostrar cantidad de libros por idioma
Salir
✨ Ejemplo de Interacción
text
Copiar
Editar
--- LiterAlura ---
1. Buscar libro por título
2. Listar todos los libros
3. Listar autores
4. Listar autores vivos en un año
5. Mostrar cantidad de libros por idioma
0. Salir
Elige una opción: 3
--- LiterAlura ---
1. Buscar libro por título
2. Listar todos los libros
3. Listar autores
4. Listar autores vivos en un año
5. Mostrar cantidad de libros por idioma
0. Salir
🧑‍💻 Contribución
Las contribuciones son bienvenidas. Si tienes alguna idea para mejorar el proyecto o has encontrado un error, por favor abre un issue o envíame un pull request.

Pasos para contribuir:
Haz un fork del repositorio.
Crea tu branch para las nuevas funcionalidades (git checkout -b feature/mi-nueva-funcionalidad).
Realiza tus cambios y haz un commit (git commit -am 'Añadir nueva funcionalidad').
Empuja tus cambios a tu repositorio remoto (git push origin feature/mi-nueva-funcionalidad).
Abre un pull request.
🔒 Licencia
Este proyecto está licenciado bajo la licencia MIT. Para más detalles, consulta el archivo LICENSE.

🤝 Agradecimientos
Gracias a #Alura por proporcionar los recursos y desafíos para seguir aprendiendo y mejorando nuestras habilidades.

