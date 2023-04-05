package de.marshal.javaspringcw.entities.helloworld;

import org.springframework.stereotype.Component;

@Component(value = "france")
public class Country {
    public Country() {
        name = "France";
        code = "FR";
    }

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
