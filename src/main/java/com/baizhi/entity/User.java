package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 徐三
 * @company com.1999
 * @create 2019-11-28 9:45
 */

@Data
/*@Getter
@Setter
@ToString
@EqualsAndHashCode*/
@NoArgsConstructor  //无参
@AllArgsConstructor //有参
@Accessors(chain = true) //链式调用
/*@Component("user")*/
public class User implements Serializable {
    private Integer id;
    private String nick_name;
    private String email;
    private String password;
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm;ss") //反序列化
    @DateTimeFormat(pattern = "yyyy-MM-dd") //序列化
    private Date regist_time;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String phone;
    private String salt;

  /*  public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", regist_time=" + regist_time +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRegist_time() {
        return regist_time;
    }

    public void setRegist_time(Date regist_time) {
        this.regist_time = regist_time;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(Integer id, String nick_name, String email, String password, Integer status, Date regist_time, Date birthday, String phone, String salt) {
        this.id = id;
        this.nick_name = nick_name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.regist_time = regist_time;
        this.birthday = birthday;
        this.phone = phone;
        this.salt = salt;
    }*/
}
