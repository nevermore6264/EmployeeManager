<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@include file="/views/common/common.jsp"%>
<%@include file="/views/common/navigator.jsp"%>
<s:include value="/views/common/head.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Record</title>

<script type="text/javascript">
$(document).ready(
		function() {
	$("#name").select2();})
	function pagination(pageNo) {
		$("#pageNo").val(pageNo);
		$("#searchForm").submit();
	}

	$(function() {

		// Clear search conditional
		$('#btnClear').click(function() {
			$("#pageNo").val('');
			$("#name").val('');
			$("#type").val('');
			$("#searchForm").submit();
		})

	})
</script>

<s:head />
</head>
<body>

	<div class="container">
		<h1 align="center">
			<s:text name="label.record.title" />
		</h1>
		<br><br>
		<s:form method="GET" name="recordSearchForm" id="searchForm">
			<s:hidden name="pn" id="pageNo" />
		</s:form>
		<s:form method="GET"  name="recordSearchForm" id="searchForm" action="record"
			theme="bootstrap" cssClass="well form-vertical">
			<div style="width: 500px; float: left;">
				<s:select id="name" key="form.record.name"
					list="reEmployee" listKey="id" listValue="nameStaff" name="idStaff"
					class="form-control" />

			</div>
			<div style="width: 550px; float: left; margin-left: 50px;">
				<s:select id="type" name="type" key="form.record.type"
					list="#{true:'Khen thưởng',false:'Kỷ luật'}">
				</s:select>
			</div>

			<br>
			<br>
			<br>
			<s:submit cssClass="btn btn-primary" id="searchRecord"
				key="common.button.search" />
			<s:submit cssClass="btn btn-warning" id="btnClear"
				key="common.button.clear" />
			<br>
			<br>
		</s:form>
		<div class="row">
			<div class="col">
				<s:a action="inputCreateRecord" class="btn btn-success"> <i class="fas fa-plus-square"></i> <s:text
						name="common.button.create"></s:text>
				</s:a>
			</div>
		</div>
		<br> <br>
	<%@include file="/views/common/contraint.jsp"%>
	<s:include value="/views/common/paging.jsp" />
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th style="text-align: center;" scope="col">No.</th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.record.name" /></th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.record.type" /></th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.record.date" /></th>
					<th style="text-align: center;" scope="col"><s:text
							name="form.record.action" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator var="list" value="listRecord" status="loop">
					<tr>
						<th style="text-align: center;" scope="row">${loop.count}</th>
						<td><s:property value="#list.nameStaff" /></td>
						<td><s:if test="%{#list.type==true}">
								Khen thưởng
							</s:if> <s:elseif test="%{#list.type==false}">
								Kỷ luật
							</s:elseif></td>
						<td><s:property value="#list.date" /></td>
						<td style="width: 150px;"><s:a
								action="inputUpdateRecord?id=%{#list.id}">
								<font color="green" size="3"><i class="fas fa-edit"></i></font>
							</s:a> <s:a action="removeRecord?id=%{#list.id}"
								onclick="return confirm('Bạn có muốn xóa không ???')">
								<font color="red" size="3"><i class="fas fa-trash-alt"></i></font>
							</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		
	</div>
</body>
</html>