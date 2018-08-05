
1. Modificar el metodo que genera los items para que los valores sean aleatorios (el valor maximo no debe ser mayor a la cantidad de items).
Correcto pero la generacion aleatoria de numeros esta realizando la impresion de los valores penalizando con tiempo la respuesta que tiene que dar.

2. La cantidad de items no debe superar el valor de la constante CANTIDAD_MAXIMA_ITEMS, el metodo 'imprimir' ya posee esa validacion. Implementar el control en los otros dos metodos de BenchmarkService.
La validacion esta en 2 lugares, tanto en el metodo del servicio como el metodo accesorio generador de elementos aleatorios.

2a. La excepcion no debe ser RuntimeException, se debe implementar una nueva excepcion incluyendo el mensaje de validacion tal como esta ahora.
No esta hecho este punto.

3b. Incluir los calculos de tiempo para esas operaciones en el response de los metodos del servicio.

3c. Si la cantidad de items supera el valor de 100 se debe limitar en la respuesta a los primeros y ultimos 50 valores. 
	OJO! Las operaciones se deben realizar con la cantidad de items requeridos.
Este punto no se realizo como se encomendo, se limitaron la cantidad de items tanto para la respuesta como para las operaciones.

4. Los tiempos de ejecucion de las operaciones se deben informar en unidades de segundos (la implementacion actual esta en microsegundos).
Por algun motivo los valores resultado estan siendo redondeados a numeros enteros en vez de a double.

APROBADO, nota final: 7
