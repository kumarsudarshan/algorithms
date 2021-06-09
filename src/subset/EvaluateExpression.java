package subset;

/*
Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
Input: "1+2*3"
Output: 7, 9
Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
Input: "2*3-4-5"
Output: 8, -12, 7, -7, -3
Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => -3
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateExpression {
    public static void main(String[] args) {
        System.out.println(evaluateExpression("1+2*3"));
        System.out.println(evaluateExpression("2*3-4-5"));
    }
    static Map<String, List<Integer>> map = new HashMap<>();
    public static List<Integer> evaluateExpression(String input) {
        if(map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    // break the equation into two parts and call then recursively
                    List<Integer> leftPart = evaluateExpression(input.substring(0, i));
                    List<Integer> rightPart = evaluateExpression(input.substring(i + 1));
                    for (int part1 : leftPart) {
                        for (int part2 : rightPart) {
                            if (chr == '+') {
                                result.add(part1 + part2);
                            } else if (chr == '-') {
                                result.add(part1 - part2);
                            } else {
                                result.add(part1 * part2);
                            }
                        }
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }
}
