<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<s:head />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h2>Login</h2>
				<hr>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"></h3>
					</div>
					<div class="panel-body">
						<s:if test="hasActionMessages()">
							<div class="alert alert-danger alert-dismissable">
								<s:actionmessage />
							</div>
						</s:if>
						<s:form action="login" theme="bootstrap"
							cssClass="well form-vertical">
							<div class="form-group">
								<s:textfield label="Username" name="userName" />
							</div>
							<div class="form-group">
								<s:password label="Password" name="password" />
							</div>
							<s:submit cssClass="btn btn-lg btn-success btn-block"
								value="Login" />
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>