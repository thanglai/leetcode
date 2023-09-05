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
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache {
    /**
     * Node
     */ Node next;
    public class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node() {
        }
        public Node(int value) {
            this.value = value;
        }
    }
    private Map<Integer, Node> cache = null;
    private int cacheCapacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        cache = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * Get the value from the cache using the key
     * @param key
     * @return the value if exists, -1 otherwise
     */
    public int get(int key) {
        var node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addNode(node);
        return node.value;
    }

    /**
     * Add the key and its value into the cache
     * @param key Must be non negative
     * @param value
     */
    public void put(int key, int value) {
        assert key > -1;
        var node = cache.get(key);
        if (node == null && cache.size() == cacheCapacity) {
            var lruNode = tail.prev;
            cache.remove(lruNode.value);
            removeNode(lruNode);
        }
        node = new Node(value);
        cache.put(key, node);
        addNode(node);
    }
    
    private void addNode(LRUCache.Node node) {
        var next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
    }

    private void removeNode(LRUCache.Node node) {
        var prev = node.prev;
        var next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

