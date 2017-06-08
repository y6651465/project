<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
		<form action="/myCalendar/friend/servlet/writemessage?userId=${friendwirte}" method="post">
			<ul>
				<li> 받는 사람 <c:out value='${friendwrite}'/>
				<li> 내용을 입력하세요 <br>
					<textarea rows="10" cols="70" name="content">입력하세요</textarea>
			</ul>
			<button>보내기</button> <button type="button" onclick="return ">취소</button>
			</form>
		</div>
	
		
		<div>
			
		</div>	
	</div>
</body>
</html>