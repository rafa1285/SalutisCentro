<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<img id="profile-img" class="profile-img-card"
			src="../images/paciente.png" />
<a href="nuevoPaciente"><spring:message code="accion.areaPacientes"/></a> 
<br>

<a href="nuevoTerapeuta"><spring:message code="accion.areaTerapeutas"/></a> 
<br>

<a href="../usuario/registrar"><spring:message code="accion.registrar"/></a>