$(document).ready(function(){
    mostrarProductos();

    $('#productos').DataTable();
});

async function mostrarProductos(){
    const request = await fetch('/prductos',{
        method 'GET',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
    }
    });
    const productos = await request.json();
    let listadoHTML = '';

    for (let producto of productos){
        let productoHTML = '<div class="card h-100"><img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." /><div class="card-body p-4"><div class="text-center"><h5 class="fw-bolder">'
        + productos.nombre +'</h5>'
        + productos.precio +'</div></div><div class="card-footer p-4 pt-0 border-top-0 bg-transparent"><div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Añadir al Carrito</a></div></div></div>';

        listadoHTML += productoHTML;


    }
    document.querySelector('#productos div').outerHTML = listadoHTML;
}