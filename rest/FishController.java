package no.engevik.fish.rest;

import no.engevik.fish.core.Fish;
import no.engevik.fish.core.FishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("fish")
public class FishController {

    private final FishService fishService;

    public FishController(FishService fishService) {
        this.fishService = fishService;
    }

    @PostMapping
    public void create(@RequestBody CreateFishRequest request) throws Exception {
        fishService.create(request.getName(), request.getSpecies(), request.getLengthInCm(),
                request.getWeightInKg());
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Fish fish, @PathVariable String id) {
        fish.setId(id);
        fishService.update(fish);
    }

    @GetMapping("/{id}")
    public Fish getById(@PathVariable String id) {
        return fishService.getById(id);
    }

    @GetMapping
    public List<Fish> getAll() {
        return fishService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        fishService.delete(id);
    }
}
