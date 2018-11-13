<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Department</title>
<s:head />
</head>
<body>
	<div class="container">

		<s:form theme="bootstrap" cssClass="well form-vertical">
			<h1 align="center"><s:text name="label.department.title" /></h1>
			<br><br>
			<div style="width: 500px;float: left;">
			<s:text name="form.department.code" />
			<s:textfield name="txtCode" label="" />
			</div>
			<div style="width: 500px;float: left; margin-left: 50px;">
			<s:text name="form.department.name" />
			<s:textfield name="txtName" label=""  />
			</div>
			<br><br><br><br>
			<s:submit cssClass="btn btn-primary" key="common.button.search" />
			<s:submit cssClass="btn btn-warning" key="common.button.clear" />
			<br><br>
			<div class="row">
				<div class="col">
					<a href="<s:url action='inputCreateDepart'/>" class="btn btn-success">
						<i class="fas fa-plus-square"></i> Create
					</a>
				</div>
			</div>
			<br>
			<br>

			<table class="table table-striped text-center">
				<thead>
					<tr >
						<th style="text-align: center;" scope="col">#</th>
						<th style="text-align: center;" scope="col"><s:text name="form.department.code" /></th>
						<th style="text-align: center;" scope="col"><s:text name="form.department.name" /></th>
						<th style="text-align: center;" scope="col"><s:text name="action" /></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator var="depart" value="listDepart" status="loop">
						<tr>
							<th style="text-align: center;" scope="row">${loop.count}</th>
							<td><s:property value="#depart.code" /></td>
							<td><s:property value="#depart.nameDepart" /></td>
							<td style="width: 150px;">
							<s:a action="inputUpdateDepart?id=%{#depart.id}" title="Sửa" > 
								<font color="green" size="3"><i class="fas fa-edit"></i></font>
							</s:a> 
							<s:a action="removeDepart?id=%{#depart.id}" title="Xóa"
									onclick="return window.confirm('Xóa sản phẩm này ?') ">
									<font color="red" size="3"><i class="fas fa-trash-alt"></i></font>
								</s:a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:form>
	</div>
</body>
</html>