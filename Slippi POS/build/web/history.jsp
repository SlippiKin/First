<%-- 
    Document   : history
    Created on : Aug 5, 2016, 11:30:20 PM
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
        <title>History</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="http://localhost:47617/Scripts/jquery-1.9.1.min.js"></script>
        <link href="css/inventorystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="http://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

        <script>
            //table onclick
            function p() {
                var table = document.getElementById("transactiontable");
                if (table != null) {
                    for (var i = 0; i < table.rows.length; i++) {
                        for (var j = 0; j < 1; j++)
                            table.rows[i].cells[j].onclick = function () {
                                tableText(this);
                            };
                    }
                }
            }
            function tableText(tableCell) {
                //alert(tableCell.innerHTML);
                var number = tableCell.innerHTML;
                document.getElementById("passValue").value = number;
                document.getElementById("passHidden").submit();
            }
            window.onload = p;

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
                $('#transactiontable').DataTable();
            });
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
        <sql:query dataSource="${snapshot}" var="allTransaction">
            SELECT * from TransDetail where id = '<%= session.getAttribute("username")%>';
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
                    <li ><a href="supplier.jsp" accesskey="s">Supplier (S)</a></li>
                    <li><a href="shelf.jsp" accesskey="y">Shelf (Y)</a></li> 
                    <li ><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                    <li><a href="reportInformation" accesskey="r">Report (R)</a></li>
                    <li class="active"><a href="history.jsp" accesskey="h">History (H)</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </nav> 
        <h2 class="text-center">  Previous Transaction </h2>
        <form method="post" target="_blank" action="displayBill" id="passHidden" name="passHidden">
            <table id="transactiontable" class="display" cellspacing="0" width="100%" style="width: 100%">
                <thead>
                    <tr>
                        <th>NO.</th>
                        <th>DATE</th>
                        <th>TIME</th>
                        <th>TOTAL</th>
                        <th>VIEW</th>

                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>NO.</th>
                        <th>DATE</th>
                        <th>TIME</th>
                        <th>TOTAL</th>
                        <th>VIEW</th>

                    </tr>
                </tfoot>
                <tbody>

                
                <c:set var="count" value="0" scope="page" />
                <c:forEach var="row" items="${allTransaction.rows}">
                    <c:set var="count" value="${count + 1}" scope="page"/>
                    <tr>
                        <td>${count}</td> 
                        <td>${row.date}</td>
                        <td>${row.time}</td>
                        <td>${row.total}</td>
                        <td> <button type="submit" name="passValue" value="${count}" >VIEW</button></td>
                    
                    </tr>
                </c:forEach> 


                </tbody> 
            </table>
        </form>

    </body>
</html>


