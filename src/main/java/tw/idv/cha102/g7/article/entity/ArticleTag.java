package tw.idv.cha102.g7.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "article_tag")
public class ArticleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ac_tag_id")
    private Integer acTagId;
    @Column(name="ac_tag_name")
    private String acTagName;
    @Column(name="tag_sta")
    private Short tagSta;



}
