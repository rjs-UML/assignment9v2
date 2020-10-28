<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="stockQuote" class="edu.rseymour.advancedjava.model.StockQuote" scope="request"/>
<jsp:setProperty name="stockQuote" property="*" />
<html>
<head>
    <title><%= stockQuote.getSymbol() %></title>
</head>
<body>

<h2>Stock Quote Search Results:</h2>

<p>
    <%= stockQuote.getSymbol() %><br>
    <%= stockQuote.getFrom() %><br>
    <%= stockQuote.getUntil() %><br>
</p>


</body>
</html>
