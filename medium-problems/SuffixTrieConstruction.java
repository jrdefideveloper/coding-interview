import java.util.*;

public class SuffixTrieConstruction {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        // O(n^2) time | O(n^2) space n = length of input string
        public void populateSuffixTrieFrom(String str) {
            // 1. iterate through suffixes
            // 2. Add one by one into the trie
            for (int i = 0; i < str.length(); i++) {
                insertSubstringStartingAt(i, str);
            }
        }

        // Insert string into suffix trie
        public void insertSubstringStartingAt(int index, String str) {
            TrieNode node = root;
            for (int j = index; j < str.length(); j++) {
                Character current = str.charAt(j);
                if (!node.children.containsKey(current)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(current, newNode);
                }
                node = node.children.get(current);
            }
            node.children.put(endSymbol, null); // Add asterisk at the end
        }

        // O(m) time | O(1) space | m = string you are looking for =)
        public boolean contains(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) {
                    return false;
                }
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }

}
