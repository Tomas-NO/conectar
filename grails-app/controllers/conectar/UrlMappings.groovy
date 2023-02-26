package conectar

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "user", action: "signIn")
        "/signIn"(controller: "user", action: "signIn")
        "/signUp"(controller: "user", action: "signUp")
        "/profile" (controller: "user", action: "info")
        "/edit" (controller: "user", action: "edit")
        "/forum" (controller: "post", action: "show")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
