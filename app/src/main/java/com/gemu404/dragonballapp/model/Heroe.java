package com.gemu404.dragonballapp.model;

public class Heroe {
    private String name;
    private String originPlanet ;
    private String gender;
    private String series ;
    private String status ;
    private String species ;

public Heroe(){

}

    public Heroe(String name, String originPlanet, String gender, String series, String status, String species) {
        this.name = name;
        this.originPlanet = originPlanet;
        this.gender = gender;
        this.series = series;
        this.status = status;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

