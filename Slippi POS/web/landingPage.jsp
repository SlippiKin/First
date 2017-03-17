<%-- 
    Document   : landingPage
    Created on : Nov 16, 2016, 10:46:52 AM
    Author     : A645653
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <style>
            .labelling {font-size: 150%; color: black;
            }
            .mid {
                text-align:center;
                font-family: 'Lato', sans-serif;
            }

            .box2 {
                margin: auto;
                border-style:solid;
                border-color:black;
                width: 50%;
                height: 250px;
                border-radius: 5px;
                background-color: white;
                padding: 10px;
                font-weight: bold;
            }
        </style>

    </head>
    <body> 
        <nav class="navbar navbar-inverse ">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>
            </ul>
        </nav>   
        <div class="mid" >

            <div class="box2" >
                <label>Welcome, <%= session.getAttribute("username")%>!</label> <br>
                <p>Last Successful Login Time : ${sucess} </p>  <br>          
                
                <p>Last Unsuccessful Login Time : ${lusucess} </p>  <br>
               
                <p>Business Name : ${business}</p>  <br>  
                
                <form action="Home.jsp">
                    <br/>
                    <input type="submit" value="Enter" autofocus/>
                </form>
            </div>
        </div>    


    </body>
</html>
