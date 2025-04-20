// 102. Binary Tree Level Order Traversal
/* Instrucciones: 
Dada la raíz de un árbol binario, devuelve el recorrido por orden 
de nivel de los valores de sus nodos. (es decir, de izquierda 
a derecha, nivel por nivel).
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var levelOrder = function(root) {
    if (!root) return []; // Si el árbol está vacío, devolvemos una lista vacía

    const result = [];
    const queue = [root]; // Cola para realizar BFS

    while (queue.length > 0) {
        const level = [];
        const size = queue.length;

        for (let i = 0; i < size; i++) {
            const node = queue.shift(); // Sacar el nodo de la cola
            level.push(node.val); // Agregar el valor del nodo al nivel actual

            if (node.left) queue.push(node.left); // Agregar hijo izquierdo a la cola
            if (node.right) queue.push(node.right); // Agregar hijo derecho a la cola
        }

        result.push(level); // Agregar el nivel actual al resultado
    }

    return result;
};


// 199. Binary Tree Right Side View
/* Instrucciones: 
Dada la raíz de un árbol binario, imagínate de pie a la derecha
 del mismo, devuelve los valores de los nodos que puedes ver 
 ordenados de arriba a abajo.
*/

class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var rightSideView = function(root) {
    if (!root) return []; // Si el árbol está vacío, devolvemos una lista vacía

    const result = [];
    const queue = [root]; // Cola para realizar BFS

    while (queue.length > 0) {
        const size = queue.length;

        for (let i = 0; i < size; i++) {
            const node = queue.shift(); // Sacar el nodo de la cola

            // Si es el último nodo del nivel, agregarlo al resultado
            if (i === size - 1) {
                result.push(node.val);
            }

            if (node.left) queue.push(node.left); // Agregar hijo izquierdo a la cola
            if (node.right) queue.push(node.right); // Agregar hijo derecho a la cola
        }
    }

    return result;
};