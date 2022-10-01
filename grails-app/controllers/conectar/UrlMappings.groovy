package conectar

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/registration"(view:"/registration")
        "/sign-up"(view:"/signUp")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
