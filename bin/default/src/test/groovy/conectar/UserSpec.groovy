package conectar

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {
    
    void "test User properties"() {
        given:
            Role testRole = new Role(name:"testRole")
        when:
            User testUser = new User(username: "test", 
                                    password: "test", 
                                    email: "test@gmail.com", 
                                    role: testRole, 
                                    firstName: "test", 
                                    lastName: "test", 
                                    country: "Argentina", 
                                    age: 25)
        then:
            testUser.validate()
            testUser.save()
        when:
            User savedUser = User.get(testUser.id)
        then:
            savedUser.username == "test"
    }

    void "test username cannot be null"() {
        when:
            domain.username = null
        then:
            !domain.validate(['username'])
            domain.errors["username"].code == "nullable"
    }

    void "test username cannot contain less than 4 characters"() {
        when:
            domain.username = "a"*2
        then:
            !domain.validate(["username"])
    }

    void "test username cannot contain more than 15 characters"() {
        when:
            domain.username = "a"*16
        then:
            !domain.validate(["username"])
    }

    void "test password cannot be null"() {
        when:
            domain.password = null
        then:
            !domain.validate(['password'])
            domain.errors["password"].code == "nullable"
    }

    void "test password cannot contain lesss than 4 characters"() {
        when:
            domain.password = "a"*2
        then:
            !domain.validate(["password"])
    }

    void "test password cannot contain more than 15 characters"() {
        when:
            domain.password = "a"*16
        then:
            !domain.validate(["password"])
    }

    void "test email cannot be null"() {
        when:
            domain.email = null
        then:
            !domain.validate(['email'])
            domain.errors["email"].code == "nullable"
    }

    void "test email cannot be blank"() {
        when:
            domain.email = ""
        then:
            !domain.validate(["email"])
    }

    void "test email has to be email format"() {
        when:
            domain.email = "tomas"
        then:
            !domain.validate(["email"])
    }

    void "test age cannot be null"() {
        when:
            domain.age = null
        then:
            !domain.validate(["age"])
            domain.errors["age"].code == "nullable"
    }

    void "test age cannot be lower than 18"() {
        when:
            domain.age = 10
        then:
            !domain.validate(["age"])
    }

    void "test age cannot be higher than 100"() {
        when:
            domain.age = 101
        then:
            !domain.validate(["age"])
    }

    void "test User hasCompletedInformation false"() {
        given:
            Role testRole = new Role(name:"testRole")
        when:
            User testUser = new User(username: "test", 
                                    password: "test", 
                                    email: "test@gmail.com", 
                                    role: testRole, 
                                    age: 25)
        then:
            !testUser.hasCompletedInformation()
    }

    void "test User hasCompletedInformation true"() {
        given:
            Role testRole = new Role(name:"testRole")
        when:
            User testUser = new User(username: "test", 
                                    password: "test", 
                                    email: "test@gmail.com", 
                                    role: testRole, 
                                    age: 25)
            testUser.firstName = "test"
            testUser.lastName = "test" 
            testUser.country = "Argentina"
        then:
            testUser.hasCompletedInformation()
    }
}
