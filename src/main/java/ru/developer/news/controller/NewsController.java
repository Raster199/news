package ru.developer.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.developer.news.service.NewsService;
import ru.developer.news.service.exeception.NotFoundException;

import static org.springframework.util.Assert.notNull;

/**
 * Created by raster on 05.03.17.
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        notNull(newsService, "News Service must be not null");
        this.newsService = newsService;
    }

    @GetMapping
    public String newsPage(Model model) {
        model.addAttribute("newsList", newsService.findAll());
        return "news";
    }

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handler(NotFoundException e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("message", e.getMessage());
        return mv;
    }
}
