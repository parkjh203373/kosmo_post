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
				<h1 class="h3 mb-4 text-gray-800">장바구니</h1>
                    <div class="row justify-content-center">
	           	    	<div class="col-8">
	           	        	<table class="table table-striped">
	                    		<thead>
	                    			<tr>
	                    				<th><input type="checkbox" class="btn btn-primary" id="id1"> 전체 선택</th>
	                    				<th></th>
	                    				<th style="width: 30%;">이름</th>
	                    				<th style="width: 15%;">종류</th>
	                    				<th style="width: 10%;">이율</th>
	                    				<th></th>
	                    			</tr>
	                    		</thead>
	                    		<tbody>
			                    	<c:forEach items="${list}" var="d">
			                    		<tr>
			                    			<td class="align-middle">
			                    				<div>
			                    					<input type="checkbox" class="ch">
			                    				</div>
			                    			</td>
			                    			<td>
			                    				<c:if test="${not empty d.productDTO.productFileDTO}">
        											<img src="/files/${name}/${d.productDTO.productFileDTO.fileName}" class="img-thumbnail" style="width: 200px; height: auto;">
    											</c:if>
    										</td>
			                    			<td class="align-middle">
			                    				<a href="../product/detail?productNum=${d.productNum}">${d.productDTO.productName}</a>
			                    			</td>
			                    			<td class="align-middle">${d.productDTO.productType}</td>
			                    			<td class="align-middle">${d.productDTO.productRate}%</td>
			                    			<td class="align-middle text-center">
			                    				<div class="d-flex flex-column align-items-center">
											        <a href="../account/create?productNum=${d.productNum}" class="btn btn-success btn-sm mb-1" style="width: 60px;">가입</a>
											        <button class="btn btn-danger btn-sm" style="width: 60px;">삭제</button>
											    </div>
			                    			</td>
			                    		</tr>
			                    	</c:forEach>
			                    	<c:if test="${empty list}">
				                        <tr>
				                            <td colspan="6" class="text-center py-5">장바구니가 비어있습니다.</td>
				                        </tr>
				                    </c:if>
			                    </tbody>
	                    	</table>
	                    	
	                    	<div>
	                    		<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item ${pager.pre?'':'disabled'}">
								      		<a class="page-link" href="./list?page=${pager.pre?pager.start-1:pager.start}&search=${pager.search}&kind=${pager.kind}" aria-label="Previous">
								       			<span aria-hidden="true">&laquo;</span>
								      		</a>
								    	</li>
								    		<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
	                    						<li class="page-item"><a class="page-link" href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
	                    					</c:forEach>
	                    				
	                    				<li class="page-item ${pager.next?'':'disabled'}">
								    		<a class="page-link" href="./list?page=${pager.next?pager.end+1:pager.end}&search=${pager.search}&kind=${pager.kind}" aria-label="Next">
								        		<span aria-hidden="true">&raquo;</span>
								      		</a>
								   		</li>
								  	</ul>
								</nav>
	                    	</div>
	                    	
	                    	<div class="text-right mt-3">
				                <a href="../product/list" class="btn btn-secondary">쇼핑 계속하기</a>
				                <button class="btn btn-success">전체 상품 가입하기</button>
				                <button class="btn btn-primary">선택 삭제</button>
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
                    
                    
    <script src="/js/cart/list.js"></script>
</body>
</html>