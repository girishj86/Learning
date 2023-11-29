package com.scaler.linkedlist;

import java.util.Objects;

public class DoubleListNode {
    int data;
    DoubleListNode next;
    DoubleListNode prev;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleListNode that = (DoubleListNode) o;
        return data == that.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
