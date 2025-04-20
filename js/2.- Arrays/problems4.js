//  681. Baseball Game
/* Instrucciones:
Estás llevando la puntuación de un partido de béisbol con reglas extrañas. 
Al principio del partido, empiezas con un registro vacío.

Se le da una lista de cadenas de operaciones, donde operations[i] es la 
i-ésima operación que debe aplicar al registro y es una de las siguientes:

- Un entero x.
    Registra una nueva puntuación de x.
- '+'.
    Registra una nueva puntuación que es la suma de las dos puntuaciones anteriores.
- 'D'.
    Registra una nueva puntuación que es el doble de la puntuación anterior.
- 'C'.
    Invalida la puntuación anterior, eliminándola del registro.
*/

var calPoints = function(operations) {
    const record = [];

    for (const op of operations) {
        if (op === "C") {
            record.pop(); // Elimina el último puntaje
        } else if (op === "D") {
            record.push(record[record.length - 1] * 2); // Duplica el último puntaje
        } else if (op === "+") {
            record.push(record[record.length - 1] + record[record.length - 2]); // Suma los dos últimos puntajes
        } else {
            record.push(parseInt(op)); // Agrega un nuevo puntaje
        }
    }

    return record.reduce((sum, score) => sum + score, 0); // Suma todos los puntajes
};


// 20. Valid Parentheses
/* Instrucciones:
Dada una cadena de entrada s, compuesta por caracteres '(', ')', '{', '}', '[' y ']',
determina si la cadena es válida.
Una cadena es válida si:
1.- Los corchetes abiertos deben cerrarse con corchetes del mismo tipo.
2.- Los corchetes abiertos deben cerrarse en el orden correcto.
3.- A cada corchete cerrado le corresponde un corchete abierto del mismo tipo.
*/
var isValid = function(s) {
    const stack = [];
        for (const char of s) {
            if (char === '(' || char == '[' || char === '{') {
                stack.push(char); 
            } else {
                if (stack.length === 0) {
                    return false;
                }
                const aux = stack.pop();
                if ((char=== ')' && aux !== '(') ||
                    (char === ']' && aux !== '[') ||
                    (char === '}' && aux !== '{')) {
                    return false;
                }
            }
        }

        return stack.length === 0;
};



// 155. Min Stack
/* Instrucciones:
Implementa una pila que soporte las operaciones push, pop, top y retrieveMin.
Cada operación debe ejecutarse en tiempo constante O(1).

*/
class MinStack {
    constructor() {
        this.stack = [];
        this.minStack = []; 
    }

    push(val) {
        this.stack.push(val);
        // Si la pila auxiliar está vacía o el nuevo valor es menor o igual al mínimo actual
        if (this.minStack.length === 0 || val <= this.getMin()) {
            this.minStack.push(val);
        }
    }

    pop() {
        const removed = this.stack.pop();
        // Si el valor eliminado es igual al mínimo actual, también lo eliminamos de minStack
        if (removed === this.getMin()) {
            this.minStack.pop();
        }
    }

    top() {
        return this.stack[this.stack.length - 1]; // Devuelve el elemento en la parte superior
    }

    getMin() {
        return this.minStack[this.minStack.length - 1]; // Devuelve el mínimo actual
    }
}



