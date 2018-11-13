<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="label.account.title" /></title>
<script type="text/javascript">
	function pagination(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}

	$(function() {

		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#username").val('');
			$("#searchForm").submit();
		})

	})
</script>
<s:head />
</head>
<body>
	<div class="container">
		<s:form method="GET" id="searchForm">
			<s:hidden name="page" id="pageNo" />
		</s:form>
		<s:form theme="bootstrap" id="searchForm" method="GET" cssClass="well form-vertical">
			<h1 align="center">
				<s:text name="label.account.title" />
			</h1>
			<br>
			<div style="width: 500px; float: left;">
				<input type="text" class="form-control"
					placeholder="<s:text name="label.account.title" />"
					id="username" name="username">
			</div>
			<br>
			<br>
			<br>

			<button type="submit" class="btn btn-primary" id="btnSearch">
				<i class="fas fa-search"></i>
				<s:text name="common.button.search" />
			</button>
			<button type="reset" class="btn btn-warning" id="btnClear">
				<i class="fas fa-eraser"></i>
				<s:text name="common.button.clear" />
			</button>
		</s:form>
		<br>

		<div class="row">
			<div class="col">
			
				<s:a action="createAccount" class="btn btn-success"> <i
					class="fas fa-plus-square"></i> <s:text name="common.button.create" />
				</s:a>
			</div>
		</div>
		<br> <br>
		
	
		<%@include file="/views/common/contraint.jsp"%>
		<%@include file="/views/common/paging.jsp"%>
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th style="text-align: center;" scope="col">#</th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.username" /></th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.password" /></th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.fullname" /></th>
					<th style="text-align: center;" scope="col"><s:text
							name="action" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="account" value="listAcc" status="i">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="#account.username" /></td>
						<td><s:property value="#account.password" /></td>
						<td><s:property value="#account.fullname" /></td>
						<td style="width: 150px;"><s:a
								action="update?id=%{#account.id}" title="Sửa">
								<font color="green" size="3"><i class="fas fa-edit"></i></font>
							</s:a> <s:url action="delete?id=%{#account.id}" var="delete"></s:url> <a
							href="${delete}"
							onclick="return confirm('<s:text
									name="common.confirm" />')">
								<font color="red" size="3"><i class="fas fa-trash-alt"></i></font>
						</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

</body>

</html>