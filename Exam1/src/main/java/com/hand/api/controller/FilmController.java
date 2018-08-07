package com.hand.api.controller;

import com.hand.api.service.FilmService;
import com.hand.domain.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FilmController {
    @Autowired
    private FilmService filmService;

    public int insert(Film film){
        return filmService.insert(film);
    }
}
