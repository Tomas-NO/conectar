package conectar

class Offer {
    String comment
    Integer budget
    String status = "Active"
    static belongsTo = [author: User]

    static constraints = {
        comment blank: false, maxSize: 1000
        budget min: 0
        author nullable: false
    }
}
