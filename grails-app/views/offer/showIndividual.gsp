<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Conectar</title>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>
        <div class="show-offers-container">
            <div class="post-offers-container">
                <div class="offers-container">
                    <g:each in="${offers.sort{it.id}.reverse()}" var="offer">
                        <div class="offer">
                            <div>
                                <h3><strong>Buget:</strong> ${offer.budget}</h2>
                                <p><strong>Comment:</strong> ${offer.comment}</p>
                                <p><strong>Status:</strong> ${offer.status}</p>
                                <p class="offer-author"><strong>Created by:</strong> ${offer.author.username}</p>
                            </div>
                        </div>
                    </g:each>
                </div>
            </div>
        </div>
    </body>
</html>