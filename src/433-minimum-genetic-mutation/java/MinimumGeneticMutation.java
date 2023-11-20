import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;
        
        Set<String> bankSet = new HashSet<>();
        for(String validGeneStr: bank) bankSet.add(validGeneStr);
        
        char[] geneCharArr = new char[]{'A', 'C', 'G', 'T'};
        
        int level = 0;
        Set<String> checkGeneStr = new HashSet<>();
        Queue<String> genesQueue = new LinkedList<>();
        genesQueue.offer(startGene);
        checkGeneStr.add(startGene);
        
        while(!genesQueue.isEmpty()) {
            int genesSize = genesQueue.size();
            while(genesSize-- > 0) {
                String currentGene = genesQueue.poll();
                if(currentGene.equals(endGene)) return level;
                
                char[] currGeneArray = currentGene.toCharArray();
                for(int i = 0; i < currGeneArray.length; i++) {
                    char old = currGeneArray[i];
                    for(char gene: geneCharArr) {
                        currGeneArray[i] = gene;
                        String next = new String(currGeneArray);
                        if(!checkGeneStr.contains(next) && bankSet.contains(next)) {
                            checkGeneStr.add(next);
                            genesQueue.offer(next);
                        }
                    }
                    currGeneArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
