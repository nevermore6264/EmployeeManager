<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Department</title>
<s:head />
</head>
<body>
	<div class="container" >
		<s:form action="updateDepart" theme="bootstrap" cssClass="well form-vertical">
			<h1 align="center">Sửa Phòng Ban</h1>
			<br>
			<div style="padding:0 350px 0 350px">
			<s:hidden name="id"></s:hidden>
			
			<s:textfield label="Mã phòng ban"  name="departmentDto.code" />
			<s:textfield label="Tên phòng ban" name="departmentDto.nameDepart" />
			</div>
			<br>
			<div align="center">
			<s:submit cssClass="btn btn-success" value="Sửa" />
			
			<a href="<s:url action='department'/>" class="btn btn-warning">
						<i class="fas fa-chevron-left"></i> Trở lại
					</a>
			 </div>
		</s:form>
	</div>
</body>
</html>