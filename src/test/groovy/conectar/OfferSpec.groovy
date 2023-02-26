package conectar

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OfferSpec extends Specification implements DomainUnitTest<Offer> {

    void "test Offer properties"() {
        given:
            Role testRole = new Role(name:"testRole")
            User testUser = new User(username: "test", 
                                    password: "test", 
                                    email: "test@gmail.com", 
                                    role: testRole, 
                                    firstName: "test", 
                                    lastName: "test", 
                                    country: "Argentina", 
                                    age: 25)
            Post testPost = new Post(title: "Test", 
                                    content: "Test", 
                                    author: testUser,
                                    budget: 100, 
                                    numberDevelopers: 3, 
                                    numberDesigners: 2, 
                                    createdDate: new Date())
        when:
            Offer offer = new Offer(comment: "test comment", 
                                    budget: 100, 
                                    author: testUser, 
                                    post: testPost)
        then:
            offer.validate()
            offer.save()
        when:
            Offer savedOffer = Offer.get(offer.id)
        then:
            savedOffer.comment == "test comment"
    }

    void "test comment cannot be null"() {
        when:
            domain.comment = null
        then:
            !domain.validate(['comment'])
            domain.errors["comment"].code == "nullable"
    }

    void "test comment cannot be blank"() {
        when:
            domain.comment = ""
        then:
            !domain.validate(["comment"])
    }

    void "test comment cannot exceed 1000 characters"() {
        when:
            domain.comment = "a"*1001
        then:
            !domain.validate(["comment"])
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
}
