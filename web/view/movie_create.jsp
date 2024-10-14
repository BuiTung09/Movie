<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create New Movie</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            margin: 20px;
        }
        label {
            display: inline-block;
            width: 150px;
        }
        input[type="text"], input[type="date"], select {
            width: 200px;
        }
        input[type="checkbox"] {
            margin-left: 5px;
        }
        input[type="submit"] {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <form action="/movie/create" method="POST">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required/> 
        <br/><br/>

        <label for="releaseddate">Released Date:</label>
        <input type="date" id="releaseddate" name="releaseddate" required/> 
        <br/><br/>

        <label for="adultonly">Only for Adult:</label>
        <input type="checkbox" id="adultonly" name="adultonly"/> 
        <br/><br/>

        <label for="category">Category:</label>
        <select id="category" name="category" required>
            <option value="" disabled selected>-- Select Category --</option> 
            <c:forEach var="category" items="${categories}">
                <option value="${category.cid}">${category.cname}</option> 
            </c:forEach>
        </select> 
        <br/><br/>

        <input type="submit" value="Save"/>
    </form>
</body>
</html>
