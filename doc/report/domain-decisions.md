### Productor
- Los distintos productos que gestiona la coopera son predefinidos. No se puede registrar un productor de un producto que no esté anteriormente definido.
- Las federaciones por producto no se crean en el momento en que dos productores lo deciden. Existen siempre de forma predefinida y los productores pueden asociarse a ellas en cualquier momento (siempre que cumplan los requisitos), lo cual significa que una federación puede no tener ningún productor.
- La evolución de precios se maneja en cada producto, mediante de una lista de precios indexada por fecha.

### Logística
- El kilometraje de un envío se establece de forma explícita al hacer el pedido. No se guardan tablas de distancias ni se hacen cálculos sobre ellas.

### Cliente

### Pedido
- Un pedido puede tener varias lineas de producto, pero sólo pueden ser de un tipo entre perecederos o no perecederos.
- Un pedido puede tener uno o varios envíos, según si se necesita pequeña logística, gran logística o una combinación de ambas.