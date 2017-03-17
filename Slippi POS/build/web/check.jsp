<%-- 
    Document   : check
    Created on : Aug 5, 2016, 11:26:44 PM
    Author     : blank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script src="http://localhost:47617/Scripts/jquery-1.9.1.min.js"></script>
        <style >
            .cont4 {

                border-style:solid;
                border-color:black;
                padding:5px 5px 5px 5px;
                width : 100%;
                height: 100%;
                border-radius: 5px;
                background-color: white;
            }
            .top img {  
                width:50%;
                height: 100px;
            }
            .no-gutter [class*="-6"] {
                padding-left:0;
            }
            .font1 {
                font-family: Arial, Helvetica, sans-serif;
            }
        </style>

    </head>
    <body style="background-image:url(image/back.jpg)">
        <div class="container-fluid" >
            <div class="font1">
                <div class="row">
                    <div class="col-md-6" style="height:30px"><img src="image/slippi.png" alt="Slippi POS Logo" height="100%"/></div>
                    <div class="col-md-2"> </div>
                    <div class="col-md-3"><div class="labelling"><label>My Account : <%= session.getAttribute("username")%> </label></div></div>               
                </div>
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
                            <li class="active"><a href="check.jsp" accesskey="t">Check (T)</a></li>
                            <li><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                            <li><a href="report.jsp" accesskey="r">Report (R)</a></li>
                            <li><a href="history.jsp" accesskey="h">History (H)</a></li>


                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>

                        </ul>
                    </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav> 
    </div>
</div>

</body>
</html>

