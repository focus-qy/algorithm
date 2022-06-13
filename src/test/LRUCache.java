package test;

import java.util.HashMap;

public class LRUCache {

    private MyCache<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new MyCache(capacity);
    }

    public int get(int key) {
        Integer result = cache.get(key);
        return result == null ? -1 : result;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    static class MyCache<K, V> {

        private final HashMap<K, Node<K, V>> hashMap;
        private final DoubleLinkedList<K, V> doubleLinkedList;
        private final int capacity;

        public MyCache(int capacity) {
            hashMap = new HashMap<>();
            doubleLinkedList = new DoubleLinkedList<K, V>();
            this.capacity = capacity;
        }


        public V get(K key) {
            if (hashMap.containsKey(key)) {
                Node<K, V> node = hashMap.get(key);
                doubleLinkedList.removeNode2Tail(node);
                return node.value;
            }
            return null;
        }

        public void put(K key, V value) {
            if (hashMap.containsKey(key)) {//更新
                Node<K, V> node = hashMap.get(key);
                node.value = value;
                doubleLinkedList.removeNode2Tail(node);
                return;
            }
            Node<K, V> newNode = new Node<>(key, value);
            doubleLinkedList.addNode(newNode);
            hashMap.put(key, newNode);
            if (capacity + 1 == hashMap.size()) {//新加
                Node<K,V> node = doubleLinkedList.removeHead();
                hashMap.remove(node.key);
            }

        }
    }

    static class DoubleLinkedList<K, V> {

        private Node<K, V> head;
        private Node<K, V> tail;

        public void addNode(Node<K, V> node) {
            if (node == null) return;
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.pre = tail;
                tail = node;
            }
        }

        public Node<K,V> removeHead() {
            if(head == null) return null;
            Node<K,V> result = head;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = result.next;
                result.next = null;
                head.pre = null;
            }
            return result;
        }

        public void removeNode2Tail(Node<K, V> node) {
            if (node == tail) return;
            if (node == head) {
                head = head.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            // addNode(node);

            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }

    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> pre;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
