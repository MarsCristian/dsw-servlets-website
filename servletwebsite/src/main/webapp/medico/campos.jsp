<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table border="1">
    <caption>
        <c:choose>
            <c:when test="${medico != null}">
                Edição
            </c:when>
            <c:otherwise>
                Cadastro
            </c:otherwise>
        </c:choose>
    </caption>
    <c:if test="${medico != null}">
        <input type="hidden" name="id" value="${medico.id}" />
    </c:if>
    <tr>
        <td><label for="email">Email</label></td>
        <td><input type="text" id="email" name="email" size="45"
                   required value="${medico.email}" /></td>
    </tr>
    <tr>
        <td><label for="senha">Senha</label></td>
        <td><input type="text" id="senha" name="senha" size="45" required
                   value="${medico.senha}" /></td>
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
        <td><label for="crm">crm</label></td>
        <td><input type="text" id="crm" name="crm" size="45" required
                   value="${medico.crm}" /></td>
    </tr>
    <tr>
        <td><label for="nome">nome</label></td>
        <td><input type="text" id="nome" name="nome" size="45" required
                   value="${medico.nome}" /></td>
    </tr>
    <tr>
        <td><label for="especialidade">especialidade</label></td>
        <td><input type="text" id="especialidade" name="especialidade" size="45"
                   required value="${medico.especialidade}" /></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="Salva" /></td>
    </tr>
</table>