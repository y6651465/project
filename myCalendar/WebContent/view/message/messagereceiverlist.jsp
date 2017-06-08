<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
    border-collapse: collapse;
    width: 50%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>
<body>
	<div>
		<div><h1>받은 쪽지함</h1>
			<table>
				<tr>
					<th>보낸사람</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
				<c:forEach var="messagelist" items="${listmessage }"> 
				<tr>
				<td><c:out value = "${messagelist.sender }"/></td>
				<td><c:out value="${messagelist.content }"/></td>
				<td><c:out value="${messagelist.regDate }"/>
				</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${empty listmessage }">
			메시지가 없습니다.
		</c:if>
		<form action="/myCalendar/friend/servlet/friendlist">
		<button>확인</button>
		</form>
	</div>
</body>
</html>