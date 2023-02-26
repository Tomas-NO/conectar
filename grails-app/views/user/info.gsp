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
            <g:form action="edit" method="post">
                <h2 class="form-title">User Information</h2>
                <div>
                    <label for="username">Username</label>
                    <input value="${user.username}" class="form-field" type="text" minlength="4" maxlength="15"  name="username" required="">
                </div>
                <div>
                    <label for="password">Password</label>
                    <input value="${user.password}" class="form-field" type="password" minlength="4" maxlength="15" name="password" required="">
                </div>
                <div>
                    <label for="email">Email</label>
                    <input value="${user.email}" class="form-field" type="email" name="email" required="">
                </div>
                <div>
                    <label for="firstName">First Name:</label>
                    <input value="${user.firstName}" class="form-field" type="text" minlength="0" maxlength="100" name="firstName" required="">
                </div>
                <div>
                    <label for="lastName">Last Name:</label>
                    <input value="${user.lastName}" class="form-field" type="text" minlength="0" maxlength="100" name="lastName" required="">
                </div>
                <div>
                    <label for="country">Country:</label>
                    <select class="form-field" name="country" id="country" required>
                        <g:if test="${user.country == "0"}">
                            <option value="0" selected="selected" hidden>Select a country ... </option>
                        </g:if>
                        <g:each var="country" in="${countryList}">
                            <option value="${country}" ${country == user.country ? 'selected' : ''}>${country}</option>
                        </g:each>
                    </select>
                </div>
                <div>
                    <label for="age">Age:</label>
                    <input value="${user.age}" class="form-field" type="number" min="18" max="100" name="age" required="">
                </div>
                <button type="submit" class="button">Editar</button>
            </g:form>
        </div>
    </body>
</html>