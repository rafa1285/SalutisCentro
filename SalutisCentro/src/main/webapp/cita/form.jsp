<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>NUEVA CITA</h1>

<c:if test = "${paciente.id_paciente != null}" var="modificar"/>

	<form:form class="form-signin" modelAttribute="cita" method="POST" action="guardarCita">
	<form:hidden path="id_cita"/>
	<form:hidden path="paciente_id.id_paciente" value="${paciente.id_paciente}"/>
		 
		<label for="dni" class="sr-only"><spring:message code="paciente.dni"/></label>
		<form:input path="paciente_id.dni" class="form-control" placeholder="${paciente.dni}" maxlength="9" disabled="${modificar}"/>
		<form:errors path="paciente_id.dni" cssClass="error" />	
		
		<label for="nombre" class="sr-only"><spring:message code="terapeuta.nombre"/></label>
		<form:input path="paciente_id.nombre" class="form-control" placeholder="${paciente.nombre}" maxlength="45" disabled="${modificar}"/>
		<form:errors path="paciente_id.nombre" cssClass="error" />
		
		<label for="apellido1" class="sr-only"><spring:message code="terapeuta.apellido1"/></label>
		<form:input path="paciente_id.apellido1" class="form-control" placeholder="${paciente.apellido1}" maxlength="45" disabled="${modificar}" />
		<form:errors path="paciente_id.apellido1" cssClass="error" />
		
	    <label for="apellido2" class="sr-only"><spring:message code="terapeuta.apellido2"/></label>
		<form:input path="paciente_id.apellido2" class="form-control" placeholder="${paciente.apellido2}" maxlength="45" disabled="${modificar}"/>
		<form:errors path="paciente_id.apellido2" cssClass="error" />	
		
		
		<%-- Formato de fecha --%>
		<spring:message code="cita.fecha_cita" var="labFecha"/>
		<%-- Esta linea es solo para cuando editemos fecha --%>
		<%--<fmt:formatDate value="${cita.fecha_cita}" pattern="dd/MM/yyyy" var="labFecha"/>--%>
		<form:input path="fecha_cita" class="form-control" value="${cita.fecha_cita}" placeholder="${labFecha}"/>
	    <form:errors path="fecha_cita" cssClass="error" />	
		
		<label for="terapeuta" class="sr-only"><spring:message code="paciente.terapeuta_id"/></label>
        <form:select path="terapeuta_id.id_empleado" items="${listaTerapeuta}" itemLabel="nombre" itemValue="id_empleado"/>
		
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="<spring:message code="accion.guardar"/>"/>
		
	</form:form>	
	
	<br>
	${msg}
	<br>

