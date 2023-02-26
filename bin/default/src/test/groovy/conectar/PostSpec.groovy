package conectar

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PostSpec extends Specification implements DomainUnitTest<Post> {

    void "test Post creation"() {
        given:
            User testUser = new User(username: "testuser", 
                                    email: "testuser@gmail.com", 
                                    password: "1")
        when:
            Post post = new Post(title: "test title", 
                                content: "test content", 
                                author: testUser, 
                                budget: 18000, 
                                numberDevelopers: 3, 
                                numberDesigners: 2, 
                                createdDate: new Date()).save()
        then:
            post.validate()
            post.save()
            post.id != null
    }

    void "test title cannot be null"() {
        when:
            domain.title = null
        then:
            !domain.validate(['title'])
            domain.errors["title"].code == "nullable"
    }

    void "test title cannot be blank"() {
        when:
            domain.title = ""
        then:
            !domain.validate(["title"])
    }

    void "test title cannot exceed 100 characters"() {
        when:
            domain.title = "a"*101
        then:
            !domain.validate(["title"])
    }

    void "test content cannot be null"() {
        when:
            domain.content = null
        then:
            !domain.validate(['content'])
            domain.errors["content"].code == "nullable"
    }

    void "test content cannot be blank"() {
        when:
            domain.content = ""
        then:
            !domain.validate(["content"])
    }

    void "test content cannot exceed 1000 characters"() {
        when:
            domain.content = "a"*1001
        then:
            !domain.validate(["content"])
    }

    void "test budget cannot be null"() {
        when:
            domain.budget = null
        then:
            !domain.validate(['budget'])
            domain.errors["budget"].code == "nullable"
    }

    void "test budget cannot be lower than 0"() {
        when:
            domain.budget = -1
        then:
            !domain.validate(["budget"])
    }

    void "test numberDevelopers cannot be null"() {
        when:
            domain.numberDevelopers = null
        then:
            !domain.validate(['numberDevelopers'])
            domain.errors["numberDevelopers"].code == "nullable"
    }

    void "test numberDevelopers cannot be lower than 0"() {
        when:
            domain.numberDevelopers = -1
        then:
            !domain.validate(["numberDevelopers"])
    }

    void "test numberDesigners cannot be null"() {
        when:
            domain.numberDesigners = null
        then:
            !domain.validate(['numberDesigners'])
            domain.errors["numberDesigners"].code == "nullable"
    }

    void "test numberDesigners cannot be lower than 0"() {
        when:
            domain.numberDesigners = -1
        then:
            !domain.validate(["numberDesigners"])
    }
}
