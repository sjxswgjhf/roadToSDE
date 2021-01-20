package graphProblemTrainning;

import java.util.*;

public class Tarjan {


    /*
    遇到了unvisited node去做dfs，访问所有neigh，然后更新lowidx
    recursion返回的时候更新lowIdx，如果当前的idx跟lowidx一样的话，把所有的stack所有scc的node情况

    graph: directed graph
    n: # of nodes
     */
    boolean[] inStack;
    int[] lowIndex;
    Stack<Integer> stack;
    int[] ids;
    boolean[] visited;
    int countSCC = 0;
    int id;
    int[] sccs;
    public int findSCC(List<List<Integer>> graph, int n){
        sccs = new int[n];
        inStack = new boolean[n];
        lowIndex = new int[n];
        ids = new int[n];
        visited = new boolean[n];
        Arrays.fill(ids, -1);
        stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(ids[i] == -1){
                dfs(i, graph);
            }
        }
        return countSCC;
    }

    private void dfs(int curIdx, List<List<Integer>> graph){
        stack.push(curIdx);
        inStack[curIdx] = true;
        lowIndex[curIdx] = ids[curIdx] = id++;
        visited[curIdx] = true;
        for(int neigh : graph.get(curIdx)) {
            if (ids[neigh] == -1) {
                dfs(neigh, graph);
            }
            if (visited[neigh]) {
                lowIndex[curIdx] = Math.min(lowIndex[curIdx], lowIndex[neigh]);
            }
        }
        if(ids[curIdx] == lowIndex[curIdx]){
            for(int node = stack.pop(); ; node = stack.pop()){
                visited[node] = false;
                sccs[node] = countSCC;
                if(node == curIdx){
                    break;
                }
            }
            countSCC++;
        }
    }

}
