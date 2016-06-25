<%@ page import="java.util.Enumeration" %>
<%
    Enumeration paramNames = request.getParameterNames();
    while(paramNames.hasMoreElements()) {
        String paramName = (String)paramNames.nextElement();

        String paramValue = request.getParameter(paramName);

    }
%>
