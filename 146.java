class LRUCache {
    
    private HashMap<Integer, Node> map;
    private int size;
    public int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);
            addFront(node);
            size++;
            if (size > capacity) {
                Node deleted = tail.pre;
                remove(deleted);
                map.remove(deleted.key);
                size--;
            }
        }
        else {
            Node node = map.get(key);
            node.value = value;
            update(node);
        }
    }
    
    private void update(Node node) {
        remove(node);
        addFront(node);
    }
    
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void addFront(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    
    private class Node {
        int key;
        int value;
        Node pre, next;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */