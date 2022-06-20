package ss12_JavaCollectionFramework.BaiTap.CaiDatThaoTacTrongBST;

public class BST <E extends Comparable<E>> extends AbstractTree<E>{
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for(int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    @Override
    public boolean insert(E e) {
        if(root == null) {
            root = createNewNode(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if(e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if(e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }
            if(e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
            } else {
                parent.right = createNewNode(e);
            }
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode<E> root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void deleteNode(E e) {
        root = deleteNode(root, e);
    }

    private TreeNode deleteNode(TreeNode<E> root, E e) {
        if(root == null) return null;
        if(e.compareTo(root.element) < 0) {
            root.left = deleteNode(root.left, e);
        } else {
            if(e.compareTo(root.element) > 0) {
                root.right = deleteNode(root.right, e);
            } else {
                if(root.left == null) return root.right;
                if(root.right == null) return root.left;
                TreeNode<E> temp = root.right;
                while (temp != null) {
                    if(temp.left == null) break;
                    temp = temp.left;
                }
                E minRight = temp.element;
                root.element = minRight;
                root.right = deleteNode(root.right, minRight);
            }
        }
        return root;
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode<E> root) {
        if(root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if(e.compareTo(current.element) < 0) {
                current = current.left;
            } else if(e.compareTo(current.element) > 0) {
                current = current.right;
            } else if(e.compareTo(current.element) == 0) {
                return true;
            }
        }
        return false;
    }
}
