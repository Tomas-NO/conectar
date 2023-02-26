<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Conectar</title>
    </head>
    <body>
        <div class="padded">
            <g:if test="${flash.message}">
                <div id="flash-message" class="alert alert-danger">
                    ${flash.message}
                </div>
            </g:if>
            <g:form action="authenticate" method="post">
                <h2 class="form-title">Sign in</h2>
                <div>
                    <label for="username">Username</label>
                    <input class="form-field" type="text" minlength="4" maxlength="15" name="username" required>
                </div>
                <div>
                    <label for="password">Password</label>
                    <input class="form-field" type="password" minlength="4" name="password" required>
                </div>
                <button type="submit" class="button">Sign in</button>
            </g:form>
        </div>
    </body>
</html>