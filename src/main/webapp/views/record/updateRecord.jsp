<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update record</title>
<s:head />
</head>
<body>
	<div class="container" >
		<s:form action="updateRecord" theme="bootstrap" cssClass="well form-vertical">
			<h1 align="center"><s:text name="label.record.update"/></h1>
			<br>
			<div style="padding:0 350px 0 350px">
			<s:hidden name="id"></s:hidden>
			<s:text name="form.record.name"/>
			<s:select headerKey="0" 
					list="listEmployee" listKey="id" listValue="nameStaff" name="recordDto.idStaff" >
			</s:select>
			<div style="width: 300px;">
			<s:text name="form.record.type"/>
			<s:radio  name="recordDto.type" list="#{true:'Khen thưởng',false:'Kỷ luật'}" />
			</div> 
			<s:text name="form.record.date"/>
			<s:textfield  name="recordDto.date" />
			<s:text name="form.record.reason"/>
			<s:textarea  name="recordDto.reason" />
			</div>
			<br>
			<div align="center">
			<s:submit cssClass="btn btn-success" key="common.button.save" />
			<a href="<s:url action='record'/>" class="btn btn-warning">
						<i class="fas fa-chevron-left"></i> <s:text name="common.button.back"/>
					</a>
			 </div>
		</s:form>
	</div>
</body>
</html>