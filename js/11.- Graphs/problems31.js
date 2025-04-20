//133. Clone Graph
/* Instrucciones: 
Dada una referencia de un nodo en un grafo no dirigido conectado.

Devuelve una copia profunda (clon) del grafo.

Cada nodo del grafo contiene un valor (int) y una lista (List[Node]) de sus vecinos.

class Node {
 public int val;
 public List<Node> neighbors;
}
*/
class Node {
    constructor(val, neighbors = []) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

var cloneGraph = function(node) {
    if (!node) return null;

    const map = new Map(); // HashMap para mapear nodos originales a sus copias

    const dfs = (current) => {
        if (map.has(current)) {
            return map.get(current); // Devolver la copia si ya existe
        }

        // Crear una copia del nodo actual
        const copy = new Node(current.val);
        map.set(current, copy);

        // Recorrer los vecinos y agregarlos a la copia
        for (const neighbor of current.neighbors) {
            copy.neighbors.push(dfs(neighbor));
        }

        return copy;
    };

    return dfs(node);
};


// 207. Course Schedule
/* Instrucciones: 
Hay un total de numCursos cursos que tiene que tomar, etiquetados de 0 a 
   numCursos - 1. Se le da un array prerrequisitos donde 
   prerrequisitos[i] = [ai, bi] indica que debe tomar primero el curso bi 
   si quiere tomar el curso ai.

 - Por ejemplo, el par [0, 1], indica que para tomar el curso 0 primero debe tomar el curso 1.
Devuelve true si puedes terminar todos los cursos. En caso contrario, devuelve false.

*/
var canFinish = function(numCourses, prerequisites) {
    const graph = Array.from({ length: numCourses }, () => []);
    const inDegree = Array(numCourses).fill(0);

    // Construir el grafo y calcular el grado de entrada
    for (const [course, prereq] of prerequisites) {
        graph[prereq].push(course);
        inDegree[course]++;
    }

    // Cola para nodos con grado de entrada 0
    const queue = [];
    for (let i = 0; i < numCourses; i++) {
        if (inDegree[i] === 0) {
            queue.push(i);
        }
    }

    let processedCourses = 0;

    // Procesar los nodos
    while (queue.length > 0) {
        const current = queue.shift();
        processedCourses++;

        for (const neighbor of graph[current]) {
            inDegree[neighbor]--;
            if (inDegree[neighbor] === 0) {
                queue.push(neighbor);
            }
        }
    }

    // Si procesamos todos los cursos, no hay ciclos
    return processedCourses === numCourses;
};