//package de.marshal.javaspringcw.context;
//
//import de.marshal.javaspringcw.entities.helloworld.Country;
//import de.marshal.javaspringcw.entities.helloworld.HelloWorld;
//import de.marshal.javaspringcw.entities.helloworld.Person;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class AppContext {
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
////    @Scope("prototype")
//    public HelloWorld helloWorld(){
//        return new HelloWorld();
//    }
//
//    @Bean
//    public Country france(){
//        Country country = new Country();
//        country.setName("France");
//        country.setCode("FR");
//        return country;
//    }
//    @Bean
//    public Country germany(){
//        Country country = new Country();
//        country.setName("Germany");
//        country.setCode("DE");
//        return country;
//    }
//
//    @Bean
//    public Person person1(){
//        Person person = new Person("Bob", 25, france());
//        return person;
//    }
//
//    @Bean(initMethod = "introduce", destroyMethod = "finishOperation") // для методов
//    public Person person2(){
//        Person person = new Person("Tom", 33, germany());
//        return person;
//    }
//}
