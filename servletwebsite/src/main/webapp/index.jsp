<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>

<head>
    <title>Página Inicial</title>
    <meta charset="UTF-8">
</head>

<body>
<h2>Hello World!</h2>
<a href="InterpretarRequests?a=123&b=123">Testa</a><br />
<p></p>
<form name="teste" action="InterpretarRequests" method="POST">
    <fieldset>
        <legend>Formulário de Envio</legend>
        Nome: <input type="text" name="nome" /> <br />
        E-mail: <input type="text" name="email" /> <br />
        Confirmação de e-mail: <input type="text" name="email" /> <br />
        Senha: <input type="password" name="senha" /><br />
        Gênero: <input type="radio" name="genero" value="Masculino" /> Masculino
        <input type="radio" name="genero" value="Feminino" /> Feminino <br />
        Receber notícias: <input type="checkbox" name="receber" value="ok" /><br />
        <input type="hidden" name="teste" value="testando" />
        <input type="submit" name="enviar" value="Enviar" />
    </fieldset>
</form>

<a href="medicos">CRUD medicos</a>

</body>

</html>