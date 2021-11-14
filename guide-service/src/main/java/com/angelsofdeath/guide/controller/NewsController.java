package com.angelsofdeath.guide.controller;

import com.angelsofdeath.guide.entity.NewGuide;
import com.angelsofdeath.guide.entity.News;
import com.angelsofdeath.guide.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/edit/{id}")
    public void editGuide(@PathVariable String id, @RequestBody NewGuide ch) {
        newsService.editNew(id, ch.getName(), ch.getText(), ch.getUserId());
    }

    @PostMapping("/add")
    public void addGuide(@RequestBody NewGuide ch){
        newsService.addNew(ch.getUserId(),ch.getName(),ch.getText());
    }

    @PostMapping("/delete/{id}")
    public void deleteGuide(@PathVariable String id, @RequestBody NewGuide ch){
        newsService.deleteNew(id, ch.getUserId());
    }
}
