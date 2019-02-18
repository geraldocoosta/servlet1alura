<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkNovaEmpresa }" method="post">
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="senha" /> 
		
		<input type="hidden" name="action" value="Login" />
		<input type="submit" value="VAI CAVALO" />
	</form>

</body>
</html>