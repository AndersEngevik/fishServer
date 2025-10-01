package no.engevik.fish.core;

import java.util.List;

public interface FishRepository {

    public String save(Fish fish);
    public void update(Fish fish);
    public List<Fish> list();
    public Fish getById(String id);
    public void delete(String id);
}
