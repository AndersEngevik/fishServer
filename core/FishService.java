package no.engevik.fish.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FishService {

    @Autowired
    private FishRepository fishRepository;

    public void create(String name, String species, double lengthInCm, double weightInKg) throws Exception {
        fishRepository.save(new Fish(UUID.randomUUID().toString(), name, species, lengthInCm, weightInKg));
    }

    public List<Fish> getAll() {
        return fishRepository.list();
    }

    public Fish getById(String id) {
        return fishRepository.getById(id);
    }

    public void update(Fish fish) {
        fishRepository.update(fish);
    }

    public void delete(String id) {
        fishRepository.delete(id);
    }
}
