package 18-Aug-2024.create  a minimal height Bst From the array;

public TreeNode createMinimalBST(int array[]) {
   
    return createMinimalBST(array, 0, array.length - 1);
    }
    TreeNode createMinimalBST(int arr[], int start, int end) {
    if (end< start) {
    return null;
    }
    int mid= (start+ end)/ 2;
    TreeNode n = new TreeNode(arr[mid]);
    n.left = createMinimalBST(arr, start, mid - 1); n.right = cre ateMinimalBST(arr, mid+ 1, end); return n; {
    
}
