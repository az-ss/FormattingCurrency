<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Simple jsp page</title></head>
<body>


<form action="param.form" method="get">
    <label for="amount">Amount</label><br />
    <input type="text" name="amount"> <br />
    <label for="siteLocale">Site Locale</label><br />
    <select name="siteLocale">
        <option value="<%=Locale.US%>">USA</option>
        <option value="<%=Locale.FRANCE%>">FRANCE</option>
        <option value="<%=Locale.UK%>">BRITAIN</option>
        <option value="<%=Locale.JAPAN%>">JAPAN</option>
        <option value="<%=Locale.CANADA%>">CANADA</option>
        <option value="<%=Locale.CANADA_FRENCH%>">CANADA_FRENCH</option>
        <option value="<%=Locale.KOREA%>">KOREA</option>
    </select> <br />
    <label for="currencyLocale">Currency Locale</label><br />
    <select name="currencyLocale">
        <option value="<%=Locale.US%>">USA</option>
        <option value="<%=Locale.FRANCE%>">FRANCE</option>
        <option value="<%=Locale.UK%>">BRITAIN</option>
        <option value="<%=Locale.JAPAN%>">JAPAN</option>
        <option value="<%=Locale.CANADA%>">CANADA</option>
        <option value="<%=Locale.CANADA_FRENCH%>">CANADA_FRENCH</option>
        <option value="<%=Locale.KOREA%>">KOREA</option>
    </select> <br />
    <input type="submit">
</form><br />
Site locale: <%=request.getAttribute("localeSite")%> <br />
Currency Locale: <%=request.getAttribute("localeCurrency")%> <br />
Result: <%= (request.getAttribute("amount") != null) ? request.getAttribute("amount") : "" %>
</body>
</html>