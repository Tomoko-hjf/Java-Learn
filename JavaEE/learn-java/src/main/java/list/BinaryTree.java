package list;

public class BinaryTree {
    public BinaryTree leftNode;
    public BinaryTree rightNode;
    public Object value;

    //向排序二叉树中插入元素
    public void add(Object v) {
        //如果当前节点的value为空，结束递归
        if(null == value) value = v;
        else {
            //如果要插入的值小于当前节点值，则插入左子树
            if((Integer) v - ((Integer)value) <= 0) {
                //如果左子树为空，需要先创建左子树节点
                if(null == leftNode) leftNode = new BinaryTree();
                leftNode.add(v);
            }
            else {
                if(null == rightNode) rightNode = new BinaryTree();
                rightNode.add(v);
            }
        }
    }
    //中序遍历排序二叉树
    public void visit() {
        if(null == leftNode && null == rightNode) return;
        if(leftNode != null) leftNode.visit();
        System.out.println(value);
        if(rightNode != null) rightNode.visit();
    }

    public static void main(String[] args) {
        int[] randoms = new int[] {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        BinaryTree root = new BinaryTree();
        for(int number : randoms) {
            root.add(number);
        }
        root.visit();
    }
}
