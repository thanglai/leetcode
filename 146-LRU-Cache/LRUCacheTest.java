import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LRUCacheTest {
    private LRUCache cache;

    @BeforeEach
    void setup() {
        cache = new LRUCache(2);
    }

    @Test
    void testGetNotFound() {
        assertEquals(-1, cache.get(1));

    }

    @Test
    void testPutNegativeKey() {
        assertThrows(AssertionError.class, () -> cache.put(-1, 1));
        assertThrows(AssertionError.class, () -> cache.put(-10, 1));
        assertEquals(-1, cache.get(-1));
    }

    /*
     * Input ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     */
    @Test
    void testN2N() {
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));
        cache.put(3, 3);
        assertEquals(-1, cache.get(2));
        cache.put(4, 4);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));
    }
}
