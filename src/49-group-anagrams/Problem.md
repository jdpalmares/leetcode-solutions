# 49. Group Anagrams


## Medium

Given an array of strings `strs`, group **the anagrams** together. You can return the answer in **any order**.

An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

### Example 1:
```console
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
```

### Example 2:
```console
Input: strs = [""]
Output: [[""]]
```

### Example 3:
```console
Input: strs = ["a"]
Output: [["a"]]
```

### Constraints:

- `1 <= strs.length <= 10`^4^
- `0 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters.

**Follow up**: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?