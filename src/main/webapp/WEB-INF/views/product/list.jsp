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
				<h1 class="h3 mb-4 text-gray-800">${name}</h1>
                    <div class="row justify-content-center">
	           	    	<div class="col-6">
	           	        	<!-- 검색 폼 -->
	                 	  	<div>
	                   			<form action="./list" method="get">
		                	   		<div class="input-group mb-3">
			                	   		<div class="input-group-prepend">
			                	   			<select name="kind" class="custom-select">
			                	   				<option ${pager.kind eq 'v1'?'selected':''} value="v1">Name</option>
			                	   				<option ${pager.kind eq 'v2'?'selected':''} value="v2">Contents</option>
			                	   				<option ${pager.kind eq 'v3'?'selected':''} value="v3">Type</option>
			                	   			</select>
	  									</div>
	  									<input type="text" value="${pager.search}" name="search" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
	  									<div class="input-group-append">
	    									<button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
	  									</div>
									</div>
	                   			</form>
	                	   	</div>
	                    
	                    	<table class="table table-striped">
	                    		<thead>
	                    			<tr>
	                    				<th>번호</th>
	                    				<th></th>
	                    				<th style="width: 40%;">이름</th>
	                    				<th style="width: 15%;">종류</th>
	                    				<th style="width: 10%;">이율</th>
	                    			</tr>
	                    		</thead>
	                    		<tbody>
			                    	<c:forEach items="${list}" var="d">
			                    		<tr>
			                    			<td class="align-middle">${d.productNum}</td>
			                    			<td>
			                    				<c:if test="${not empty d.productFileDTO}">
        											<img src="/files/${name}/${d.productFileDTO.fileName}" class="img-thumbnail" style="width: 200px; height: auto;">
    											</c:if>
    										</td>
			                    			<td class="align-middle">
			                    				<a href="./detail?productNum=${d.productNum}">${d.productName}</a>
			                    			</td>
			                    			<td class="align-middle">${d.productType}</td>
			                    			<td class="align-middle">${d.productRate}%</td>
			                    		</tr>
			                    	</c:forEach>
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
	                    	
	                    	<div>
	                    		<a href="./create">상품 추가</a>
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
                    
                    
                    
</body>
</html>