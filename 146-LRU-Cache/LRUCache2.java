/**
* Copyright 2023 Apirus Inc
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * https://leetcode.com/problems/lru-cache/
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache2 {
    private Map<Integer, Integer> cache = null;
    private int cacheCapacity;
    private BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction;
    public LRUCache2(int capacity) {
        this.cacheCapacity = capacity;
        cache = new HashMap<>(2);
    }
    
    public int get(int key) {
        var r = cache.computeIfPresent(key, remappingFunction);
        return r == null? -1: r.intValue();
    }
    
    public void put(int key, int value) {
        
    }

    public static void main(String[] args) {
        // LinkedHashSet<Integer> map = new LinkedHashSet<>();
        // map.add(Integer.valueOf(1));
        // map.add(Integer.valueOf(2));
        // map.add(Integer.valueOf(3));
        // map.add(Integer.valueOf(4));
        // System.out.println(map);

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(Integer.valueOf(1), Integer.valueOf(1));
        map.put(Integer.valueOf(2), Integer.valueOf(2));
        map.put(Integer.valueOf(3), Integer.valueOf(3));
        map.put(Integer.valueOf(4), Integer.valueOf(4));
        System.out.println(map);
        System.out.println(map.keySet().iterator().next());
    }
}
