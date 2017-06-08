<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Calendar</title>
</head>
<body>
	<form action="Register" method="post">
	<table>
		<thead>
		<tr>
		<th colspan="2"><h1>회원가입 페이지</h1></th>
		</tr>
		</thead>
		<tr>
			<th>ID</th>
			<td><input type="text" name="id" /></td>
		</tr>
		<tr>
			<th>NAME</th>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<th>GENDER</th>
			<td>
				<input type="radio" id="gendercheck1" name="gender" value="1"/>
				<label for="gendercheck1">남자</label>
				<input type="radio" id="gendercheck2" name="gender" value="2"/>
				<label for="gendercheck2">여자</label>
			</td>
			</tr>
		<tr>
			<th>EMAIL ADDRESS</th>
			<td>
				<input type="text" name="emailId" /> @ 
				<select name="emailAddr">
				<option value="" selected>선택하세요</option>
				<option value="empal.com">empal.com</option>
			    <option value="dreamwiz.com">dreamwiz.com</option>
			    <option value="naver.com">naver.com</option>
			    <option value="hotmail.com">hotmail.com</option>
			    <option value="chollian.net">chollian.net</option>
			    <option value="freechal.com">freechal.com</option>
			    <option value="hanafos.com">hanafos.com</option>
			    <option value="kebi.com">kebi.com</option>
			    <option value="korea.com">korea.com</option>
			    <option value="lycos.co.kr">lycos.co.kr</option>
			    <option value="netian.com">netian.com</option>
			    <option value="netsgo.com">netsgo.com</option>
			    <option value="unitel.co.kr">unitel.co.kr</option>
			    <option value="yahoo.co.kr">yahoo.co.kr</option>
			    <option value="gmail.com">gmail.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>BIRTH</th>
			<td>
				<select name="birthyear">
			 	<c:forEach var="y"  begin="1950" end="2005">
			 		<option value="${y}">${y}</option>
			 	</c:forEach>
				</select> 년
				<select name="birthmonth">
			 	<c:forEach var="m"  begin="1" end="12">
			 		<option value="${m}">${m}</option>
			 	</c:forEach>
				</select> 월
				<select name="birthdate">
				<c:forEach var="d" begin="1" end="31">
					<option value="${d}">${d}</option>
				</c:forEach>
				</select> 일
			</td>
		</tr>
		<tr>
			<th>광고 수신 동의</th>
			<td>
				<input type="radio" id="notice1" name="notice" value="1" />
				<label for="notice1" >동의 합니다</label>
				<input type="radio" id="notice2" name="notice" value="2" />
				<label for="notice2" >동의 하지않습니다</label>
			</td>
		</tr>
		
		<tr>
			<th colspan="2">
			<br>
			<button>가입하기</button>  
			<button type="button" onclick="location.href='Main'">취소</button>
			</th>
		</tr>
	</table>
	</form>
</body>
</html>






