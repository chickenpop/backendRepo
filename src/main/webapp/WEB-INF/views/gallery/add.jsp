<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Gallery</title>
<%@ include file="/WEB-INF/views/gallery/inc/asset.jsp" %>
<style>


</style>
</head>
<body>

	<div class="container">
	<form method="POST" action="/jsppro/gallery/addok.do" enctype="multipart/form-data">
		<div>이미지 내용: <input type="text" name="content" required></div>
		<div>파일: <input type="file" name="attach" required></div>
		<input type="submit">
	</form>
	</div>

	<script>
	
	
	</script>

</body>
</html>