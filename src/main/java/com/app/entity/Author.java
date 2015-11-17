package com.app.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author", schema = "public")
@SequenceGenerator(name = "author_id_sequence", sequenceName = "author_id_sequence", initialValue = 20, allocationSize = 1)
public class Author extends AbstractEntity {
    public static final String ARTICLES_PROPERTY = "articles";

    private String firstName;
    private String lastName;
    private Set<Article> articles = new HashSet<>();

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_sequence")
    public Long getId() {
        return super.getId();
    }

    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "author_has_article",
        joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "article_id", referencedColumnName = "id")})
    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
