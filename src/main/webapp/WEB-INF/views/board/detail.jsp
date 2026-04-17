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
	                   					<th>제목</th>
	                   					<th>작성자</th>
	                   					<th>내용</th>
	                   					<th>첨부파일</th>
	                   				</tr>
	                   			</thead>
	                   			<tbody>
	                   				<tr>
	                   					<td>${d.boardTitle}</td>
	                   					<td>${d.boardWriter}</td>     
	                   					<td>
	                   						<div>
	                   							${d.boardContents}
	                   						</div>
	                   					</td>
	                   					<td>
	                   						<div>	                   						
		                   						<c:forEach items="${d.list}" var="f">
		                   							<h4><img src="/files/${name}/${f.fileName}"></h4>
		                   						</c:forEach>
	                   						</div>
	                   					</td>
	                   				</tr>
	                   			</tbody>
	                   		</table>
                    
	                    <div>
	                    	<a class="btn btn-info" href="./update?boardNum=${d.boardNum}">수정</a>
	                    	<form action="./delete" method="post">
	                    		<input type="hidden" name="boardNum" value="${d.boardNum}">
	                    		<button type="submit" class="btn btn-info">삭제</button>
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