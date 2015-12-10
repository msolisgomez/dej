


<%@page import="bean.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Producto> datos = (List<Producto>)
                    request.getAttribute("datos");
                    pageContext.setAttribute("datos",datos);
                    
                    
            
        %>
         
  
 <c:forEach var="obj" items="${datos}">
     <c:set var="precio" value="${obj.getPrecio()}"/>
<fmt:setLocale value="es_CL"/>

<c:out value="${obj.getId()}" /> - <c:out value="${obj.getNombre()}"/> - <fmt:formatNumber value="${obj.getPrecio()}" pattern="#,##0" /> <%--<c:out value="${obj.getPrecio()}" />--%>-<c:out value="${obj.getBaja()}" /><br>
             
</c:forEach>
            
          
            <%--
            <c:set value="${obj.getPrecio()}" var="formattedCurrency"/>
            <fmt:parseNumber value="${formattedCurrency}"
                type="currency"
                parseLocale="es-CL"
                var="parsedCurrency"/>
            <c:set value="${parsedCurrency}" var="updatedAmount"/>
            <fmt:setLocale value="es-CL"/>
            <fmt:formatNumber value="${updatedAmount}" type="currency"/>   
            --%>
            <%--
             <c:set var="precio" value="${obj.getPrecio()}" />
<fmt:formatNumber type="number" value="${obj.getPrecio()}" />
<br />
<fmt:parseNumber type="number" var="precio1" value="${obj.getPrecio()}" integerOnly="true" pattern="#.###.00" />
            <fmt:formatNumber type="number" value="${obj.getPrecio()}" />
            --%>
<%--
             <c:set value='${obj.getPrecio()}' var='precio'/>
        <fmt:parseNumber value='${obj.getPrecio()}'
            type='currency'
            parseLocale='es-CL'
            var='parsedCurrency'/>
        
        <fmt:setLocale value='es-CL'/>
        <fmt:formatNumber value='${obj.getPrecio()}' type='currency'/>
--%>


<%--
              
              <fmt:formatNumber value="" type="NUMBER"
                          minFractionDigits="2" maxFractionDigits="5" /><br>
              <fmt:formatNumber value="" type="NUMBER" maxFractionDigits="2" /><br>
--%>
<%--
<fmt:formatNumber value="${obj.getPrecio()}" type="NUMBER" pattern="#,###.00" /><br>
--%>
    </body>
</html>
