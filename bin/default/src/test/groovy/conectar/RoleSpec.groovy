package conectar

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RoleSpec extends Specification implements DomainUnitTest<Role> {

    void "test Role properties"() {
        when:
            Role role = new Role(name: "admin")
        then:
            role.validate()
            role.save()
        when:
            Role savedRole = Role.get(role.id)
        then:
            savedRole.name == "admin"
    }

    void "test name cannot be null"() {
        when:
            domain.name = null
        then:
            !domain.validate(['name'])
            domain.errors["name"].code == "nullable"
    }

    void "test name cannot be blank"() {
        when:
            domain.name = ""
        then:
            !domain.validate(["name"])
    }
}
