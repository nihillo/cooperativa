### Consideraciones generales
- Para los temas derivados de temporalidad y fechas, se ha considerado para la carga de datos el contexto de un único año fiscal completo.
Es decir, por ejemplo, para el umbral de pequeños a grandes productores se ha establecido un único valor fijo, correspondiente a dicho año fiscal, y para la evolución semanal de precios de productos se han predefinido los correspondientes a cada una de las semanas de un año completo. 
- En relación con el punto anterior, las fechas de creación de elementos (pedidos, etc.) se introducirán manualmente dentro de este plazo de un año fiscal, al tratarse de una simulación en la que no se toma en consideración la fecha actual en que se está ejecutando el sistema.

### Productor y producto
- Los distintos productos que gestiona la cooperativa son predefinidos. No se puede registrar un productor que trabaja un producto distinto a los registrados.
- La evolución de precios se maneja en cada producto, mediante de una lista de precios indexada por semana.
- Se interpreta la limitación de 5 cultivos a pequeños productores como un umbral más a partir del que serán considerados grandes productores. Un productor es considerado gran productor si pasa uno de los dos umbrales, el de superfice o el de número de cultivos (no necesariamente ambos a la vez).
- Se interpreta que un cultivo produce una cantidad de producto anual igual a su extensión multiplicada por el rendimiento por Ha. del producto. El stock inicial de un producto se establece como la suma de las producciones de todos los cultivos de este producto.

### Logística
- Se entiende como logística lo que comúnmente llamamos transportista, es decir, aquella empresa que se dedica al transporte de mercancías. En el sistema los hay de dos tipos, los que hacen envíos a larga distancia (gran logística), y los que lo hacen a pequeña distancia (pequeña logística). 
- Para un pedido puede haber una o dos lineas de envío, dependiendo de si se necesita gran logística, pequeña logística, o una combinación de ambas.
- Todos los envíos tienen como origen las instalaciones centrales de la cooperativa, que hemos localizado arbitrariamente en Albacete. No se tendrán en cuenta en el sistema las localizaciones de los productores ni la posibilidad de envíos desde éstas sin pasar por la central de la cooperativa.
- El cálculo de las líneas de envío necesarias y sus kilometrajes se basa en las siguientes reglas:
    - El envío en gran logística se determina a partir de la provincia de la dirección de envío, leida desde los dos primeros dígitos del código postal, y según tablas de distancias guardadas en los sets de datos de prueba. Sólo se hacen envíos al territorio español peninsular, por lo que no se aceptarán pedidos cuyo destino esté fuera de este territorio.
    - Se calcula la distancia desde la capital de la provincia de destino hasta la localización exacta dividiendo entre 10 el valor numérico de los 3 últimos dígitos del código postal.(Esta lógica claramente no se corresponde con la realidad, pero es una forma de que este dato sea un valor calculado a partir de la dirección de envío, simplificándolo de acuerdo con el alcance y ámbito de este proyecto).
    - Si el resultado es superior a 5km o se ha calculado que no es necesaria una linea de gran logística, se añade una linea de pequeña logística con esta distancia. En cualquier otro caso, se suma esta distancia a la linea de gran logística creada previamente.
- No se establecen diferencias, en cuanto al cálculo de lineas de envío y kilometrajes, para envíos de productos perecederos y no perecederos. Las diferencias entre envíos de tipos de productos radicarán únicamente en el cálculo de sus costes, teniendo tablas de coste por km diferentes para cada uno de ellos.


### Cliente

### Pedido
- Un pedido sólo puede contener un único producto, para evitar la problemática que generaría con los envíos la mezcla de productos perecederos y no perecederos.
- Un pedido puede tener una o varias líneas de envío, según si se necesita pequeña logística, gran logística o una combinación de ambas para poder hacer llegar el envío a destino.
- Se adopta, respecto al requisito referente al plazo de entrega de 10 días y el recálculo de precios si el cliente solicitara un plazo mayor, la siguiente estrategia: siempre se pedirá por defecto al cliente la fecha en que desea la entrega y se establecerá como fecha de formalización del pedido y cálculo de precios la fecha del décimo día anterior a la de entrega. 