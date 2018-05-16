/**
 *
 * @author alexandrebornerand
 */

public class WordStoreImp implements WordStore{
    private WordStoreDT[] wordsStored;
    int count;
    //constructor
    public WordStoreImp(int size){
        wordsStored = new WordStoreDT[size];
        count=1;
    }
    
    /*** EXPAND array ***/
    
    private void expand() {
        WordStoreDT[] wordsStored1 = new WordStoreDT[wordsStored.length*2];
        for (int i=0; i<wordsStored.length; i++)
            wordsStored1[i] = wordsStored[i];
        wordsStored=wordsStored1;
    }//END expand
    
    /*** ADD METHOD ***/
    
    @Override
    public void add(String word) {
        int index = hash(word);
        WordStoreDT<String> ws = wordsStored[index];
        if (ws==null) wordsStored[index] = new WordStoreDT<>(word,null);
        
        else {
            if (!isRepeated(wordsStored[index], word)) {
                wordsStored[index] = new WordStoreDT<>(word,wordsStored[index]);
            }
        }
        count++;
        if (count >= 0.75*wordsStored.length)
            //ensures at least 25% of array remains empty in order to accomodate more additions and avoid collisions.
            expand();
    }//END add method
    
    /**** COUNT METHOD ******/
    
    @Override
    public int count(String word) {
        //returns the number of times a string appears in the collection.
        int index = hash(word);
        WordStoreDT<String> ws = wordsStored[index];
        if (ws == null){
            return 0;
        }
        else {       
            WordStoreDT<String> ptr = ws;
            for (; ptr!=null; ptr = ptr.next) {
                if (word.equals(ptr.first))
                    return ptr.count;
            }
        }
        return 0;
    }//END count
    
    /**** REMOVE METHOD ******/
    
    @Override
    public void remove(String word) {
        //removes one occurence of a String from the collection, or leaves the collection unchanged if the String does not occur in it.
        int index = hash(word);
        WordStoreDT<String> ws = wordsStored[index];
        if (ws!=null) {
            WordStoreDT<String> ptr = ws;
            for (;ptr.next!=null&&!word.equals(ptr.next.first);ptr=ptr.next) {
                if (word.equals(ptr.first)) {
                    if (ptr.count>1) {
                        ptr.count--;
                        return;
                    }
                    else if (ptr.count == 1) {
                        if (ptr.next!=null){
                            count--;
                            wordsStored[index] = wordsStored[index].next;}
                        return;
                        
                    }
                }
            }
        }
    }//END remove
        
    /**** INITIAL HASH FUNCTION ****/
    
    private int hash_initial(String word) {
        //initial hash function, too slow

        //converts each letter of a string into its ASCII equivalent, 
        //sums up the numbers and returns the remainder when divided by the size of the array.
        int sum=0;
        char[] ascii = word.toCharArray();
        for (int i=0; i<ascii.length; i++) {
            sum = 43*sum*ascii[i];
        }
        return Math.abs(sum)%wordsStored.length;
    }//END hash_initial
    
    /**** FINAL HASH FUNCTION ****/
      
    private int hash(String word) {
        //final hash functin, different hashing algorithm
        int hashKey =0;
        for (int i=0; i<word.length(); i++) 
            hashKey=31*hashKey+word.charAt(i);
        return Math.abs(hashKey)%wordsStored.length;
    }//END hash
    
    /*** ISREPEATED METHOD *****/
    
    private boolean isRepeated(WordStoreDT ws, String word) {
        WordStoreDT<String> ptr = ws;
        while (ptr.next!=null) {
            if (ptr.first.equals(word)) {
                ptr.count++;
                return true;
            }
            ptr=ptr.next;
        }
        return false;
    }//END isRepeated
    
    /*** TRIAL METHOD: displays the words in array ***/
    //In order for this method to work, it must be added in WorstStore.java
    
    @Override
    public void display(){
        for(int i=0;i<wordsStored.length; i++) {
            if (wordsStored[i]==null) {/*System.out.println("oops");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a word to add");
                String word = scanner.nextLine();
                System.out.println(hash(word));*/
            continue;}
            WordStoreDT<String> current = wordsStored[i];
            while(current!=null) {
                System.out.println(current.first);
                current=current.next;
            }
            System.out.println();
        }
    }//END display
      
    /************* WORDSTOREDT CLASS ****************/
    
    private static class WordStoreDT <String> {
        String first;
        WordStoreDT<String> next;
        int count;
        
        WordStoreDT(String f, WordStoreDT<String> n) {
            first = f;
            next = n;
            count = 1;
        }
    }//END class WordStoreDT
}//END class WordStoreImp