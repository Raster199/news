package ru.developer.news.service;

import ru.developer.news.model.News;

import java.util.List;

/**
 * Created by raster on 05.03.17.
 */
public interface NewsService {
    List<News> findAll();

    List<News> findByCategory(Integer caregoryId);

    List<News> findByTtile(String title);

    List<News> findByContext(String partContext);

    News create(News news);

    News update(News news);

    News delete(Integer id);
}
