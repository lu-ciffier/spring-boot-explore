package com.lucifer.dao.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Lucifer on 2019/5/12 22:09
 **/
@Entity
@Table(name = "account")
@Data
public class Account implements Serializable {

    @Id
    private Long accountId;
    private String accountName;
    private String nickName;
    private String email;
    private Long phoneNum;
}
