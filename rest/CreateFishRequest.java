package no.engevik.fish.rest;

public class CreateFishRequest {

    private String name;
    private String species;
    private double lengthInCm;
    private double weightInKg;

    public CreateFishRequest (String name, String species, double lengthInCm, double weightInKg) {

        this.name = name;
        this.species = species;
        this.lengthInCm = lengthInCm;
        this.weightInKg = weightInKg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getLengthInCm() {
        return lengthInCm;
    }

    public void setLengthInCm(double lengthInCm) {
        this.lengthInCm = lengthInCm;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        this.weightInKg = weightInKg;
    }
}
