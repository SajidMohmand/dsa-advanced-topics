package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAlgorithms {

    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // undirected graph
//        graph[0].add(new Edge(0,1));
//        graph[0].add(new Edge(0,2));
//
//        graph[1].add(new Edge(1,0));
//        graph[1].add(new Edge(1,3));
//
//        graph[2].add(new Edge(2,0));
//        graph[2].add(new Edge(2,4));
//
//        graph[3].add(new Edge(3,1));
//        graph[3].add(new Edge(3,4));
//        graph[3].add(new Edge(3,5));
//
//        graph[4].add(new Edge(4,2));
//        graph[4].add(new Edge(4,3));
//        graph[4].add(new Edge(4,5));
//
//        graph[5].add(new Edge(5,3));
//        graph[5].add(new Edge(5,4));
//        graph[5].add(new Edge(5,6));
//
//        graph[6].add(new Edge(6,5));

        // directed graph
//        graph[0].add(new Edge(0,2));
//
//        graph[1].add(new Edge(1,0));
//
//        graph[2].add(new Edge(2,3));
//
//        graph[3].add(new Edge(3,0));


        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));


    }


    // time complexity: O(V+E)
    public static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while (!q.isEmpty()){
            int curr = q.poll();
            if (!vis[curr]){
                System.out.print(curr+" ");
                vis[curr] = true;

                for (int i=0; i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
    }

    // time complexity: O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, boolean[] vis,int x){
        if (!vis[x]){
            System.out.print(x+" ");
            vis[x] = true;
            for (int i=0; i<graph[x].size(); i++){
                int val = graph[x].get(i).dest;
                dfs(graph,vis,val);
            }
        }
    }


//    Questions

    // 1:All path from source to target
    // time complexity: O(V^V)
    public static void allPathFromRange(ArrayList<Edge>[] graph,int curr,boolean[] vis,String path,int target){
        if (curr == target){
            System.out.println(path);
            return;
        }

        for (int i=0; i<graph[curr].size(); i++){
            int val = graph[curr].get(i).dest;
            if (!vis[val]){
                vis[curr] = true;
                allPathFromRange(graph,val,vis,path+val,target);
                vis[curr] = false;
            }
        }
    }

    // 2:Cycle detection
    // time complexity: O(E+V)
    public static boolean cycleDetection(ArrayList<Edge>[] graph,boolean[] vis,int curr,boolean[] stackArr){
        vis[curr] = true;
        stackArr[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){
            int val = graph[curr].get(i).dest;

            if (stackArr[val]){
                return true;
            }else if (!vis[val]){
                if (cycleDetection(graph, vis, val, stackArr)) {
                    return true;
                }
            }
        }
        stackArr[curr] = false;
        return false;
    }


    // 3:Topological Sorting
    // time complexity: O(E+V)
    public static void topSort(ArrayList<Edge>[] graph,boolean[] vis){

        Stack<Integer> st = new Stack<>();

        for (int i=0; i<vis.length; i++){
            if (!vis[i]){
                topologicalSorting(graph,vis,i,st);
            }
        }

       while (!st.empty()){
           System.out.print(st.pop()+" ");
       }
        System.out.println();

    }
    public static void topologicalSorting(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stack){

        vis[curr] = true;
        for (int i=0; i<graph[curr].size(); i++){

            int val = graph[curr].get(i).dest;
            if (!vis[val]) {
                topologicalSorting(graph,vis,val,stack);
            }
        }
        stack.push(curr);
    }




    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean[] vis = new boolean[v];

        // for disconnected component graph also
//        for (int i=0; i<vis.length; i++){
//            if (vis[i] == false){
//                bfs(graph,vis,i);
//            }
//        }

//        dfs(graph,new boolean[v],0);
//        allPathFromRange(graph,0,new boolean[v],"0",5);

//        boolean[] stackArr = new boolean[v];
//        for (int i = 0; i < graph.length; i++) {
//            if (!vis[i]) {
//                if (cycleDetection(graph, vis, i, stackArr)) {
//                    System.out.println("Cycle found");
//                    break;
//                }
//            }
//        }


        topSort(graph,vis);


    }
}
