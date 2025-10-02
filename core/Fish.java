package no.engevik.fish.core;


public class Fish {
    private String id;
    private String name;
    private String species;
    private double lengthInCm;
    private double weightInKg;

    public Fish (String id, String name, String species, double lengthInCm, double weightInKg) throws Exception{
        if (name == null || name.isBlank()) {
            throw new Exception("name cannot be null or blank");
        }
        if (species == null || species.isBlank()) {
            throw new Exception("species cannot be null or blank");
        }
        if (lengthInCm < 0) {
            throw new Exception("length cannot be less than 0");
        }
        if (weightInKg < 0) {
            throw new Exception("weight cannot be less than 0");
        }

        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
