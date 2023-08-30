package tw.idv.cha102.g7.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.repo.ArticleBrowserRepository;
import tw.idv.cha102.g7.article.service.ArticleBrowserService;

import java.util.List;

@Component
public class ArticleBrowserServiceImpl implements ArticleBrowserService {

    @Autowired
    private ArticleBrowserRepository articleBrowserRepository;

    @Override
    public String updateByArticleId(Integer articleId, Article article) {
        // 舊文章
        // 新文章為輸入要更改的文章ID
        Article art = articleBrowserRepository.findById(articleId).orElse(null);
        //更改後的新文章
        if (art != null) {  // schedule為欲修改的行程資料
            art.setArticleTitle(article.getArticleTitle());
            art.setArticleId(article.getAcTypeId());
            art.setArticleContent(article.getArticleContent());
            articleBrowserRepository.save(art);
            return "更新成功！";
        } else {
            return "更新失敗，查詢的行程不存在";
        }

    }

    @Override
    public List<Article> findByArticleTitle(String keyword) {
        return articleBrowserRepository.findByTitleOrderByLike(keyword);
    }

    //    public List<Article> findByArticleTitle(String keyword) {
    //   return articleRepository.findByTitleOrderByTime(keyword);
    //    }



    @Override
    public List<Article> findPublicArticle() {
        return articleBrowserRepository.findPublicArticle();
    }


    @Override
    public void postArticle(Article article) {
        articleBrowserRepository.save(article);
        }


    @Override
    public void deleteByArticleId(Integer articleId) {

    }

    @Override
    public List<Article> getAllByMemId(Integer memId) {
        List<Article> articles = articleBrowserRepository.findByMemId(memId);
        return articles;

    }
}
