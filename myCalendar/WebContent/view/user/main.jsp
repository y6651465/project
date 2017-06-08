<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Calendar</title>
<script src="sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css" href="sweetalert.css">
</head>
<body>
	<script>swal("My Calendar 메인");</script>
	<form action="Login" method="post">
		
		<p>${error}</p>
		<table>
			<tr>
				<th colspan="2"><h1>MY CALENDAR 로그인</h1></th>
			</tr>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>PASSWORD</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<br>
					<button>로그인</button>
					<button type="button" onclick="location.href='registerForm'">회원가입</button>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="" >비밀번호를 잊으셨습니까?</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>