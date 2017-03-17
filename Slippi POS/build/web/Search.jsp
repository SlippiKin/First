<%-- 
    Document   : Search
    Created on : Aug 12, 2016, 2:39:02 AM
    Author     : blank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*" %>  
 <html>  
   <head>  
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
     <title>Insert title here</title>  
   </head>  
   <body>  
       alert("wrong");
     <%  
       String product = request.getParameter("search").toString();  
       String buff1 = "<div id='hint'>";  
       String buff2 = "<input type='text' name='name' value=''>";  
       String buff3 = "<input type='text' name='unit' value=''>";  
       String buff4 = "<input type='text' name='selling' value=''>";  
       String buff5 = "<input type='text' name='orderlevel' value=''>";  
       try {  
         Class.forName("com.mysql.jdbc.Driver");  
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pointofsales");  
         Statement stmt = conn.createStatement();  
         ResultSet rs = stmt.executeQuery("Select * from person where email_id= '" + product + "'");  
         while (rs.next()) {  
           buff1 = "email already exists" + "<br>";  
           buff2 = "<input type='text' name='name' value='" + rs.getString(2) + "'>";  
           buff3 = "<input type='text' name='unit' value='" + rs.getString(3) + "'>";  
           buff4 = "<input type='text' name='selling' value='" + rs.getString(4) + "'>";  
           buff5 = "<input type='text' name='orderlevel' value='" + rs.getString(5) + "'>";  
         }  
         buff1 = buff1 + "</div>";  
         buff2 = buff2 + "</input></div>";  
         buff3 = buff3 + "</input>";  
         buff4 = buff4 + "</input>";  
         buff5 = buff5 + "</input>";  
         response.getWriter().println(buff1 + "brk" + buff2 + "brk" + buff3 + "brk" + buff4 + "brk" + buff5);  
       } catch (Exception e) {  
         System.out.println(e);  
       }  
     %>  
   </body>  
 </html>  