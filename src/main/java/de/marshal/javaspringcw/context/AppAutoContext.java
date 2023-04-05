package de.marshal.javaspringcw.context;

import de.marshal.javaspringcw.entities.helloworld.Country;
import de.marshal.javaspringcw.entities.helloworld.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan(basePackages = {
        "de.marshal.javaspringcw.entities.helloworld",
        "de.marshal.javaspringcw.context"
})
//@SpringBootApplication
public class AppAutoContext {

    @Autowired
    private Country france;

    @Bean
    public Person person1() {
        Person person = new Person("Bob", 25, france);
        return person;
    }

    @Bean(initMethod = "introduce", destroyMethod = "finishOperation") // для методов
    @Lazy
    public Person person2() {
        Person person = new Person("Tom", 33, france);
        return person;
    }
}

