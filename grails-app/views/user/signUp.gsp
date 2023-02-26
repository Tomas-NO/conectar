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
            <g:form action="save" method="post" >
                <h2 class="form-title">Sign up</h2>
                <div>
                    <label for="role">Role</label>
                    <g:select class="form-field" name="role" from="${conectar.Role.list()}" optionKey="id" optionValue="name" value="${role?.id}" required=""/>
                </div>
                <div>
                    <label for="username">Username</label>
                    <input class="form-field" type="text" minlength="4" maxlength="15" name="username" required="">
                </div>
                <div>
                    <label for="password">Password</label>
                    <input class="form-field" type="password" minlength="4" maxlenght="15" name="password" required="">
                </div>
                <div>
                    <label for="email">Email</label>
                    <input class="form-field" type="email" name="email" required="">
                </div>
                <div>
                    <label for="email">Age</label>
                    <input class="form-field" type="number" min="18" max="100" name="age" required="">
                </div>
                <button type="submit" class="button">Sign up</button>
            </g:form>
        </div>
    </body>
</html>