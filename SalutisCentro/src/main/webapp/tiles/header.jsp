<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	  <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="../inicio"><spring:message code="app.name"/></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        	        	
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="accion.paciente"/></a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="nuevoPaciente"><spring:message code="accion.nuevo"/></a>
		  	  <a class="dropdown-item" href="listarPaciente"><spring:message code="accion.listar"/></a>
            </div>
          </li>
          
             <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="accion.terapeuta"/></a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="nuevoTerapeuta"><spring:message code="accion.nuevo"/></a>
		  	  <a class="dropdown-item" href="listarTerapeuta"><spring:message code="accion.listar"/></a>
            </div>
          </li>
             
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><spring:message code="accion.idiomas"/></a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="inicio?lang=es"><spring:message code="idioma.es"/></a>
		  	  <a class="dropdown-item" href="inicio?lang=en"><spring:message code="idioma.en"/></a>
            </div>
          </li>

          
          <c:if test="${not empty sessionUser}">
				<li class="nav-item active"><a class="nav-link" href="../usuario/logout"><spring:message code="accion.logout"/></a></li>
		    </c:if>
        </ul>
      </div>
    </nav>