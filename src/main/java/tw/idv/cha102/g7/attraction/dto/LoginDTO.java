package tw.idv.cha102.g7.attraction.dto;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class LoginDTO {

    String memEmail;
    String memPassword;

    public String getMemEmail(){
       return this.memEmail;
    }

}
