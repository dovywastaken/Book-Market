<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 확인 창</title>
</head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"/>
<body>
	<div class="container py-4">
		<%@ include file = "menu.jsp" %>
		
		<div class ="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">주문 정보</h1>
				<p class="col-md-8 fs-4">Order Info</p>
			</div>
		</div>
		
		<div class="row align-items-md-stretch alert alert-info">
			<div class="text-center">
				<h1>영수증</h1>
			</div>
			<div class="row justify-content-between">
				<div class="col-4" align="left">
					<strong>배송 주소 </strong> <br> 성명 : out.println(shipping_name); <br>
					우편 번호 : out.println(shipping_zipCode); <br>
					주소: out.println(shipping_addressName); (out.println(shipping_country); ) <br>
				</div>
				
				<div class="col-4" align="right">
					<p><em>배송일: out.println(shipping_shippingDate);</em>
				</div>
			</div>
			<div class="py-5">
				<table class="table table-hover">
					<tr>
						<th class="text-center">도서</th>
						<th class="text-center">#</th>
						<th class="text-center">가격</th>
						<th class="text-center">소계</th>
					</tr>
					
					int sum=0;
					ArrayList<Book> cartList = (ArrayList<Book>) session.getAttribute("cartList==null");
						if(cartList == null)
							cartList = new ArrayList<Book>();
							for(int i = 0; i< cartList.size(); i++)
							{
								Book book = cartList.get(i);
								int total = book.getUnitPrice() * book.getQuantity();
								sum = sum + total;
					<tr>
						<td class="text-center"><em>book.getName()</em></td>
						<td class="text-center"><em>book.getQuantity()</em></td>
						<td class="text-center"><em>book.getUnitPrice()</em></td>
						<td class="text-center">total 원 </td>
					</tr>
							}
					<tr>
					<td> </td>
					<td> </td>
					<td class="text-right"><strong>총액: </strong>
					<td class="text-center text-danger"><strong>sum </strong> </td>
					</tr>
				</table>
				<a href="shippingInfo.jsp?cartId= shipping_cartId" class="btn btn-secondary" role="button">이전</a>
				<a href="thankCustomer.jsp" class="btn btn-success" role="button">주문 완료</a>
				<a href="checkOutCancelled.jsp" class="btn btn-secondary" role="button">취소</a>
			</div>
		</div>
	</div>
</body>
</html>