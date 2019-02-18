<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="link" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${link }" method="post">
		Nome: <input type="text" name="nome" />
		Data Abertura: <input type="text" name="data" /> 
		
		<input type="hidden" name="action" value="NovaEmpresa" />
		<input type="submit" value="VAI CAVALO" />
	</form>

</body>
</html>