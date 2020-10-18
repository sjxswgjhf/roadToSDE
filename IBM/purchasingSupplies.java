package IBM;

public class purchasingSupplies {

    public void purchasingSupplies(String[] scenarios){
        for(String scenario : scenarios){
            String[] strs = scenario.split(" ");
            int budget = Integer.valueOf(strs[0]);
            int cost = Integer.valueOf(strs[1]);
            int exchange = Integer.valueOf(strs[2]);

            int containers = budget / cost;
            int ans = containers;
            while(containers >= exchange){
                ans += containers / exchange;
                int rem = containers % exchange;
                containers = containers / exchange + rem;
            }
            System.out.println(ans);
        }
    }
}
