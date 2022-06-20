package ss12_JavaCollectionFramework.BaiTap.CaiDatThaoTacTrongBST;

public interface Tree<E> {
    boolean insert(E e);
    void inorder();
    int getSize();
    void postorder();
    void deleteNode(E e);
    void preorder();
    boolean search(E e);
}
