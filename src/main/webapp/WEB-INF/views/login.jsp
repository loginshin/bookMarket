<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<title>로그인</title>
</head>
<body>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="./home">Home</a>
            </div>
        </div>
    </nav>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">로그인</h1>
        </div>
    </div>
    <div class="container col-md-4">
        <div class="text-center">
            <h3 class="form-signin-heading">Please login</h3>
        </div>
        <!-- 인증실패 시 모델 속성 error에 저장된 값이 있다면 오류 출력 -->
          <c:if test="${not empty error}"> 
           <div class="alert alert-danger">
                UserName과 Password가 올바르지 않습니다.<br />
            </div>
        </c:if> 
        
        <form class="form-signin" action="<c:url value="/login"/>" method="post"> 
            <div class="form-group row">
                <input type="text" name="username" class="form-control" placeholder="User Name" required autofocus>
            </div>
            <div class="form-group row">
                <input type="password" name="password" class="form-control"  placeholder="Password" required>
            </div>
            <div class="form-group row">
                <button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
                <!-- CSRF 공격을 방어하려고 설정합니다 -->
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </form>
    </div>
</body>
</html>