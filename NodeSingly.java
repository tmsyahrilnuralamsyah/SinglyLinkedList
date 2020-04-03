public class NodeSingly<I> {
    protected I data;
    protected NodeSingly<I> link;

    // Constructor 
    public NodeSingly() {
        link = null;
        data = null;
    }

    // Constructor 
    public NodeSingly(I d, NodeSingly<I> n) {
        data = d;
        link = n;
    }

    // Function to set link to next node
    public void setLink(NodeSingly<I> n) {
        link = n;
    }

    // Function to set data to current node
    public void setData(I d) {
        data = d;
    }

    // Function to get link to next NodeSingly
    public NodeSingly<I> getLink() {
        return link;
    }

    // Function to get data from current NodeSingly
    public I getData() {
        return data;
    }
}