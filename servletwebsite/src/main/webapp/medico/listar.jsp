<%--
  Created by IntelliJ IDEA.
  User: crist
  Date: 12/07/2024
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Site Consultas</title>
</head>
<body>
    <div align="center">
        <h1>Gerenciamento de Medicos</h1>
        <h2>
            <a href="/${requestScope.contextPath}">Menu Principal</a> &nbsp;&nbsp;&nbsp;
            <a href="/${requestScope.contextPath}/medicos/cadastro">Adicione novo Medico</a>
        </h2>
    </div>
    <div align="center">
        <table border="1">
            <caption>Lista de Medicos</caption>
            <tr>
                <th>id</th>
                <th>email</th>
                <th>senha</th>
                <th>crm</th>
                <th>nome</th>
                <th>especialidade</th>
                <th>acoes</th>
            </tr>
            <c:forEach var="medico" items="${requestScope.listaMedicos}">
                <tr>
                    <td>${medico.id}</td>
                    <td>${medico.email}</td>
                    <td>${medico.senha}</td>
                    <td>${medico.crm}</td>
                    <td>${medico.nome}</td>
                    <td>${medico.especialidade}</td>
                    <td>
                        <a href="/${requestScope.contextPath}/medicos/edicao?id=${medico.id}">edicao</a> &nbsp;&nbsp;&nbsp;
                        <a href="/${requestScope.contextPath}/medicos/remocao?id=${medico.id}" onclick="return confirm('Tem certeza de que deseja excluir este item?');"> Remoção </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
