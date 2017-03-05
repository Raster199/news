package ru.developer.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.developer.news.model.News;

/**
 * Created by raster on 05.03.17.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {
}
