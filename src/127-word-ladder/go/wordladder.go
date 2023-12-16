func ladderLength(beginWord string, endWord string, wordList []string) int {
    dict := make(map[string]bool)
    for _, v := range wordList {
        dict[v] = true
    }
    
    if _, ok := dict[endWord]; !ok {
        return 0
    }
    
    q := make([]string, 0)
    q = append(q, beginWord)
    
    ll := len(beginWord)
    level := 0
    
    for len(q) > 0 {
        level++;
        size := len(q)
        for i := 0; i < size; i++ {
            w := q[0]
            q = q[1:]
            for j := 0; j < ll; j++ {
                for ch := 'a'; ch <= 'z'; ch++{
                    ww := w[:j] + string(ch) + w[j+1:]
                    if ww == endWord {return level+1}
                    if _, ok := dict[ww]; !ok { continue}
                    delete(dict, ww)
                    q = append(q, ww)
                }
            }
        }
    }
    return 0
}