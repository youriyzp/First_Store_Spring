package net.ukr.kiyashko.brain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.err;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");
        source.setCacheSeconds(3600); // Refresh cache once per hour.
        return source;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    try {
//
//        // TODO Подключение к БД
//        JdbcConnector app = new JdbcConnector();
//        conn = app.connect();
//        // TODO создать Пользователя - new User
//        User bot = new User(1,"a@d.tr.com","7Street","Jon");
//        // TODO создать несколько произвольных товаров - new Product
//        List<String> tags= new ArrayList<>();
//        tags.add("Igr");
//        Product myach = new Product(1,"myach",120,tags);
//        Product kukla = new Product(2,"kukla",150,new ArrayList<>());
//        // TODO создать Заказ - new Purchase
//
//        Purchase zakaz = new Purchase(new java.util.Date(),"Tolik","Zp",69059,bot.getId());
//
//        // TODO создать несколько заказанных единиц  - new PurchaseItem
//        PurchaseItem vesh1 = new PurchaseItem(1,2,300,1);
//        PurchaseItem vesh2 = new PurchaseItem(2,3,320,2);
//        // *TODO Получить все заказы и купленные товары пользователем.
//
//        conn.close();
//    } catch (Exception e) {
//        err.println("Got an exception! ");
//        err.println(e.getMessage());
//    }

}