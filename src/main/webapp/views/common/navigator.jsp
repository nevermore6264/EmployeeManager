<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/views/common/common.jsp"%>
<s:include value="/views/common/head.jsp" />
</head>
<body>
	<div class="container">
	
		
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="<s:url  action='homepage'/>"><s:text name="homepage" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link"
						href="<s:url action='department'/>"><s:text name="department" /></a></li>
					<li class="nav-item "><a class="nav-link"
						href="<s:url action='employee'/>"><s:text name="employee" /></a></li>
					<li class="nav-item "><a class="nav-link"
						href="<s:url action='record'/>"><s:text name="record" /></a></li>
						<li class="nav-item "><a class="nav-link"
						href="<s:url action='account'/>"><s:text name="account" /></a></li>
					<li class="nav-item "><a class="nav-link"
						href="<s:url action='statics'/>"><s:text name="static"/></a></li>
				</ul>
				<ul class="navbar-nav mr-auto">
					<li class="nav-item "><a class="nav-link" href="?request_locale=en">EN</a></li>
					<li class="nav-item "><a class="nav-link" href="?request_locale=vi">VN</a></li>
					<li class="nav-item "><a class="nav-link" href="logout"><s:text
								name="logout" /></a></li>
				</ul>
			</div>
			
		</nav>
	</div>
</body>
</html>