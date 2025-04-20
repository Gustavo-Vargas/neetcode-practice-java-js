// 912. Sort an Array con Quick Sort
/* Instrucciones: 
Dada una matriz de números enteros, ordene la matriz en orden ascendente y devuélvala.

Debe resolver el problema sin utilizar ninguna función incorporada en O(nlog(n)) 
complejidad de tiempo y con la menor complejidad de espacio posible.
*/
var sortArray = function(nums) {
    // Función para intercambiar dos elementos en el arreglo
    const swap = (arr, i, j) => {
        [arr[i], arr[j]] = [arr[j], arr[i]];
    };

    // Función para particionar el arreglo
    const partition = (arr, low, high) => {
        let pivot = arr[high]; // Elegir el último elemento como pivote
        let i = low - 1; // Índice del elemento más pequeño

        for (let j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j); // Intercambiar elementos
            }
        }
        swap(arr, i + 1, high); // Colocar el pivote en su posición correcta
        return i + 1; // Retornar el índice del pivote
    };

    // Función recursiva para Quick Sort
    const quickSort = (arr, low, high) => {
        if (low < high) {
            let pi = partition(arr, low, high); // Índice del pivote
            quickSort(arr, low, pi - 1); // Ordenar la subpartición izquierda
            quickSort(arr, pi + 1, high); // Ordenar la subpartición derecha
        }
    };

    quickSort(nums, 0, nums.length - 1); // Llamar a Quick Sort
    return nums;
};


// 215. Kth Largest Element in an Array
/* Instrucciones: 
Dado un array entero nums y un entero k, devuelve el k-ésimo elemento más grande del array.

Nótese que es el k-ésimo elemento mayor en el orden, no el k-ésimo elemento distinto.

*/
var findKthLargest = function(nums, k) {
    // Función para intercambiar dos elementos en el arreglo
    const swap = (arr, i, j) => {
        [arr[i], arr[j]] = [arr[j], arr[i]];
    };

    // Función para particionar el arreglo
    const partition = (arr, left, right) => {
        let pivot = arr[right]; // Elegir el último elemento como pivote
        let i = left; // Índice para colocar elementos mayores al pivote

        for (let j = left; j < right; j++) {
            if (arr[j] > pivot) { // Orden descendente
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right); // Colocar el pivote en su posición correcta
        return i; // Retornar el índice del pivote
    };

    // Quick Select para encontrar el k-ésimo elemento más grande
    const quickSelect = (arr, left, right, k) => {
        if (left <= right) {
            let pivotIndex = partition(arr, left, right);

            if (pivotIndex === k) {
                return arr[pivotIndex]; // Encontramos el k-ésimo elemento más grande
            } else if (pivotIndex < k) {
                return quickSelect(arr, pivotIndex + 1, right, k); // Buscar en la derecha
            } else {
                return quickSelect(arr, left, pivotIndex - 1, k); // Buscar en la izquierda
            }
        }
        return -1;
    };

    return quickSelect(nums, 0, nums.length - 1, k - 1); // k-1 porque los índices son 0-based
};



