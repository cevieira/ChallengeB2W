package com.apistarwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planetas {

    List<PlanetaAPI> results;

    public Planetas(){
    }

    public List<PlanetaAPI> getResults() {
        return results;
    }

    public void setResults(List<PlanetaAPI> results) {
        this.results = results;
    }
}
