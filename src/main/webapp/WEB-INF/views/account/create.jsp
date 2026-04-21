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
                    <h1 class="h3 mb-4 text-gray-800">상품 가입</h1>
                    
                    <div>
                    	<div class="row"> <div class="col-md-4">
                    	<form action="./create" method="post" enctype="multipart/form-data">
	                    	<input type="hidden" name="productNum" value="${param.productNum}">
	                    	<div class="mb-3">
	                    		<label for="password" class="form-label">비밀번호</label>
						        <input type="password" class="form-control" name="accountPw" id="password">
						    </div>
						
						    <div class="mb-3">
						        <label for="passwordCheck" class="form-label">비밀번호 확인</label>
						        <input type="password" class="form-control" name="accountPwCheck" id="passwordCheck">
						    </div>
						
						    <div class="text-start mt-4">
						    	<button type="submit" class="btn btn-primary px-5">가입</button>
						    </div>
					    
						</form>
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