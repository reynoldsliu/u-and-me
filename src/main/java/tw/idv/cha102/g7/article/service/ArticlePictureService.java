package tw.idv.cha102.g7.article.service;

import org.springframework.stereotype.Component;
import tw.idv.cha102.g7.article.entity.ArticlePicture;

import java.util.List;

@Component
public interface ArticlePictureService {

    // 新增文章
    public void postArticle(List<ArticlePicture> pics);

}

