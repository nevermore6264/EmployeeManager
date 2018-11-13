<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="label.department.title"/></title>
<s:head/>
</head>
<body>
	<div class="container">
		<s:form action="createDepart" theme="bootstrap"
			cssClass="well form-vertical">

			<h1 align="center"><s:text name="label.department.create"/></h1>
			<br>
			
				<div style="padding: 0 350px 0 350px">
					<s:hidden name="departmentCreateForm.id" />
					<s:text name="form.department.code"/>
					<s:textfield name="departmentCreateForm.code" />
					
					<s:text name="form.department.name"/>
					<s:textfield name="departmentCreateForm.nameDepart" />
				</div>
			
			<br>

			<div align="center">
				<s:submit cssClass="btn btn-success" key="common.button.save" />

				<a href="<s:url action='department'/>" class="btn btn-warning">
					<i class="fas fa-chevron-left"></i> <s:text name="common.button.back"></s:text>
				</a>

			</div>
		</s:form>
	</div>
</body>
</html>