package com.app.web.dto;

import com.app.entity.Article;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.List;

public class ArticleDto {
    private Long id;
    private String name;
    private List<AuthorDto> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    public ArticleDto() {
    }

    public ArticleDto(Article article) {
        Assert.notNull(article);

        BeanUtils.copyProperties(article, this, Article.AUTHORS_PROPERTY);
    }
}
