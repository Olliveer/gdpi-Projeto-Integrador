<%-- 
    Document   : newjsp
    Created on : 03/12/2018, 20:15:12
    Author     : 2017203277
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
                String id = request.getParameter("id");
                
            %>
            
            <h1><%= id%></h1>
    </body>
</html>
