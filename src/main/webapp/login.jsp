<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Genesis Login</title>
</head>
<body>
<center>
    <h1>
        Login
    </h1>
    <form action="http://localhost:8080/org.genesis.login/authenticate" method="post">
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
      </div>
    </form>
         <div class="container">
            <button type="button" onclick="doOpenId()">WSO2 OpenId Login</button>
            <span>Forgot <a href="#">password?</a></span>
          </div>


     <script>
     function doOpenId(){
     var authorizeURL ="https://localhost:9443/oauth2/authorize?response_type=code&scope=openid&client_id=j5eXqvEaZcpCO23fhsWtMDmzta4a&redirect_uri=http://localhost:8080/org.genesis.login/callback";
     window.location = authorizeURL;
     }
     </script>
</body>
</html>