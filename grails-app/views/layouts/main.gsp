<!doctype html>
<html lang="en" class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
        <title>
            <g:layoutTitle default="Grails"/>
        </title>
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <asset:link rel="icon" href="favicon.png" type="image/x-ico"/>

        <asset:stylesheet src="application.css"/>
        
        <g:layoutHead/>
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
                <div class="container-fluid">
                    <g:if test="${!session.user}">
                        <g:link controller="user" action="signIn">
                            <asset:image src="logo.png" alt="Grails Logo" class="logo"/>
                        </g:link>
                        <ul class="nav navbar-nav">
                            <li>
                                <g:link controller="user" action="signIn" class="navbar-link">Sign in</g:link>
                            </li>
                            <li>
                                <g:link controller="user" action="signUp" class="navbar-link">Sign up</g:link>
                            </li>
                        </ul>
                    </g:if>
                    <g:else>
                        <g:link controller="post" action="show">
                            <asset:image src="logo.png" alt="Grails Logo" class="logo"/>
                        </g:link>
                        <ul class="nav navbar-nav">
                            <li>
                                <g:link controller="post" action="show" class="navbar-link">Forum</g:link>
                            </li>
                            <g:if test="${session.user.role.name == 'Contractor'}">
                                <g:if test="${session.user.hasCompletedInformation()}">
                                    <li>
                                        <g:link controller="post" action="create" class="navbar-link">Make a Post</g:link>
                                    </li>
                                </g:if>
                                <g:else>
                                    <li>
                                        <g:link controller="user" action="info" class="navbar-link">Make a Post</g:link>
                                    </li>
                                </g:else>
                                <li>
                                    <g:link controller="offer" action="showWithPosts" class="navbar-link">Offers</g:link>
                                </li>
                            </g:if>
                            <g:else>
                               <li>
                                    <g:link controller="offer" action="showIndividual" class="navbar-link">Offers</g:link>
                                </li>
                            </g:else>
                            <li>
                                <g:link controller="user" action="info" class="navbar-link">Profile</g:link>
                            </li>
                            <li>
                                <g:link controller="user" action="signOut" class="navbar-link">Sign out</g:link>
                            </li>
                        </ul>
                    </g:else>
                    
                </div>
            </nav>
        </header>

        <div class="content-container">
            <g:layoutBody/>
        </div> 

        <div class="footer" role="contentinfo">
            <div class="container-fluid">
                <p>&copy; 2023 Copyright<br>All rights reserved</p>
            </div>
        </div>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>

        <asset:javascript src="application.js"/>
    </body>
</html>
