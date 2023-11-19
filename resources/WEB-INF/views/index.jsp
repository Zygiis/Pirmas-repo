<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Automobiliai</title>
</head>
<body>
    <h1>Automobiliai</h1>
    <a href="/vidutinis-variklio-turis">Vidutinis variklio tūris</a>
    <a href="/ieskoti-pagal-marke-modeli">Ieškoti pagal markę ir modelį</a>
    <a href="/ieskoti-pagal-marke-modeli-greiti">Ieškoti pagal markę, modelį ir greitį</a>
    
    <c:if test="${not empty vidutinisTuris}">
        Vidutinis variklio tūris: ${vidutinisTuris}
    </c:if>
</body>
</html>
