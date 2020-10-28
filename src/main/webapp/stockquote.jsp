<%--
  Created by IntelliJ IDEA.
  User: ryanseymour
  Date: 10/26/20
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<jsp:useBean id="stockQuote" class="edu.rseymour.advancedjava.model.StockQuote" scope="request"/>
<jsp:setProperty name="stockQuote" property="*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock Quote</title>
</head>
<body>

<h2>Please enter stock quote details:</h2>

<p></p>

<form name="myform" action="stockQuoteResults.jsp" method="post">
    Stock Symbol: <input type="text" name="symbol"
                         value='<%= stockQuote.getSymbol() == null ? "" : stockQuote.getSymbol() %>'><br>
    From date: <input type="text" name="from"
                      value='<%= stockQuote.getFrom()== null ? "" : stockQuote.getFrom() %>'><br>

    Until date: <input type="text" name="until"
                      value='<%= stockQuote.getUntil()== null ? "" : stockQuote.getUntil() %>'><br>


    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>

</body>
</html>
