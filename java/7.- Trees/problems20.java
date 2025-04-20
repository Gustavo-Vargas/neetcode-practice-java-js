// 102. Binary Tree Level Order Traversal
/* Instrucciones: 
Dada la raíz de un árbol binario, devuelve el recorrido por orden 
de nivel de los valores de sus nodos. (es decir, de izquierda 
a derecha, nivel por nivel).
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result; // Si el árbol está vacío, devolvemos una lista vacía

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Cola para realizar BFS

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Sacar el nodo de la cola
                level.add(node.val); // Agregar el valor del nodo al nivel actual

                if (node.left != null) queue.add(node.left); // Agregar hijo izquierdo a la cola
                if (node.right != null) queue.add(node.right); // Agregar hijo derecho a la cola
            }

            result.add(level); // Agregar el nivel actual al resultado
        }

        return result;
    }
}

// 199. Binary Tree Right Side View
/* Instrucciones: 
Dada la raíz de un árbol binario, imagínate de pie a la derecha
 del mismo, devuelve los valores de los nodos que puedes ver 
 ordenados de arriba a abajo.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result; // Si el árbol está vacío, devolvemos una lista vacía

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // Cola para realizar BFS

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll(); // Sacar el nodo de la cola

                // Si es el último nodo del nivel, agregarlo al resultado
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) queue.add(node.left); // Agregar hijo izquierdo a la cola
                if (node.right != null) queue.add(node.right); // Agregar hijo derecho a la cola
            }
        }

        return result;
    }
}
