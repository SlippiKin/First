<%-- 
    Document   : displaycustomerdetaillist
    Created on : Feb 23, 2017, 8:49:46 PM
    Author     : INSPIRON 15
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
        <title>Display Debtor </title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
        <link href="css/Ubuntu-Regular.ttf" rel="stylesheet">
        <link href="css/Lato-Regular.ttf" rel="stylesheet">
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
        </script>
        <style>
            .invoice-box{
                max-width:800px;
                margin:auto;
                padding:30px;
                border:1px solid #eee;
                box-shadow:0 0 10px rgba(0, 0, 0, .15);
                font-size:16px;
                line-height:24px;
                font-family:'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
                color:#555;
            }

            .invoice-box table{
                width:100%;
                line-height:inherit;
                text-align:left;
            }

            .invoice-box table td{
                padding:5px;
                vertical-align:top;
            }



            .invoice-box table tr.top table td{
                padding-bottom:20px;
            }

            .invoice-box table tr.top table td.title{
                font-size:45px;
                line-height:45px;
                color:#333;
            }
            .businessname{
                font-size:45px;
                line-height:45px;
                color:#333;
            }

            .invoice-box table tr.information table td{
                padding-bottom:40px;
            }

            .invoice-box table tr.heading td{
                background: #01B0BF ;
                border-bottom:1px solid #ddd;
                font-weight:bold;
            }

            .invoice-box table tr.details td{
                padding-bottom:20px;
            }

            .invoice-box table tr.item td{
                border-bottom:1px solid #eee;
            }

            .invoice-box table tr.item.last td{
                border-bottom:none;
            }

            .invoice-box table tr.total td:nth-child(5){
                border-top:2px solid #eee;
                font-weight:bold;
            }

            @media only screen and (max-width: 600px) {
                .invoice-box table tr.top table td{
                    width:100%;
                    display:block;
                    text-align:center;
                }

                .invoice-box table tr.information table td{
                    width:100%;
                    display:block;
                    text-align:center;
                }
            } 
            .ubuntufont {
                font-family: 'Ubuntu', sans-serif;
            }
            .latofont {
                font-family: 'Lato', sans-serif;
            }


        </style>
    </head>
    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/pointofsales"
                           user="root"  password="root"/>       
        <sql:query dataSource="${snapshot}" var="CustomerInfo">
            SELECT * from customerdetail where id = '<%= session.getAttribute("username")%>' and custno = '${custno}';
        </sql:query> 
        
        <nav class="navbar navbar-inverse ">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="JavaScript:window.close()" accesskey="l">Close<span class="sr-only">(current)</span></a></li>
            </ul>
        </nav>   
        <div class="invoice-box latofont">
            <c:set var="countTotal" value="0" scope="page" />            
            <c:forEach var="row" items="${CustomerInfo.rows}">
                <c:set var="countTotal" value="${countTotal + row.remain}" scope="page"/>
               
            </c:forEach>  
            <table cellpadding="0" cellspacing="0" border="0">
                <tr class="top"> 
                    <td class="title">
                        <b class="businessname" style="width:100%; max-width:300px;"> ${customer.custname}</b> 
                    </td>

                    <td>
                        <b class="businessname" style="width:100%; max-width:300px;"> Total : ${countTotal}</b>

                    </td>


                </tr>

                <tr class="information">

                    <td>
                        Phone Number : ${customer.ph} <br>
                        Email :   ${customer.email} <br><br><br>

                    </td>

                    <td>


                    </td>

                </tr>
            </table>
                     
            <table cellpadding="0" cellspacing="0">     
                <tr class="heading right">

                    <td class="left">
                        Date
                    </td>
                    <td class="left">
                        Time
                    </td>
                    <td>
                        Remain
                    </td>
                    <td>
                        Transaction Number
                    </td>
                    <td>
                        View Bill
                    </td>
                    <td>
                        Edit
                    </td>

                </tr>
                


                <c:forEach var="list" items="${list}">
                    <tr class="right">
                        <td class="left">${list.date}</td>
                        <td class="left">${list.time}</td>
                        <td>${list.remain}</td>
                        <td>${list.transid}</td>
                    <form method="post" target="_blank" action="displayBill" id="passHidden" name="passHidden">
                        <td><button type="submit" name="passValue" value="${list.transid + 1}" >VIEW</button></td>
                    </form>
                    <form method="post" action="debtor" id="passHidden" name="passHidden">
                        <input type="hidden" name="custno" id="custno" value="${customer.custno}">
                        <td><input type="number" step="any" autofocus required min="0" name="pay" id="pay"><button type="submit" name="transid" value="${list.transid}">Pay</button></td>
                    </form>

                    </tr>
                </c:forEach>
                    <tr>
                        <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <button name="back" style="float: right;" onClick="window.location='customer.jsp';">Back</button>
                    </td>
                    </tr>
            </table>

        </div>
    </body>
</html>
