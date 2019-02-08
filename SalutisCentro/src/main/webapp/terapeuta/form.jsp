<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<h1>ALTA TERAPEUTA</h1>
	<form:form class="form-signin" modelAttribute="terapeuta" method="POST" action="guardarTerapeuta">
		<form:hidden path="id_empleado"/>

		<label for="dni" class="sr-only"><spring:message code="terapeuta.dni" var="labDni"/></label>
		<form:input path="dni" class="form-control" placeholder="${labDni}" maxlength="9" />
		<form:errors path="dni" cssClass="error" />	
		
		<label for="nombre" class="sr-only"><spring:message code="terapeuta.nombre" var="labNombre"/></label>
		<form:input path="nombre" class="form-control" placeholder="${labNombre}" maxlength="45" />
		<form:errors path="nombre" cssClass="error" />
		
		<label for="apellido1" class="sr-only"><spring:message code="terapeuta.apellido1" var="labApellido1"/></label>
		<form:input path="apellido1" class="form-control" placeholder="${labApellido1}" maxlength="45" />
		<form:errors path="apellido1" cssClass="error" />
		
	    <label for="apellido2" class="sr-only"><spring:message code="terapeuta.apellido2" var="labApellido2"/></label>
		<form:input path="apellido2" class="form-control" placeholder="${labApellido2}" maxlength="45" />
		<form:errors path="apellido2" cssClass="error" />		
									
		<%-- Formato de fecha --%>
		<spring:message code="terapeuta.fecha_nacimiento" var="labFecha_nacimiento"/>
		<fmt:formatDate value="${terapeuta.fecha_nacimiento}" pattern="dd/MM/yyyy" var="fecha_nacimiento"/>
		<form:input path="fecha_nacimiento" class="form-control" value="${fecha_nacimiento}" placeholder="${labFecha_nacimiento}"/>
		<form:errors path="fecha_nacimiento" cssClass="error" />
			
		<label for="direccion" class="sr-only"><spring:message code="terapeuta.direccion" var="labDireccion"/></label>
		<form:input path="direccion" class="form-control" value="${direccion}" placeholder="${labDireccion}" maxlength="100" />
		<form:errors path="direccion" cssClass="error" />			
		
		<label for="telefono" class="sr-only"><spring:message code="terapeuta.telefono" var="labTelefono"/></label>
		<form:input path="telefono" class="form-control" value="${telefono}" placeholder="${labTelefono}" maxlength="11" />
		<form:errors path="telefono" cssClass="error" />
		
		<label for="email" class="sr-only"><spring:message code="terapeuta.email" var="labEmail"/></label>
		<form:input type="email" path="email" class="form-control" value="${email}" placeholder="${labEmail}"/>
		<form:errors path="email" cssClass="error" />		
		
		<label for="especialidad" class="sr-only"><spring:message code="terapeuta.especialidad_id"/></label>
		<form:select path="especialidad_id.id_especialidad" class="form-control" items="${listaEspecialidad}" itemLabel="especialidad" itemValue="id_especialidad"/>
		
		<label for="tipoUsuario" class="sr-only"><spring:message code="terapeuta.tipo_usuario_id"/></label>
		<form:select path="tipoUsuario.id_tipo" class="form-control" items="${listaTipoUsuario}" itemLabel="tipo" itemValue="id_tipo"/>
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		
	</form:form>	
	
	<br>
	${msg}
	<br>
	<a href="listarTerapeuta"><spring:message code="accion.listar"/></a>
