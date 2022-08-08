package com.jnews.service;

import com.jnews.model.News;
import com.jnews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> list = newsRepository.findAll();
        for (News n : list) {
            if(n.getTitle().equals(newsTitle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
