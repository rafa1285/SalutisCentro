<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<h1>LISTADO DE DIAGNOSTICO</h1>
	<table class="table table-bordered">
	
		<thead class="thead-dark">
		<tr>
			<th><spring:message code="paciente.diagnostico"/></th>
			<th><spring:message code="diagnostico.paciente"/></th>				
			<th><spring:message code="diagnostico.terapeuta"/></th>	
			<th><spring:message code="accion.editar"/></th>		
		</tr>
		</thead>
		<c:forEach items="${listaPaciente}" var="item">		
			<tr>
				<td>${item.diagnostico}</td>
				<td>${item.paciente_id.nombre}</td>
				<td>${item.paciente_id.terapeuta_id.nombre}</td>
				
				<td><a href="buscarDiagnostico?id=${item.id_diagnostico}"><img src="../images/editar.jpg" height="24"></a></td>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	<td><a href="DiagnosticoNuevo?id=${paciente.id_paciente}"><spring:message code="diagnostico.nuevoDiagnostico"/></a></td>