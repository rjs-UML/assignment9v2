<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


<html>

<head>
    <title>Stock Quote Search</title>
</head>

<body>

<form name="stockform" action="servlets/StockSearchServlet/" method="post">

    Stock symbol: <input type="text" name="symbol" title="symbol"><br><br>
    From date: <input type="text" name="from" title="from" placeholder="yyyy-mm-dd"><br><br>
    Until date: <input type="text" name="until" title="until" placeholder="yyyy-mm-dd"><br><br>
    <br>
    <input type="SUBMIT" value="Get Quote">
    <input type="HIDDEN" name="submit" value="true">


</form>

</body>

</html>
