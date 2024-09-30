package Mojodoo.KnifeEdge.co.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "knives")

public class Knife {

    @Id
    private String id;

    public String getType() {
        return type;
    }
    public Knife(){

    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    private String type;
    private String length;

}
