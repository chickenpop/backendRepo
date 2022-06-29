<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo</title>
<%@ include file="/WEB-INF/views/memo/inc/asset.jsp" %>
<style>


</style>
</head>
<body>
	
	
	<div class="container">
		<%@ include file="/WEB-INF/views/memo/inc/header.jsp" %>
		<c:forEach items="${list }" var="dto">
		<table class="table table-bordered item">
			<tr>
				<th>아이디</th>
				<td>${dto.id }</td>
				<th>날짜</th>
				<td>${dto.regdate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${dto.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${dto.content }</td>
			</tr>
		</table>
		<input type="button" value="메모삭제" class="btn btn-danger"
			onclick="location.href='/jsppro/memo/del.do?seq=${dto.seq }';"/>
		</c:forEach>
		<hr>
		<input type="button" value="메모등록" class="btn btn-secondary"
			onclick="location.href='/jsppro/memo/add.do';"/>
		
	</div>

	<script>
	
	
	</script>

</body>
</html>