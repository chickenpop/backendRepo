<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Address</title>
<%@ include file="/WEB-INF/views/address/inc/asset.jsp" %>
<style>

	.table th, .table td { text-align: center; }
	.table td:nth-child(5) { text-align: left; }
	.table td:nth-child(1) { width: 120px; }
	.table td:nth-child(2) { width: 80px; }
	.table td:nth-child(3) { width: 80px; }
	.table td:nth-child(4) { width: 160px; }
	.table td:nth-child(5) { width: auto; }
	.table td:nth-child(6) { width: 80px; }
	
	form input, form select { margin: 10px 0; }
	form input[type=text] { width: 120px; }
	form input[type=text]:nth-child(4) { width: 200px; }
	form input[type=text]:nth-child(5) { width: 400px; }
	form select.form-control { width: 120px; }

</style>
</head>
<body>
	
	
	<main>
		<section>
			<h2>
				주소록
				<small>
					<input type="button" value="남자" class="btn btn-primary btn_gender">
					<input type="button" value="여자" class="btn btn-danger btn_gender">
					<input type="button" value="전체" class="btn btn-info btn_gender">
				</small>
			</h2>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>이름</th>
						<th>나이</th>
						<th>성별</th>
						<th>전화</th>
						<th>주소</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.name}</td>
						<td>${dto.age}</td>
						<td>${dto.gender}</td>
						<td>${dto.tel}</td>
						<td>${dto.address}</td>
						<td><input type="button" value="삭제" class="btn btn-warning" onclick="del(${dto.seq});"></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<hr>
			<form id="insert">
			<div>
				<input type="text" name="name" id="name" class="form-control" placeholder="이름" required>
				<input type="text" name="age" id="age" class="form-control" placeholder="나이" required>
				<select name="gender" id="gender" class="form-control">
					<option value="m">남자</option>
					<option value="f">여자</option>
				</select>
				<input type="text" name="tel" id="tel" class="form-control" placeholder="전화" required>
				<input type="text" name="address" id="address" class="form-control" placeholder="주소" required>
			</div>
			<div class="btns">
				<input type="button" value="등록하기" id="btnInsert" class="btn btn-primary" required>
			</div>
			</form>	
		</section>
	</main>

	<script>
	
		function del(seq){
			
			let tr = $(event.target).parent().parent();
			
			$.ajax({
				type: 'GET',
				url: 'deladdress.do',
				data: "seq=" + seq,
				dataType: 'json',
				success: function(result) {
					console.log(result);	
				
					if(result.result != "0"){	
						tr.remove();	
					} else {
						alert('등록에 실패했습니다');
					}
					
				},
				error: function (result) {
					console.log(result);
				}
			});
			
		}
		
		$('#btnInsert').click(function() {
			$.ajax({
				type: 'GET',
				url: 'addaddress.do',
				data: $('#insert').serialize(),
				dataType: 'json',
				success: function(result) {
					console.log(result);				
					if(result.result != "0"){
						let temp = '';
						
						// 입력된 값 그리기
						temp += '<tr>';
						temp += '<td>' + $('#name').val() + '</td>';
						temp += '<td>' + $('#age').val() + '</td>';
						temp += '<td>' + $('#gender').val() + '</td>';
						temp += '<td>' + $('#tel').val() + '</td>';
						temp += '<td>' + $('#address').val() + '</td>';
						temp += '<td><input type="button" value="삭제" class="btn btn-warning" onclick="del(' + result.seq + ');"></td>';
						temp += '</tr>';
						
						$('table tbody').append(temp);
						
						// 입력 폼 초기화
						$('#name').val('');
						$('#age').val('');
						$('#gender').val('m');
						$('#tel').val('');
						$('#address').val('');
					}
				},
				error: function (result) {
					console.log(result);
				}
			});
		});
		
		$('.btn_gender').click(function(){
			
			let gender = $(this).val();
			
			$.ajax({
				type: 'GET',
				url: 'serachaddress.do',
				data: 'gender=' + gender,
				dataType: 'JSON',
				success: function(result){
					console.log(result);
					
					// 현재 목록 제거
					$('table tbody').html('');
					
					if (result.length > 0) {
						$(result).each(function(index, item){
							let temp = '';
												
							temp += '<tr>';
							temp += '<td>' + item.name + '</td>';
							temp += '<td>' + item.age + '</td>';
							temp += '<td>' + item.gender + '</td>';
							temp += '<td>' + item.tel + '</td>';
							temp += '<td>' + item.address + '</td>';
							temp += '<td><input type="button" value="삭제" class="btn btn-warning" onclick="del(' + item.seq + ');"></td>';
							temp += '</tr>';
							
							$('table tbody').append(temp);
						});
					} else {
						$('table tbody').append('<tr><td colspan="6">조회되는 데이터가 없습니다</td></tr>');
					}
				
				},
				error: function(result){
					console.log(result);
				}
			});
			
		});
		
	
	</script>

</body>
</html>