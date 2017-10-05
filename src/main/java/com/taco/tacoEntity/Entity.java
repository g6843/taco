package com.taco.tacoEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Entity {
    @Id
    @JsonProperty()
    private String id;
    @JsonProperty(required=true, value="value")
    private String value;


    public Entity(@JsonProperty("value")String value,String id){
        this.value = value;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
