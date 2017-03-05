package ru.developer.news.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.developer.news.model.News;
import ru.developer.news.repository.CategoryRepository;
import ru.developer.news.repository.NewsRepository;
import ru.developer.news.service.exeception.NotFoundException;

import java.util.List;

import static org.springframework.util.Assert.notNull;

/**
 * Created by raster on 05.03.17.
 */
@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        notNull(newsRepository, "News Repository must be not null");
        notNull(categoryRepository, "Category Repository must be not null");
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public List<News> findByCategory(Integer caregoryId) {
        return categoryRepository.findOne(caregoryId).getNews();
    }

    @Override
    public List<News> findByTtile(String title) {
        return newsRepository.findByTitle(title);
    }

    @Override
    public List<News> findByContext(String partContext) {
        return newsRepository.findByContext(partContext);
    }

    @Override
    public News create(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News update(News news) {
        News oldNews = newsRepository.findOne(news.getId());
        if (oldNews == null) {
            throw new NotFoundException(String.format("Entity with id = %s not found", news.getId()));
        }
        oldNews
                .setAuthor(news.getAuthor())
                .setCategoryId(news.getCategoryId())
                .setContext(news.getContext())
                .setDatePublic(news.getDatePublic())
                .setTitle(news.getTitle());
        return newsRepository.save(oldNews);
    }
    @Override
    public News delete(Integer id) {
        News oldNews = newsRepository.findOne(id);
        if (oldNews == null) {
            throw new NotFoundException(String.format("Entity with id = %s not found", id));
        }
        newsRepository.delete(id);
        return oldNews;
    }
}
