package geeksforgeeks;

import java.util.Vector;

class GFG{

    static int sum;

    // Function to implement DFS
    static void depthFirst(int v,
                           Vector<Integer> graph[],
                           boolean []visited,
                           Vector<Integer> values)
    {

        // Marking the visited vertex as true
        visited[v] = true;

        // Updating the value of connection
        sum += values.get(v - 1);

        // Traverse for all adjacent nodes
        for(int i : graph[v])
        {
            if (visited[i] == false)
            {

                // Recursive call to the DFS algorithm
                depthFirst(i, graph, visited, values);
            }
        }
    }

    static void maximumSumOfValues(Vector<Integer> graph[],
                                   int vertices,
                                   Vector<Integer> values)
    {

        // Initializing boolean array to
        // mark visited vertices
        boolean []visited = new boolean[values.size() + 1];

        // maxChain stores the maximum chain size
        int maxValueSum = Integer.MIN_VALUE;

        // Following loop invokes DFS algorithm
        for(int i = 1; i <= vertices; i++)
        {
            if (visited[i] == false)
            {

                // Variable to hold temporary values
                sum = 0;

                // DFS algorithm
                depthFirst(i, graph, visited, values);

                // Conditional to update max value
                if (sum > maxValueSum)
                {
                    maxValueSum = sum;
                }
            }
        }

        // Printing the heaviest chain value
        System.out.print("Max Sum value = ");
        System.out.print(maxValueSum + "\n");
    }

    // Driver code
    public static void main(String[] args)
    {

        // Initializing graph in the form
        // of adjacency list
        @SuppressWarnings("unchecked")
        Vector<Integer> []graph = new Vector[1001];

        for(int i = 0; i < graph.length; i++)
            graph[i] = new Vector<Integer>();

        // Defining the number of edges and vertices
        int E = 4, V = 7;

        // Assigning the values for each
        // vertex of the undirected graph
        Vector<Integer> values = new Vector<Integer>();
        values.add(10);
        values.add(25);
        values.add(5);
        values.add(15);
        values.add(5);
        values.add(20);
        values.add(0);

        // Constructing the undirected graph
        graph[1].add(2);
        graph[2].add(1);
        graph[3].add(4);
        graph[4].add(3);
        graph[3].add(5);
        graph[5].add(3);
        graph[6].add(7);
        graph[7].add(6);

        maximumSumOfValues(graph, V, values);
    }
}
