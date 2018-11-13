<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<title>Update employee</title>
</head>
<body>
	<div class="container" >
		<s:form theme="bootstrap" cssClass="well form-vertical" action="updateEmployeeSucces" enctype="multipart/form-data">
			<h1 align="center">Sua Nhan vien</h1>
			
			<br>
			<div style="padding:0 350px 0 350px">
			<s:hidden name="id"></s:hidden>
			<s:textfield  key="form.code" disabled="true"/>
			<s:textfield  key="form.nameStaff" />
			<s:select  list="#{'false':'Nu', 'true':'Nam'}"
			key="form.gender">
			</s:select>
			<s:textfield key="form.birthday" />
			<s:textfield  key="form.photo" type="file"/>
			<s:textfield  key="form.email" type="email"/>
			<s:textfield  key="form.phone"  type="number"/>
			<s:textfield  key="form.salary" type="number" />
			<s:textarea  key="form.note" />
			
			<s:select headerKey="0" 
					list="listDepart" listKey="id" listValue="nameDepart" key="form.idDepart" >
			</s:select>
			</div>
			<br>
			<div align="center">
			<s:submit cssClass="btn btn-success" key="common.button.save" />
			<a href="<s:url action='employee'/>" class="btn btn-warning">
						<i class="fas fa-chevron-left"></i> <s:text name="common.button.back" />
					</a>
			 </div>
		</s:form>
	</div>
</body>
</html>