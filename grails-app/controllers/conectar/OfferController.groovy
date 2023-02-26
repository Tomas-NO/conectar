package conectar

class OfferController {

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
}
