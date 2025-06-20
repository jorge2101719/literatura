Desafío para trabajar desde el lado de la consola, que cumple los cinco puntos básico solicidados.

El programa hace consultas a la API Gutendex en donde se hacen búsquedas por nombre o título de un libro, como puede ser "Don Quijote", "Niebla", "Moby Dick" u otros.

Las informaciones que decidí almacenar (además del título) son: nombre del autor(es), idioma(s), años de nacimiento y muerte del autor.

Al ejecutar el programa se desplegará un menu con ocho (8) puntos. (La información de los paréntesis, solo aparece en este archivo como detalle).

1. Buscar libro por título (comprueba si el título está en la api; de ser cierto, comprueba la base de datos y si no lo encuentra en ésta, lo agrega)
2. Listar libros registrados (muestra los libros almacenados en el repositorio)
3. Listar autores registrados (muestra los autores en el repositorio)
4. Listar autores vivos en un determinado año (se pide el ingreso de un año, v.g. 1800, 1900,... y muestra los autores que vivián en ese momento; en los casos en que no aparece la fecha de nacimiento, se verá un -1 y de ocurrir algo similar con la fecha de fallecimiento, se mostrará el valor 5000)
5. Listar libros por idioma (después de seleccionar esta alternativa, despliega otro menu para seleccionar el idioma, y traer el (los) libro(s) respectivo(s); de no encontrarse en la lista, debe aparece 'desconocido')

Hasta aquí los mínimos solicitados. Además incluyo las siguientes alternativas:

6. Buscar un libro en la base de datos (busca un libro específico en el repositorio y muestra la información si lo encuentra o un mensaje alternativo)
7. Buscar un autor (busca un autor específico, o bien un mensaje en caso de no encontrarlo)
8. Buscar los cinco libros (top 5) más descargados (el método consulta toda la base, eliminando posibles datos con null; ordena descendentemente y muestra el título, número de descarga y autor)

y por último, pero no menos importante, la opción 0, para salir

