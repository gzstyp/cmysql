<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    final String path = request.getContextPath();
    final String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8"/>
    <base href="<%=basePath%>">
    <title>首页</title>
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
取消 registry.addViewController("/").setViewName("index");了注释<br>
默认显示的jsp页面是/WEB-INF/view/index.jsp,如果配置了resources/index.html或static/index.html都会走这个html页面,配置的优先权大于默认值,默认是resources/index.html或static/index.html
</body>
</html>