package com.angelsofdeath.guide.service;

import com.angelsofdeath.guide.entity.News;
import com.angelsofdeath.guide.repository.NewsRepository;

import java.util.List;

public class NewsService {
    private NewsRepository newsRepository = new NewsRepository();

    public List<News> getAllNews() {
        return newsRepository.getAllNews();
    }

    public News getNews(String id) {
        return newsRepository.getNews(id);
    }
}
