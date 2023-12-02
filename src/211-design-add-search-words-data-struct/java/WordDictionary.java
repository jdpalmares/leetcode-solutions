
//solution based on https://leetcode.com/problems/design-add-and-search-words-data-structure/solutions/1725327/java-c-python-a-very-well-detailed-explanation/
public class WordDictionary {
    private WordDictionary[] dictionary;
    boolean isEndOfWord;

    public WordDictionary() {
        dictionary = new WordDictionary[26];
        isEndOfWord = false;
    }
    
    public void addWord(String word) {
        WordDictionary instance = this;
        for(char c: word.toCharArray()){
            if(instance.dictionary[c - 'a'] == null)
                instance.dictionary[c - 'a'] = new WordDictionary();
            instance = instance.dictionary[c - 'a'];
        }
        instance.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        WordDictionary instance = this;
        for(int i = 0; i < word.length(); ++i){
            char c = word.charAt(i);
            if(c == '.'){
                for(WordDictionary dict: instance.dictionary)
                    if(dict != null && dict.search(word.substring(i+1))) return true;
                return false;
            }
            if(instance.dictionary[c - 'a'] == null) return false;
            instance = instance.dictionary[c - 'a'];
        }
        return instance != null && instance.isEndOfWord;
    }
}
