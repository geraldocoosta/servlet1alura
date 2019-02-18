<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkAlteraEmpresa" />
<fmt:formatDate value="${empresa.dataCriacao }" pattern="dd/MM/yyyy"
	var="dataFormatada" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkAlteraEmpresa }" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome }" /> Data
		Abertura: <input type="text" name="data" value=${dataFormatada } /> <input
			type="hidden" name=id value=${empresa.id }> <input
			type="hidden" name=action value="AlteraEmpresa"> <input
			type="submit" value="VAI CAVALO" />
	</form>

</body>
</html>