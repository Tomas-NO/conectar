package conectar

class OfferController {

    def showWithPosts() {
        def posts = Post.findAllByAuthor(session.user)
        [posts: posts]
    }

    def showIndividual() {
        def offers = Offer.findAllByAuthor(session.user)
        [offers: offers]
    }

    def save() { 
        Post.withTransaction {
            def post = Post.get(params.post)
            def offer = new Offer(params)
            offer.author = session.user
            if(!offer.hasErrors()) {
                post.addToOffers(offer)
                post.save(flush:true)
            } else {
                flash.message = "Error creating Offer"
            }
        }
        redirect(controller: 'Post', action: 'show')
    }

    def accept() {
        Post.withTransaction {
            def post = Post.get(params.postId)
            def offer = Offer.get(params.offerId)
            if(!post.isFullRole(offer.author)) {
                offer.status = "Accepted"
                if(offer.author.role.name == "Developer") {
                    post.acceptedDevelopers++
                } else {
                    post.acceptedDesigners++
                }
                if(!offer.hasErrors() && !post.hasErrors()) {
                    post.save(flush:true)
                } else {
                    flash.message = "Error accepting Offer"
                }
            } else {
                flash.message = "Capacity for this role has already been filled"
            }
            if(post.isFull()) {
                post.delete(flush: true)
            }
        }
        redirect(action: "showWithPosts")
    }

    def reject() {
        Post.withTransaction {
            def post = Post.get(params.postId)
            def offer = Offer.get(params.offerId)
            offer.status = "Rejected"
            if(!offer.hasErrors() && !post.hasErrors()) {
                post.save(flush:true)
            } else {
                flash.message = "Error rejecting Offer"
            }
        }
        redirect(action: "showWithPosts")
    }
}
