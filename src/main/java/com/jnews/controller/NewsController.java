package com.jnews.controller;

import com.jnews.model.News;
import com.jnews.service.NewsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    private final NewsServiceImpl service;

    public NewsController(NewsServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/news")
    public List<News> getAllNews() {
        return service.getAllNews();
    }
}
