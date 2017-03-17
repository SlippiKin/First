<%-- 
    Document   : inventory
    Created on : Aug 5, 2016, 11:26:21 PM
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
        <title>Inventory</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/inventorystyle.css" />


        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="http://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
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
            table th:first-child {
                text-align: left;
                padding-left:20px;
            }
            table tr:first-child th:first-child {
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
            table td:first-child {
                text-align: left;
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

            function calculate()
            {
                var unit = document.getElementById('unit').value;
                var selling = document.getElementById('selling').value;
                document.getElementById('mark').value = ((parseFloat(selling) - parseFloat(unit)) / unit) * 100;

            }
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
            
            //disable enter to submit
            $(document).ready(function () {
                $(window).keydown(function (event) {
                    if (event.keyCode == 13) {
                        event.preventDefault();
                        return false;
                    }
                });
            });
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
                        var proname = responseArray[0];
                        var originalprice = responseArray[1];
                        var sellingprice = responseArray[2];
                        var minimumquantity = responseArray[3];
                        var gst = responseArray[4];
                        var shelflocation = responseArray[5];
                        var currentquantity = responseArray[6];
                        var productimage = responseArray[7];
                        var category = responseArray[8];
                        var sname = responseArray[9];
                        var mark = ((parseFloat(sellingprice) - parseFloat(originalprice)) / parseFloat(originalprice)) * 100;
                        document.getElementById("name").value = proname;
                        document.getElementById("unit").value = originalprice;
                        document.getElementById("selling").value = sellingprice;
                        document.getElementById("orderlevel").value = minimumquantity;

                        document.getElementById("shelflocation").value = shelflocation;
                        document.getElementById("cquantity").value = currentquantity;
                        //document.getElementById("pic").value = productimage;
                        document.getElementById("cat").value = category;
                        document.getElementById("supplier").value = sname;
                        document.getElementById("markup").value = mark;
                        document.getElementById("gst").value = gst;
                    }
                }
                xmlhttp.open("GET", "searchForInventoryform?barcode=" + str, true);
                xmlhttp.send();
            }
            
            // call confirmation box if not valid input
            function validate(form) {

                if (!valid) {
                    alert('Please correct the errors in the form!');
                    return false;
                } else {
                    return confirm('Confirm?');
                }
            }
            //select
            $("#table tr").click(function () {

                var value = $(this).find('td:first').html();
                alert(value);
            });
            //data table
            $(document).ready(function () {
                $('#producttable').DataTable();
            });
            //data table
            $(document).ready(function () {
                $('#restockproducttable').DataTable();
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

    <body >

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
                    <li ><a href="Home.jsp" accesskey="a">Sales (A)</a></li>
                    <li class="active"><a href="inventory.jsp" accesskey="i">Inventory (I)</a></li>
                    <li ><a href="supplier.jsp" accesskey="s">Supplier (S)</a></li>
                    <li><a href="shelf.jsp" accesskey="y">Shelf (Y)</a></li> 
                    <li ><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                    <li><a href="reportInformation" accesskey="r">Report (R)</a></li>
                    <li ><a href="history.jsp" accesskey="h">History (H)</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </nav> 
        <ul class="nav nav-pills">
            <li class="active"><a data-toggle="pill" href="#allproduct">VIEW ALL PRODUCT</a></li>
            <li><a data-toggle="pill" href="#edit">EDIT PRODUCT</a></li>    
            <li><a data-toggle="pill" href="#alarm">PRODUCT RESTOCK</a></li>
        </ul>
        <div class="tab-content">

            <div id="allproduct" class="tab-pane fade in active">
                <h2 class="text-center">  Product</h2>
                <table id="producttable" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>BARCODE</th>
                            <th>NAME</th>
                            <th>UNIT PRICE</th>
                            <th>SELLING PRICE</th>
                            <th>MARGIN</th>
                            <th>CURRENT QUANTITY</th>
                            <th>CATEGORY</th>
                            <th>SUPPLIER</th>
                            <th>LOCATION</th>
                            <th>GST</th>
                            <th>MINIMUM QUANTITY</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>BARCODE</th>
                            <th>NAME</th>
                            <th>UNIT PRICE</th>
                            <th>SELLING PRICE</th>
                            <th>MARGIN</th>
                            <th>CURRENT QUANTITY</th>
                            <th>CATEGORY</th>
                            <th>SUPPLIER</th>
                            <th>LOCATION</th>
                            <th>GST</th>
                            <th>MINIMUM QUANTITY</th>
                        </tr>
                    </tfoot>
                    <tbody style="text-align: center">
                        <c:forEach var="row" items="${allProduct.rows}">
                            <tr>
                                <td>${row.barcode}</td>
                                <td>${row.proname}</td>
                                <td>${row.originalprice}</td>
                                <td>${row.sellingprice}</td>

                                <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(row.sellingprice - row.originalprice) / row.originalprice}" /></td>

                                <td>${row.currentquantity}</td>
                                <td>${row.category}</td>
                                <td>${row.sname}</td>
                                <td>${row.shelflocation}</td>
                                <td>${row.gst}</td>
                                <td>${row.minimumquantity}</td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------- -->

            <div id="edit" class="tab-pane fade white">

                <div class="wrap">
                    <div class="Regisration">
                        <h2 class="text-center">Edit or Insert Product</h2>
                        <form method="Get" id="productinformation" name="productinformation" accept="image/gif, image/jpeg" action="addIncomingproduct" onsubmit="return validate(this);">
                            <div class="col-md-4">                       
                                <p>Item Code :</p> 

                                <input list="text" id='list1' oninput='onInput()' name="code" autofocus required onkeyup="get(this.value)" onchange="calculate();"/> 

                                <datalist id="text">
                                    <c:forEach var="row" items="${allProduct.rows}">
                                        <option value="${row.barcode}" onclick="">                                               
                                        </c:forEach>
                                </datalist>

                                <p>Description :</p> <input type="text" id="name" name="name" required> 


                                <p>Unit Price : </p><input type="text" id="unit" name="unit" onkeypress="return (event.charCode >= 48 && event.charCode <= 57) || event.charCode == 46 || event.charCode == 0" onchange="calculate()">                                              


                                <p>Selling Price :</p> <input type="text" id="selling" name="selling" onkeypress="return (event.charCode >= 48 && event.charCode <= 57) || event.charCode == 46 || event.charCode == 0" onchange="calculate()">                                              

                                <p>Markup %  :</p> <input type="text" id="mark" name="markup" disabled >                                              



                            </div>
                            <div class="col-md-4">
                                <p> Reorder Level :</p> <input type="number" id="orderlevel" name="orderlevel" >
                                <p> Current Quantity :</p> <input type="number" id="cquantity" name="cquantity" >
                                <p> Incoming Quantity :</p> <input type="number" id="inquantity" name="inquantity" value="0">
                                <p> GST Included : </p> 
                                <select name="gst">
                                    <option value="include">Include</option>
                                    <option value="exclude">Exclude</option>

                                </select>
                            </div>
                            <div class="col-md-4">
                                <p> Shelf Location :</p> <input type="text" id="shelflocation" name="shelflocation" >
                                <p> Category :</p> <input type="text" id="cat" name="cat" >
                                <p> Image :</p><input type="file" id="pic" name="pic" id="pic">
                                <p> Supplier :</p> <input type="text" id="supplier" name="supplier" ><br/>
                                <input type="submit" style="background-color: greenyellow" value="Save"/>
                            </div>
                            <input type="hidden" id="idn" name="idn" value="<%= session.getAttribute("username")%>"><br/>


                        </form>

                    </div>
                </div>
            </div>
            <!-- ------------------------------------------------------------------------------------------------------------- -->
            <div id="alarm" class="tab-pane fade">
                <h2 class="text-center">PRODUCT NEED TO BE RESTOCK</h2>
                <table id="restockproducttable" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>NO.</th> 
                            <th>BARCODE</th>
                            <th>NAME</th>                     
                            <th>CURRENT QUANTITY</th>                        
                            <th>MINIMUM QUANTITY</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>NO.</th> 
                            <th>BARCODE</th>
                            <th>NAME</th>                    
                            <th>CURRENT QUANTITY</th>                         
                            <th>MINIMUM QUANTITY</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:set var="count" value="0" scope="page" />
                        <c:forEach var="row" items="${allProduct.rows}">
                            
                            <tr>
                                <c:if test="${row.currentquantity <= row.minimumquantity}">
                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                    <td>${count}</td>
                                    <td>${row.barcode}</td>
                                    <td>${row.proname}</td>
                                    <td>${row.currentquantity}</td>
                                    <td>${row.minimumquantity}</td>


                                </c:if>

                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>


    </body>
</html>

