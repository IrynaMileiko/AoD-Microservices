package com.angelsofdeath.guide.controller;

import com.angelsofdeath.guide.entity.News;
import com.angelsofdeath.guide.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/news")
public class NewsController {
    NewsService newsService = new NewsService();

    @GetMapping("/all")
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public News getNews(@PathVariable String id) {
        return newsService.getNews(id);
    }
}
