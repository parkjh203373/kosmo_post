<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:forEach items="${list}" var="d">
	<tr>
		<td class="align-middle">
			<div>
				<input type="checkbox" class="ch" data-product-num="${d.productNum}">
			</div>
		</td>
		<td><c:if test="${not empty d.productDTO.productFileDTO}">
				<img src="/files/${name}/${d.productDTO.productFileDTO.fileName}"
					class="img-thumbnail" style="width: 200px; height: auto;">
			</c:if></td>
		<td class="align-middle"><a
			href="../product/detail?productNum=${d.productNum}">${d.productDTO.productName}</a>
		</td>
		<td class="align-middle">${d.productDTO.productType}</td>
		<td class="align-middle">${d.productDTO.productRate}%</td>
		<td class="align-middle text-center">
			<div class="d-flex flex-column align-items-center">
				<a href="../account/create?productNum=${d.productNum}"
					class="btn btn-success btn-sm mb-1" style="width: 60px;">가입</a>
				<button class="btn btn-danger btn-sm del"
					data-product-num="${d.productNum}" style="width: 60px;">삭제</button>
			</div>
		</td>
	</tr>
</c:forEach>
<c:if test="${empty list}">
	<tr>
		<td colspan="6" class="text-center py-5">장바구니가 비어있습니다.</td>
	</tr>
</c:if>