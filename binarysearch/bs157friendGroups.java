package binarysearch;

import java.util.HashSet;

public class bs157friendGroups {

    class Solution {
        public int solve(int[][] friends) {
            //dfs
            int n = friends.length;
            HashSet<Integer> visited = new HashSet<>();
            int count = 0;
            for(int i = 0; i < n; i++){
                if(visited.contains(i)){
                    continue;
                }
                else{
                    count++;
                    dfs(friends, i, visited);
                }
            }
            return count;
        }

        private void dfs(int[][] friends, int cur, HashSet<Integer> visited){
            if(visited.contains(cur)){
                return;
            }
            visited.add(cur);
            for(int friend : friends[cur]){
                dfs(friends, friend, visited);
            }
        }
    }

}
