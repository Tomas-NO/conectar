package conectar
import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        Role contractorRole = new Role(name: "Contractor").save()
        Role developerRole = new Role(name: "Developer").save()
        Role designerRole = new Role(name: "Designer").save()
        User contractorUser = new User( username: "tomascontractor", 
                                        password: "1111", 
                                        email: "contractor@gmail.com", 
                                        age: 25,
                                        role: contractorRole, 
                                        firstName: "First Name", 
                                        lastName: "Last Name", 
                                        country: "Argentina").save()
        User developerUser = new User(  username: "tomasdeveloper", 
                                        password: "1111", 
                                        email: "developer@gmail.com", 
                                        age: 30,
                                        role: developerRole, 
                                        firstName: "First Name", 
                                        lastName: "Last Name", 
                                        country: "Argentina").save()
        User designerUser = new User(   username: "tomasdesigner", 
                                        password: "1111", 
                                        email: "designer@gmail.com", 
                                        age: 18,
                                        role: designerRole, 
                                        firstName: "First Name", 
                                        lastName: "Last Name", 
                                        country: "Argentina").save()
        Post.withTransaction {
            Post post1 = new Post(  title: "Artificial Intelligence Project", 
                                    content: "I am looking for a specialized chatbot for my web application. I need it to answer the most common questions that our customers may have. If the questions are more complex it should delegate them to an operator.", 
                                    author: contractorUser, 
                                    budget: 18000, 
                                    numberDevelopers: 3, 
                                    numberDesigners: 2, 
                                    createdDate: new Date())
            Offer offer1 = new Offer(comment: "test offer 1", 
                                    budget: 100, 
                                    author: developerUser)
            Offer offer2 = new Offer(comment: "test offer 2", 
                                    budget: 200, 
                                    author: designerUser)
            Offer offer3 = new Offer(comment: "test offer 3", 
                                    budget: 300, 
                                    author: developerUser)
               
            post1.addToOffers(offer1)
            post1.addToOffers(offer2)                                            
            post1.addToOffers(offer3) 
            post1.save(flush: true)
        }

        Post.withTransaction {
            Post post2 = new Post(  title: "Ecommerce Project", 
                                    content: "I am looking to make an ecommerce for my company. I need it to have several payment methods and I don't care about the technologies used in the process.", 
                                    author: contractorUser, 
                                    budget: 5000, 
                                    numberDevelopers: 1, 
                                    numberDesigners: 1, 
                                    createdDate: new Date()).save()
            Offer offer1 = new Offer(comment: "test offer 1", 
                                    budget: 100, 
                                    author: developerUser)
            Offer offer2 = new Offer(comment: "test offer 2", 
                                    budget: 200, 
                                    author: designerUser)
            Offer offer3 = new Offer(comment: "test offer 3", 
                                    budget: 300, 
                                    author: developerUser)
            Offer offer4 = new Offer(comment: "test offer 4", 
                                    budget: 400, 
                                    author: developerUser)
            Offer offer5 = new Offer(comment: "test offer 5", 
                                    budget: 500, 
                                    author: developerUser)
            Offer offer6 = new Offer(comment: "test offer 6", 
                                    budget: 600, 
                                    author: developerUser)
            Offer offer7 = new Offer(comment: "test offer 7", 
                                    budget: 700, 
                                    author: developerUser)
               
            post2.addToOffers(offer1)
            post2.addToOffers(offer2)                                            
            post2.addToOffers(offer3) 
            post2.addToOffers(offer4) 
            post2.addToOffers(offer5) 
            post2.addToOffers(offer6) 
            post2.addToOffers(offer7) 

            post2.save(flush: true)
        }

        Post.withTransaction {
            Post post3 = new Post(  title: "Salesforce Convertion of a Company", 
                                    content: "I need several developers and designers specialized in salesforce for the transformation of our company. We currently do not use any type of CRM, so it would be starting from 0 until our entire system can be operable with the Salesforce platform.", 
                                    author: contractorUser, 
                                    budget: 123500, 
                                    numberDevelopers: 10, 
                                    numberDesigners: 10, 
                                    createdDate: new Date())
            Offer offer1 = new Offer(comment: "test offer 1", 
                                    budget: 100, 
                                    author: developerUser)
            post3.addToOffers(offer1)
            post3.save(flush: true)
        }
    }

    def destroy = {
    }
}
