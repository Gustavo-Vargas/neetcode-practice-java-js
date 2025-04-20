// 112. Path Sum 
/* Instrucciones: 
Dada la raíz de un árbol binario y un entero SumaObjetivo, devuelve 
  verdadero si el árbol tiene un camino de raíz a hoja tal que la 
  suma de todos los valores a lo largo del camino es igual a SumaObjetivo.

Una hoja es un nodo sin hijos.
*/
class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

var hasPathSum = function(root, targetSum) {
    if (!root) return false; // Si el árbol está vacío, no hay camino

    // Si llegamos a una hoja, verificamos si targetSum es igual al valor del nodo
    if (!root.left && !root.right) {
        return targetSum === root.val;
    }

    // Restamos el valor del nodo actual de targetSum y exploramos los subárboles
    const remainingSum = targetSum - root.val;
    return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
};


// 78. Subsets
/* Instrucciones: 
Dado un array entero nums de elementos únicos, devuelve todos los 
  subconjuntos posibles (el conjunto potencia).

El conjunto solución no debe contener subconjuntos duplicados.
  Devuelve la solución en cualquier orden.
*/
var subsets = function(nums) {
    const result = [];
    const subset = [];

    const backtrack = (index) => {
        // Agregar el subconjunto actual al resultado
        result.push([...subset]);

        // Explorar todas las opciones a partir del índice actual
        for (let i = index; i < nums.length; i++) {
            subset.push(nums[i]); // Incluir el elemento actual
            backtrack(i + 1); // Llamada recursiva con el siguiente índice
            subset.pop(); // Retroceder (backtrack) eliminando el último elemento
        }
    };

    backtrack(0); // Iniciar desde el índice 0
    return result;
};





// 39. Combinaciones de suma
/* Instrucciones: 
Dada una matriz de enteros distintos candidatos y un entero objetivo objetivo, 
  devuelve una lista de todas las combinaciones únicas de candidatos en las que 
  los números elegidos suman objetivo. Puede devolver las combinaciones en 
  cualquier orden.

Se puede elegir el mismo número entre los candidatos un número ilimitado de veces. 
  Dos combinaciones son únicas si la frecuencia de al menos uno de los números 
  elegidos es diferente.

Los casos de prueba se generan de forma que el número de combinaciones únicas 
  que suman el objetivo sea inferior a 150 combinaciones para la entrada dada.
*/
var combinationSum = function(candidates, target) {
    const result = [];
    const combination = [];

    const backtrack = (start, remaining) => {
        if (remaining === 0) {
            result.push([...combination]); // Agregar combinación válida al resultado
            return;
        }

        if (remaining < 0) return; // Si excedemos el target, retrocedemos

        for (let i = start; i < candidates.length; i++) {
            combination.push(candidates[i]); // Incluir el número actual
            backtrack(i, remaining - candidates[i]); // Permitir reutilizar el mismo número
            combination.pop(); // Retroceder eliminando el último número
        }
    };

    backtrack(0, target); // Iniciar desde el índice 0 con el target completo
    return result;
};

