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
    <h1>Gerenciamento de Pacientes</h1>
    <h2>
        <a href="/${requestScope.contextPath}">Menu Principal</a> &nbsp;&nbsp;&nbsp;
        <a href="/${requestScope.contextPath}/pacientes/cadastro">Adicione novo Paciente</a>
    </h2>
</div>
<div align="center">
    <table border="1">
        <caption>Lista de Paciente</caption>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>senha</th>
            <th>cpf</th>
            <th>nome</th>
            <th>telefone</th>
            <th>sexo</th>
            <th>dataNascimento</th>

        </tr>
        <c:forEach var="paciente" items="${requestScope.listaPacientes}">
            <tr>
                <td>${paciente.id}</td>
                <td>${paciente.email}</td>
                <td>${paciente.senha}</td>
                <td>${paciente.cpf}</td>
                <td>${paciente.nome}</td>
                <td>${paciente.telefone}</td>
                <td>${paciente.sexo}</td>
                <td>${paciente.dataNascimento}</td>

                <td>
                    <a href="/${requestScope.contextPath}/pacientes/edicao?id=${paciente.id}">edicao</a> &nbsp;&nbsp;&nbsp;
                    <a href="/${requestScope.contextPath}/pacientes/remocao?id=${paciente.id}" onclick="return confirm('Tem certeza de que deseja excluir este item?');"> Remoção </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
