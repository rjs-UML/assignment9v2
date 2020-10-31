<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%--<jsp:useBean id="stocks" class="java.util.List<edu.rseymour.advancedjava.model.StockQuote>" scope="session">--%>
<%--    <c:set target='${stocks}'  value='${sessionScope.get("stocks")}'/>--%>
<%--</jsp:useBean>--%>

<html>
<head>
    <title>Stock Results</title>
</head>
<body>


<c:forEach items="${stocks}" var="quote">
    <tr>
        <td>Symbol: ${quote.symbol}</td>
        <td>Date: ${quote.date}</td>
        <td>Price: ${quote.price}</td>
    </tr>
</c:forEach>


<c:if test="${stocks.isEmpty()}">
    <h2>No stock results. Search again!</h2>
</c:if>

</body>
</html>