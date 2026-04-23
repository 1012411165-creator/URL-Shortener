class MyHashMap {
    private int SIZE = 100;
    private Node[] table;

    MyHashMap() {
        table = new Node[SIZE];
    }

    private int hash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash += c;
        }
        return hash % SIZE;
    }

    // Insert URL
    public void put(String key, String value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node temp = table[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Get URL and increase click count
    public String get(String key) {
        int index = hash(key);
        Node temp = table[index];

        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.clickCount++;
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    // Get analytics
    public int getClickCount(String key) {
        int index = hash(key);
        Node temp = table[index];

        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.clickCount;
            }
            temp = temp.next;
        }
        return -1;
    }
}