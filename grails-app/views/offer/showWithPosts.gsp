<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Conectar</title>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <div class="show-offers-container">
            <g:if test="${flash.message}">
                <div id="flash-message" class="alert alert-danger">
                    ${flash.message}
                </div>
            </g:if>
            <g:each in="${posts}" var="post">
                <div class="post-offers-container">
                    <h2 class="post-offers-title">Post: ${post.title}</h2>
                    <div class="offers-container">
                        <g:each in="${post.offers.sort{it.id}.reverse()}" var="offer">
                            <g:if test="${offer.status == "Active"}">
                                <div class="offer">
                                    <div>
                                        <h3><strong>Buget:</strong> ${offer.budget}</h2>
                                        <p><strong>Role:</strong> ${offer.author.role.name}</p>
                                        <p><strong>Comment:</strong> ${offer.comment}</p>
                                        <p class="offer-author"><strong>Created by:</strong> ${offer.author.username}</p>
                                    </div>
                                    <div class="offer-buttons">
                                        <g:link style="color:green;" controller="offer" action="accept" params="[postId: post.id, offerId: offer.id]">
                                            Accept
                                        </g:link>
                                        <g:link style="color:red;" controller="offer" action="reject" params="[postId: post.id, offerId: offer.id]">
                                            Reject
                                        </g:link>
                                    </div>
                                </div>
                            </g:if>
                        </g:each>
                    </div>
                </div>
            </g:each>
        </div>
    </body>
</html>