<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/temp/head_css.jsp"></c:import>

</head>
<body id="page-top">
<div id="wrapper">
		<c:import url="/WEB-INF/views/temp/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/temp/topbar.jsp"></c:import>
				<div class="container-fluid">
					<h1 class="h3 mb-4 text-gray-800">Detail Page</h1>
	                	<div class="col-8">
	                   		<table class="table table-hover">
	                   			<thead>
	                   				<tr class="table-secondary">
	                   					<th style="width: 15%;"></th>
	                   					<th style="width: 20%;">이름</th>
	                   					<th>내용</th>
	                   					<th style="width: 10%;">종류</th>
	                   					<th style="width: 7%;">이율</th>
	                   				</tr>
	                   			</thead>
	                   			<tbody>
	                   				<tr>
	                   					<td>
	                   						<c:if test="${not empty d.productFileDTO}">
        										<img src="/files/product/${d.productFileDTO.fileName}" class="img-thumbnail" style="width: 200px; height: auto;">
    										</c:if>
    									</td>
	                   					<td class="align-middle">${d.productName}</td>  
	                   					<td class="align-middle">${d.productContents}</td>
	                   					<td class="align-middle">${d.productType}</td>
	                   					<td class="align-middle">${d.productRate}%</td>
	                   				</tr>
	                   			</tbody>
	                   		</table>
                    
		                    <div class="d-flex align-items-center">
		                    	<a class="btn btn-info mr-3" href="./update?productNum=${d.productNum}">수정</a>
		                    	<form action="./delete" method="post" class="mb-0 mr-3">
		                    		<input type="hidden" name="productNum" value="${d.productNum}">
		                    		<button type="submit" class="btn btn-info">삭제</button>
		                    	</form>
		                    	<a href="../account/create?productNum=${d.productNum}" class="btn btn-info mr-3">상품 가입</a>
		                    	<button class="btn btn-info mr-3" id="create" data-pn="${d.productNum}">장바구니 담기</button>
		                    </div>
							<hr class="my-5">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">상품 후기 (댓글)</h6>
								</div>
								<div class="card-body">
									<div id="review_list" class="mb-4">
										<p class="text-center text-muted">등록된 댓글이 없습니다.</p>
									</div>
									
									<div class="form-group d-flex align-items-center mb-2">
								        <label for="review_star" class="mb-0 mr-2 font-weight-bold">평점 : </label>
								        <select class="form-control col-2" id="review_star">
								            <option value="5">★★★★★</option>
								            <option value="4">★★★★☆</option>
								            <option value="3">★★★☆☆</option>
								            <option value="2">★★☆☆☆</option>
								            <option value="1">★☆☆☆☆</option>
								            <option value="0">☆☆☆☆☆</option>
								        </select>
								    </div>
	
									<div class="input-group">
										<textarea id="review_contents" class="form-control" rows="3"
											placeholder="댓글을 입력해주세요."></textarea>
										<div class="input-group-append">
											<button class="btn btn-primary px-4" type="button"
												id="review_add">등록</button>
										</div>
									</div>
								</div>
							</div>
						</div>
                <!-- end container-fluid -->
			</div>
			<!-- end content -->
			<c:import url="/WEB-INF/views/temp/footer.jsp"></c:import>
		</div>
		<!-- end content-wrapper -->
	</div>
	<!-- end wrapper -->
	<c:import url="/WEB-INF/views/temp/footer_script.jsp"></c:import>
                    
                    
                    
    <script src="/js/cart/cart.js"></script>
</body>
</html>