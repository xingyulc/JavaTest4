package com.hand;

import com.hand.api.controller.FilmController;
import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Application
 */
public class Application {


    public static void main(String[] args) {
        System.out.println("Context Start");
        Application application = new Application();
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //程序中使用的title，description和languageId需要从环境变量中读取
        String title = System.getenv("title");
        String description = System.getenv("description");
        Byte languageId = Byte.valueOf(System.getenv("languageId"));
        Film film = new Film();
        film.setFilmId((short) 10001);
        film.setTitle(title);
        film.setDescription(description);
        film.setLanguageId(languageId);
        film.setRentalRate(BigDecimal.valueOf(9.9));
        film.setLength((short) 101);
        film.setReplacementCost(BigDecimal.valueOf(26.99));
        film.setRating("NC-17");
        film.setSpecialFeatures("Trailers,Commentaries,Deleted Scenes");
        film.setLastUpdate(new Date());

        System.out.println("Film Title：\n"+title);
        System.out.println("Film Description：\n"+description);
        System.out.println("Film LanguageId：\n"+languageId);
        FilmController filmController = (FilmController) ctx.getBean("filmController");
        filmController.insert(film);
        System.out.println("Context Stop");


    }
}
