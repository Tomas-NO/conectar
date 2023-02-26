package conectar

class User {
    String username
    String password
    String email
    Integer age
    // Values initialized blank so they can change it later
    String firstName = ""
    String lastName = ""
    // Value initialized in 0 for use in Country Dropdown
    String country = "0"
    static belongsTo = [role: Role]

    static constraints = {
        username unique:true, size: 4..15
        password size: 4..15
        email blank:false, email:true
        age min: 18, max: 100
        role nullable: false
    }

    static mapping = {
        role lazy: false
    }

    Boolean hasCompletedInformation() {
        return firstName != "" && lastName != "" && country != "0"
    }
}
