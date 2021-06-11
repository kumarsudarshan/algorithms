package heap.topkelements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Rearrange String (hard)
Given a string, find if its letters can be rearranged in such a way that no two same characters come next to each other.
Input: "aappp"
Output: "papap"
Explanation: In "papap", none of the repeating characters come next to each other.
Input: "Programming"
Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
Explanation: None of the repeating characters come next to each other.
Input: "aapa"
Output: ""
Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".
 */
public class RearrangeString {
    public static void main(String[] args) {
        System.out.println(rearrangeString("aappp"));
        System.out.println(rearrangeString("Programming"));
        System.out.println(rearrangeString("aapa"));
    }

    public static String rearrangeString(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max-heap
        maxHeap.addAll(frequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();

            // add previous entry back to the max heap if it's frequency > 0
            if (previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }
            // append the current character to result string and decrement its count
            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }
        return result.length() == str.length() ? result.toString() : "";
    }
}
