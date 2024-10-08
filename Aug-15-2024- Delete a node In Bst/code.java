package Aug-15-2024- Delete a node In Bst;

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
class Solution {
    
    public TreeNode getMin(TreeNode root)
    {
        
        
        if( root.left == null)
        {
            return root ; 
        }
        
        
        return getMin(root.left) ;
    }
    
    
    
  public TreeNode deleteNodeHelper(TreeNode root, int key) {


        if( root == null)
        {
            return root ;   
        }
        if( key < root.val)
        {
           root.left = deleteNode(root.left , key);

        }
      else  if( key > root.val)
        {
           root.right = deleteNode(root.right , key);

        }
      else
      {
            if( root.left != null && root.right !=null)
            {
               TreeNode temp = getMin(root.right); 
                root.val = temp.val ; 
                root.right = deleteNodeHelper(root.right , temp.val );



            }
            else if( root.right !=null)
            {
                root = root.right;
            }
             else if( root.left !=null)
            {
                root = root.left;
            }
            else
            {
                root = null ; 
            }
            

      }
      
      return root ;
    
  } 
    
   public TreeNode deleteNode(TreeNode root, int key) {
        
        
        deleteNodeHelper(root ,key) ;
        return root ; 
        
    }
}