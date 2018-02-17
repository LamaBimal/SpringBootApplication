package com.test.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by bimal on 2/11/18.
 */
@Entity
public class Greeting {
    @Id
    private long id;
    private String content;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
