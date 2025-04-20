// 912. Sort an Array
/* Instrucciones: 
Dada una matriz de números enteros, ordene la matriz en orden ascendente y devuélvala.

Debe resolver el problema sin utilizar ninguna función incorporada en O(nlog(n)) 
complejidad de tiempo y con la menor complejidad de espacio posible.
*/
var sortArray = function(nums) {
    // Función para fusionar dos subarreglos ordenados
    const merge = (left, right) => {
        let sorted = [];
        let i = 0, j = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sorted.push(left[i]);
                i++;
            } else {
                sorted.push(right[j]);
                j++;
            }
        }

        // Agregar los elementos restantes
        while (i < left.length) sorted.push(left[i++]);
        while (j < right.length) sorted.push(right[j++]);

        return sorted;
    };

    // Función recursiva para dividir y ordenar
    const mergeSort = (arr) => {
        if (arr.length <= 1) return arr; // Caso base

        const mid = Math.floor(arr.length / 2);
        const left = mergeSort(arr.slice(0, mid)); // Mitad izquierda
        const right = mergeSort(arr.slice(mid)); // Mitad derecha

        return merge(left, right); // Fusionar las mitades ordenadas
    };

    return mergeSort(nums);
};




