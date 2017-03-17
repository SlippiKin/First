<%-- 
    Document   : report
    Created on : Aug 5, 2016, 11:28:59 PM
    Author     : blank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="css/inventorystyle.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
        <script src="http://code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <link href="css/Ubuntu-Regular.ttf" rel="stylesheet">
        <link href="css/Lato-Regular.ttf" rel="stylesheet">
        <script src="js/Chart.min.js" type="text/javascript"></script>
        <style >

            .ubuntufont {
                font-family: 'Ubuntu', sans-serif;
            }
            .latofont {
                font-family: 'Lato', sans-serif;
            }
        </style>
        <style>
            canvas {
                display:block;
                margin:0 auto;

            }
            .cont1 {
                height: 400px;
                width : 100%;
                border-color: transparent;
                width:800px; height:500px;


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
            //chart js for canvas
            window.onload = function () {
                var monthTotalArray = [];
                var January = 0;
                var February = 0;
                var March = 0;
                var April = 0;
                var May = 0;
                var June = 0;
                var July = 0;
                var August = 0;
                var September = 0;
                var October = 0;
                var November = 0;
                var December = 0;
                var year = [];
                var total = [];
                //call ajax for month total
                $.ajax({
                    async: false,
                    url: "getTotal",
                    dataType: "text",
                    success: function (dataa) {
                        console.log(dataa);

                        var data = dataa.split(",");

                        January = data[0].split('[')[1];
                        February = data[1];
                        March = data[2];
                        April = data[3];
                        May = data[4];
                        June = data[5];
                        July = data[6];
                        August = data[7];
                        September = data[8];
                        October = data[9];
                        November = data[10];
                        var i = data[11].indexOf("]");
                        December = data[11].slice(0, i);
                        console.log(January);
                        console.log(February);
                        console.log(March);
                        console.log(December);
                    }
                });
                //call ajax for year total
                $.ajax({
                    async: false,
                    url: "getYearTotalTransaction",
                    dataType: "json",
                    success: function (dataa) {
                        console.log(dataa);
                        $.each(dataa, function (index, value) {
                            year.push(value.date);
                            total.push(value.total);
                        });
                        console.log("year " + year);
                        console.log("total " + total);
                    }
                });
                const CHART = document.getElementById("lineChart");
                console.log(CHART);
                let lineChart = new Chart(CHART, {
                    type: 'line',
                    data: {
                        labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
                        datasets: [
                            {
                                label: "Monthly Sales Line Graph",
                                fill: false,
                                lineTension: 0.1,
                                backgroundColor: "rgba(75,192,192,0.4)",
                                borderColor: "rgba(75,192,192,1)",
                                borderCapStyle: 'butt',
                                borderDash: [],
                                borderDashOffset: 0.0,
                                borderJoinStyle: 'miter',
                                pointBorderColor: "rgba(75,192,192,1)",
                                pointBackgroundColor: "#fff",
                                pointBorderWidth: 1,
                                pointHoverRadius: 5,
                                pointHoverBackgroundColor: "rgba(75,192,192,1)",
                                pointHoverBorderColor: "rgba(220,220,220,1)",
                                pointHoverBorderWidth: 2,
                                pointRadius: 1,
                                pointHitRadius: 10,
                                data: [
                                    January,
                                    February,
                                    March,
                                    April,
                                    May,
                                    June,
                                    July,
                                    August,
                                    September,
                                    October,
                                    November,
                                    December]
                            }
                        ]
                    }
                });
                const CHART2 = document.getElementById("yearLineChart");
                console.log(CHART2);
                let yearLineChart = new Chart(CHART2, {
                    type: 'line',
                    data: {
                        labels: year,
                        datasets: [
                            {
                                label: "Year Sales Line Graph",
                                fill: false,
                                lineTension: 0.1,
                                backgroundColor: "rgba(75,192,192,0.4)",
                                borderColor: "rgba(75,192,192,1)",
                                borderCapStyle: 'butt',
                                borderDash: [],
                                borderDashOffset: 0.0,
                                borderJoinStyle: 'miter',
                                pointBorderColor: "rgba(75,192,192,1)",
                                pointBackgroundColor: "#fff",
                                pointBorderWidth: 1,
                                pointHoverRadius: 5,
                                pointHoverBackgroundColor: "rgba(75,192,192,1)",
                                pointHoverBorderColor: "rgba(220,220,220,1)",
                                pointHoverBorderWidth: 2,
                                pointRadius: 1,
                                pointHitRadius: 10,
                                data: total
                                
                            }
                        ]
                    }
                });

            };
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
                $('#salesDetail').DataTable();
            });
            //data table
            $(document).ready(function () {
                $('#weeksalesDetail').DataTable();
            });
            //data table
            $(document).ready(function () {
                $('#monthsalesDetail').DataTable();
            });
            //data table
            $(document).ready(function () {
                $('#yearsalesDetail').DataTable();
            })
                    ;

        </script>


    </head>
    <body>

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
                    <li ><a href="inventory.jsp" accesskey="i">Inventory (I)</a></li>
                    <li ><a href="supplier.jsp" accesskey="s">Supplier (S)</a></li>
                    <li><a href="shelf.jsp" accesskey="y">Shelf (Y)</a></li> 
                    <li ><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                    <li class="active"><a href="reportInformation" accesskey="r">Report (R)</a></li>
                    <li ><a href="history.jsp" accesskey="h">History (H)</a></li>



                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>

                </ul>

        </nav> 
        <div class="ubuntufont">
            <ul class="nav nav-pills">
                <li class="active"><a data-toggle="pill" href="#allproduct">TODAY SALES</a></li>
                <li><a data-toggle="pill" href="#previoussales">WEEKLY SALES</a></li>   
                <li><a data-toggle="pill" href="#monthsales">MONTHLY SALES</a></li> 
                <li><a data-toggle="pill" href="#yearlysales">ANNUAL SALES</a></li> 

            </ul>


            <div class="tab-content">
                <div id="allproduct" class="tab-pane fade in active">
                    <h2 class="text-center"> TODAY SALES</h2>


                    <div class="col-md-4"> 
                        <table border="1">
                            <thead>
                                <tr>
                                    <th colspan="2" style="text-align: center">TODAY SALES</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>PRODUCT SALES</td>
                                    <td>${currentReport.productSales}</td>
                                </tr>
                                <tr>
                                    <td>COGS</td>
                                    <td>${currentReport.COGS}</td>
                                </tr>
                                <tr>
                                    <td>No. of Sales</td>
                                    <td>${currentReport.noOfSales}</td>
                                </tr>
                                <tr>
                                    <td>Earning</td>
                                    <td>${currentReport.earning}</td>
                                </tr>
                                <tr>
                                    <td>Margin</td>

                                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${currentReport.margin}" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-8"> 

                        <table id="salesDetail" class="display" cellspacing="0" width="100%" style="width: 100%">        
                            <thead>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </tfoot>
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="row" items="${ListProductDetail}">

                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <tr>

                                    <td>${count}</td>
                                    <td>${row.barcode}</td>
                                    <td>${row.quantity}</td>
                                    <td>${row.sellingprice}</td>
                                    <td>${row.sellingprice * row.quantity}</td>


                                </tr>
                            </c:forEach>         
                        </table>
                    </div>

                </div>

                <!– ---------------------------------------------------------------------------------------------------------------------------------------------- –>            
                <div id="previoussales" class="tab-pane fade">
                    <h2 class="text-center">WEEKLY SALES ${weeklyReport.starting} - ${weeklyReport.ending}</h2>

                    <div class="col-md-4"> 
                        <table border="1">
                            <thead>
                                <tr>
                                    <th colspan="2" style="text-align: center">WEEKLY SALES</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>PRODUCT SALES</td>
                                    <td>${weeklyReport.productSales}</td>
                                </tr>
                                <tr>
                                    <td>COGS</td>
                                    <td>${weeklyReport.COGS}</td>
                                </tr>
                                <tr>
                                    <td>No. of Sales</td>
                                    <td>${weeklyReport.noOfSales}</td>
                                </tr>
                                <tr>
                                    <td>Earning</td>
                                    <td>${weeklyReport.earning}</td>
                                </tr>
                                <tr>
                                    <td>Margin</td>

                                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${weeklyReport.margin}" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-8"> 

                        <table id="weeksalesDetail" class="display" cellspacing="0" width="100%" style="width: 100%">        
                            <thead>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </tfoot>
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="row" items="${ListWeeklyProductDetail}">

                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <tr>

                                    <td>${count}</td>
                                    <td>${row.barcode}</td>
                                    <td>${row.quantity}</td>
                                    <td>${row.sellingprice}</td>
                                    <td>${row.sellingprice * row.quantity}</td>


                                </tr>
                            </c:forEach>         
                        </table>
                    </div>
                </div>
                <!– ---------------------------------------------------------------------------------------------------------------------------------------------- –>            
                <div id="monthsales" class="tab-pane fade">
                    <h2 class="text-center">MONTHLY SALES ${monthlyReport.starting} - ${monthlyReport.ending}</h2>


                    <div class="col-md-6">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th colspan="2" style="text-align: center">MONTHLY SALES</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>PRODUCT SALES</td>
                                    <td>${monthlyReport.productSales}</td>
                                </tr>
                                <tr>
                                    <td>COGS</td>
                                    <td>${monthlyReport.COGS}</td>
                                </tr>
                                <tr>
                                    <td>No. of Sales</td>
                                    <td>${monthlyReport.noOfSales}</td>
                                </tr>
                                <tr>
                                    <td>Earning</td>
                                    <td>${monthlyReport.earning}</td>
                                </tr>
                                <tr>
                                    <td>Margin</td>

                                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${monthlyReport.margin}" /></td>
                                </tr>
                            </tbody>
                        </table>

                    </div>
                    <div class="col-md-6">          
                        <table id="monthsalesDetail" class="display" cellspacing="0" width="100%" style="width: 100%">        
                            <thead>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </tfoot>
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="row" items="${ListMonthProductDetail}">

                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <tr>

                                    <td>${count}</td>
                                    <td>${row.barcode}</td>
                                    <td>${row.quantity}</td>
                                    <td>${row.sellingprice}</td>
                                    <td>${row.sellingprice * row.quantity}</td>


                                </tr>
                            </c:forEach>         
                        </table>
                    </div>
                    <div class="col-md-12">
                        <div class="cont1">
                            <div style="position:absolute; width:1000px; height:500px;">
                                <canvas id="lineChart" name="lineChart" width="1000px" height="500px"></canvas>
                            </div>
                        </div>
                    </div>
                </div>


                <!– ---------------------------------------------------------------------------------------------------------------------------------------------- –>            
                <div id="yearlysales" class="tab-pane fade">
                    <h2 class="text-center">ANNUAL SALES ${yearlyReport.starting} - ${yearlyReport.ending}</h2>
                    <div class="col-md-5"> 
                        <table border="1">
                            <thead>
                                <tr>
                                    <th colspan="2" style="text-align: center">ANNUAL SALES</th>

                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>PRODUCT SALES</td>
                                    <td>${yearlyReport.productSales}</td>
                                </tr>
                                <tr>
                                    <td>COGS</td>
                                    <td>${yearlyReport.COGS}</td>
                                </tr>
                                <tr>
                                    <td>No. of Sales</td>
                                    <td>${yearlyReport.noOfSales}</td>
                                </tr>
                                <tr>
                                    <td>Earning</td>
                                    <td>${yearlyReport.earning}</td>
                                </tr>
                                <tr>
                                    <td>Margin</td>

                                    <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${yearlyReport.margin}" /></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-7"> 

                        <table id="yearsalesDetail" class="display" cellspacing="0" width="100%" style="width: 100%">        
                            <thead>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>NO.</th>
                                    <th>BARCODE</th>
                                    <th>QUANTITY</th>
                                    <th>PRICE</th>
                                    <th>EARN</th>

                                </tr>
                            </tfoot>
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="row" items="${ListYearlyProductDetail}">

                                <c:set var="count" value="${count + 1}" scope="page"/>
                                <tr>

                                    <td>${count}</td>
                                    <td>${row.barcode}</td>
                                    <td>${row.quantity}</td>
                                    <td>${row.sellingprice}</td>
                                    <td>${row.sellingprice * row.quantity}</td>


                                </tr>
                            </c:forEach>         
                        </table>
                    </div>
                    <div class="col-md-12">
                        <div class="cont1">
                            <div style="position:absolute; width:1000px; height:500px;">
                                <canvas id="yearLineChart" name="yearLineChart" width="1000px" height="500px"></canvas>
                            </div>
                        </div>
                    </div>
                </div>   
            </div>  
        </div>
    </div>
</body>
</html>

