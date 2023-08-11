package tw.idv.cha102.g7.attraction.vo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attractions")
public class Attraction {
    @Id
    @Column(name = "attr_id")
    private Integer id;
    @Column(name = "attr_veri_sta")
    private Short veri_sta;
    @Column(name = "attr_sta")
    private Short sta;
    @Column(name = "attr_name")
    private String name;
    @Column(name = "attr_addr")
    private String addr;
    @Column(name = "attr_lon")
    private Float lon;//google api可透過地址定位經緯度
    @Column(name = "attr_lat")
    private Float lat;
    @Column(name = "attr_illa")
    private String illa;
    @Column(name = "attr_type_id")
    private Integer type_id;
    @Column(name = "attr_buss_time")
    private String buss_time;
    @Column(name = "attr_cost_range")
    private Short cost_range;
    @Column(name = "attr_rep")
    private String rep;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Short getVeri_sta() {
        return veri_sta;
    }
    public void setVeri_sta(Short veri_sta) {
        this.veri_sta = veri_sta;
    }
    public Short getSta() {
        return sta;
    }
    public void setSta(Short sta) {
        this.sta = sta;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public Float getLon() {
        return lon;
    }
    public void setLon(Float lon) {
        this.lon = lon;
    }
    public Float getLat() {
        return lat;
    }
    public void setLat(Float lat) {
        this.lat = lat;
    }
    public String getIlla() {
        return illa;
    }
    public void setIlla(String illa) {
        this.illa = illa;
    }
    public Integer getType_id() {
        return type_id;
    }
    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }
    public String getBuss_time() {
        return buss_time;
    }
    public void setBuss_time(String buss_time) {
        this.buss_time = buss_time;
    }
    public Short getCost_range() {
        return cost_range;
    }
    public void setCost_range(Short cost_range) {
        this.cost_range = cost_range;
    }
    public String getRep() {
        return rep;
    }
    public void setRep(String rep) {
        this.rep = rep;
    }
}
