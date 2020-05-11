<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page import="org.genesis.Constants" %>
    <meta charset="UTF-8">
    <title>Genesis Login</title>
</head>
<body>
<center>
    <h1>
        Login
    </h1>
    <form action="http://localhost:8080/genesis-login/authenticate" method="post">
      <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>
        </br>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        </br>

        <button type="submit">Login</button>
        <label>
          <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
        </br>
      </div>

      <div class="container">
        <button type="button" class="cancelbtn">Cancel</button>
        <span>Forgot <a href="#">password?</a></span>
        <span><a href="register.do">Dont have an account?</a></span>
      </div>
    </form>
    <div class="container">
        <button type="button" onclick="doOpenId()">Login with your Social Account</button>
    </div>

     <script>
        function doOpenId(){
            var authorizeURL ="<%=Constants.AUTHORIZATION_URL%><%=Constants.LOGIN_FLOW%>";
            window.location = authorizeURL;
        }
     </script>
</body>
</html>