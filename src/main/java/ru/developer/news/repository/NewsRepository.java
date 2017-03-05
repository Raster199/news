package ru.developer.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.developer.news.model.News;

import java.util.List;

/**
 * Created by raster on 05.03.17.
 */
public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query("select n from ru.developer.news.model.News as n where n.title like '%:text%'")
    List<News> findByTitle(@Param("text") String text);

    @Query("select n from ru.developer.news.model.News as n where n.context like '%:text%'")
    List<News> findByContext(@Param("text") String text);
}
