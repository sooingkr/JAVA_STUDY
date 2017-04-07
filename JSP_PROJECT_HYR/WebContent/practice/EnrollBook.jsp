<%--
	책을 등록하는 페이지...
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#enroll").click(function() {
			var id = $("#id").val();
			var title = $("#title").val();
			var author = $("#author").val();
			var price = $("#price").val();
			var qty = $("#qty").val();
			if (id === "") {
				alert("빈칸 안됨, ID입력하세요.");
				$("#id").focus();
				return;
			}
			if (title === "") {
				alert("빈칸 안됨, title입력하세요.");
				$("#title").focus();
				return;
			}
			if (author === "") {
				alert("빈칸 안됨, author입력하세요.");
				$("#author").focus();
				return;
			}
			if (price === "") {
				alert("빈칸 안됨, ID입력하세요.");
				$("#price").focus();
				return;
			}
			if (qty === "") {
				alert("빈칸 안됨, ID입력하세요.");
				$("#qty").focus();
				return;
			}

			form1.submit();
		});

	});
</script>
</head>
<body>
	등록할 책 정보를 입력해 주세요 :
	<br />
	<form name="form1" action="./BookEnrollController.jsp" />
	ID :
	<input type="number" name="id" id="id" />
	<br /> TITLE :
	<input type="text" name="title" id="title" />
	<br /> AUTHOR :
	<input type="text" name="author" id="author" />
	<br /> PRICE :
	<input type="number" name="price" id="price" />
	<br /> QTY :
	<input type="number" name="qty" id="qty" />
	<br />
	<input type="submit" value="등록" id="enroll" />
	</form>
</body>
</html>