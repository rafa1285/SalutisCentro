<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="app.name"/></title>
</head>
<body>
<h1>LISTADO DE TERAPEUTAS</h1>
	<table class="table table-bordered">
		<thead class="thead-dark">
		<tr>
			<%--<th><spring:message code="terapeuta.dni"/></th>--%>
			<th><spring:message code="terapeuta.nombre"/></th>
			<th><spring:message code="terapeuta.apellido1"/></th>
			<th><spring:message code="terapeuta.apellido2"/></th>
			<th><spring:message code="terapeuta.fecha_nacimiento" /></th>
			<%--<th><spring:message code="terapeuta.direccion" /></th>--%>
			<%--<th><spring:message code="terapeuta.telefono" /></th>--%>
			<th><spring:message code="terapeuta.email" /></th>
			<th><spring:message code="terapeuta.tipo_usuario_id" /></th>
			<th><spring:message code="terapeuta.especialidad_id" /></th>	
			<th><spring:message code="accion.editar" /></th>	
			<th><spring:message code="accion.eliminar" /></th>	
			<th><spring:message code="accion.citas" /></th>	
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${listaTerapeuta}" var="item">
			<tr>
				<%--<td>${item.dni}</td>--%>
				<td>${item.nombre}</td>
				<td>${item.apellido1}</td>
				<td>${item.apellido2}</td>
				<td>${item.fecha_nacimiento}</td>
				<%--<td>${item.direccion}</td>--%>
				<%--<td>${item.telefono}</td>--%>
				<td>${item.email}</td>				
				<td>${item.tipoUsuario.tipo}</td>
				<td>${item.especialidad_id.especialidad}</td>
				<td><a href="buscarTerapeutaEditar?id=${item.id_empleado}"><img src="../images/editar.jpg" height="24"></a></td>	
				<td><a href="borrarTerapeuta?id=${item.id_empleado}" onclick="return confirm('<spring:message code="accion.confirmar"/>');"><img src="../images/borrar.jpg" height="24"></a></td>	
				<td><a href="listarCitasTerapeuta?id=${item.id_empleado}"><spring:message code="accion.citas"/></a></td>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br>
	<a href="nuevoTerapeuta"><spring:message code="terapeuta.nuevo"/></a>
</body>
</html>