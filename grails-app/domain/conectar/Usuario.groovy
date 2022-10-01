package conectar

class Usuario {
    String name
    String email
    String password

    static constraints = {
        name blank: false, nullable: false
        email email: true, nullable: false, blank: false
        password blank: false, nullable: false
    }
}
