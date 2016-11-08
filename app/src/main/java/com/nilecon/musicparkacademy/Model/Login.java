package com.nilecon.musicparkacademy.Model;

/**
 * Created by Maximus on 29/10/2559.
 */
public class Login  {
    /**
     * isSuccess : false
     * member_id : 0
     * username : 0
     * password : 0
     */

    private boolean isSuccess;
    private String member_id;
    private String username;
    private String password;

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
