package com.app.web.dto;

import com.app.entity.Author;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.util.List;

public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<ArticleDto> articles;

    public AuthorDto() {
    }

    public AuthorDto(Author author) {
        Assert.notNull(author);

        BeanUtils.copyProperties(author, this, Author.ARTICLES_PROPERTY);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }
}
