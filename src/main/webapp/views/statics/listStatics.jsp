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
	<h1 align="center"><s:text name="label.static.title"/> </h1>
	<br><br>
			<table class="table table-striped text-center">
				<thead>
					<tr >
						<th style="text-align: center;" scope="col">#</th>
						<th style="text-align: center;" scope="col"><s:text name="form.code"/></th>
						<th style="text-align: center;" scope="col"><s:text name="form.nameStaff"/></th>
						<th style="text-align: center;" scope="col"><s:text name="label.static.achievements"/></th>
						<th style="text-align: center;" scope="col"><s:text name="label.static.discipline"/></th>
						<th style="text-align: center;" scope="col"><s:text name="label.static.total"/></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator var="a" value="listStatic" status="loop">
						<tr>
							<th style="text-align: center;" scope="row">${loop.count}</th>
							<td>${a[0]}</td>
							<td>${a[1]}</td>
							<td>${a[3]}</td>
							<td>${a[4]}</td>
							<td>${a[3] + a[4]}</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			</div>
</body>
</html>