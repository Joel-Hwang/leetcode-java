package Medium;

import java.util.LinkedList;
import java.util.List;

public class PhoneNumber {
    public PhoneNumber() {
        letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        // 2. abc
        // 3. def
        // 4. ghi
        // 5. jkl
        // 6. mno
        // 7. pqrs
        // 8. tuv
        // 9. wxyz
        // digits = "23"
        // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        // digit = "2"
        // ["a","b","c"]
        LinkedList<String> queue = new LinkedList<>();
        if (digits.isEmpty())
            return queue;
        String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        queue.add("");

        while (queue.peek().length() != digits.length()) {
            String curElem = queue.remove();
            String nums = map[Integer.parseInt("" + digits.charAt(curElem.length()))];
            for (char c : nums.toCharArray()) {
                queue.add(curElem + c);
            }
        }

        return queue;

    }
}

/*
 * 
 * LinkedList<String> ans = new LinkedList<String>(); if (digits.isEmpty())
 * return ans; String[] mapping = new String[] { "0", "1", "abc", "def", "ghi",
 * "jkl", "mno", "pqrs", "tuv", "wxyz" }; ans.add(""); while
 * (ans.peek().length() != digits.length()) { String remove = ans.remove();
 * String map = mapping[digits.charAt(remove.length()) - '0']; for (char c :
 * map.toCharArray()) { ans.addLast(remove + c); } } return ans;
 * 
 * 
 * 
 * public List<String> letterCombinations(String digits) { LinkedList<String>
 * queue = new LinkedList<>(); if("".equals(digits)) return queue; String[]
 * matrix = {"","","abc","def","ghi","jkl","mno","qprs","tuv","wxyz"}; char[]
 * ardigit = digits.toCharArray(); queue.add(""); for(int j = 0;
 * j<ardigit.length;j++){ char c = ardigit[j]; String m = matrix[c-'0'];
 * while(queue.getFirst().length() == j){ String q = queue.removeFirst();
 * for(int i=0; i<m.length(); i++){ queue.add(q+m.substring(i, i+1)); } } }
 * return queue; }
 */