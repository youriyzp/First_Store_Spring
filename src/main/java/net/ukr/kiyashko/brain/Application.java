package net.ukr.kiyashko.brain;

import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.Product;
import net.ukr.kiyashko.brain.model.User;
import org.hibernate.type.DateType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.datetime.standard.DateTimeContextHolder;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.System.err;
import static net.ukr.kiyashko.brain.model.enums.UnitEnum.piece;

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
 // try {
//
//        // TODO Подключение к БД
//        JdbcConnector app = new JdbcConnector();
//        conn = app.connect();
//        // TODO создать Пользователя - new User
//Date date = new Date();
       //User bot = new User(1,"q@trr.com","password", bot.getCreationDate(),"Zp","bot1","Booot1",0671234567,"paswordhash");
    User bot2 = new User();

//        // TODO создать несколько произвольных товаров - new Product
     //   List<String> tags= new ArrayList<>();
//        tags.add("Igr");
    Product enythink =new Product();
      Product strela = new Product((long) 1,"strela",1.26,piece);
    Product strelaLux = new Product((long) 1,"strela lux",1.32,piece);
     //   Product kukla = new Product(2,"kukla",150,new ArrayList<>());
//        // TODO создать Заказ - new Purchase
Order order1 = new Order();
//Order order2= new Order(order2.getId(),"1",order2.getLast_order() ,1,3,15);



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
//  }
// Подготовка SQL запроса, на вставку продукта
    //try{
//PreparedStatement productStatement= new PreparedStatement("INSERT INTO store.products " +
//        "VALUES (DEFAULT,'Пароварка', 780, ?,?)",
//        Statement.RETURN_GENERATED_KEYS) {
//}; // указываем возвращение сгенерированного ID

    // Создание значения для колонки с датой
//    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            productStatement.setTimestamp(1, timestamp);

    // Создание значения для колонки с массивом
//    Array tags = conn.createArrayOf("varchar", new Object[]{"Кухня", "Бытовая техника"});
//            productStatement.setArray(2, tags);

    // Выполнение
    //        productStatement.executeUpdate();

    // Обработка ответа, считываем созданный ID
//            try (ResultSet generatedKeys = productStatement.getGeneratedKeys()) {
//        if (generatedKeys.next()) {
//            System.out.println(generatedKeys.getInt(1));
//        }
//        else {
//            throw new SQLException("Creating user failed, no ID obtained.");
//        }
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Подготовка SQL запроса, на вставку пользователя
            /*PreparedStatement user
                    = conn.prepareStatement("INSERT INTO store.users " +
                    "VALUES (DEFAULT,'abc@gml.com', 'qwerty', 'Запорожье, пр.Соборный 22', ?)");
            user.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            user.executeUpdate();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Подготовка SQL запроса, на вставку заказа
            PreparedStatement purchase
                    = conn.prepareStatement("INSERT INTO store.purchases " +
                    "VALUES (DEFAULT, ?, '#123456', 'Запорожье, пр.Соборный 23', 123, 0)");
            purchase.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            purchase.executeUpdate();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            // Подготовка SQL запроса, на вставку заказанного товара
            PreparedStatement purchaseItem1
                    = conn.prepareStatement("INSERT INTO store.purchase_items " +
                    "VALUES (DEFAULT, 1000, 1, 1460, 2, 'Отправлено')");
            purchaseItem1.executeUpdate();
*/
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Получение всех значений товаров из таблицы
//    ResultSet result = conn.createStatement().executeQuery("SELECT id, title, price, created_at, tags " +
//            "  FROM store.products;");

    // Список для сформированного результата
//    List<Product> selectProducts = new ArrayList<>();
////
////    // Цикл по всем рзультатам запроса
////            while (result.next()) {
////        // Переводим результаты значений колонок в объект
////        Product p = new Product(1,"Myach",500, (List<String>) tags);
////        p.setId(result.getInt(1)); // получение по номеру колонки
////        p.setTitle(result.getString("title")); // получение по имени колонки
////        p.setPrice(result.getInt("price"));
////        p.setCreateAt(result.getDate("created_at"));
////
////        Array tagValues = result.getArray("tags"); // получаем массив
////        p.setTags(Arrays.asList((String[]) tagValues.getArray())); // конвертируем массив в список
////
////        selectProducts.add(p);
////    }
////            conn.close();
//} catch (Exception e) {
//        System.err.println("Got an exception! ");
//        System.err.println(e.getMessage());
//        }



}