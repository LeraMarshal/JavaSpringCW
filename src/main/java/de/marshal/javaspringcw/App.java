package de.marshal.javaspringcw;

//import de.marshal.javaspringcw.context.AppAutoContext;
import de.marshal.javaspringcw.context.AppAutoContext;
import de.marshal.javaspringcw.context.UserBeans;
import de.marshal.javaspringcw.entities.helloworld.Country;
import de.marshal.javaspringcw.entities.helloworld.HelloWorld;
import de.marshal.javaspringcw.entities.helloworld.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ServletComponentScan
public class App {

//    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);
//    }


//    public static void main(String[] args) {
////        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
////        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppAutoContext.class);
//
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//        helloWorld.setMessage("Hello World!");
//        System.out.println(helloWorld.getMessage());
//
//        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
//        helloWorld2.setMessage("Another message..");
//
//        System.out.println(helloWorld.getMessage());
//        System.out.println(helloWorld2.getMessage());
//
//        System.out.println("____________________");
//        //
//
//        Country country = (Country) context.getBean("france");
//        Person person1 = (Person) context.getBean("person1");
//        Person person2 = (Person) context.getBean("person2");
//
//        System.out.println(country);
//        System.out.println(person1);
//        System.out.println(person2);
//    }

    public static void main(String[] args) {
        System.out.println("Main starts");

//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppAutoContext.class);

        System.out.println("Context created");

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.setMessage("Hello World!");

        System.out.println(helloWorld.getMessage());

        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorld");
        helloWorld2.setMessage("Another message");

        System.out.println(helloWorld.getMessage());
        System.out.println(helloWorld2.getMessage());

        Country country = (Country) context.getBean("france");
        Person personOne = (Person) context.getBean("person1");
        Person personTwo = (Person) context.getBean("person2");
        System.out.println(personOne.getCountry() == personTwo.getCountry());


//        AppContext appContext = new AppContext();
//        Person person1 = appContext.person1();
//        Person person2 = appContext.person2();
//        System.out.println(person1.getCountry() == person2.getCountry());

        System.out.println(country);
        System.out.println(personOne);
        System.out.println(personTwo);

        UserBeans userBeans = context.getBean(UserBeans.class);
        userBeans.method();

        context.close();
//        context.getBean("person1");
        System.out.println("Main ends");
    }
}