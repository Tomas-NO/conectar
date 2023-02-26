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
            <g:form action="save" method="post">
                <h2 class="form-title">Create a Post</h2>
                <div>
                    <label>Title</label>
                    <g:textField class="form-field" name="title" maxlength="100" required=""/>
                </div>
                <div>
                    <label>Content</label>
                    <g:textArea class="form-field" name="content" rows="10" maxlength="1000" required=""/>
                </div>
                <div>
                    <label>Budget</label>
                    <input class="form-field" type="number" name="budget" min="0" required="">
                </div>
                <div class="post-creation-number">
                    <div>
                        <label>Number of Developers</label>
                        <input class="form-field" type="number" name="numberDevelopers" value="${post?.numberDevelopers}" min="0" max="10" required="">
                    </div>
                    <div>
                        <label>Number of Designers</label>
                        <input class="form-field" type="number" name="numberDesigners" value="${post?.numberDesigners}" min="0" max="10" required="">
                    </div>
                </div>
                <g:submitButton class="button" name="create" value="Create Post"/>
            </g:form>
        </div>
    </body>
</html>