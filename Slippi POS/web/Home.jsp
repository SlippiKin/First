<%-- 
    Document   : Home
    Created on : Aug 5, 2016, 3:57:08 PM
    Author     : blank
--%>

<%@page import="java.io.PrintWriter"%>
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
        <title>Home</title>
        <script src="js/angular.min.js" type="text/javascript"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link href="css/inventorystyle.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="http://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <style >

            .cont1 {
                height: 20%;
                width : 100%;
                border-radius: 5px;
                border-color: transparent;
                background-color: white;
            }

            #outer > table a:link {
                color: #666;
                font-weight: bold;
                text-decoration:none;
            }
            #outer > table a:visited {
                color: #999999;
                font-weight:bold;
                text-decoration:none;
            }
            #outer > table a:active,
            #outer > table a:hover {
                color: #bd5a35;
                text-decoration:underline;
            }
            #outer > table {
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
            #outer > table th {
                padding:21px 25px 22px 25px;
                border-top:1px solid #fafafa;
                border-bottom:1px solid #e0e0e0;

                background: #ededed;
                background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
                background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
            }
            #outer > table th{
                text-align: center;
                padding-left:20px;
            }
            #outer > table tr{
                -moz-border-radius-topleft:3px;
                -webkit-border-top-left-radius:3px;
                border-top-left-radius:3px;
            }
            #outer > table tr:first-child th:last-child {
                -moz-border-radius-topright:3px;
                -webkit-border-top-right-radius:3px;
                border-top-right-radius:3px;
            }
            #outer > table tr {
                text-align: center;
                padding-left:20px;
            }
            #outer > table td{
                text-align: center;
                padding-left:20px;
                border-left: 0;
            }
            #outer > table td {
                padding:18px;
                border-top: 1px solid #ffffff;
                border-bottom:1px solid #e0e0e0;
                border-left: 1px solid #e0e0e0;

                background: #fafafa;
                background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
                background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
            }
            #outer > table tr.even td {
                background: #f6f6f6;
                background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
                background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
            }
            #outer > table tr:last-child td {
                border-bottom:0;
            }
            #outer > table tr:last-child td:first-child {
                -moz-border-radius-bottomleft:3px;
                -webkit-border-bottom-left-radius:3px;
                border-bottom-left-radius:3px;
            }
            #outer > table tr:last-child td:last-child {
                -moz-border-radius-bottomright:3px;
                -webkit-border-bottom-right-radius:3px;
                border-bottom-right-radius:3px;
            }
            #outer > table tr:hover td {
                background: #f2f2f2;
                background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
                background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
            }

            #containernote {
                background-color: white;
                border-style: solid;
                border-color: black;
                overflow: auto;
                width: 100%;
                height: 420px;
                border-radius: 5px;
                overflow-x: hidden;
            }
            .cont2 {
                height: 50%;
                border-style:solid;
                border-color:black;
                padding:5px 5px 5px 5px;
                width : 100%;
                border-radius: 5px;
                background-color: white;
            }
            html, body {
                height: 100%;
            }
            .fill-height {

                height: 200px; /* cross-browser */
            }
            .top img {  
                width:50%;
                height: 100px;
            }
            .no-gutter [class*="-6"] {
                padding-left:0;
            }

            p.sansserif {
                font-family: Arial, Helvetica, sans-serif;
            }
            table {
                border-collapse: collapse;
                width: 100%;
                table-layout:fixed;

            }
            #purchaselist tr:nth-child(even) {background: #CCC}
            #purchaselist tr:nth-child(odd) {background: #FFF}
            #purchaselist tr:hover td {background:background; color: white}



            th {
                background-color: #4CAF50;
                color: white;
            }

            .trns input[type="text"],input[type="number"] {
                border: none;
                background: transparent;
                /*background-color: blue;*/
            }
            .boxwidth { width:100%; height:100%;  }
            .scrollable {overflow:auto;}

        </style>
        <script>

          

            //time
            var app = angular.module('myApp', []);
            app.controller('myCtrl', function($scope, $interval) {
            $scope.theTime = new Date().toLocaleTimeString();
            $interval(function () {
            $scope.theTime = new Date().toLocaleTimeString();
            }, 1000);
            });
            app.controller('Ctrl', function ($scope) {
            $scope.date = new Date();
            });
            //modal pass value
            function modalPass(number) {
            $("#producttable").DataTable().search("").draw();
            var table = document.getElementById("producttable");
            var barcode = "";
            barcode = table.rows[number].cells[1].innerText;
            document.getElementById("insertbarcode").value = barcode;
            addRow('purchaselist');
            }
            //data table
            $(document).ready(function () {
            $('#producttable').DataTable();
            });
            //delete
            function deleteRow(tableID) {
            try {

            var table = document.getElementById("purchaselist");
            var rowCount = table.rows.length;
            for (var i = 0; i < rowCount; i++) {
            var row = table.rows[i];
            var chkbox = row.cells[1].childNodes[0];
            if (null != chkbox && true == chkbox.checked) {
            table.deleteRow(i);
            rowCount--;
            i--;
            }
            }
            for (var i = 0; i < rowCount; i++)
            {
            document.getElementById("purchaselist").rows[i].cells[0].innerHTML = i + 1;
            }
            checkRow();
            document.getElementById("insertbarcode").focus();
            } catch (e) {
            alert(e);
            }
            }

            //prompt change balance
            function balanceCheck() {
            var amount = prompt("How much customer paid", "");
            var total = document.getElementById('totalpayment').innerText;
            var change = Math.round((parseFloat(amount) - parseFloat(total)) * 100) / 100;
            if (amount != null) {

            if (change >= 0) {
            document.getElementById("billing").submit();
            var Table = document.getElementById("purchaselist");
            Table.innerHTML = "";
            alert("change : RM " + change);
            } else {
            alert("Customer pay less then the total amount of product");
            }
            }
            }

            //check tablerow is 0 or not if zero set price to RM0 after delete
            function checkRow() {
            var table = document.getElementById("purchaselist");
            var rowCount = table.rows.length;
            if (rowCount == 0) {

            document.getElementById('paymentvalue').value = "0";
            document.getElementById('totalpayment').innerText = "0";
            }
            }

            //space enter to bill
            $(window).keypress(function (e) {
            if (e.keyCode === 0 || e.keyCode === 32) {
            pay();
            }
            });
            //button for pay
            function pay() {
            var total = document.getElementById("totalpayment").innerText;
            if (total <= 0) {
            alert("Please enter at least 1 item.");
            } else {
            var table = document.getElementById("purchaselist");
            var rowCount = table.rows.length;
            if (rowCount == 0) {

            } else {
            balanceCheck();
            }
            }
            document.getElementById("insertbarcode").focus();
            }

            //AJAX for get product information
            //button trigger add
            function addRow(tableID) {
            var barcode = document.getElementById('insertbarcode').value;
            var rowCount = 0;
            var count = document.getElementById(tableID);
            var rowCount1 = count.rows.length;
            var same = 0;
            var tablebarcode = "";
            var currentvalue = 0;
            if (rowCount1 > 0) {

            for (var i = 0; i < rowCount1; i++)
            {
            tablebarcode = document.getElementById("purchaselist").rows[i].cells[2].getElementsByTagName("input")[0].value;
            if (tablebarcode === barcode) {
            same = 1;
            currentvalue = document.getElementById("purchaselist").rows[i].cells[4].getElementsByTagName("input")[0].value;
            currentvalue = parseInt(currentvalue) + 1;
            document.getElementById("purchaselist").rows[i].cells[4].getElementsByTagName("input")[0].value = currentvalue;
            var price = document.getElementById("purchaselist").rows[i].cells[4].getElementsByTagName("input")[0].value;
            var total = parseInt(currentvalue) * parseInt(price);
            document.getElementById('totalpayment').innerText = total;
            document.getElementById('paymentvalue').value = total;
            }
            }
            }
            if (barcode === "") {

            } else if (barcode !== "" && same === 0)
            {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function ()
            {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
            {

            var responseArray = xmlhttp.responseText.split(",");
            var proname = responseArray[0];
            var sellingprice = responseArray[2];
            var gst = responseArray[4];
            var table = document.getElementById(tableID);
            rowCount = table.rows.length;
            if (proname === "") {
            } else {
            var row = table.insertRow(rowCount);
            var cell2 = row.insertCell(0);
            cell2.innerHTML = rowCount + 1;
            var cell1 = row.insertCell(1);
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name = "chkbox[]";
            cell1.appendChild(element1);
            var cell3 = row.insertCell(2);
            var element3 = document.createElement("input");
            element3.type = "text";
            element3.name = "barcodetext";
            element3.value = barcode;
            cell3.appendChild(element3);
            var cell4 = row.insertCell(3);
            var element4 = document.createElement("input");
            element4.type = "text";
            element4.name = "name";
            element4.value = proname;
            cell4.appendChild(element4);
            var cell5 = row.insertCell(4);
            var element5 = document.createElement("input");
            element5.type = "number";
            element5.name = "quantity";
            element5.id = "quantity";
            element5.className = "quantity";
            element5.onchange = onclick = function () {
            var td4 = document.querySelectorAll('#purchaselist > tbody > tr > td:nth-last-child(2) ');
            var td5 = document.querySelectorAll('#purchaselist > tbody > tr > td:last-child');
            var total = 0;
            var q = 0;
            var p = 0;
            if (td4.length === 0) {

            q = document.getElementById("purchaselist").rows[0].cells[4].getElementsByTagName("input")[0].value;
            p = document.getElementById("purchaselist").rows[0].cells[5].getElementsByTagName("input")[0].value;
            total = parseFloat(p) * parseFloat(q);
            } else {
            for (var i = 0; i < td5.length; i++)
            {

            q = document.getElementById("purchaselist").rows[i].cells[4].getElementsByTagName("input")[0].value;
            p = document.getElementById("purchaselist").rows[i].cells[5].getElementsByTagName("input")[0].value;
            total += parseFloat(p) * parseFloat(q);
            }
            }
            document.getElementById('totalpayment').innerText = total;
            document.getElementById('paymentvalue').value = total;
            };
            element5.value = "1";
            cell5.appendChild(element5);
            var cell6 = row.insertCell(5);
            var element6 = document.createElement("input");
            element6.type = "number";
            element6.className = "price";
            element6.id = "price";
            element6.name = "price";
            element6.onchange = onclick = function () {
            var td4 = document.querySelectorAll('#purchaselist > tbody > tr > td:nth-last-child(2) ');
            var td5 = document.querySelectorAll('#purchaselist > tbody > tr > td:last-child');
            var total = 0;
            var q = 0;
            var p = 0;
            if (td4.length === 0) {

            q = document.getElementById("purchaselist").rows[0].cells[3].getElementsByTagName("input")[0].value;
            p = document.getElementById("purchaselist").rows[0].cells[4].getElementsByTagName("input")[0].value;
            total = parseFloat(p) * parseFloat(q);
            } else {
            for (var i = 0; i < td5.length; i++)
            {

            q = document.getElementById("purchaselist").rows[i].cells[4].getElementsByTagName("input")[0].value;
            p = document.getElementById("purchaselist").rows[i].cells[5].getElementsByTagName("input")[0].value;
            total += parseFloat(p) * parseFloat(q);
            }
            }
            document.getElementById('totalpayment').innerText = total;
            document.getElementById('paymentvalue').value = total;
            };
            element6.value = sellingprice;
            cell6.appendChild(element6);
            sumTransaction();
            }
            }
            }
            xmlhttp.open("GET", "searchForInventoryform?barcode=" + barcode, true);
            xmlhttp.send();
            }
            document.getElementById('insertbarcode').value = "";
            document.getElementById('insertbarcode').focus();
            }

            //calculate
            function sumTransaction()
            {
            var td4 = document.querySelectorAll('#purchaselist > tbody > tr > td:nth-last-child(2)');
            var td5 = document.querySelectorAll('#purchaselist > tbody > tr > td:last-child');
            var total = 0;
            var q = 0;
            var p = 0;
            if (td4.length === 0) {

            q = document.getElementById("purchaselist").rows[0].cells[4].getElementsByTagName("input")[0].value;
            p = document.getElementById("purchaselist").rows[0].cells[5].getElementsByTagName("input")[0].value;
            total = parseFloat(p) * parseFloat(q);
            } else {
            for (var i = 0; i < td5.length; i++)
            {

            q = document.getElementById("purchaselist").rows[i].cells[4].getElementsByTagName("input")[0].value;
            p = document.getElementById("purchaselist").rows[i].cells[5].getElementsByTagName("input")[0].value;
            total += parseFloat(p) * parseFloat(q);
            }
            }
            document.getElementById('totalpayment').innerText = total;
            document.getElementById('paymentvalue').value = total;
            }



        </script>
    </head>
    <body ng-app="myApp" > 
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/pointofsales"
                           user="root"  password="root"/>       
        <sql:query dataSource="${snapshot}" var="allProduct">
            SELECT * from product where id = '<%= session.getAttribute("username")%>';
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

                    <li class="active"><a href="Home.jsp" accesskey="a">Sales (A)</a></li>
                    <li><a href="inventory.jsp" accesskey="i">Inventory (I)</a></li>
                    <li><a href="supplier.jsp" accesskey="s">Supplier (S)</a></li>
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
        <label>Welcome : <%= session.getAttribute("username")%> </label>
        <div class="col-md-12">
            <div class="col-md-12">
                <div class="cont1">
                    <table border="0">

                        <tr>
                            <td style="width:350px"> 
                                <table border="0">
                                    <tr>
                                        <td style="width:100px"><p>Barcode : </p></td>
                                        <td><input type="text" style="display:inline" width="120px" id="insertbarcode" name="insertbarcode" autofocus onkeydown = "if (event.keyCode == 13)
                                                    document.getElementById('barcodebutton').click()" onkeyup="if (event.keyCode == 32) {
                                                        balanceCheck();
                                                        }"/> 
                                        </td>    
                                    </tr>
                                </table>

                            </td>
                            <td style="width:100px">
                                <button style="width:90px;" class="btn btn-info btn-lg" type="button" id="barcodebutton" onclick="addRow('purchaselist')" >Add</button> 
                            </td>
                            <td style="width:100px">
                                <button style="width:90px;" class="btn btn-info btn-lg" type="button" id="delete" onclick="deleteRow('purchaselist')" >Delete</button> 
                            </td>
                            <td>
                                <button  type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="search">Search</button>
                            </td>
                            <td>
                                <div ng-controller="Ctrl">
                                    <h1 style="text-align: right">{{date| date:'yyyy-MM-dd'}}</h1>
                                </div>

                            </td>
                            <td>
                                <div ng-controller="myCtrl">
                                    <h1 style="text-align: right">{{theTime}}</h1>
                                </div>

                            </td>
                        </tr>
                    </table>
                    <!-- Button to trigger modal -->
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Product Information</h4>
                                </div>
                                <div class="modal-body">
                                    <div id="outer">
                                        <table id="producttable" class="display" cellspacing="0" width="90%">
                                            <thead>
                                                <tr>
                                                    <th>SELECT</th>
                                                    <th>BARCODE</th>
                                                    <th>NAME</th>                           
                                                    <th>SELLING PRICE</th>                        
                                                    <th>CURRENT QUANTITY</th>
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>SELECT</th>
                                                    <th>BARCODE</th>
                                                    <th>NAME</th>        
                                                    <th>SELLING PRICE</th>
                                                    <th>CURRENT QUANTITY</th>
                                                </tr>
                                            </tfoot>
                                            <tbody style="text-align: center">
                                                <c:set var="countTotal" value="0" scope="page" />  
                                                <c:forEach var="row" items="${allProduct.rows}">
                                                    <c:set var="countTotal" value="${countTotal + 1}" scope="page"/>
                                                    <tr >
                                                        <td><button value="${row.barcode}" onclick="modalPass(${countTotal})" data-dismiss="modal">Select</button></td>

                                                        <td>${row.barcode}</td>
                                                        <td>${row.proname}</td>
                                                        <td>${row.sellingprice}</td>
                                                        <td>${row.currentquantity}</td>                                             
                                                    </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>


                    <form id="billing" action="billing" method="get" >
                        <div id="containernote" class="trns">
                            <table border="1">
                                <col width="10px">
                                <col width="1%">
                                <col width="7%">
                                <col width="10%">
                                <col width="5%">
                                <col width="5%">
                                <tr>
                                    <th>No.</th>
                                    <th> </th>
                                    <th>Ref</th>
                                    <th>Name</th>
                                    <th>Quantity</th>
                                    <th>Price</th>                                  
                                </tr>


                            </table>
                            <table id="purchaselist" border="1" width="100%">
                                <col width="10px">
                                <col width="1%">
                                <col width="7%">
                                <col width="10%">
                                <col width="5%">
                                <col width="5%">
                            </table>
                        </div>

                        <input type="hidden" id="paymentvalue" name="paymentvalue" value="0"/>
                        <div class="cont1" >
                            <table>
                                <tr>
                                    <td><h1 id="total" style="color:red;display: inline">Total:</h1><h1  style="color:black;display: inline">RM </h1> <h1 id="totalpayment" style="color:black;display: inline"> 0.00</h1> </td>
                                    <td><button type="button" style="float: right; width:70px" onclick="pay()">Pay</button></td>


                                </tr>
                            </table>

                        </div>

                    </form>
                </div>

            </div>
        </div>

        <br/>
        <br/>










    </body>
</html>
