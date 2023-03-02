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
    static belongsTo = [author: User]

    static constraints = {
        title blank: false, maxSize: 100
        content blank: false, maxSize: 1000
        budget min: 0 
        numberDevelopers min:0
        numberDesigners min:0
        offers nullable: true
        author nullable: false
    }

    static mapping = {
        offers cascade: 'all-delete-orphan'
        sort id: "desc"
    }

    Boolean isFull() {
        return (this.numberDevelopers == this.acceptedDevelopers && this.numberDesigners == this.acceptedDesigners)
    }

    Boolean isFullRole(User user) {
        String roleString = user.role.name
        switch(roleString) {
            case "Developer":
                return this.numberDevelopers == this.acceptedDevelopers
                break
            case "Designer":
                return this.numberDesigners == this.acceptedDesigners
                break
        }
    }
}
