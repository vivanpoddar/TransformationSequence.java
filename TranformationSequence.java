import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class TranformationSequence {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);        
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visitedNodes = new HashSet<>();
        int count = 0;
        queue.addFirst(beginWord);

        count++;
        while(true) {  
            int queueLength = queue.size();
            for(int i=0; i<queueLength; i++) {
                String curr = queue.remove();
                if (curr.equals(endWord)) return count;
                for (int j = 0; j<curr.length(); j++) {
                    for(char letter = 'a'; letter <= 'z'; letter++) {
                        String temp = curr.substring(0, j) + letter + curr.substring(j + 1);

                        if(visitedNodes.contains(temp)) continue;

                        if(words.contains(temp)) {
                            queue.addLast(temp);
                            visitedNodes.add(temp);
                        }
                    }
                }
            }
            count++;
            if(queueLength == 0) return 0;
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(ladderLength("a", "c", list));

        // list.add("hot");
        // list.add("dot");
        // list.add("dog");
        // list.add("lot");
        // list.add("log");
        // list.add("cog");
        // System.out.println(ladderLength("hit", "cog", list));

        // list.add("ted");
        // list.add("tex");
        // list.add("red");
        // list.add("tax");
        // list.add("tad");
        // list.add("den");
        // list.add("rex");
        // list.add("pee");

        // System.out.println(ladderLength("red", "tax", list));
    } 
}
