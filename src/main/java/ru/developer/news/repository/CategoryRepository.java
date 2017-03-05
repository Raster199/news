package ru.developer.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.developer.news.model.Category;

/**
 * Created by raster on 05.03.17.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
