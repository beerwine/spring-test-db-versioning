package com.app.web.controllers;

import com.app.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/articles/{idArticle}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteArticle(@PathVariable long idArticle) {
        articleService.deleteArticle(idArticle);
    }
}
