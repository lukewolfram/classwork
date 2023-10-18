import java.util.*;

class src
{
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] graph = new int[n+1][n+1];
            for (int i = 0; i < m; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int c = sc.nextInt();
                graph[u][v] += c;
            }
            int maxFlow = maxFlow(graph, 1, n);
            System.out.println(maxFlow);
        }
    }

    static int maxFlow(int[][] graph, int source, int sink)
    {
        int[][] residual = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++)
        {
            for (int j = 0; j < graph.length; j++)
            {
                residual[i][j] = graph[i][j];
            }
        }
        int[] parent = new int[graph.length];
        int maxFlow = 0;
        while (bfs(residual, source, sink, parent))
        {
            int pathFlow = INF;
            for (int v = sink; v != source; v = parent[v])
            {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }
            for (int v = sink; v != source; v = parent[v])
            {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }

    static boolean bfs(int[][] graph, int source, int sink, int[] parent)
    {
        Arrays.fill(parent, -1);
        parent[source] = -2;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty())
        {
            int u = queue.poll();
            for (int v = 1; v < graph.length; v++)
            {
                if (parent[v] == -1 && graph[u][v] > 0) 
                {
                    parent[v] = u;
                    if (v == sink)
                    {
                        return true;
                    }
                    queue.offer(v);
                }
            }
        }
        return false;
    }
}