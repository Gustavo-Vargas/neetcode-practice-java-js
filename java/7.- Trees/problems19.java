// 94. Binary Tree Inorder Traversal
/* Instrucciones: 
Dada la raíz de un árbol binario, devuelve el recorrido en orden 
de los valores de sus nodos.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null) return;
        traverse(node.left, result); // Subárbol izquierdo
        result.add(node.val); // Nodo actual
        traverse(node.right, result); // Subárbol derecho
    }
}



// 230. Kth Smallest Element in a BST
/* Instrucciones: 
Dada la raíz de un árbol de búsqueda binario y un número entero k, 
devuelve el k-ésimo valor más pequeño (indexado en 1) de todos los
 valores de los nodos del árbol.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current); // Agregar nodos del subárbol izquierdo
                current = current.left;
            }

            current = stack.pop(); // Procesar el nodo más profundo
            count++;
            if (count == k) {
                return current.val; // Encontramos el k-ésimo nodo
            }

            current = current.right; // Ir al subárbol derecho
        }

        return -1; // Esto no debería ocurrir si k es válido
    }
}

// 105. Construct Binary Tree from Preorder and Inorder Traversal
/* Instrucciones: 
Dadas dos matrices de enteros preorder e inorder donde preorder es 
el recorrido preorder de un árbol binario e inorder es el recorrido 
inorder del mismo árbol, construye y devuelve el árbol binario.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) return null;

        // La raíz es el primer elemento de preorder
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Encuentra el índice de la raíz en inorder
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Construye los subárboles recursivamente
        root.left = helper(preorder, inorder, preStart + 1, inStart, rootIndex - 1);
        root.right = helper(preorder, inorder, preStart + (rootIndex - inStart) + 1, rootIndex + 1, inEnd);

        return root;
    }
}


