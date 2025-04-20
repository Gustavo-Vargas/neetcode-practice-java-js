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

public class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> record = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) {
                record.pop(); // Elimina el último puntaje
            } else if (op.equals("D")) {
                record.push(record.peek() * 2); // Duplica el último puntaje
            } else if (op.equals("+")) {
                int last = record.pop();
                int newScore = last + record.peek();
                record.push(last); // Reagrega el último puntaje
                record.push(newScore); // Agrega la suma de los dos últimos puntajes
            } else {
                record.push(Integer.parseInt(op)); // Agrega un nuevo puntaje
            }
        }

        int sum = 0;
        for (int score : record) {
            sum += score; // Suma todos los puntajes
        }

        return sum;
    }

}


// 20. Valid Parentheses
/* Instrucciones:
Dada una cadena de entrada s, compuesta por caracteres '(', ')', '{', '}', '[' y ']',
determina si la cadena es válida.
Una cadena es válida si:
1.- Los corchetes abiertos deben cerrarse con corchetes del mismo tipo.
2.- Los corchetes abiertos deben cerrarse en el orden correcto.
3.- A cada corchete cerrado le corresponde un corchete abierto del mismo tipo.
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); 
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char aux = stack.pop();
                if ((c == ')' && aux != '(') ||
                    (c == ']' && aux != '[') ||
                    (c == '}' && aux != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // La pila debe estar vacía al final
    }
}


// 155. Min Stack
/* Instrucciones:
Implementa una pila que soporte las operaciones push, pop, top y retrieveMin.
Cada operación debe ejecutarse en tiempo constante O(1).

*/
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
         stack.push(val);
        if (minStack.isEmpty() || val <= getMin()) {
            minStack.push(val);
        }
    }
    
     public void pop() {
        int removed = stack.pop();
        // Si el valor eliminado es igual al mínimo actual, también lo eliminamos de minStack
        if (removed == getMin()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek(); // Devuelve el elemento en la parte superior
    }

    public int getMin() {
        return minStack.peek(); // Devuelve el mínimo actual
    }
}
