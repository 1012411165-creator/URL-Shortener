class Node {
    String key;
    String value;
    int clickCount;
    Node next;

    Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.clickCount = 0;
        this.next = null;
    }
}