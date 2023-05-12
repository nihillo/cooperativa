### Consideraciones generales
- Para los temas derivados de temporalidad y fechas, se ha considerado para la carga de datos el contexto de un único año fiscal completo.
Es decir, por ejemplo, para el umbral de pequeños a grandes productores se ha establecido un único valor fijo, y para la evolución semanal de precios de productos se han predefinido los correspondientes a cada una de las semanas de un año completo. 

### Productor y producto
- Los distintos productos que gestiona la cooperativa son predefinidos. No se puede registrar un productor que trabaja un producto distinto a los registrados.
- La evolución de precios se maneja en cada producto, mediante de una lista de precios indexada por semana.

### Logística
- El kilometraje de un envío se establece de forma explícita al hacer el pedido. No se guardan tablas de distancias ni se hacen cálculos sobre ellas. Si un pedido necesita dos etapas, una de gran logística y otra de pequeña logística para los km finales, se generan dos envíos de sus respectivos tipos de logística y sus respectivos kilometrajes.

### Cliente

### Pedido
- Un pedido puede tener varias lineas de producto, pero sólo pueden ser de un tipo entre perecederos o no perecederos.
- Un pedido puede tener uno o varios envíos, según si se necesita pequeña logística, gran logística o una combinación de ambas.