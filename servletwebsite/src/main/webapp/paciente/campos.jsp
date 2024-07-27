<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
    <caption>
        <c:choose>
            <c:when test="${paciente != null}">
                Edição
            </c:when>
            <c:otherwise>
                Cadastro
            </c:otherwise>
        </c:choose>
    </caption>
    <c:if test="${paciente != null}">
        <input type="hidden" name="id" value="${paciente.id}" />
    </c:if>
    <tr>
        <td><label for="email">Email</label></td>
        <td><input type="text" id="email" name="email" size="45"
                   required value="${paciente.email}" /></td>
    </tr>
    <tr>
        <td><label for="senha">Senha</label></td>
        <td><input type="text" id="senha" name="senha" size="45" required
                   value="${paciente.senha}" /></td>
    </tr>
<%--    <tr>--%>
<%--        <td><label for="editora">Editora</label></td>--%>
<%--        <td><select id="editora" name="editora">--%>
<%--            <c:forEach items="${editoras}" var="editora">--%>
<%--                <option value="${editora.key}"--%>
<%--                    ${livro.editora.nome==editora.value ? 'selected' : '' }>--%>
<%--                        ${editora.value}</option>--%>
<%--            </c:forEach>--%>
<%--        </select></td>--%>
<%--    </tr>--%>
    <tr>
        <td><label for="cpf">cpf</label></td>
        <td><input type="text" id="cpf" name="cpf" size="45" required
                   value="${paciente.cpf}" /></td>
    </tr>
    <tr>
        <td><label for="nome">nome</label></td>
        <td><input type="text" id="nome" name="nome" size="45" required
                   value="${paciente.nome}" /></td>
    </tr>
    <tr>
        <td><label for="telefone">telefone</label></td>
        <td><input type="text" id="telefone" name="telefone" size="45"
                   required value="${paciente.telefone}" /></td>
    </tr>
    <tr>
        <td><label for="sexo">sexo</label></td>
        <td><input type="text" id="sexo" name="sexo" size="45"
                   required value="${paciente.sexo}" /></td>
    </tr>
    <tr>
        <td><label for="dataNascimento">dataNascimento</label></td>
        <td><input type="text" id="dataNascimento" name="dataNascimento" size="45"
                   required value="${paciente.dataNascimento}" /></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="Salva" /></td>
    </tr>
</table>