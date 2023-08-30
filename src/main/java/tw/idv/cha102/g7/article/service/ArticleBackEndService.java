package tw.idv.cha102.g7.article.service;

import tw.idv.cha102.g7.article.entity.Article;

import java.util.List;

public interface ArticleBackEndService {
    public List<Article> getAll();
    public List<Article> findNonPublicArticle();

}
