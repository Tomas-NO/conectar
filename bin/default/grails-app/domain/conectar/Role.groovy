package conectar

class Role {
    String name
    static hasMany = [users: User]

    static constraints = {
        name blank: false, unique: true
    }
}
