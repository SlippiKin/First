<%-- 
    Document   : supplier
    Created on : Aug 19, 2016, 2:26:35 AM
    Author     : blank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/inventorystyle.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="http://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script>
            //tab function
            function openCity(evt, cityName) {
                var i, tabcontent, tablinks;
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }
                document.getElementById(cityName).style.display = "block";
                evt.currentTarget.className += " active";
            }
            //data table
            $(document).ready(function () {
                $('#suppliertable').DataTable();
            });


            //Call AJAX
            //detect datalist changed
            function onInput() {
                var val = document.getElementById("list1").value;
                var opts = document.getElementById('text').childNodes;

                for (var i = 0; i < opts.length; i++) {
                    if (opts[i].value === val) {
                        get(val);

                        break;

                    }
                }


            }

            //AJAX for get product information
            function get(str)
            {

                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {

                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {

                        var responseArray = xmlhttp.responseText.split(",");
                        var address = responseArray[0];
                        var number = responseArray[1];
                        var salesman = responseArray[2];
                        var email = responseArray[3];
                        document.getElementById("address").value = address;
                        document.getElementById("number").value = number;
                        document.getElementById("salesman").value = salesman;
                        document.getElementById("email").value = email;

                    }
                }
                xmlhttp.open("GET", "searchForSupplier?sname=" + str, true);
                xmlhttp.send();
            }
        </script>
        <style>
            .center{
                text-align: center;
            }
            table a:link {
                color: #666;
                font-weight: bold;
                text-decoration:none;
            }
            table a:visited {
                color: #999999;
                font-weight:bold;
                text-decoration:none;
            }
            table a:active,
            table a:hover {
                color: #bd5a35;
                text-decoration:underline;
            }
            table {
                font-family:Arial, Helvetica, sans-serif;
                color:#666;
                font-size:12px;
                text-shadow: 1px 1px 0px #fff;
                background:#eaebec;
                margin:20px;
                border:#ccc 1px solid;

                -moz-border-radius:3px;
                -webkit-border-radius:3px;
                border-radius:3px;

                -moz-box-shadow: 0 1px 2px #d1d1d1;
                -webkit-box-shadow: 0 1px 2px #d1d1d1;
                box-shadow: 0 1px 2px #d1d1d1;
            }
            table th {
                padding:21px 25px 22px 25px;
                border-top:1px solid #fafafa;
                border-bottom:1px solid #e0e0e0;

                background: #ededed;
                background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
                background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
            }
            table th{
                text-align: center;
                padding-left:20px;
            }
            table tr{
                -moz-border-radius-topleft:3px;
                -webkit-border-top-left-radius:3px;
                border-top-left-radius:3px;
            }
            table tr:first-child th:last-child {
                -moz-border-radius-topright:3px;
                -webkit-border-top-right-radius:3px;
                border-top-right-radius:3px;
            }
            table tr {
                text-align: center;
                padding-left:20px;
            }
            table td{
                text-align: center;
                padding-left:20px;
                border-left: 0;
            }
            table td {
                padding:18px;
                border-top: 1px solid #ffffff;
                border-bottom:1px solid #e0e0e0;
                border-left: 1px solid #e0e0e0;

                background: #fafafa;
                background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
                background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
            }
            table tr.even td {
                background: #f6f6f6;
                background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
                background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
            }
            table tr:last-child td {
                border-bottom:0;
            }
            table tr:last-child td:first-child {
                -moz-border-radius-bottomleft:3px;
                -webkit-border-bottom-left-radius:3px;
                border-bottom-left-radius:3px;
            }
            table tr:last-child td:last-child {
                -moz-border-radius-bottomright:3px;
                -webkit-border-bottom-right-radius:3px;
                border-bottom-right-radius:3px;
            }
            table tr:hover td {
                background: #f2f2f2;
                background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
                background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
            }
        </style>
    </head>
    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/pointofsales"
                           user="root"  password="root"/>       
        <sql:query dataSource="${snapshot}" var="allSupplier">
            SELECT * from supplier where id = '<%= session.getAttribute("username")%>';
        </sql:query> 
        
        <nav class="navbar navbar-inverse ">

            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li ><a href="Home.jsp" accesskey="a">Sales (A)</a></li>
                    <li><a href="inventory.jsp" accesskey="i">Inventory (I)</a></li>
                    <li class="active"><a href="supplier.jsp" accesskey="s">Supplier (S)</a></li>
                    <li><a href="shelf.jsp" accesskey="y">Shelf (Y)</a></li> 
                    <li><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                    <li><a href="reportInformation" accesskey="r">Report (R)</a></li>
                    <li><a href="history.jsp" accesskey="h">History (H)</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </nav> 

        <ul class="nav nav-pills">
            <li class="active"><a data-toggle="pill" href="#allSupplier">View Supplier</a></li>
            <li><a data-toggle="pill" href="#edit">Edit or Create New Supplier</a></li>

        </ul>
        <div class="tab-content">
            <div id="allSupplier" class="tab-pane fade in active">

                <h2 class="text-center">  Supplier</h2>
                <table id="suppliertable" class="display" cellspacing="0" width="100%" style="width: 100%">
                    <thead>
                        <tr>
                            <th>NO.</th>
                            <th>COMPANY NAME</th>
                            <th>NAME</th>
                            <th>ADDRESS</th>
                            <th>PHONE NUMBER</th>
                            <th>EMAIL</th>

                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>NO.</th>
                            <th>COMPANY NAME</th>
                            <th>NAME</th>
                            <th>ADDRESS</th>
                            <th>PHONE NUMBER</th>
                            <th>EMAIL</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:set var="count" value="0" scope="page" />
                        <c:forEach var="row" items="${allSupplier.rows}">
                            <c:set var="count" value="${count + 1}" scope="page"/>
                            <tr>
                                <td>${count}</td>
                                <td>${row.sname}</td>
                                <td>${row.sellman}</td>
                                <td>${row.address}</td>
                                <td>${row.hp}</td>
                                <td>${row.email}</td>

                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
            <div id="edit" class="tab-pane fade">
                <div class="wrap">
                    <div class="Regisration">
                        <h2 class="text-center">EDIT OR INSERT SUPPLIER</h2>
                        <form method="Get" name="supplierform" action="addSupplier" id="supplierform">
                            <div class="col-md-6">                       
                               
                                            <p>Supplier Company Name :</p> 

                                            <input list="text" id='list1' oninput='onInput()' name="sname" autofocus required onkeyup="get(this.value)"/> 

                                            <datalist id="text">
                                                <c:forEach var="row" items="${allSupplier.rows}">
                                                    <option value="${row.sname}">    

                                                    </c:forEach>
                                            </datalist>
                                   
                                            <p>Phone Number : (eg: 0191231631)</p> 
                                            <input type="text" pattern="[0-9]{10}" required="" name="phonenumber" id="number"> 
                                  

                            </div>
                            <div class="col-md-6">
                                <p>Sells Agent Name :</p> 
                                <input type="text" name="agent" id="salesman"/>           
                                <p>Email Address :</p> 
                                <input type="email" name="email" id="email"/>   
                            </div>
                            <div class="col-md-12">
                                <p>Address :</p>
                                <textarea rows="4" name="address" cols="50" form="supplierform" id="address">

                                </textarea>          
                                <input type="hidden" id="idn" name="idn" value="<%= session.getAttribute("username")%>"><br/>
                                <input type="submit" style="background-color: greenyellow; width: 30%" value="Save"/>
                            </div>


                        </form>

                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
