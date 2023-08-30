package tw.idv.cha102.g7.article.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

// 複合主鍵
@Embeddable
public class ArticleCollectionId implements Serializable {
                                            // 可以序列化和反序列化
    @Column(name = "article_id")
    public Integer articleId;

    @Column(name = "mem_id")
    public Integer memId;

    //  equals 方法被重寫
    public boolean equals(Object o) {
        if (this == o) {
            return true;
            // 比較當前物件（this）與傳入的物件（o）
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArticleCollectionId id = (ArticleCollectionId) o;
        return Objects.equals(articleId, id.articleId)
                && Objects.equals(memId, id.memId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleId, memId);
    }
}
