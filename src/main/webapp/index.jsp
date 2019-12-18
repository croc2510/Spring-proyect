<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%@page import="com.softtek.academia.controller.StateController"%>
<%@page import="com.softtek.academia.model.State"%>
<%@page import="com.softtek.academia.model.City"%>
<c:set var="names" value="Joe, Zhou" scope="page" />


<%

StateController controller = new StateController();
List<City> ciudades = controller.getCities();
pageContext.setAttribute("ciudades", ciudades);

%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

    
    


<table class="table">
  <thead class="thead-light">
    <tr>
      <th scope="col">Id Ciudad</th>
      <th scope="col">Ciudad</th>
      <th scope="col">Id Estado</th>
      <th scope="col">Estado</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${ciudades}" var="city">
   
   
   <!--  
   <c:if test="${  city.state.id eq 19   }">
       <tr style="background-color: blue;">
   </c:if>
   
   <c:if test="${  city.state.id ne 19   }">
       <tr>
   </c:if>
   -->
   
   <c:choose>
      <c:when test="${  city.state.id eq 19   }">
             <tr style="background-color: blue;">
      </c:when>
      
      <c:when test="${  city.state.id eq 23   }">
             <tr style="background-color:lime;">
      </c:when>
      <c:otherwise>
            <tr>
      </c:otherwise>
   </c:choose>
   
       <td><c:out value="${city.id}" />
       <td><c:out value="${city.description}" />
       <td><c:out value="${city.state.id}" />
       <td><c:out value="${city.state.description}" />
    </tr>
    </c:forEach>
    
    
  </tbody>
</table>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>