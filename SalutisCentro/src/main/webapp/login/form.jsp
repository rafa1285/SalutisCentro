
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<div class="card card-container">
		<img id="profile-img" class="profile-img-card"
			src="../images/logo.png" />
		<p id="profile-name" class="profile-name-card"></p>
		<form:form class="form-signin" modelAttribute="usuario" method="POST"
			action="../usuario/login">
			<%-- USUARIO --%>
			<label for="username" class="sr-only"><spring:message
					code="usuario.username" var="labUsuario" /></label>
			<form:input path="username" class="form-control"
				placeholder="${labUsuario}" />
			<form:errors path="username" cssClass="error" />
			<%-- PASSWORD --%>
			<label for="password" class="sr-only"><spring:message
					code="usuario.password" var="labClave" /></label>
			<form:password path="password" class="form-control"
				placeholder="${labClave}" />
			<form:errors path="password" cssClass="error" />
			<div id="remember" class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<input type="submit" value="<spring:message code="accion.login"/>" />
			<form:errors path="id_usuario" cssClass="errorblock" element="div" />
		</form:form>
		<a href="#" class="forgot-password"> Olvidastes la contraseña? </a>
	</div>
	<!-- /card-container -->
</div>
<!-- /container -->
<br>
${msg}

