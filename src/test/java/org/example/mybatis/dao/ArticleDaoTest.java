package org.example.mybatis.dao;

import org.example.mybatis.domain.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/beans.xml")
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    private Article newArticle;

    @Before
    public void setUp() {
        this.newArticle = new Article();
        this.newArticle.setId(10L);
        this.newArticle.setTitle("MyBatis");
        this.newArticle.setAuthor("@Bck.");
    }

    @Test
    public void whenRecordsInDatabase_shouldReturnArticleWithGsvenId() {
        Article article = articleDao.findById(1L);

        assertNotNull(article);
        assertEquals(article.getId(), (Long) 1L);
        assertEquals(article.getAuthor(), "Baeldung");
        assertEquals(article.getTitle(), "Working with MyBatis in Spring");

        System.out.println(article);
    }

    @Test
    public void whenRecordsInDatabase_shouldReturnAllArticles() {
        List<Article> articles = articleDao.findAll();

        assertNotNull(articles);
        assertEquals(articles.size(), 1);

        System.out.println(articles);
    }


    @Test
    @Transactional
    public void whenSaveArticle_shouldReturnThisArticle() {
        articleDao.saveArticle(this.newArticle);

        Article article = articleDao.findById(newArticle.getId());

        assertNotNull(article);
        assertEquals(this.newArticle.getId(), article.getId());
        assertEquals(this.newArticle.getTitle(), article.getTitle());
        assertEquals(this.newArticle.getAuthor(), article.getAuthor());

        System.out.println(article);
    }

}