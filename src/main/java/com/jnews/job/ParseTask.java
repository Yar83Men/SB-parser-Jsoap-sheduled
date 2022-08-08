package com.jnews.job;

import com.jnews.model.News;
import com.jnews.service.NewsServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ParseTask {
    private final NewsServiceImpl newsService;

    @Autowired
    public ParseTask(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @Scheduled(fixedDelay = 10000)
    public void parseNews() {
        String url = "https://news.ycombinator.com/";
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            Elements news = doc.getElementsByClass("titlelink");
            for (Element el : news) {
                String title = el.ownText();
                if (!newsService.isExist(title)) {
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
