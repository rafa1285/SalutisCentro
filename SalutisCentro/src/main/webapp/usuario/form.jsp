<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


	<form:form class="form-signin" modelAttribute="usuario" method="POST" action="../usuario/registrar">
		
		<label for="username" class="sr-only"><spring:message code="usuario.username" var="labUsuario"/></label>
		<form:input path="username" class="form-control" placeholder="${labUsuario}"/>
		<form:errors path="username" cssClass="error" />
		<label for="password" class="sr-only"><spring:message code="usuario.password" var="labClave"/></label>
		<form:password path="password" class="form-control" placeholder="${labClave}"/>
		<form:errors path="password" cssClass="error" />
		<label for="claveRepetida" class="sr-only"><spring:message code="usuario.claveRepetida" var="labClaveRepetida"/></label>
		<form:password path="claveRepetida" class="form-control" placeholder="${labClaveRepetida}"/>
		<form:errors path="claveRepetida" cssClass="error" />
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		<form:errors path="id_usuario" cssClass="error" element="div" />
	</form:form>
