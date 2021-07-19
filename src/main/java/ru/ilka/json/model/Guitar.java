package ru.ilka.json.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Guitar {
    @JsonProperty(value = "proizvoditel", required = true)
    private String manufacturer;
    @JsonIgnore
    private String title;
    private GuitarBodyType bodyType;

    public Guitar() {
    }

    public Guitar(String manufactorer, String title, GuitarBodyType bodyType) {
        this.manufacturer = manufactorer;
        this.title = title;
        this.bodyType = bodyType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GuitarBodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(GuitarBodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guitar guitar = (Guitar) o;
        return Objects.equals(manufacturer, guitar.manufacturer)
                && Objects.equals(title, guitar.title)
                && bodyType == guitar.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, title, bodyType);
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "manufactorer='" + manufacturer + '\'' +
                ", title='" + title + '\'' +
                ", bodyType=" + bodyType +
                '}';
    }
}
