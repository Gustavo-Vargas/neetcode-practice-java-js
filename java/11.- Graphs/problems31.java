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
public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>(); // HashMap para mapear nodos originales a sus copias

        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node); // Devolver la copia si ya existe
        }

        // Crear una copia del nodo actual
        Node copy = new Node(node.val);
        map.put(node, copy);

        // Recorrer los vecinos y agregarlos a la copia
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, map));
        }

        return copy;
    }
}


// 207. Course Schedule
/* Instrucciones: 
Hay un total de numCursos cursos que tiene que tomar, etiquetados de 0 a 
   numCursos - 1. Se le da un array prerrequisitos donde 
   prerrequisitos[i] = [ai, bi] indica que debe tomar primero el curso bi 
   si quiere tomar el curso ai.

 - Por ejemplo, el par [0, 1], indica que para tomar el curso 0 primero debe tomar el curso 1.
Devuelve true si puedes terminar todos los cursos. En caso contrario, devuelve false.

*/
//
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Crear el grafo y calcular el grado de entrada
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph.get(prereqCourse).add(course);
            inDegree[course]++;
        }

        // Cola para nodos con grado de entrada 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedCourses = 0;

        // Procesar los nodos
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCourses++;

            for (int neighbor : graph.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Si procesamos todos los cursos, no hay ciclos
        return processedCourses == numCourses;
    }
}
