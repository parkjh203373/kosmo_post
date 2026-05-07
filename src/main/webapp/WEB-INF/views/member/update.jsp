<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <h1 class="h3 mb-4 text-gray-800">내 정보 수정</h1>
                    
                    <div>
                    	<div class="row"> <div class="col-md-6">
                    	<form:form method="post" enctype="multipart/form-data" modelAttribute="memberDTO" id="frm">						    
						    <div class="mb-3">
						        <label for="name" class="form-label">이름</label>
						        <form:input path="name" cssclass="form-control" id="name"/>
						        <form:errors path="name"></form:errors>
						    </div>
						    
						    <div class="mb-3">
						        <label for="phone" class="form-label">핸드폰 번호</label>
						        <form:input path="phone" cssclass="form-control" id="phone" placeholder="010-0000-0000"/>
						        <form:errors path="phone"></form:errors>
						    </div>
						
						    <div class="mb-3">
						        <label for="email" class="form-label">이메일</label>
						        <form:input path="email" cssclass="form-control" id="email" placeholder="name@example.com"/>
						        <form:errors path="email"></form:errors>
						    </div>
						
						    <div class="mb-3">
						        <label for="birth" class="form-label">출생년월일</label>
						        <input type="date" class="form-control" name="birth" id="birth" value="${memberDTO.birth}">
						        <form:errors path="birth"></form:errors>
						    </div>

						    <div class="mb-3">
						        <label class="form-label">첨부파일</label>
						        <input type="file" name="attach" class="form-control">
						    </div>

							<div class="text-start mt-4">
							    <button type="submit" class="btn btn-primary px-5" id="btn">회원가입</button>
							</div>
                    	</form:form>

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
	
	<!-- <script src="/js/member/join.js"></script> -->
</body>
</html>