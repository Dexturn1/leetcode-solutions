class Pair {
    String first;
    int second;

    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));


        Set<String> st = new HashSet<>();

        for(String word: wordList)
            st.add(word);

        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // Target Reached
            if(word.equals(endWord) == true) return steps;

            // tra replacing every character
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);



                    // if it exists in 
                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);// mark visited;
                        q.add(new Pair(replacedWord, steps+ 1 ));
                    }

                }

            }

        }
        return 0;
    }
}