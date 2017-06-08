<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<li>프로필 사진을 등록하세요</li>
		<form method="post" enctype="multipart/form-data" action="Upload" >
			<input type="hidden" name="id" value="${user.id}" />
			<input type="file" name="profilePic" size=40 /><br>
			<button>사진 등록</button>
		</form>
		<c:out value="${user.id}" /><br>
		<c:out value="${user.name}" />
	</div>
</body>
</html>