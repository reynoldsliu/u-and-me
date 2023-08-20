package tw.idv.cha102.g7.article.service;

import tw.idv.cha102.g7.article.entity.Article;

import java.util.List;

public interface ArticleService {

    // 新增文章
    void postArticle(Article article);

    // 刪除文章
    void deleteByArticleId(Integer articleId);

    String updateByArticleId(Integer articleId, Article article);

    // 搜尋文章title，可依照熱門(讚數)或最新最舊排序
    List<Article> findByArticleTitle(String keyword);

    // 首頁呈現所有文章
    public List<Article> getAll();

    // 使用者所有發表過的文章
    public List<Article> getAllByMemId(Integer memId);


    // 精確搜尋文章hashtag，可依照熱門(讚數)或最新最舊排序(多對多表格)


}
