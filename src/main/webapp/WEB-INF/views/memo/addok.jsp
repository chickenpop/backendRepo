<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo 등록확인</title>
<%@ include file="/WEB-INF/views/memo/inc/asset.jsp" %>
<style>


</style>
</head>
<body>

	<div class="container">
		
	</div>

	<script>
	
		<c:if test="${result == 1}">
			location.href="/jsppro/memo/list.do";
		</c:if>
		
		<c:if test="${result == 0}">
			alert('failed');
			histroy.back();
		</c:if>
	
	</script>

</body>
</html>