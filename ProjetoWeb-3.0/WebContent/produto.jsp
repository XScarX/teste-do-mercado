<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="to.ProdutoTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ProdutoTO to = (ProdutoTO) request.getAttribute("produto");
	%>
	Codigo:
	<%=to.getCodigo()%><br> 
	
	marca:
	<%=to.getMarca()%><br>
	
	modelo:
	<%=to.getModelo()%><br>
	
	Preco de venda:
	<%=to.getPrecoDeVenda()%><br> 
	
	Preco de compra:
	<%=to.getPrecoDeCompra()%><br>
	
	cor:
	<%=to.getCor()%><br>

</body>
</html>