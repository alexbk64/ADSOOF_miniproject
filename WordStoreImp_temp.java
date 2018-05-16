/**
 *
 * @author alexandrebornerand
 */
/*
 *import java.util.*;
 *for display(), a test method to ensure words are being added.
 */

import java.util.*;
public class WordStoreImp implements WordStore{
    private WordStoreDT[] wordsStored;
    private int count;
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
    }
    
    
    
    /*** ADD METHOD ***/
    
    @Override
    public void add(String word) {
        int index = hash(word);
        WordStoreDT<String> ws = wordsStored[index];
        if (ws==null) 
            wordsStored[index] = new WordStoreDT<String>(word,null);
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
            //System.out.println("oops");
            return 0;
        }
        else {       
            WordStoreDT<String> ptr = ws;
            for (; ptr!=null; ptr = ptr.next) {
                if (word.equals(ptr.first))
                {
                    //System.out.println(ptr.count);
                    return ptr.count;
                }
            }
        }
        return 0;//in order to be abe to recognise an error
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
                        if (ptr.next != null)
                            wordsStored[index] = wordsStored[index].next;
                        return;
                    }
                }
            }
            if (ptr.next!=null)
                ptr.next = ptr.next.next;
        }
    }//END remove
    
    /**** HASH FUNCTION ****/
    
    private int hash(String word) {
        int hashKey =0;
        for (int i=0; i<word.length(); i++) {
            hashKey=43*hashKey+word.charAt(i);
        }
        return Math.abs(hashKey)%wordsStored.length;
    }//END hash
    
    
    /*** ISREPEATED METHOD *****/
    
    private boolean isRepeated(WordStoreDT ws, String word) {
        //checks if a word has already been stored in the collection, and increments a counter for it if so.
        WordStoreDT<String> ptr = ws;
        while (ptr.next!=null) {
            if (ptr.first.equals(word)) {
                ptr.count++;
                return true;
            }
            ptr=ptr.next;
        }
        return false;
    }//ENDs isRepeated
    
    /*** TRIAL METHOD: displays the words in array ***/
    //In order for this method to work, it must be added in WordStore.java
    @Override
    public void display(){
        for(int i=0;i<wordsStored.length; i++) {
            if (wordsStored[i]==null)
                continue;
            WordStoreDT<String> ptr = wordsStored[i];
            while(ptr!=null) {
                System.out.println(ptr.first);
                ptr=ptr.next;
            }
            System.out.println();
        }
     }//END display
    
    
    /************* WORDSTOREDT CLASS ****************/
    
    private static class WordStoreDT <String> {
        //static because same in all instances of WordStoreDT
        String first;
        WordStoreDT<String> next;
        int count;
        
        WordStoreDT(String f, WordStoreDT<String> n) {
            first = f;
            next = n;
            count = 1;
        }
    }//END class WordStore
}//END class WordStoreImp
