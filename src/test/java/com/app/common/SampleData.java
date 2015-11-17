package com.app.common;

import com.app.web.dto.ArticleDto;
import com.app.web.dto.AuthorDto;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    private SampleData() {}

    public static AuthorDto createAuthorWithArticle(int articles) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setFirstName("Stephen");
        authorDto.setLastName("King");

        List<ArticleDto> articleDtos = new ArrayList<>();
        for(int i=0; i<articles; i++) {
            ArticleDto articleDto = new ArticleDto();
            articleDto.setName("Article " + i);
            articleDtos.add(articleDto);
        }

        authorDto.setArticles(articleDtos);

        return authorDto;
    }
}
