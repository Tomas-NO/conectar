package conectar

class Post {
    String title
    String content
    Integer budget
    Integer numberDevelopers
    Integer numberDesigners
    Integer acceptedDevelopers = 0
    Integer acceptedDesigners = 0
    Date createdDate
    static hasMany = [offers: Offer]
    List<Offer> acceptedOffers = []
    static belongsTo = [author: User]

    static constraints = {
        title blank: false, maxSize: 100
        content blank: false, maxSize: 1000
        author nullable: false
        budget min: 0 
        numberDevelopers min:0
        numberDesigners min:0
        offers nullable: true
        acceptedOffers nullable: true 
    }

    static mapping = {
        offers cascade: 'all-delete-orphan'
    }

    void acceptOffer(Offer offer) {
        acceptedOffers.add(offer)
        if(offer.author.role = 'Developer') {
            acceptedDevelopers++
        } else {
            acceptedDesigners++
        }
    }

}
