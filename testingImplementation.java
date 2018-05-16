class testingImplementation
{
  private static class WordPair
  {
   String word1;
   String word2;

   WordPair(String w1, String w2)
   {
    word1=w1;
    word2=w2;
   }
  }

  private WordPair[] wordpairs;
  private int count;
  private static final int INITMAX=10;

  public Dictionary()
  {
   count=0;
   wordpairs = new WordPair[INITMAX];
  }

  private void expand()
  {
   WordPair[] wordpairs1 = new WordPair[wordpairs.length*2];
   for(int i=0;i<wordpairs.length;i++)
       wordpairs1[i]=wordpairs[i];
   wordpairs=wordpairs1;
  }

  private int position(String word)
  {
   for(int i=0; i<count; i++)
      if(wordpairs[i].word1.equals(word))
         return i;
   return -1;
  }

  void add(String word1, String word2)
  {
   int pos=position(word1);
   if(pos>=0)
      {
       wordpairs[pos].word2=word2;
       return;
      }
   if(count==wordpairs.length)
      expand();
   wordpairs[count] = new WordPair(word1,word2);
   count++;
  }
  
  boolean contains(String word)
  {
   return position(word)>=0;
  }

  String equiv(String word) throws NotFoundException
  {
   int pos=position(word);
   if(pos>=0)
      return wordpairs[pos].word2;
   else
      throw new NotFoundException(word);
  }

  void remove(String word) throws NotFoundException
  {
   int pos=position(word);
   if(pos>=0)
      {
       count--;
       wordpairs[pos]=wordpairs[count];
      }
   else
      throw new NotFoundException(word);
  }

  boolean same(String word1, String word2) throws NotFoundException
  {
   int pos=position(word1);
   if(pos>=0)
      return wordpairs[pos].word2.equals(word2);
   else 
      throw new NotFoundException(word1);
  }

  int size()
  {
   return count;
  }

}