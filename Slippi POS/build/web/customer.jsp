<%-- 
    Document   : customer
    Created on : Aug 5, 2016, 11:29:20 PM
    Author     : blank
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
        <title>Customer</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="http://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <link href="css/inventorystyle.css" rel="stylesheet" type="text/css"/>
        <style>
            .cont1 {
                height: 550px;
                width : 80%;
                border-radius: 5px;
                background-color: white;
                border-color: black;
                margin: auto;
                padding: 10px;

            }
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
        <script>
            //data table
            $(document).ready(function () {
                $('#customertable').DataTable();
            });

            function get(str)
            {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        var responseArray = xmlhttp.responseText.split(",");
                        var ph = responseArray[0];
                        var email = responseArray[1];
                        var total = responseArray[2];

                        document.getElementById("ph").value = ph;
                        document.getElementById("email").value = email;
                        document.getElementById("total").value = total;

                    }
                }
                xmlhttp.open("GET", "searchForCustomer?custname=" + str, true);
                xmlhttp.send();
            }
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
            function gettransid(str)
            {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function ()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {

                        var responseArray = xmlhttp.responseText.split(",");
                        var total = responseArray[0];
                        document.getElementById("bill").value = total;
                    }
                }
                xmlhttp.open("GET", "searchForTransid?transid=" + str, true);
                xmlhttp.send();
            }

            function onInput1() {
                var val = document.getElementById("transdetailid").value;
                var opts = document.getElementById('transid').childNodes;

                for (var i = 0; i < opts.length; i++) {
                    if (opts[i].value === val) {
                        gettransid(val);
                        break;
                    }
                }
            }
        </script>

    </head>
    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/pointofsales"
                           user="root"  password="root"/>       
        <sql:query dataSource="${snapshot}" var="allCustomer">
            SELECT * from customer where id = '<%= session.getAttribute("username")%>';
        </sql:query> 
        <sql:query dataSource="${snapshot}" var="allTrans">
            SELECT * from transdetail where id = '<%= session.getAttribute("username")%>';
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
                    <li class="active"><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                    <li><a href="reportInformation" accesskey="r">Report (R)</a></li>
                    <li><a href="history.jsp" accesskey="h">History (H)</a></li></ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>
                </ul>
            </div><!--/.nav-collapse -->

        </nav> 
        <ul class="nav nav-pills">
            <li class="active"><a data-toggle="pill" href="#allcustomer">VIEW ALL CUSTOMER</a></li>
            <li><a data-toggle="pill" href="#edit">EDIT CUSTOMER</a></li>    

        </ul>
        <div class="tab-content">

            <div id="allcustomer" class="tab-pane fade in active">
                <h2 class="text-center">DEBTOR</h2>
                <form method="post" action="displayCustomerDetail">
                    <table id="customertable" class="display" cellspacing="0" width="100%">
                        <thead>
                            <tr>
                                <th>CUSTOMER NAME</th>
                                <th>PHONE NUMBER</th>
                                <th>EMAIL</th>
                                <th>TOTAL CREDIT</th> 
                                <th>VIEW</th> 
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>CUSTOMER NAME</th>
                                <th>PHONE NUMBER</th>
                                <th>EMAIL</th>
                                <th>TOTAL CREDIT</th>
                                <th>VIEW</th> 
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach var="row" items="${allCustomer.rows}">
                                <tr>
                                    <td>${row.custname}</td>
                                    <td>${row.ph}</td>
                                    <td>${row.email}</td>
                                    <td>${row.total}</td>
                                    <td> <button type="submit" name="passValue" value="${row.custno}" >VIEW</button></td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </form>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------- -->

            <div id="edit" class="tab-pane fade white">

                <div class="wrap">
                    <div class="Regisration">
                        <h2 class="text-center">Edit or Insert Customer</h2>
                        <div class="cont1">
                            <div class="container">
                                <form method="Post" id="addCustomer" name="addCustomer" action="searchForCustomer">


                                    <div class="col-md-6">  
                                        <p><b>CUSTOMER INFORMATION</b></p>
                                        <p>Name :</p> 

                                        <input list="text" id='list1' oninput='onInput()' name="customername"  required onkeyup="get(this.value)" /> 

                                        <datalist id="text">
                                            <c:forEach var="row" items="${allCustomer.rows}">
                                                <option value="${row.custname}">                                               
                                                </c:forEach>
                                        </datalist>

                                        <p>Phone Number :</p> <input type="text" id="ph" name="ph" required> 

                                        <p>Email : </p><input type="email" id="email" name="email">          

                                        <p>Total :</p> <input type="text" disabled id="total" name="total">                                              

                                    </div>
                                    <div class="col-md-6">
                                        <P><b>TRANSACTION DETAIL</b></P>
                                        <P>Transaction Number :</P>
                                        <input list="transid" id='transdetailid' oninput='onInput1()' name="transdetail" required onkeyup="gettransid(this.value)" /> 
                                        <datalist id="transid">
                                            <c:forEach var="row" items="${allTrans.rows}">
                                                <option value="${row.transid}">                                               
                                                </c:forEach>
                                        </datalist>
                                        <p>Total :</p> <input disabled type="text" id="bill" name="bill" >  
                                        <p>Remain :</p> <input type="number" step="any" required id="remain" name="remain">  
                                        <br>    
                                        <input type="submit" style="background-color:greenyellow">
                                    </div> 


                                    <input type="hidden" id="id" name="id" value="<%= session.getAttribute("username")%>"><br/>
                                   

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </body>
</html>

