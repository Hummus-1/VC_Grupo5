# Funcionamiento 

El fichero **VertexCover.jar** es un ejecutable de la práctica del módulo 2. 

Al ejecutarlo nos encontramos con la siguiente ventana:

![imagen1](img/img1.png)

Para cargar una instancia del problema del 3-SAT, nos dirigimos a 'Archivo/Abrir Archivo'. En la carpeta "examples" podemos encontrar 3 ejemplos del 3-SAT. 

Una vez abierto el fichero, aparecerá en la ventana la definición del problema del 3-SAT, así como, el valor de K y el grafo.

![imagen1](img/img2.png)

# Instancias del 3-SAT

Para crear una instancia del 3-SAT, debemos crear un fichero con la extensión **.sat3**. El fichero deberá contener lo siguiente:

1. El número de literales.
2. El conjunto de literales del problema (un literal por línea).
3. Las cláusulas del problema (una cláusula por línea).

Ejemplo:

```
4
u1
u2
u3
u4
u1 !u3 !u4
!u1 u2 !u4
```

Nota: para negar un literal hacemos uso del símbol `!`.