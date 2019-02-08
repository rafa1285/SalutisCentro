<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  


<h1>LISTADO DE CITAS</h1>
	<table class="table table-bordered">
	
		<thead class="thead-dark">
		<tr>
			<th><spring:message code="cita.fecha_cita"/></th>
			<th><spring:message code="cita.terapeuta"/></th>	
			<th><spring:message code="accion.editar"/></th>		
		</tr>
		</thead>
		<c:forEach items="${listaPaciente}" var="item">		
			<tr>
				<td>${item.fecha_cita}</td>
				<td>${item.terapeuta_id.nombre}</td>
				
				<td><a href="buscarCita?id=${item.id_cita}"><img src="../images/editar.jpg" height="24"></a></td>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="nuevoPaciente"><spring:message code="accion.inicio"/></a>
	<br>
	<td><a href="CitaNueva?id=${paciente.id_paciente}"><spring:message code="cita.nueva_cita"/></a></td>
