<%@page import="org.w3c.dom.Document"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지보내기</title>
<style>

#div_menu{
width:10%;
height:300px;
float:left;
backgound-color:#82fa58
text-align:left;
}
#div_con{
width:80%;
height:300px;
backgound-color:#819ff7;
text-align:center;
}
#div_bottom{
width:100%;
height:100px;
clar:both;
backgound-color:#819ff7;
text-align:conter;
}

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
	<div id = "div_menu">
	<form action = "/myCalendar/friend/servlet/messagereceiverlist">
			<button>받은 쪽지함</button>
			
<!-- 			<a href = "/myCalendar/friend/servlet/messagesenderlist">보낸 쪽지함</a> -->
	</form><br>
	<form action="/myCalendar/friend/servlet/messagesenderlist">
		<button> 보낸 쪽지함</button>
	</form>
	</div>
 	<div id = "div_con">
 	<table>
 		<tr>
 			<th>친구 아이디</th>
 			<th>친구 관심사</th>
 		</tr>
 		<c:forEach var="friend" items="${list}">
 		<tr>
 			<td><c:out value="${friend.friendId}" /></td>
 			<td><c:out value="${friend.friendInterest}"/></td>
 			<td><a href="/myCalendar/friend/servlet/message/WriteForm?userId=${friend.friendId}">쪽지 보내기</a>
 			<td><a href="/myCalendar/friend/servlet/frienddelete?userId=${friend.friendId}">친구 삭제</a>
 		</tr>
 		</c:forEach>
 	</table>
 	</div>
 	<div id="div_bottom">
 		<form action="/myCalendar/friend/servlet/friendadd">
 			친구 등록 : <input type="text" name="friendId" value="아이디를 입력하세요"><button>검색</button>
 		</form>
 	</div>
			<c:if test="${empty list}">
				<ul>
					<li>ㅋㅋㅋ 넌 홍모다 친구없음 ㅃㅃ
				</ul>
			</c:if>

</body>
</html>