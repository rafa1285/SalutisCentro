<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>ALTA PACIENTE</h1>
	<form:form class="form-signin" modelAttribute="paciente" method="POST" action="guardarPaciente">
		<form:hidden path="id_paciente"/>
		
		<label for="dni" class="sr-only"><spring:message code="paciente.dni" var="labDni"/></label>
		<form:input path="dni" class="form-control" placeholder="${labDni}" maxlength="9"/>
		<form:errors path="dni" cssClass="error" />	
		
		<label for="nombre" class="sr-only"><spring:message code="paciente.nombre" var="labNombre"/></label>
		<form:input path="nombre" class="form-control" placeholder="${labNombre}" maxlength="45" />
		<form:errors path="nombre" cssClass="error" />
		
		<label for="apellido1" class="sr-only"><spring:message code="paciente.apellido1" var="labApellido1"/></label>
		<form:input path="apellido1" class="form-control" placeholder="${labApellido1}" maxlength="45" />
		<form:errors path="apellido1" cssClass="error" />
		
		<label for="apellido2" class="sr-only"><spring:message code="paciente.apellido2" var="labApellido2"/></label>
		<form:input path="apellido2" class="form-control" placeholder="${labApellido2}" maxlength="45" />
		<form:errors path="apellido2" cssClass="error" />
			<%-- CORREGIR --%>
		<label for="fecha" class="sr-only"><spring:message code="paciente.fecha_nacimiento" var="labFecha"/></label>				
		<%-- Formato de fecha --%>
		<spring:message code="terapeuta.fecha_nacimiento" var="labFecha_nacimiento"/>
		<fmt:formatDate value="${paciente.fecha_nacimiento}" pattern="dd/MM/yyyy" var="labFecha"/>
		<form:input path="fecha_nacimiento" class="form-control" value="${fecha_nacimiento}" placeholder="${labFecha_nacimiento}"/>
	    <form:errors path="fecha_nacimiento" cssClass="error" />
			
		<label for="direccion" class="sr-only"><spring:message code="paciente.direccion" var="labDireccion"/></label>
		<form:input path="direccion" class="form-control" value="${direccion}" placeholder="${labDireccion}" maxlength="100" />
		<form:errors path="direccion" cssClass="error" />
		
		<label for="telefono" class="sr-only"><spring:message code="paciente.telefono" var="labTelefono"/></label>
		<form:input path="telefono" class="form-control" value="${telefono}" placeholder="${labTelefono}" maxlength="11" />
		<form:errors path="telefono" cssClass="error" />
		
		<label for="email" class="sr-only"><spring:message code="paciente.email" var="labEmail"/></label>
		<form:input type="email" path="email" class="form-control" value="${email}" placeholder="${labEmail}"/>
		<form:errors path="email" cssClass="error" />
		
		<label for="historial" class="sr-only"><spring:message code="paciente.historial" var="labHistorial"/></label>
		<form:textarea rows="5" cols="22" path="historial" class="form-control" value="${historial}" placeholder="${labHistorial}" maxlength="300"/>
		<form:errors path="historial" cssClass="error" />
		
		<label for="motivo_consulta" class="sr-only"><spring:message code="paciente.motivo_consulta" var="labMotivo_consulta"/></label>
		<form:input path="motivo_consulta" class="form-control" value="${motivo_consulta}" placeholder="${labMotivo_consulta}" maxlength="100"/>
		<form:errors path="motivo_consulta" cssClass="error" />
		
		<label for="terapeuta" class="sr-only"><spring:message code="paciente.terapeuta_id"/></label>
		<form:select path="terapeuta_id.id_empleado" class="form-control" items="${listaTerapeuta}" itemLabel="nombre" itemValue="id_empleado"/>
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		
	</form:form>
	<br>
	${msg}
	<br>
	<a href="listarPaciente"><spring:message code="accion.listar"/></a>
