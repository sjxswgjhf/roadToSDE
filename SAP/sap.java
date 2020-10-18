package SAP;

import java.util.*;

public class sap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] names = new String[5];
        int idx = 0;
        while (input.hasNextLine()) {
            names[idx++] = input.nextLine();
        }
        String leader = findLeader(names);
        System.out.println(leader);
    }

    static class Node{
        int count;
        String name;
        public Node(int count, String name){
            this.count = count;
            this.name = name;
        }
    }

    private static String findLeader(String[] names){
        Stack<Node> stack = new Stack<>();
        for(String name : names){
            int numberOfLetters = countLetter(name.toLowerCase());
            Node node= new Node(numberOfLetters, name);
            if(stack.isEmpty()){
                stack.push(node);
            }else{
                Node top = stack.peek();
                if(top.count < node.count){
                    stack.push(node);
                }
                else if(top.count == node.count){
                    if(top.name.compareTo(node.name) < 0){
                        continue;
                    }else{
                        stack.push(node);
                    }
                }else{
                    continue;
                }
            }
        }
        return stack.peek().name;
    }

    private static int countLetter(String name){
        int letters = 0;
        HashSet<Character> set = new HashSet<>();
        for(Character c : name.toCharArray()){
            if(!Character.isLetter(c)){
                continue;
            }else{
                if(set.contains(c)){
                    continue;
                }else{
                    letters++;
                    set.add(c);
                }
            }
        }
        return letters;
    }
}
