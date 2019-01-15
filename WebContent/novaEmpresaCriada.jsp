<%@page import="br.com.gerenciador.modelo.Empresa"%>
<%
	Empresa empresa = (Empresa) request.getAttribute("empresa");
%>


<html>
<body>
	Empresa
	<%=empresa.getNome()%>
	criada com sucesso
</body>
</html>