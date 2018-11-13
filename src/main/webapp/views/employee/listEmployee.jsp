<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(document).ready(
		function() {
	$("#idDepart").select2();})
	
	function pagination(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}

	$(function() {

		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#nameStaff").val('');
			$("#idDepart").val('');
			$("#searchForm").submit();
		})

	})
</script>
<title>List Employee</title>
<s:head />
</head>
<body>
	<div class="container">
		
			<h1 align="center"><s:text name="label.employee.title" /></h1>
			<br><br>
			<s:form method="GET"  id="searchForm">
			<s:hidden name="pn" id="pageNo" />
			</s:form>
		
			<s:form action="employee" id="searchForm" theme="bootstrap" cssClass="well form-vertical">
			 <div>
			 <div style="width: 500px;float: left;">
			<label><s:text name="form.nameStaff" /></label>
			<s:textfield id="nameStaff" name="nameStaff" />
			</div>  
			<div style="width: 500px;float: left;  margin-left:100px;"> 
			 <s:select id="idDepart"  headerKey="0" key="form.idDepart" 
					list="departmentDto" listKey="id" listValue="nameDepart" name="idDepart" >
			</s:select> 
			</div>
			<br>
			<br>
			<br>
			<br>
			<s:submit id="searchForm" cssClass="btn btn-primary" key="common.button.search" />
			<s:submit id="btnClear" cssClass="btn btn-warning" key="common.button.clear" />
			<br><br>
			</div> 
			</s:form>
			
			<div class="row">
				<div class="col">
					<a href="<s:url action='createEmployee'/>" class="btn btn-success">
						<i class="fas fa-plus-square"></i> <s:text name="common.button.create" />
					</a>
				</div>
			</div>
			<br>
			<%@include file="/views/common/contraint.jsp"%>
				<s:include value="/views/common/paging.jsp" />
			<table class="table table-hover table-bordered text-center">
				<thead>
					<tr>
						<th style="text-align: center;" scope="col">#</th>
						<th style="text-align: center;" scope="col"><s:text name="form.code" /></th>
						<th style="text-align: center;" scope="col"><s:text name="form.nameStaff" /></th>
						<th style="text-align: center;" scope="col"><s:text name="form.gender" /></th>
						<th style="text-align: center;" scope="col"><s:text name="form.photo" /></th>
						<th style="text-align: center;" scope="col"><s:text name="form.email" /></th>
						<%-- <th style="text-align: center;" scope="col"><s:text name="form.salary" /></th> --%>
						<th style="text-align: center;" scope="col"><s:text name="form.idDepart" /></th>
						<th style="text-align: center;" scope="col"><s:text name="form.function" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator var="emp" value="listEmp" status="loop">
					<tr>
						<th style="text-align: center;" scope="row">${loop.count}</th>
						<td><s:property value="%{#emp.code}"/></td>
						<td><s:property value="%{#emp.nameStaff}"/></td>
						<td>
							<s:if test="%{#emp.gender==0}">
								Nữ
							</s:if>
							<s:elseif test="%{#emp.gender==1}">
								Nam
							</s:elseif> 
						</td>
						<td>
						<s:if test="%{#emp.photo != null}">
                                <img  src="<s:url value="/upload/%{#emp.photo}"></s:url>" width="100"/>
                            </s:if>
                            <s:elseif test="%{#emp.photo == null}">
                               <img  src="upload/default-user-image.png" width="100"/>
                            </s:elseif>
                            </td>
						<td><s:property value="%{#emp.email}"/></td>
						<%-- <td><s:property value="%{#emp.salary}"/></td> --%>
						<td><s:property value="%{#emp.nameDepart}"/></td>
						 
					
						<td style="width: 150px;"><s:a
							 action='updateEmployee?id=%{#emp.id}' > <font color="green"
								size="3"><i class="fas fa-edit"></i></font>
						</s:a> 
						<s:a onclick="return confirm('Bạn có muốn xóa không ???')"
							 action='removeEmployee?id=%{#emp.id}'> <font color="red" size="3"><i
									class="fas fa-trash-alt"></i></font>
						</s:a></td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
	</div>
</body>
</html>