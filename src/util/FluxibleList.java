package util;

// 쉽게 크기를 증가시킬 수 있는 List
public class FluxibleList {

    private int size;
    private int capacity;
    private Object[] list;

    public FluxibleList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.list = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public Object get(int index) {
        return list[index];
    }

    // 배열의 크기를 늘리는 메소드
    private boolean resize() {
        int newcapacity;

        if (capacity == Integer.MAX_VALUE) // 크기가 Integer의 최댓값이면
            return false; // 더 이상 크기를 늘릴 수 없으므로 추가가 불가능하니 false 반환.
        else if (capacity > Integer.MAX_VALUE / 2) // 크기를 2배할 시 Integer의 최댓값을 넘어설 경우
            newcapacity = Integer.MAX_VALUE; // 크기를 Integer의 최댓값으로 설정
        else
            newcapacity = capacity * 2; // 크기를 기존 크기의 2배로 설정.

        Object[] newList = new Object[newcapacity];

        for (int i=0; i<capacity; i++) {
            newList[i] = list[i];
        }

        capacity = newcapacity; // 크기를 새로운 크기로 변경
        list = newList; // 배열을 새로운 배열로 변경

        return true;
    }

    // 추가에 성공 시 true, 실패 시 false 반환
    public boolean add(Object value) {
        if (value == null)
            return false;
        if (size == capacity) { // 처음으로 비어있는 인덱스가 없을 경우 (배열이 다 찼을 경우)
            boolean b = resize();

            if (b == false) // 크기 재설정에 실패했을 경우
                return false; // 추가가 불가능하니 false 반환
        }

        list[size] = value;
        size++;

        return true;
    }

    public boolean remove(int index) {
        if (list[index] == null) {
            return false;
        } else {
            list[index] = null;

            for (int i=index; i<capacity-1; i++) {
                list[i] = list[i+1];
            }

            list[capacity-1] = null;
            size--;
            return true;
        }
    }

    public void set(int index, Object value) {
        if (index >= capacity)
            resize();

        list[index] = value;
    }

    public void clear() {
        for (int i=0; i<size; i++) {
            list[i] = null;
        }

        size = 0;
    }

    public boolean hasValue(int index) {
        return !(list[index] == null);
    }

}
