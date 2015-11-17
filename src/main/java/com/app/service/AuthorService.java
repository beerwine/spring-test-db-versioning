package com.app.service;

import com.app.entity.AbstractEntity;
import com.app.entity.Article;
import com.app.entity.Author;
import com.app.repository.ArticleRepository;
import com.app.repository.AuthorRepository;
import com.app.service.utils.ServiceAssert;
import com.app.web.dto.ArticleDto;
import com.app.web.dto.AuthorDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Author getAuthor(long idAuthor) {
        Author author = authorRepository.findOne(idAuthor);
        ServiceAssert.notNull(author);

        // fetch articles
        author.getArticles().size();

        return author;
    }

    public Author saveAuthorDto(AuthorDto authorDto) {
        Assert.notNull(authorDto);
        final Author author;

        if(authorDto.getId() != null) {
            // Update
            author = authorRepository.findOne(authorDto.getId());
            ServiceAssert.notNull(author);
        } else {
            // Create
            author = new Author();
        }

        // scalar properties
        BeanUtils.copyProperties(authorDto, author, AbstractEntity.ID_PROPERTY, Author.ARTICLES_PROPERTY);

        // articles
        if(CollectionUtils.isNotEmpty(authorDto.getArticles())) {
            for (ArticleDto articleDto : authorDto.getArticles()) {
                final Article article;
                if(articleDto.getId() != null) {
                    article = articleRepository.findOne(articleDto.getId());
                    ServiceAssert.notNull(article);
                } else {
                    article = new Article();
                    BeanUtils.copyProperties(articleDto, article, AbstractEntity.ID_PROPERTY, Article.AUTHORS_PROPERTY);
                }

                article.getAuthors().add(author);
                author.getArticles().add(article);

                articleRepository.save(article);
            }
        }

        final Author savedAuthor = authorRepository.save(author);
        // fetch articles
        savedAuthor.getArticles().size();

        return savedAuthor;
    }
}
