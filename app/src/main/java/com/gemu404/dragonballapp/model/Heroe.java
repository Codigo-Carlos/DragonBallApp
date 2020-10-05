package com.gemu404.dragonballapp.model;

public class Heroe {
    private String name;
    private String originPlanet ;
    private  String gender;
    private String series ;
     private String status ;
    private String species ;
 private String temp_image;

public Heroe(){

}

    public Heroe(String name, String originPlanet, String gender, String series, String status, String species, String temp_image) {
        this.name = name;
        this.originPlanet = originPlanet;
        this.gender = gender;
        this.series = series;
        this.status = status;
        this.species = species;
        this.temp_image = temp_image;
    }



}

