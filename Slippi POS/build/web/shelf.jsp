<%-- 
    Document   : shelf
    Created on : Aug 5, 2016, 11:29:32 PM
    Author     : blank
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
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
        <title>Shelf</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">         
        <link href="css/inventorystyle.css" rel="stylesheet" type="text/css"/>        
        <script src="js/jquery.min.js" type="text/javascript"></script>       
        <script src="js/angular.min.js" type="text/javascript"></script>
        <style>
            .container {
                position: relative;
                width: 25%;
                float: left;
            }

            .image {
                display: block;
                width: 100%;
                height: auto;
                float: left;
            }

            .overlay {
                position: absolute;
                bottom: 0;
                left: 100%;
                right: 0;
                background-color: WHITE;
                overflow: hidden;
                width: 0;
                height: 100%;
                transition: .5s ease;
            }

            .container:hover .overlay {
                left: 0;
            }

            .text {

                transform: translate(-50%, -50%);
                -ms-transform: translate(-50%, -50%);
            }
            html{
                heigth: 100%;
            }
            body{ 
                margin:0;
                padding:0;
                height:100%;
            }

            .Fixed
            {
                position: fixed;
                bottom: 0;
                left: 0;
                width: 300px;
                height: 220px;
                border: 3px solid #73AD21;
            }

            .FixedEditIcon
            {
                position: fixed;
                bottom: 0;
                left: 0;
                width: 25%;
            }

            .FixedEditIcon2
            {
                position: fixed;
                bottom: 0;
                right: 0;
                width: 25%;
            }

            .boxOfFloorPlan{
                float: left;
                width: 86px;
                height:45px;
                margin: 3px;
            }

            .showme{ 
                display: none;
            }
            .showhim:hover .showme{
                display : block;
                width: 25%;
            }
        </style>
        <script>
            var jsonStr = '{"shelf":[{"name":"null","location":"", "shape":"", "level":""}]}';
            var jsonObj = JSON.parse(jsonStr);
            var picture;
            jsonObj = JSON.parse(jsonStr);
            var level;
            window.onload = function () {
            //call ajax for month total
            $.ajax({
            async: false,
                    url: "getFloorPlanFromAjax",
                    dataType: "text",
                    success: function (data) {
                    jsonStr = data;
                    jsonObj = JSON.parse(jsonStr);
                    console.log("window load AJAX Return " + JSON.stringify(jsonObj));
                    }
            });
            callingAjax();
            }

            $(document).ready(function () {
            callingAjax();
            });
            function showShelf(data){
            alert(data.id);
            }
            function callingAjax(){
            $.ajax({
            async: false,
                    url: "getFloorPlanFromAjax",
                    dataType: "text",
                    success: function(data) {
                    jsonStr = data;
                    jsonObj = JSON.parse(jsonStr);
                    console.log("document ready AJAX Return " + JSON.stringify(jsonObj));
                    }
            });
            var dataAjax = jsonObj.shelf;
            for (var i in dataAjax) {
            var name = dataAjax[i].name;
            var level = dataAjax[i].level;
            var shape = dataAjax[i].shape;
            var location = dataAjax[i].location;
            picture = document.createElement("img");
            console.log("shape --> " + shape);
            if ("vertical" === shape){

            picture.setAttribute("src", "image/straight.png");
            } else{
            picture.setAttribute("src", "image/horizon.png");
            }
            picture.setAttribute("ondblclick", "showShelf(this)");
            picture.setAttribute("draggable", "true");
            picture.setAttribute("ondragstart", "drag(event)");
            picture.setAttribute("id", name);
            picture.setAttribute("style", "cursor:move");
            console.log("picture --> " + picture);
            document.getElementById(location).appendChild(picture);
            }
            }
            function checkNumber(number) {
            var returnLevel;
            if (number <= 100 && number >= 1) {
            returnLevel = number;
            } else {
            returnLevel = prompt("Wrong level input, Please enter the correct number of level of this shelf");
            returnLevel = checkNumber(returnLevel);
            }
            return returnLevel;
            }
            function addVerticalShape(ev, location) {
            var data = ev.dataTransfer.getData("text");
            var nodeCopy = document.getElementById(data).cloneNode(true);
            var Vertical = prompt("Please enter shelf name");
            Vertical = addInform(Vertical);
            nodeCopy.id = Vertical;
            jsonObj['shelf'].push({"name": Vertical, "location": location, "shape": "vertical"});
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            }
            //----------------------------------------------------------------------------------------------------------
            function drop(ev) {
            ev.preventDefault();
            var data = ev.dataTransfer.getData("text");
            console.log("place of div " + ev.target.id + " data = " + data);
            var isVertical = 'drag1' == data;
            var isHorizon = "drag2" == data;
            var nodeCopy = document.getElementById(data).cloneNode(true);
            var Vertical;
            var Horizon;
            // clean target space if needed

            if ("deleteimg" === ev.target.id) {

            console.log("in if deteleimg that comapre ev.target " + JSON.stringify(jsonObj.shelf));
            jsonObj = deleteJson(jsonObj.shelf, "name", data);
            removeNode(document.getElementById(data));
            console.log("after delete left " + JSON.stringify(jsonObj));
            } else if (isVertical) {

            if (ev.target.nodeName == 'IMG') {
            Vertical = prompt("Please enter shelf name");
            Vertical = addInform(Vertical);
            level = prompt("Please enter the number of level of this shelf");
            level = checkNumber(level);
            nodeCopy.id = Vertical;
            jsonObj = editJson(jsonObj.shelf, 'name', ev.target.id, Vertical, "vertical");
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            //jsonObj['shelf'].push({"name": Vertical, "location": ev.target.id, "shape":"vertical"});
            ev.target.parentNode.appendChild(nodeCopy);
            //addVerticalShape(ev, ev.target.id);
            removeNode(ev.target);
            } else {
            console.log("in new");
            Vertical = prompt("Please enter shelf name");
            Vertical = addInform(Vertical);
            level = prompt("Please enter the number of level of this shelf");
            level = checkNumber(level);
            nodeCopy.id = Vertical;
            jsonObj['shelf'].push({"name": Vertical, "location": ev.target.id, "shape": "vertical", "level": level});
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            console.log("in new vertical " + jsonStr);
            //addVerticalShape(ev, ev.target.id);
            ev.target.appendChild(nodeCopy);
            }
            }
            //----------------------------------------------------------------------------------
            else if (isHorizon) {

            if (ev.target.nodeName == 'IMG') {

            Horizon = prompt("Please enter shelf name");
            Horizon = addInform(Horizon);
            level = prompt("Please enter the number of level of this shelf");
            level = checkNumber(level);
            nodeCopy.id = Horizon;
            jsonObj = editJson(jsonObj.shelf, 'name', ev.target.id, Horizon, "horizon");
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            ev.target.parentNode.appendChild(nodeCopy);
            removeNode(ev.target);
            } else {

            Horizon = prompt("Please enter shelf name");
            Horizon = addInform(Horizon);
            level = prompt("Please enter the number of level of this shelf");
            level = checkNumber(level);
            nodeCopy.id = Horizon;
            jsonObj['shelf'].push({"name": Horizon, "location": ev.target.id, "shape": "horizon", "level": level});
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            console.log("in new horizon " + jsonStr);
            ev.target.appendChild(nodeCopy);
            }
            }
            //------------------------------------------------------------------------------------
            else {
            if (ev.target.nodeName != 'IMG') {

            editReplaceJson(jsonObj.shelf, 'name', data, ev.target.id);
            removeNode(document.getElementById(data));
            ev.target.appendChild(nodeCopy);
            }
            }
            ev.stopPropagation();
            return false;
            }
            function addInform(nameOfShelf) {
            var shelfname = nameOfShelf;
            if (nameOfShelf === ""){
            shelfname = prompt("Please do not leave blank for the name");
            shelfname = addInform(shelfname);
            }else if (nameOfShelf === " "){
            shelfname = prompt("Please do not leave blank for the name");
            shelfname = addInform(shelfname);
            }
            var returnValue = true;
            var shelfname = nameOfShelf;
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            for (i = 0; i < jsonObj.shelf.length; i++) {
            if (jsonObj.shelf[i].name === nameOfShelf) {
            returnValue = false;
            }
            }
            while (returnValue == false) {
            shelfname = prompt("The name is exist, please insert unique name");
            returnValue = true;
            for (i = 0; i < jsonObj.shelf.length; i++) {

            if (jsonObj.shelf[i].name === shelfname) {
            returnValue = false;
            }
            }
            }
            return shelfname;
            }
            function allowDrop(ev) {
            ev.preventDefault();
            }
            function drag(ev) {
            ev.dataTransfer.setData("text", ev.target.id);
            }
            function removeNode(node) {
            node.parentNode.removeChild(node);
            }
            function deleteJson(object, key, value)
            {
            console.log("delete de object " + object);
            $.each(object, function (index)
            {
            $.each(this, function (k, v)
            {

            if (k == key && v == value)
            {

            object.splice(index, 1);
            objStr = "{\"shelf\":" + (JSON.stringify(object)) + "}";
            object = JSON.parse(objStr);
            console.log("delete Stringify" + JSON.stringify(object));
            }
            });
            });
            return object;
            }
            function editJson(object, key, value, name, shape)
            {
            $.each(object, function (index)
            {
            $.each(this, function (k, v)
            {

            if (k == key && v == value)
            {
            object[index].name = name;
            object[index].shape = shape;
            //object.splice(index, 1);
            objStr = "{\"shelf\":" + (JSON.stringify(object)) + "}";
            object = JSON.parse(objStr);
            console.log("Stringify" + JSON.stringify(object));
            }
            });
            });
            return object;
            }
            function editReplaceJson(object, key, value, location)
            {
            console.log("in replace editreplace " + JSON.stringify(object));
            $.each(object, function (index)
            {
            $.each(this, function (k, v)
            {

            if (k == key && v == value)
            {
            object[index].location = location;
            //object.splice(index, 1);
            objStr = "{\"shelf\":" + (JSON.stringify(object)) + "}";
            object = JSON.parse(objStr);
            console.log("Stringify" + JSON.stringify(object));
            }
            });
            });
            return object;
            }
            function save() {
            jsonStr = JSON.stringify(jsonObj);
            jsonObj = JSON.parse(jsonStr);
            jsonStr = JSON.stringify(jsonObj);
            console.log("save obj " + jsonStr);
            var request = $.ajax({
            url: "saveFloorPlan?objectString=" + jsonStr,
                    type: "GET",
                    dataType: "html"
            });
            request.done(function (msg) {
            alert("save");
            });
            request.fail(function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
            });
            }

        </script>


    </head>
    <body ng-app="myApp">
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
                    <li><a href="Home.jsp" accesskey="a">Sales (A)</a></li>
                    <li><a href="inventory.jsp" accesskey="i">Inventory (I)</a></li>
                    <li><a href="supplier.jsp" accesskey="s">Supplier (S)</a></li>
                    <li  class="active"><a href="shelf.jsp" accesskey="y">Shelf (Y)</a></li>
                    <li><a href="customer.jsp" accesskey="c">Customer (C)</a></li>
                    <li><a href="reportInformation" accesskey="r">Report (R)</a></li>
                    <li><a href="history.jsp" accesskey="h">History (H)</a></li></ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="index.html" accesskey="l">Logout (L)<span class="sr-only">(current)</span></a></li>
                </ul>
            </div><!--/.nav-collapse -->

        </nav>  


        <div ng-controller="myCtrl"  > 
            <h1 style="text-align: center">FLOOR PLAN</h1>
            <c:set var="countTotal" value="0" scope="page" />
            <c:set var="countTotal" value="${countTotal + 1}" scope="page"/>
            <c:forEach begin="1" end="20" varStatus="loop">
                <c:forEach begin="1" end="20" varStatus="loop1">

                    <c:set var="countTotal" value="${countTotal + 1}" scope="page"/>

                    <div id="div${countTotal}" class="boxOfFloorPlan" ondrop="drop(event)" ondragover="allowDrop(event)" value="loop">

                    </div>

                </c:forEach> 
            </c:forEach> 

        </div>

        <div class="showhim FixedEditIcon" style="width: 250px">

            <div class="container">
                <img id="editimg" class="image" style="float: right" src="image/edit.png" alt="" height="100px" width="100px" ondrop="drop(event)" ondragover="allowDrop(event)"/>

                <div class="Fixed showme overlay">
                    <p>Drag the shelf to the floor plan</p>

                    <img src="image/straight.png" ondblclick="showShelf(this)" draggable="true" ondragstart="drag(event)" id="drag1" style="cursor:move"  >


                    <img  src="image/horizon.png" ondblclick="showShelf(this)" draggable="true" ondragstart="drag(event)" id="drag2" style="cursor:move"  >
                    <button type="button" onclick="save()">Save</button> 

                </div>
            </div>




        </div>  
        <img src="image/bin.png" class="FixedEditIcon2" id="deleteimg"  style="float: right; height:60px; width:55px;"  ondrop="drop(event)" ondragover="allowDrop(event)"/>



    </body>
</html>





