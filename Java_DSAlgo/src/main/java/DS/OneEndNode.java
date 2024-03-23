package DS;

public class OneEndNode<T> {

    public T getData() { return data; }

    public void setData(T data) {
        this.data = data;
    }

    public OneEndNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(OneEndNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    private T data;
    private OneEndNode<T> nextNode;
}
