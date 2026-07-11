/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     int p;
//     HashMap <Integer,Integer> hm=new HashMap<>();
//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         int n= inorder.length;
//         p=n-1;
//         for(int i =0;i<n;i++){
//             hm.put(inorder[i],i);
//         }
//         return build(postorder,n-1,0);
//     }
//     TreeNode build( int[] postorder,int right, int left){
//             if(right<left) return null;
//             if(p<0) return null;
//             int val = postorder[p--];
//             TreeNode root=new TreeNode(val);
//             int mid= hm.get(val);
//             root.right=build(postorder,right,mid+1);
//             root.left=build(postorder,mid-1,left);
//             return root;
//         }
// }
class Solution {
    private int p, i;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length - 1;
        i = inorder.length - 1;
        return build(postorder, inorder, -3001);
    }
    private TreeNode build(int[] postorder, int[] inorder, int stop) {
        if (p < 0) {
            return null;
        }
        if (i >= 0 && inorder[i] == stop) {
            i--;
            return null;
        }
        TreeNode node = new TreeNode(postorder[p--]);
        node.right = build(postorder, inorder, node.val);
        node.left = build(postorder, inorder, stop);
        return node;
    }
}