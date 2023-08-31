package tw.idv.cha102.g7.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.Article;
import tw.idv.cha102.g7.article.repo.ArticleBackEndRepository;
import tw.idv.cha102.g7.article.service.ArticleBackEndService;

import java.util.List;
@Component
public class ArticleBackEndServiceImpl implements ArticleBackEndService {
    @Autowired
    private ArticleBackEndRepository articleBackEndRepository;
    @Override
    public List<Article> getAll() {
        return articleBackEndRepository.findAll();
    }

    @Override
    public List<Article> findNonPublicArticle() {
        return articleBackEndRepository.findNonPublicArticle();
    }
}
