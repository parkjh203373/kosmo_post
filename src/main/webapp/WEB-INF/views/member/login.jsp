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
                    <h1 class="h3 mb-4 text-gray-800">로그인</h1>
                    
                    <div>
                    	<div class="row"> <div class="col-md-4">
                    	<form action="./login" method="post" enctype="multipart/form-data">
	                    	<div class="mb-3">
	                    		<label for="username" class="form-label">아이디</label>
						        <input type="text" value="test2" class="form-control" name="username" id="username">
						    </div>
						
						    <div class="mb-3">
						        <label for="password" class="form-label">비밀번호</label>
						        <input type="password" value="test2" class="form-control" name="password" id="password">
						    </div>
						
						    <div class="text-start mt-4">
						    	<button type="submit" class="btn btn-primary px-5">로그인</button>
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