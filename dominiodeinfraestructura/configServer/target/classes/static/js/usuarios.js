$(document).ready(function(){
    mostrarUsuarios();

    $('#usuarios').DataTable();
});

async function mostrarUsuarios(){
    const request = await fetch('usuarios/',{
        method: 'GET',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
    }
    });

    const usuarios = await request.json();

    let listadoHTML = '';

    for(let usuario of usuarios){
    let usuarioHTML =   "<tr><td>"+usuario.id+
                        "</td><td>"+usuario.nombre+
                        "</td><td>"+usuario.email+
                        "</td><td>"+usuario.ciudad+
                        "</td><td>"+usuario.direccion+
                        "</td><td>"+"</td></tr>"
                        listadoHTML += usuarioHTML;
}

    document.querySelector("#usuarios tbody").outerHTML = listadoHTML;
}
