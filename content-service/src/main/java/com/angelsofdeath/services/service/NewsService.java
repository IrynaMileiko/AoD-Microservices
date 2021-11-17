package com.angelsofdeath.services.service;

import com.angelsofdeath.services.entity.News;
import com.angelsofdeath.services.repository.NewsRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsService {
    private NewsRepository newsRepository = new NewsRepository();

    public List<News> getAllNews() {
        return newsRepository.getAllNews();
    }

    public News getNews(String id) {
        return newsRepository.getNews(id);
    }

    public boolean isUsersNew(String chId, String userId) {
        return newsRepository.isUsersNew(chId, userId);
    }

    public void editNew(String id, String name, String text, String userId) {
        if (isUsersNew(id, userId)) {
            newsRepository.editNew(id, name, text);
        }
    }

    public void addNew(String userId, String name, String text) {
        Date udate = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH-mm-ss");
        newsRepository.addNew(userId, name, text, dateFormat.format(udate));
    }

    public void deleteNew(String id, String userId) {
        if (isUsersNew(id, userId))
            newsRepository.deleteNew(id);
    }
}
