// 94. Binary Tree Inorder Traversal
/* Instrucciones: 
Dada la raíz de un árbol binario, devuelve el recorrido en orden 
de los valores de sus nodos.
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var inorderTraversal = function(root) {
    const result = [];

    const traverse = (node) => {
        if (!node) return;
        traverse(node.left); // Subárbol izquierdo
        result.push(node.val); // Nodo actual
        traverse(node.right); // Subárbol derecho
    };

    traverse(root);
    return result;
};



// 230. Kth Smallest Element in a BST
/* Instrucciones: 
Dada la raíz de un árbol de búsqueda binario y un número entero k, 
devuelve el k-ésimo valor más pequeño (indexado en 1) de todos los
 valores de los nodos del árbol.
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var kthSmallest = function(root, k) {
    let count = 0;
    let result = null;

    const inorder = (node) => {
        if (!node || result !== null) return;

        inorder(node.left); // Subárbol izquierdo

        count++;
        if (count === k) {
            result = node.val; // Encontramos el k-ésimo nodo
            return;
        }

        inorder(node.right); // Subárbol derecho
    };

    inorder(root);
    return result;
};

// 105. Construct Binary Tree from Preorder and Inorder Traversal
/* Instrucciones: 
Dadas dos matrices de enteros preorder e inorder donde preorder es 
el recorrido preorder de un árbol binario e inorder es el recorrido 
inorder del mismo árbol, construye y devuelve el árbol binario.
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var buildTree = function(preorder, inorder) {
    if (!preorder.length || !inorder.length) return null;

    // La raíz es el primer elemento de preorder
    const rootVal = preorder[0];
    const root = new TreeNode(rootVal);

    // Encuentra el índice de la raíz en inorder
    const rootIndex = inorder.indexOf(rootVal);

    // Divide el inorder en subárbol izquierdo y derecho
    const leftInorder = inorder.slice(0, rootIndex);
    const rightInorder = inorder.slice(rootIndex + 1);

    // Divide el preorder en subárbol izquierdo y derecho
    const leftPreorder = preorder.slice(1, leftInorder.length + 1);
    const rightPreorder = preorder.slice(leftInorder.length + 1);

    // Construye los subárboles recursivamente
    root.left = buildTree(leftPreorder, leftInorder);
    root.right = buildTree(rightPreorder, rightInorder);

    return root;
};
