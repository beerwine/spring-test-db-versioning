package com.app.service;

import com.app.entity.Article;
import com.app.repository.ArticleRepository;
import com.app.service.utils.ServiceAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public void deleteArticle(long idArticle) {
        Article article = articleRepository.findOne(idArticle);
        ServiceAssert.notNull(article);

        articleRepository.delete(article);
    }
}
