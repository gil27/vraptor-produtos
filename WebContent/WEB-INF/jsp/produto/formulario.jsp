<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo produto</title>
</head>
<body>
	<form action="<c:url value="/produto/adiciona" />" method="post">
		Nome: <input type="text" name="produto.nome" />
        Descrição: <input type="text" name="produto.descricao" />
        Preço: <input type="text" name="produto.preco" />
       <input type="submit" value="Adicionar" />
    </form>
</body>
</html>