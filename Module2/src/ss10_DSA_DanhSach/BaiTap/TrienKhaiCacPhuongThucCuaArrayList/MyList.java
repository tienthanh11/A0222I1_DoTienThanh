package ss10_DSA_DanhSach.BaiTap.TrienKhaiCacPhuongThucCuaArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if(capacity >= 0) {
            elements = new Object[capacity];
        } else {
            //thông báo cho user capacity có lỗi
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
    }

    //return element in MyList
    public int size() {
        return this.size;
    }

    //clean all element in MyList
    public void clear() {
        size = 0;
        for(int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    //add element to MyList
    public boolean add(E element) { // truyền đối tượng e vào mảng
        if(elements.length == size) {
            this.ensureCapacity(5);
        }
        elements[size] = element;  //gán đối tượng (mình truyền vào) vào vị trí thứ si  ze
        size++;                    //tăng số lượng phần tử lên 1
        return true;
    }

    public void add(E element, int index) {
        if(index > elements.length) {
            throw new IllegalArgumentException("Index: " + index);
        } else if(elements.length == size) {
            this.ensureCapacity(5);
        }

        if(elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for(int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    // tăng kích thước mảng
    public void ensureCapacity(int minCapacity) {
        if(minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    // lấy 1 e tại vị trí i
    public E get(int i) {
        return (E) elements[i];
    }

    // tìm kiếm 1 e
    public int indexOf(E element) {
//        int index = -1;
        for(int i = 0; i < size; i++) {
            if(this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1; // e not exist in MyArray
    }

    // kiểm tra 1 e có tồn tại trong mảng ko
    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    // tạo bản sao của MyList hiện tại
    public MyList<E> clone() {
        MyList<E> a = new MyList<>();
        a.elements = Arrays.copyOf(this.elements, this.size);
        a.size = this.size;
        return a;
    }

    // xoá 1 e tại 1 vị trí index
    public E remove(int index) {
        if(index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for(int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}
