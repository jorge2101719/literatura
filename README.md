Desafío para trabajar desde el lado de la consola, que cumple los cinco puntos básico solicidados.

El programa hace consultas a la API Gutendex en donde se hacen búsquedas por nombre o título de un libro, como puede ser "Don Quijote", "Niebla", "Moby Dick" u otros.

La información que dedidí almacenar son (además del título): nombre del autor(es), idioma(s), años de nacimiento y muerte del autor, y como extra el número de descargas, omitiendo las demás para no hacer muy extensa la información expuesta.

Al ejecutar el programa se desplegará el siguiente menu:

1. Buscar libro por título (comprueba si el título está en la api; de ser cierto, comprueba la base de datos y si no lo encentra en esta, lo agrega)
2. Listar libros registrados (muestra los libros almacenados en el repositorio)
3. Listar autores registrados (muestra los autores en el repositorio)
4. Listar autores vivos en un determinado año (se pide el ingreso de un año, v.~g. 1800, 1900,... y muestra los autores que vivián en ese momento)
5. Listar libros por idioma (después de seleccionar esta alternativa, despliega otro menu para seleccionar el idioma, y trar el libro respectivo)

Hasta aquí los mínimos solicitados. Además incluyo un par de alternativas más, a saber:

6. Buscar libro en la base de datos (busca el libro en el repositorio y muestra la información si lo encuentra o un mensaje alternativo)
7. Buscar un autor (busca el autor o algún mensaje en caso de no encontrarlo)

y 0. Salir

