<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/08/2022
  Time: 12:43 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        h1 {
            color: red;
        }

        #page {
            width: 450px;
            margin: 0 auto;
            padding: 0px 20px 20px;
            background-color: whitesmoke;
            border: solid rebeccapurple 2px;
        }

        label {
            width: 10em;
            padding-right: 1em;
            float: left;
        }

        #content input {
            float: left;
            width: 15em;
            margin-bottom: 10px;
        }

        #color-input {
            color: blue;
            background-color: yellow;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="page">
    <h1>Product Discount Calculator</h1>
    <form action="/display-discount" method="post">
        <div id="content">
            <label>Product Description</label>
            <input type="text" name="description">
            <br>
            <label>List Price</label>
            <input type="text" name="price">
            <br>
            <label>Discount Percent (%)</label>
            <input type="text" name="discount">
            <br>
        </div>
        <div>
            <input id="color-input" type="submit" value="Calculate Discount">
        </div>
    </form>
</div>
</body>
</html>
