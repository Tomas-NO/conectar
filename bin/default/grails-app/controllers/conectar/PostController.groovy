package conectar

class PostController {
    def show() { 
        def posts = Post.list()
        [posts: posts]
    }

    def create() { }

    def save() {
        Post.withTransaction {
            if(session.user.hasCompletedInformation()) {
                if(params.int("numberDevelopers") + params.int("numberDesigners") > 0) {
                    def post = new Post(params)
                    post.author = session.user
                    post.createdDate = new Date()
                    if(!post.hasErrors()) {
                        post.save(flush: true)
                        redirect(action: "show")
                    } else {
                        flash.message = "An error occurred while trying to create the post"
                        render(view: "create")
                    }
                } else {
                    flash.message = "Your Post has to have at least one developer or designer"
                    render(view: "create")
                }  
            } else {
                flash.message = "You must complete your profile information before creating Posts"
                render(view: "create")
            }
        }
    }

    def delete() {
        Post.withTransaction{
            def post = Post.get(params.postId)
            post.delete(flush: true)
        }
        redirect(action: "show")
    }
}
