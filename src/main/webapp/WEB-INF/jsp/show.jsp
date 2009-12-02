<%--
  Created by IntelliJ IDEA.
  User: Julien Cheype
  Date: Dec 1, 2009
  Time: 5:59:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Code</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
        <script type="text/javaScript" src="${pageContext.request.contextPath}/js/chili/jquery.chili-2.2.js"></script>
        <script type="text/javascript">
            ChiliBook.recipeFolder = "${pageContext.request.contextPath}/js/chili/";
            ChiliBook.lineNumbers = true;
        </script>
    </head>
    <body>
        <div>
            <code class="<c:out value="${dataBean.language}"/>"><c:out value="${dataBean.data}"/></code>
        </div>
    </body>
</html>