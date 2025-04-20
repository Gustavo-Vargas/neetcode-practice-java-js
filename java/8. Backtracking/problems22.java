// 112. Path Sum 
/* Instrucciones: 
Dada la raíz de un árbol binario y un entero SumaObjetivo, devuelve 
  verdadero si el árbol tiene un camino de raíz a hoja tal que la 
  suma de todos los valores a lo largo del camino es igual a SumaObjetivo.

Una hoja es un nodo sin hijos.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // Si el árbol está vacío, no hay camino

        // Si llegamos a una hoja, verificamos si targetSum es igual al valor del nodo
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Restamos el valor del nodo actual de targetSum y exploramos los subárboles
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}


// 78. Subsets
/* Instrucciones: 
Dado un array entero nums de elementos únicos, devuelve todos los 
  subconjuntos posibles (el conjunto potencia).

El conjunto solución no debe contener subconjuntos duplicados.
  Devuelve la solución en cualquier orden.
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(0, nums, subset, result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        // Agregar el subconjunto actual al resultado
        result.add(new ArrayList<>(subset));

        // Explorar todas las opciones a partir del índice actual
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]); // Incluir el elemento actual
            backtrack(i + 1, nums, subset, result); // Llamada recursiva con el siguiente índice
            subset.remove(subset.size() - 1); // Retroceder (backtrack) eliminando el último elemento
        }
    }
}





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
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        backtrack(0, target, candidates, combination, result);
        return result;
    }

    private void backtrack(int start, int remaining, int[] candidates, List<Integer> combination, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(combination)); // Agregar combinación válida al resultado
            return;
        }

        if (remaining < 0) return; // Si excedemos el target, retrocedemos

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]); // Incluir el número actual
            backtrack(i, remaining - candidates[i], candidates, combination, result); // Permitir reutilizar el mismo número
            combination.remove(combination.size() - 1); // Retroceder eliminando el último número
        }
    }
}

