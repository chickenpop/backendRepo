<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo 메모등록</title>
<%@ include file="/WEB-INF/views/memo/inc/asset.jsp" %>
<style>


</style>
</head>
<body>

	<div class="container">
	<%@ include file="/WEB-INF/views/memo/inc/header.jsp" %>
		<form method="POST" action="/jsppro/memo/addok.do">
			<table class="table table-bordered add">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="form-control"></td>
					<th>비번</th>
					<td><input type="password" name="pw" class="form-control"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="4"><input type="text" name="title" class="form-control"></td>
				</tr>
				<tr>
					<th>내용</th>
					<!--TODO CSS resize, height 적용안되는 이유찾기-->
					<td colspan="4"><textarea name="content" class="form-control" style="resize:none; height:300px;"></textarea></td>
				</tr>
			</table>
			<div class="btns">
				<input type="button" value="메모목록" class="btn btn-secondary"
					onclick="location.href='/jsppro/memo/list.do';"/>
				<input type="submit" value="메모등록" class="btn btn-primary"/>
			</div>
		</form>
	</div>

	<script>
	
	
	</script>

</body>
</html>