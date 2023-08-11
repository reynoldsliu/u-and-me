package tw.idv.cha102.g7.member.model;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="EMAIL")
    private String email;
    @Column(name="CELLPHONE")
    private String cellphone;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="ADDRESS")
    private String address;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCellphone() {
        return cellphone;
    }
    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
