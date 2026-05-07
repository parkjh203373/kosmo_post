<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                    <h1 class="h3 mb-4 text-gray-800">Home</h1>
                    <c:if test="${not empty member}">
                    	<h3>로그인 상태</h3>
                    	<spring:message code="welcome.login" arguments="${member.username}, ${member.birth}" argumentSeparator=","></spring:message>
                    </c:if>
                    <c:if test="${empty member}">
                    	<h3>비로그인 상태</h3>
                    </c:if>
                    
                    <spring:message code="hi" text="code가 없을 때 출력하는 기본 메세지" var="m"></spring:message>

                    <div id="map" style="width:500px;height:400px;"></div>                    
					
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
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8c3aee1f4922c98ea860b51fda94ab2c"></script>
	<script>
		const container = document.getElementById('map');
		let options = {
			center : new kakao.maps.LatLng(33.450701, 126.570667),
			level : 3
		};

		let map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>