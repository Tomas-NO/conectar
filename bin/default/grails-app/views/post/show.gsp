<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Conectar</title>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script>
        $(document).ready(function() {
            $('.post-offer-button').click(function(e) {
                $('#post')[0].value = e.target.parentNode.parentNode.parentNode.id;
                $('.offer-form').fadeIn();
            });

            $('.close-form').click(function() {
                $('.offer-form').fadeOut();
            });
        });
        </script>
    </head>
    <body>
        <div class="forum-container">
            <g:each in="${posts}" var="post">
                <div class="post" id="${post.id}">
                    <div class="post-image">
                        <asset:image src="profilePicture.jpg" alt="Profile Picture"/>
                    </div>
                    <div class="post-information">
                        <div class="post-header">
                            <g:formatDate format="dd-MM-yyyy" date="${post.createdDate}" class="post-date"/>
                            <p>${post.offers.size()}</p>
                        </div>
                        <h2 class="post-title">${post.title}</h2>
                        <p class="post-content">${post.content}</p>
                        <p class="post-budget">$${post.budget}</p>
                        <div class="post-icons">
                            <div class="post-icons-item">
                                <g:each var="i" in="${ (1..post.numberDevelopers) }">   
                                    <g:if test="${post.acceptedDevelopers - i >= 0}">
                                       <asset:image src="developerFull.png" alt="Developer Icon"/>
                                    </g:if>                 
                                    <g:else>
                                       <asset:image src="developerFree.png" alt="Developer Icon"/>
                                    </g:else>                
                                </g:each>
                            </div>
                            <div class="post-icons-item">
                                <g:each var="i" in="${ (1..post.numberDesigners) }">
                                    <g:if test="${post.acceptedDesigners - i >= 0}">
                                       <asset:image src="designerFull.png" alt="Designer Icon"/>
                                    </g:if>                 
                                    <g:else>
                                       <asset:image src="designerFree.png" alt="Designer Icon"/>
                                    </g:else>  
                                </g:each>
                            </div>                            
                        </div>
                        <g:if test="${session.user.role.name != "Contractor"}">
                            <div class="post-footer">   
                                <g:if test="${session.user.hasCompletedInformation()}">
                                    <button class="post-offer-button">Create Offer</button>
                                </g:if>
                                <g:else>
                                    <button class="post-offer-button" disabled>Create Offer</button>
                                </g:else>
                                <p class="post-author">Created by: ${post.author.username}</p>
                            </div>    
                        </g:if>
                        <g:else>
                            <p class="post-author alone">Created by: ${post.author.username}</p>
                        </g:else>
                    </div>
                </div>
            </g:each>
        </div>
        <div class="offer-form" style="display:none;">
            <div class="form-content">
                <span class="close-form">&times;</span>
                <g:form controller="Offer" action="save" method="post">
                    <h2 class="form-title">Create Offer</h2>
                    <input id="post" type="text" name="post" style="display:none;"/>
                    <div>
                        <label>Budget</label>
                        <input class="form-field" type="number" name="budget" min="0" required=""/>
                    </div>
                    <div>
                        <label>Comment</label>
                        <g:textArea class="form-field" name="comment" maxlength="1000" rows="10" required=""/>
                    </div>
                    <g:submitButton class="button" name="create" value="Create Offer"/>
                </g:form>
            </div>
        </div>
    </body>
</html>