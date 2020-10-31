
function mensaje(e){
    if (confirm("¿Estás seguro que deseas eliminiar el registro?")){
        return true;
    }else{
        return false; //cancela el evento por defecto de ir a la pagina
    }
}