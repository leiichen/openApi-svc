package com.lei.chen.model.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginReq implements Serializable {
    private static final long serialVersionUID = 3191241716373120793L;

    private String userName;

    private String userPassword;
}
