	<s:if test="%{#session.sessionMessageDto != null}">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				<span class="glyphicon glyphicon-check"></span>
				<s:property value="%{#session.sessionMessageDto}" />
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<s:set var="sessionMessageDto" value="" scope="session" />
		</s:if>