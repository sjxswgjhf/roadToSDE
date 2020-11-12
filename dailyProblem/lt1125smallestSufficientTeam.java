package dailyProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class lt1125smallestSufficientTeam {

    class Solution {
        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            int n = req_skills.length;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(req_skills[i], i);
            }
            //bit mask
            List<Integer>[] suff = new ArrayList[1 << n];
            suff[0] = new ArrayList<>();
            for (int i = 0; i < people.size(); i++) {
                int skill = 0;
                //build bit mask for this people
                for (String s : people.get(i)) {
                    skill |= (1 << map.get(s));
                }
                for (int prev = 0; prev < suff.length; prev++) {
                    if (suff[prev] == null) {
                        continue;
                    }
                    int comb = prev | skill;
                    if (suff[comb] == null || suff[prev].size() + 1 < suff[comb].size()) {
                        suff[comb] = new ArrayList<>(suff[prev]);
                        suff[comb].add(i);
                    }
                }
            }
            List<Integer> res = suff[(1 << n) - 1];
            int[] arr = new int[res.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }
}
