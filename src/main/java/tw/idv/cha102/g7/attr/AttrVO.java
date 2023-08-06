package tw.idv.cha102.g7.attr;

public class AttrVO {
    private Integer id;
    private Short veri_sta;
    private Short sta;
    private String name;
    private String addr;
    private Float lon;//google api可透過地址定位經緯度
    private Float lat;
    private String illa;
    private Integer type_id;
    private String buss_time;
    private Short cost_range;
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
