// 75. Sort Colors
/* Instrucciones: 
Dada una matriz nums con n objetos de color rojo, blanco o azul, ordénelos en su lugar 
  de modo que los objetos del mismo color sean adyacentes, con los colores en el orden 
  rojo, blanco y azul.

Usaremos los enteros 0, 1 y 2 para representar el color rojo, blanco y azul, respectivamente.

Debes resolver este problema sin utilizar la función de ordenación de la biblioteca.
*/
var sortColors = function(nums) {
    // Paso 1: Contar los elementos
    const count = [0, 0, 0]; // count[0] para 0, count[1] para 1, count[2] para 2
    for (let num of nums) {
        count[num]++;
    }

    // Paso 2: Sobrescribir el arreglo original
    let index = 0;
    for (let i = 0; i < count[0]; i++) nums[index++] = 0; // Escribir todos los 0
    for (let i = 0; i < count[1]; i++) nums[index++] = 1; // Escribir todos los 1
    for (let i = 0; i < count[2]; i++) nums[index++] = 2; // Escribir todos los 2
};


