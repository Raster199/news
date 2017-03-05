package ru.developer.news.model;

import lombok.Data;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.EAGER;

/**
 * Created by raster on 05.03.17.
 */
@Entity
@Table(name = "news")
public class News {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "author")
    private String author;
    @Column(name = "name_news")
    private String nameNews;
    @Column(name = "context")
    private String context;
    @Column(name = "date_public")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime datePublic;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    @Override
    public String toString() {
        return "News{" +
                "nameNews='" + nameNews + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;

        News news = (News) o;

        if (getId() != news.getId()) return false;
        if (!getCategoryId().equals(news.getCategoryId())) return false;
        if (!getAuthor().equals(news.getAuthor())) return false;
        if (!getNameNews().equals(news.getNameNews())) return false;
        if (!getContext().equals(news.getContext())) return false;
        return getDatePublic().equals(news.getDatePublic());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCategoryId().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getNameNews().hashCode();
        result = 31 * result + getContext().hashCode();
        result = 31 * result + getDatePublic().hashCode();
        return result;
    }

    public int getId() {
        return id;
    }

    public News setId(int id) {
        this.id = id;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public News setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public News setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getNameNews() {
        return nameNews;
    }

    public News setNameNews(String nameNews) {
        this.nameNews = nameNews;
        return this;
    }

    public String getContext() {
        return context;
    }

    public News setContext(String context) {
        this.context = context;
        return this;
    }

    public LocalDateTime getDatePublic() {
        return datePublic;
    }

    public News setDatePublic(LocalDateTime datePublic) {
        this.datePublic = datePublic;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public News setCategory(Category category) {
        this.category = category;
        return this;
    }
}
