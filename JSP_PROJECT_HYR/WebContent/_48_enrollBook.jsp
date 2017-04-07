<%--
	등록할 책을 입력하는 form 페이지
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.js"></script>
<!-- 
	Jquery 연동
 -->
 <script type="text/javascript">
 	$(document).ready(function(){
 		
 		$("#btnAdd").click(function(){ // 버튼에 클릭이벤트
 			// 등록버튼 누를 때마다 Validation 체크
 			var id = $("#id").val();
 			var title = $("#title").val();
 			var author = $("#author").val();
 			var price = $("#price").val();
 			var qty = $("#qty").val();
 			
 			if ( "0" === id ){ // 빈값이면
 				alert("값을 입력해야합니다.");
 				$("#id").focus();
 				return; // 더 수행되지 못하도록 return
 			}
 			if ( "" === title ){ // 빈값이면
 				alert("값을 입력해야합니다.");
 				$("#title").focus();
 				return; // 더 수행되지 못하도록 return
 			}
 			if ( "" === author ){ // 빈값이면
 				alert("값을 입력해야합니다.");
 				$("#author").focus();
 				return; // 더 수행되지 못하도록 return
 			}
 			if ( "0" === price ){ // 빈값이면
 				alert("값을 입력해야합니다.");
 				$("#price").focus();
 				return; // 더 수행되지 못하도록 return
 			}
 			if ( "0" === qty ){ // 빈값이면
 				alert("값을 입력해야합니다.");
 				$("#qty").focus();
 				return; // 더 수행되지 못하도록 return
 			}
 			return document.form1.submit();
 			// 끝까지 return되지 않으면 validation 통과니까 form태그의 submit 실행
 		});
 		
 	}); // end of jquery
 </script>
</head>
<body>
	<h2>도서 정보 등록</h2>
	<form name="form1" method="post" action="./_48_BookController.jsp">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="number" name="id" id="id"></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><input type="text" name="author" id="author"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="price" id="price"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="qty" id="qty"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="확인" id="btnAdd" />
					<input type="reset" value="취소" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>