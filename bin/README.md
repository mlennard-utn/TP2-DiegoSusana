Clonar el proyecto del siguiente repositorio: https://github.com/mlennard-utn/intermedio_tp

1. Modificar el metodo que genera los items para que los valores sean aleatorios (el valor maximo no debe ser mayor a la cantidad de items).

2. La cantidad de items no debe superar el valor de la constante CANTIDAD_MAXIMA_ITEMS, el metodo 'imprimir' ya posee esa validacion. Implementar el control en los otros dos metodos de BenchmarkService.

2a. La excepcion no debe ser RuntimeException, se debe implementar una nueva excepcion incluyendo el mensaje de validacion tal como esta ahora.

3. El servicio BenchmarkService ya hace los calculos con OperacionStreams.

3a. Implementar las operaciones para las clases OperacionFor y OperacionWhile.

3b. Incluir los calculos de tiempo para esas operaciones en el response de los metodos del servicio.

3c. Si la cantidad de items supera el valor de 100 se debe limitar en la respuesta a los primeros y ultimos 50 valores. 
	OJO! Las operaciones se deben realizar con la cantidad de items requeridos.

4. Los tiempos de ejecucion de las operaciones se deben informar en unidades de segundos (la implementacion actual esta en microsegundos).

5. En el controlador DateController se debe implementar la operacion que devuelva la fecha (en formato dd/MM/yyyy) del ultimo dia del mes del año solicitado.

5a. Controlar y validar que el mes sea un numero entre 1 y 12. De no ser asi se debe devolver un error HTTP 400 indicando que valor se espera para el mes.

Utilizar alguna extension de Google Chrome (buscar Rest Client Chrome Extension) para probar las peticiones HTTP.

FORMA DE ENTREGA: Enviar correo electronico a mlennard-utn@gmail.com con la URL de su repositorio personal con el TP resuelto.
FECHA DE ENTREGA: 27/06
