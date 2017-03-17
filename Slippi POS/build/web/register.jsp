<%-- 
    Document   : register
    Created on : Aug 7, 2016, 1:21:16 AM
    Author     : blank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <link href="css/registerstyle.css" rel='stylesheet' type='text/css' />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

        <link href='http://fonts.googleapis.com/css?family=Lobster|Pacifico:400,700,300|Roboto:400,100,100italic,300,300italic,400italic,500italic,500' ' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,500,600,700,300' rel='stylesheet' type='text/css'>
        <script language='javascript' type='text/javascript'>
            function fncSubmit() {
                if (document.form1.Password.value != document.form1.ConfirmPassword.value)
                {
                    alert('Confirm Password Not Match');
                    document.form1.Password.focus();
                    return false;
                }
                document.form1.submit();
            }
        </script>
        
        <style>
            aline{white-space: nowrap;display:inline }

            p,label{
                color:black;
                text-align: left;
                margin-left: 5%;

            }
            img {display: block;
                 margin-left: auto;
                 margin-right: auto }
            table{
                width: 100%;

                table-layout: fixed;
                word-wrap: break-word;


            }
        </style>
    </head>
    <body style="background-image: url(image/2.jpg);">
        <a href="index.html"><img src="image/slippi.png" alt=""/></a>
        <div class="main">
            <div class="container-fluid">
                <div class="wrap">
                    <div class="Regisration">
                        <div class="Regisration-head">
                            <h2>Register</h2>
                        </div>
                        <form action="registerAccount" method="Post" name="form1" OnSubmit="return fncSubmit();">
                            <table>
                                <tr>
                                    <td><p>Username :</p> <input type="text" name="username" autofocus required></td>
                                    <td><p>Full Name :</p> <input type="text" name="fullname" required></td>
                                </tr>
                                <tr>
                                    <td> <p>Password :</p> <input type="password" id="Password" name="password"  required ></td>
                                    <td> <p>Confirm Password :</p> <input type="password" id="ConfirmPassword" name="confirmpassword" required></td>
                                </tr>
                                <tr>
                                    <td> <p>Date of Birth :</p>  <input type="date" name="birthday" required></td>
                                    <td><p>Phone Number : (eg: 0191231631)</p> <input type="text" pattern="[0-9]{10}" required="" name="phonenumber"></td>
                                </tr>
                                <tr>
                                    <td><p>Name of Business :</p> <input type="text"  name="businessname" required></td>
                                    <td><p>Email Address :</p> <input type="email"  name="email" required></td>    
                                </tr>
                                 
                                <tr>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label class="form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="condition"> I agree to the Terms and Conditions
                                        </label>
                                    </td>
                                    <td>
                                        <div class="submit">
                                            <input type="submit" id="submit">
                                        </div>
                                        <div class="clear"> </div></td>
                                    
                                    </td>
                                </tr>


                            </table>
                      
                             <a href="index.html" style="float: right; padding-right: 1%"> >> Back << </a>
                        </form>
                       
                        
                    </div>
                </div>

            </div>

        </div>
    </body>
</html>
