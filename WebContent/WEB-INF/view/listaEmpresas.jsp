<%@page import="br.com.gerenciador.modelo.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listando empresas</title>
</head>
<body>

	Usuario Logado: ${usuario.login } - <c:import url="logout-parcial.jsp"/>
	
	<br>
	<ul>
		<c:forEach items="${listaEmpresas }" var="empresa">
			<li>${empresa.nome } - <fmt:formatDate value="${empresa.dataCriacao }" pattern="dd/MM/yyyy"/>
			<a href="<c:url value="entrada?action=RemoveEmpresa&id=${empresa.id }" />"> remover</a>  
			<a href="<c:url value="entrada?action=MostraEmpresa&id=${empresa.id }" />"> edita</a>  
			 </li>
		</c:forEach>

	</ul>
</body>
</html>