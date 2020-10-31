<%-- 
    Document   : escoge-ruta
    Created on : 25-oct-2020, 13:11:40
    Author     : Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Escoger ruta</h1>
        <form action="../Controlador/">
        <p>
            <label>Origen</label>
            <select name="origen">
                <option value="">Seleccione</option>
                <option value="lima">Lima</option>
                <option value="ica">Ica</option>
                <option value="arequipa">Arequipa</option>
                <option value="cusco">Cusco</option>
                <option value="huancato">Huancayo</option>
            </select>
        </p>
        <p>
            <label>Destino</label>
            <select name="destino">
            <option value="">Seleccione</option>
                <option value="lima">Lima</option>
                <option value="ica">Ica</option>
                <option value="arequipa">Arequipa</option>
                <option value="cusco">Cusco</option>
                <option value="huancato">Huancayo</option>
            </select>
        </p>
        <p>
            <input type="hidden" name="accion" value="buscar-ruta">
            <input type="submit" name="submit" value="Buscar">
        </p>
    </form>
    </body>

</html>
