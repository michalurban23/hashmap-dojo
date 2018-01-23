package com.codecool.michalurban.map;

import com.codecool.michalurban.node.Node;

import java.util.LinkedList;

public class HashMap {

    private int mapSize;
    private LinkedList<Node>[] elements;

    public HashMap() {

        this.mapSize = 16;
        this.elements = new LinkedList[mapSize];
    }

    private int getHash(String key) {

        return key.hashCode() % mapSize;
    }

    public void add(String key, Integer value) {

        int index = getHash(key);

        if (elements[index] == null) {
            elements[index] = new LinkedList<>();
        }

        elements[index].add(new Node(key, value));
        overwriteKeyIfNeeded(index);
    }

    public Integer getValue(String key) {

        int index = getHash(key);

        if (elements[index] != null) {
            for (Node node : elements[index]) {
                if (node.getKey().equals(key)) {
                    return node.getValue();
                }
            }
        }
        return null;  // Or should this throw an exception?
    }

    public void remove(String key) {

        int index = getHash(key);
        Node toRemove = null;

        if (elements[index] != null) {
            for (Node node : elements[index]) {
                if (node.getKey().equals(key)) {
                    toRemove = node;
                }
            }
            elements[index].remove(toRemove);
        }
    }

    public void clearAll() {

        this.elements = new LinkedList[mapSize];
    }

    private void overwriteKeyIfNeeded(int index) {

        LinkedList<Node> list = elements[index];
        String newKey = list.getLast().getKey();
        Node toRemove = null;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getKey().equals(newKey)) {
                toRemove = list.get(i);
            }
        }
        list.remove(toRemove);
    }

}
