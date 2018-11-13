<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Account</title>
</head>
<s:head />
<body>
	<div class="container">

		<s:form action="updateAcc" theme="bootstrap"
			cssClass="well form-vertical">
			<h1 align="center">Sửa Tài khoản</h1>
			<br>
			<div style="padding: 0 350px 0 350px">
				<s:hidden name="id"></s:hidden>
				<s:textfield key="form.username" />
				<s:textfield key="form.password" />
				<s:textfield key="form.fullname" />
			</div>
			<br>
			<div align="center">
				<s:submit cssClass="btn btn-success" key="common.button.save" />
				<a href="<s:url action='account'/>" class="btn btn-warning"> <i
					class="fas fa-chevron-left"></i> <s:text name="common.button.back" />
				</a>
			</div>
		</s:form>
	</div>
</body>
</html>