<%@page pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<div class="clearfix">
    <c:if test="${pagination.totalRecords > 0}">
    <nav aria-label="page navigation" class="float-right">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="javascript:pagination(${pagination.first})" aria-label="First page">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">First</span>
                </a>
            </li>
             <c:forEach var ="index" begin ="${pagination.from}" end ="${pagination.to}">
                <c:if test="${index != pagination.currentPage}">
                    <li class="page-item"><a class="page-link" href="javascript:pagination(${index})">${index}</a></li>
                </c:if>
                <c:if test="${index == pagination.currentPage}">
                    <li class="page-item active"><a class="page-link" href="javascript:pagination(${index})">${index}</a></li>
                </c:if>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="javascript:pagination(${pagination.last})" aria-label="Last">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Last</span>
                </a>
            </li>
        </ul>
    </nav>
    </c:if>
    <c:if test="${pagination.totalRecords == 0}">
    <nav aria-label="page navigation" class="float-right">
        <ul class="pagination">
            <li class="page-item">&nbsp;</li>
        </ul>
    </nav>
    </c:if>
     <div class="float-right p-2"><span>Tong: 
     ${pagination.totalRecords} items </span></div>
</div>
