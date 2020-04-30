<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>jsp测试页面</title>
</head>

<body>
  springboot测试jsp的支持
  <table border="1" align="center">
      <tr>
          <td>编号</td>
          <td>广告位置/类型</td>
      </tr>
      <c:forEach items="${tbContentCategoryList}" var="c">
          <tr>
              <td>${c.id}</td>
              <td>${c.name}</td>
          </tr>
      </c:forEach>

  </table>
</body>