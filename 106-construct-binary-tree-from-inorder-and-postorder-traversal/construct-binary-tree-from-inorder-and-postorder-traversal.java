class Solution {

    private int postIdx;
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIdx = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int mid = map.get(rootVal);

        root.right = build(postorder, mid + 1, right);
        root.left = build(postorder, left, mid - 1);

        return root;
    }
}