package no.engevik.fish.core;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FishTest {

    @Mock
    private FishRepository fishRepository;

    @InjectMocks
    private FishService fishService;

    @Test
    void testFishPositive() throws Exception {
        var id = UUID.randomUUID().toString();
        var mockFish = new Fish(id, "nemo", "makrell", 21.2, 0.6);
        when(fishRepository.getById(id)).thenReturn((mockFish));

        var retrievedMockFish = fishService.getById(id);

        assertNotNull(retrievedMockFish);
        assertSame(retrievedMockFish.getId(), id);
    }

    @Test
    void testFishNegative() throws Exception {
        var id1 = UUID.randomUUID().toString();

        var retrievedMockFish = fishService.getById(id1);

        assertNull(retrievedMockFish);
    }
}
