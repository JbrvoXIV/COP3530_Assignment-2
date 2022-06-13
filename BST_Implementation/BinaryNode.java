public class BinaryNode<E> {
    public E element;//data
    public BinaryNode<E> left;//left child
    public BinaryNode<E> right;//right child

    BinaryNode(E element){
        this(element, null, null);
    }
    
    BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right){
        this.left = left;
        this.right = right;
        this.element = element;
    }

}