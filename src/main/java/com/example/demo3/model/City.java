package com.example.demo3.model;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String nation;
    private int acreage;
    private int population;
    private int gdp;
    private String describee;
    public City(){}

    public City(String name, String nation, int acreage, int population, int gdp, String describe) {
        this.name = name;
        this.nation = nation;
        this.acreage = acreage;
        this.population = population;
        this.gdp = gdp;
        this.describee = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGdp() {
        return gdp;
    }

    public void setGdp(int gdp) {
        this.gdp = gdp;
    }

    public String getDescribee() {
        return describee;
    }

    public void setDescribee(String describe) {
        this.describee = describe;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", acreage=" + acreage +
                ", population=" + population +
                ", gdp=" + gdp +
                ", describee='" + describee + '\'' +
                '}';
    }
}
