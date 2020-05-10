<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page import="org.genesis.Constants" %>
    <meta charset="UTF-8">
    <title>Genesis Registration</title>
</head>
<body>
<center>
    <h1>
        Registration Page
    </h1>
    <form action="http://localhost:8080/genesis-login/register" method="post">
      <div class="container">
        <label><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>
        </br>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        </br>

        <label><b>Confirm password</b></label>
        <input type="password" placeholder="Re-enter Password" name="confirm-password" required>
        </br>

        <label><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>
        </br>

        <label><b>Gender</b></label>
          <input type="radio" id="male" name="gender" value="male">
          <label for="male">Male</label><br>
          <input type="radio" id="female" name="gender" value="female">
          <label for="female">Female</label><br>
        </br>

        <button type="submit">Register</button>
        </br>
      </div>

      <div class="container">
        <button type="button" class="cancelbtn">Cancel</button>
        <span><a href="login.do">Already have an account?</a></span>
      </div>
    </form>
        <div class="container">
            <button type="button" onclick="doOpenId()">Register with WSO2</button>
        </div>

         <script>
            function doOpenId(){
                var authorizeURL ="https://localhost:9443/oauth2/authorize?response_type=code&scope=openid&client_id=<%=Constants.CLIENT_ID%>&redirect_uri=<%=Constants.REDIRECT_URL%><%=Constants.REGISTER_FLOW%>";
                window.location = authorizeURL;
            }
         </script>
</body>
</html>