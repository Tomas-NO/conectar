package conectar

class Usuario {
    String nombre
    String apellido
    String email

    static constraints = {
        nombre blank: false, nullable: false
        apellido blank: false, nullable: false
        email email: true, nullable: false, blank: false
    }
}
