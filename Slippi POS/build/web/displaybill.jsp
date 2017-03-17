
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Bill</title>
        <script>
            function myFunction() {
                window.print();
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

            .invoice-box table tr td:nth-child(2){
                text-align:right;
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
        </style>
        <style>
            .center {
                margin: auto;
                width: 30%;
                border: 3px solid #73AD21;
                padding: 10px;
            }
            .right{
                text-align:right;
            }
            .left{
                text-align:left;
            }
            IMG.displayed {
                display: block;
                margin-left: auto;
                margin-right: auto }

        </style>
    </head>
    <body>
        <div class="invoice-box">
            <table cellpadding="0" cellspacing="0" >
                <tr class="top">



                    <td class="title">
                        <b class="businessname" style="width:100%; max-width:300px;"> ${businessInformation.busname}</b> 
                    </td>

                    <td>
                        Invoice #: ${TransDetail.transid} <br>
                        Created:   ${TransDetail.date} <br><br><br>

                    </td>


                </tr>

                <tr class="information">

                    <td>
                        Email: ${businessInformation.email}<br>
                        Contact Number: ${businessInformation.hp}<br><br><br>

                    </td>

                    <td>
                        Person In Charge: ${businessInformation.name}<br>

                    </td>

                </tr>
            </table>

            <table cellpadding="0" cellspacing="0">     
                <tr class="heading right">

                    <td class="left">
                        Product
                    </td>
                    <td class="left">
                        Barcode
                    </td>
                    <td>
                        Quantity
                    </td>
                    <td>
                        Price
                    </td>
                    <td>
                        Amount
                    </td>
                </tr>


                <c:forEach var="list" items="${detail}">
                    <tr class="right">
                        <td class="left">${list.name}</td>
                        <td class="left">${list.barcode}</td>
                        
                        <td>${list.quantity}</td>
                        <td>${list.price}</td>
                        <td>${list.price * list.quantity}</td>

                    </tr>
                </c:forEach>




                <tr class="total right" >
                    <td></td>
                    <td></td>

                    <td></td>
                    <td>Total: </td>
                    <td>
                        RM ${TransDetail.total}
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
