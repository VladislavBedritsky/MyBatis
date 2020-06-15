package org.example.mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.example.mybatis.domain.Article;

import java.util.List;

public interface ArticleDao {

    @Select("SELECT * FROM articles where id = #{id}")
    Article findById(@Param("id") Long id);

    @Select("SELECT * FROM articles")
    List<Article> findAll();

    @Insert("INSERT INTO articles VALUES (#{article}.id, #{article}.title, #{article}.author)")
    void saveArticle(@Param("article") Article article);

    @Update("UPDATE articles SET title = #{article}.title, author = #{article}.author")
    void updateArticle(@Param("article") Article article);

    @Delete("DELETE FROM articles where id=#{id}")
    void deleteArticle(@Param("id") Long id);
}
