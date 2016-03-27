<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="to.ClienteTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ClienteTO to = (ClienteTO) request.getAttribute("cliente");
	%>
	Id:
	<%=to.getId()%><br> 
	Nome:
	<%=to.getNome()%><br> 
	Fone:
	<%=to.getTelefone()%><br>
	Endereço:
	<%=to.getEndereco()%><br>
	Nascimento:
	<%=to.getNasc() %><br>
	
</body>
</html>