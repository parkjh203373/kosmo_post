<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:choose>
    <c:when test="${not empty list}">
        <ul class="list-group list-group-flush">
            <c:forEach items="${list}" var="dto">
                <li class="list-group-item d-flex justify-content-between align-items-start">
                    <div class="ms-2 me-auto">
                        <div class="fw-bold">
                        	<strong>${dto.username}</strong>
                        	<span class="text-warning ml-2">
                        	    <c:forEach begin="1" end="${dto.reviewStar}">★</c:forEach>
                        	    <c:forEach begin="1" end="${5 - dto.reviewStar}">☆</c:forEach>
                        	</span>
                        	<small class="text-muted ml-1">(${dto.reviewStar})</small>
                        </div>
                        <div class="mt-1">
                            ${dto.reviewContents}
                        </div>
                    </div>
                    <span class="badge bg-light text-muted">${dto.reviewDate.toString().replace('T', ' ').substring(0, 19)}</span>
                </li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p class="text-center text-muted">등록된 댓글이 없습니다.</p>
    </c:otherwise>
</c:choose>