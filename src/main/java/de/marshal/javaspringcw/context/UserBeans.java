package de.marshal.javaspringcw.context;

import de.marshal.javaspringcw.entities.helloworld.Country;
import de.marshal.javaspringcw.entities.helloworld.HelloWorld;
import de.marshal.javaspringcw.entities.helloworld.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    //    @Autowired
    private final HelloWorld helloWorld;
    //    @Autowired
    private final Country france;
    //    @Autowired
    private final Person person1;
    //    @Autowired
    private final Person person2;

//    @Autowired
//    public void setHelloWorld(HelloWorld helloWorld) {
//        this.helloWorld = helloWorld;
//    }
//
//    @Autowired
//    public void setFrance(Country france) {
//        this.france = france;
//    }
//
//    @Autowired
//    public void setPerson1(Person person1) {
//        this.person1 = person1;
//    }
//
//    @Autowired
//    public void setPerson2(Person person2) {
//        this.person2 = person2;
//    }

    @Autowired
    public UserBeans(HelloWorld helloWorld, Country france, Person person1, Person person2) {
        this.helloWorld = helloWorld;
        this.france = france;
        this.person1 = person1;
        this.person2 = person2;
    }

    public void method() {
        System.out.println("Method in Userbeans class invoked");
        System.out.println(helloWorld.getMessage());
        System.out.println(france);
        System.out.println(person1);
        System.out.println(person2);
    }
}
