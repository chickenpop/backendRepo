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
		
		<div class="btns">
				<input type="button" value="메모등록" class="btn btn-secondary"
					onclick="location.href='/jsppro/memo/add.do';"/>
				<input type="submit" value="메모삭제" class="btn btn-primary"
					onclick=""/>
			</div>
	</div>

	<script>
	
	
	</script>

</body>
</html>