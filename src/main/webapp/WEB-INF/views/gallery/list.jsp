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
	<%@ include file="/WEB-INF/views/gallery/inc/header.jsp" %>
		<div id="list">
			<div>
				<span><img src="/jsppro/images/0.png" alt="" /></span>
				<div></div>
			</div>
		</div>
	</div>
	<input type="button" value=" 이미지 업로드 "
			class="btn btn-success" onclick="location.href='add.do';">

	<script>
	
	
	</script>

</body>
</html>