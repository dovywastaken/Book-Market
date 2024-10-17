<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 추가하기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
</head>
<body>
		<div class = "py-4">
		<%@ include file ="menu.jsp" %>
		
		
		<div class ="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class = "container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 등록</h1>
				<p class="col-md-8 fs-4">Book Addition</p>
			</div>
		</div>
		
		
<!-- submit 태그 -->
		<div class="row align-items-md-stretch">
			<form name="newBook" action ="book" method="post" class="form-horizontal" enctype="multipart/form-data"> <!-- class="form-horizontal", multipart/form-data 추가 -->
				<div class="mb-3 row">
					<label class="col-sm-2">도서코드</label>
					<div class="col-sm-3">
						<input type = "text" name="bookId" class="form-control" id="bookId">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">도서명</label>
					<div class="col-sm-3">
						<input type = "text" name="name" class="form-control" id="name">
					</div>
				</div>
				
				<div class="mb-3 row">
					<label class="col-sm-2">가격</label>
					<div class="col-sm-3">
						<input type = "text" name="unitPrice" class="form-control" id="unitPrice">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">저자</label>
					<div class="col-sm-3">
						<input type = "text" name="author" class="form-control">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">출판사</label>
					<div class="col-sm-3">
						<input type = "text" name="publisher" class="form-control">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">출판일</label>
					<div class="col-sm-3">
						<input type = "text" name="releaseDate" class="form-control">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">상세정보</label>
					<div class="col-sm-5">
						<textarea name ="description" cols ="50" rows ="2" class ="form-control" placeholder="100자 이상 적어주세요" id="description"></textarea>
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">분류</label>
					<div class="col-sm-3">
						<input type = "text" name="category" class="form-control">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">재고수</label>
					<div class="col-sm-3">
						<input type = "text" name="unitInStock" class="form-control" id="unitInStock">
					</div>
				</div>
				
				
				<div class="mb-3 row">
					<label class="col-sm-2">상태</label>
					<div class="col-sm-5">
						<input type = "radio" name="condition" value="New">신규도서
						<input type = "radio" name="condition" value="Old">중고도서
						<input type = "radio" name="condition" value="EBook">EBook
					</div>
				</div>
				
				<div class="mb-3 row">
					<label class="col-sm-2">이미지</label>
					<div class = "col-sm-5">
						<input type="file" name="BookImage" class="form-control">
					</div>
					<div class="col-sm-3">
						<input type = "button" class="btn btn-primary" value ="등록" id="submitBtn">
					</div>
				</div>
				
			</form>
		
		</div>
		<jsp:include page ="footer.jsp" />
	</div>
	
	<script type="text/javascript" src="./resources/js/validation.js"></script>
</body>
</html>