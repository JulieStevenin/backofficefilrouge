<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="../css/login.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<html>
<style type="text/css"> body {
    background-color: aquamarine
}</style>
<style type="text/css"> div {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 80%;
    margin-left: auto;
    margin-right: auto;
    width: 8em;
    width: 80%;
}</style>
<style type="text/css"> h1 {
    height: 200px;
    display: flex;
    align-items: center;
    justify-content: center;
    width: 80%;
}</style>
<head>
    <title>Title</title>
</head>
<body>
<h2>Connexion :</h2>

<form action="login" method="post">
    <div class="form-example">
        <label for="mail">Enter your name: </label>
        <input type="text" name="mail" id="mail" required/>
    </div>
    <div class="form-example">
        <label for="password">Enter your password: </label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div class="form-example">
        <input type="submit" value="Register"/>
    </div>
</form>

</body>
</html>