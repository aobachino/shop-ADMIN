<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h4{
		text-align:center;
	}

</style>
<link rel="stylesheet" type="text/css" href="shop.css">
<meta charset="UTF-8">
<title>ユーザーログイン</title>
</head>
<body>
	<h4><c:out value="${logoutStatus}" /></h4>
	<h4>★管理者用ログイン★</h4>
	<div class="ppp">
		<h4><c:out value="${loginnot}" /></h4>
	</div>
	<form action="loginStaff.html" method="POST" id="loginForm">
	<table class="ppp" border="1">
		<tr >
			<th class="form">ログインID</th>
			<td><input type="text" name= "id" placeholder="ログインID"><form:errors cssClass="error" path="loginModel.memNum" /><p class="error"><c:out value="${error}" /></td>
		</tr>
		<tr >
			<th class="form">パスワード</th>
			<td><input type="password" name="pass" placeholder="パスワード"><form:errors cssClass="error" path="loginModel.pass" /><p class="error"><c:out value="${error}" /></td>
		</tr>

	</table>
	<div class="ppp">
		<input type="submit" value="ログイン"> <input type="reset" value="クリア"> 
	</div>
	</form>
</body>
</html>