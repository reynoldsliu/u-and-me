package tw.idv.cha102.g7.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.ArticlePicture;
import tw.idv.cha102.g7.article.repo.ArticlePictureRepository;
import tw.idv.cha102.g7.article.service.ArticlePictureService;

import java.util.List;

@Component
public class ArticlePictureServiceImpl implements ArticlePictureService {
    @Autowired
    private ArticlePictureRepository articlePostingPicRepository;
    @Override
    public void postArticle(List<ArticlePicture> pics)  {
        articlePostingPicRepository.saveAll(pics);
    }



}
