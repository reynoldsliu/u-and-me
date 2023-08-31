package tw.idv.cha102.g7.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

// 複合主鍵
@Entity
@Table(name = "article_collection")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCollection {

    @Column(name = "article_collection")
    @EmbeddedId
    private ArticleCollectionId id;
    @Column(name="ac_follow_date")
    private Date acFollowDate;

}
