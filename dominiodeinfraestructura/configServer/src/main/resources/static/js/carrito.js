const productos = [
            { id: L1, nombre: 'Martillo', precio: 25, descripcion: 'Un martillo resistente.', stock: 10 },
            { id: L2, nombre: 'Destornillador', precio: 15, descripcion: 'Un destornillador multiusos.', stock: 20 }
        ];

        const carrito = [];

        function agregarAlCarrito(producto) {
            carrito.push(producto);
            actualizarCarrito();
        }

        function actualizarCarrito() {
            $('#carritoCount').text(carrito.length);
            const carritoLista = $('#carritoLista');
            carritoLista.empty();
            carrito.forEach(producto => {
                carritoLista.append(`<li class="list-group-item">${producto.nombre} - $${producto.precio}</li>`);
            });
        }

        $(document).ready(function() {
            const productosContainer = $('#productos');
            productos.forEach(producto => {
                productosContainer.append(`
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <img src="https://via.placeholder.com/150" class="card-img-top" alt="${producto.nombre}">
                            <div class="card-body">
                                <h5 class="card-title">${producto.nombre}</h5>
                                <p class="card-text">${producto.descripcion}</p>
                                <p class="card-text">$${producto.precio}</p>
                                <button class="btn btn-primary" onclick="agregarAlCarrito(${JSON.stringify(producto)})">Agregar al Carrito</button>
                            </div>
                        </div>
                    </div>
                `);
            });
        });
