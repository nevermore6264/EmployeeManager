<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

</head>
<s:head />
<body>
	<div class="container">
		<s:form action="createRecord" theme="bootstrap" cssClass="well form-vertical">
			<h1 align="center"><s:text name="label.record.create"/></h1>
			<br>
			<div style="padding:0 350px 0 350px">
				<s:text name="form.record.name"/>
			<s:select headerKey="0" list="reEmployeeDto"
								listKey="id" listValue="nameStaff" name="recordCreateForm.idStaff"
								class="form-control" />
						
			 <div style="width: 300px;" >
			<s:text name="form.record.type"/>
			<s:radio name="recordCreateForm.type" list="#{true:'Khen thưởng',false:'Kỷ luật'}" value="true"/>
			</div> 
			
			<s:text name="form.record.date"/>
			<s:textfield type="date"  name="recordCreateForm.date" />
			<s:text name="form.record.reason"/>
			<s:textarea  name="recordCreateForm.reason" />
			</div>
			<br>
			<div align="center">
			<s:submit  cssClass="btn btn-success" key="common.button.save" />
			<a href="<s:url action='record'/>" class="btn btn-warning">
						<i class="fas fa-chevron-left"></i> <s:text name="common.button.back"/>
					</a>
			</div>
		</s:form>
	</div>
</body>
</html>