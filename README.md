# ADSOOF_miniproject

<body style="" lang="EN-GB" link="blue" vlink="blue">
<p style="text-align: center;" align="center"><b><span
 style="font-family: Arial;">ECS510 Algorithms and Data Structures 
   in an Object-Oriented Framework</span></b>
<p style="text-align: center;" align="center"><b><span
 style="font-family: Arial;">Mini Project 2017</span></b>

<h2>Implementing a <code>String</code> collection class</h2>

<p>
In this mini-project I had to build a class which implements
an interface called <code>WordStore</code>. This interface defines a collection
which stores <code>String</code>s. It has methods:
<ul>
<li><code>public void add(String word)</code>
<br>
Adds a <code>String</code> to the collection
</br>
<li><code>public int count(String word)</code>
<br>
Returns the number of times a <code>String</code> is in the collection
</br>
<li><code>public void remove(String word)</code>
<br>
Removes <u>one</u> occurrence of a <code>String</code> from the
collection, or leaves the collection unchanged if the <code>String</code>
does not occur in it.
</br>
</ul>
</p>
<a name="givenfiles">
<p> 
The following Java files were made available to me:
<ul>
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/intro/WordStore.java">WordStore.java</a></code></li>
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/content/5/WordTest0.java">WordTest0.java</a></code></li>
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/content/5/WordTest1.java">WordTest1.java</a></code></li>
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/content/5/WordTest2.java">WordTest2.java</a></code></li>
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/content/5/WordTest3.java">WordTest3.java</a></code></li> 
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/content/5/WordTest4.java">WordTest4.java</a></code></li>
</ul>
Plus the compiled file
<ul>
<li><code><a href = "http://qmplus.qmul.ac.uk/pluginfile.php/372668/mod_page/content/5/WordGen.class">WordGen.class</a></code></li>
</ul>
</p>
</a>
<p>
<h3>Assignment:</h3>
There is a missing file called <code>WordStoreImp.java</code>. Without this 
file, you can compile and run the code in <code>WordTest0.java</code>, which 
uses the code in <code>WordGen.class</code>, but not the other files. You 
need to supply the missing file, with correct code to make the other programs 
work. You will not need to make modifications to any of the other files. You may, however,
produce some further files in order to test your code for all aspects of correctness and
efficiency.  The Java files given pass an <code>int</code> argument to the <code>WordStoreImp</code>
constructor, indicating the initial number of <Code>String</code>s the
<code>WordStore</code> object will hold. You may or may not need to make
use of this parameter when you write your code to implement 
<code>WordStore</code>, if you do not need to make use of it just give your
constructor an <code>int</code> parameter but do not otherwise use it.
</p></br>
Description of files: 
<p>
The code in <code>WordGen.java</code> generates random words.  It is used to test the code with large amounts of data.
The zero-argument static method <code>make</code> in <code>WordGen</code> returns a 
<code>String</code> with a new word. There is no guarantee that a word returned
by a previous call of <code>make</code> will not be 
returned again. The static method <code>initialise</code> which takes an 
integer argument, the &#8220;seed&#8221;, sets up a particular series of words which is 
always given for any particular seed, so the code can be tested several times, 
knowing each time the same words will be generated. There is no test that the 
words generated have any meaning in English, most won't, but the rules which 
generate them ensure they are pronounceable using standard English spelling 
and phonetics convention, with shorter words being generated more often than 
longer words, and the chance of a particular letter being used being roughly 
as it is in English. So some words are more likely to be generated than others.
All words generated consist of lower case alphabetic characters only.
</p>
<p>
The program in <code>WordTest0.java</code> just generates and displays
some words, so we can see the sort of data we are dealing with.
The program in <code>WordTest1.java</code> enables us to generate some
words (which are not displayed, so we can generate more of them than we
could reasonably display on the screen) and then enter our own words to see 
how many times each of them was generated. It requires that objects of type 
<code>WordStore</code> have methods <code>add</code> and <code>count</code>. 
Both take a <code>String</code> as an argument, the first adding it to the 
collection held in the <code>WordStore</code> object, the second returning an 
integer saying how many times the <code>String</code> argument is stored in 
the collection. So the collection class we write as <code>WordStoreImp</code> 
must have the concept of a word being stored in it a particular number of times.
Objects of type <code>WordStore</code> must also have the method
<code>remove</code> which takes a <code>String</code> as an argument
and removes one occurrence of it from the collection, or leaves the
collection unchanged if the <code>String</code> does not occur in it.
</p>
<p>
The programs in <code>WordTest2.java</code>, <code>WordTest3.java</code>
and <code>WordTest4.java</code> are designed to test the efficiency of
the operations <code>count</code>, <code>add</code> and <code>remove</code>
respectively.  The code in these programs generates a collection of words, 
then generates a second set of words stored in an array and applies the 
operation on the collection with each word from the second set. It measures 
and displays the time taken to apply the operation repeatedly.  
</p>

<h3>Marks</h3>
<p>
Marks for this coursework will be divided equally between marks for the code and marks
for the presentation.  
</p>
<p>
Marks for the code in this coursework will be given for both correctness and
<u>efficiency</u> of the implementation of <code>WordStore</code>. 
To get very efficient storage, you will need to research techniques
such as <b>hash tables</b> and <b>ordered trees</b>, which are not covered directly
in the notes for this module. For full marks you will need to demonstrate
some research into suitable data structures, and implementation of them.
Books or websites you have used that have contributed to your solution should be
fully referenced in the submission.
</p>
<p>
As this coursework is meant to test your ability to build your own
data structures, your code should <u>not</u> make use of any code
provided in the Java library apart from methods provided as part of the
class <code>String</code>. So you may use arrays, but not the class
<code>ArrayList</code> or <code>Map</code> or <u>any</u> other class which
is listed under Java's API documentation. You may not make use of any
code provided by any third party supplier either (that is classes written
in Java by someone else, intended to support Java programming but
not an official part of Oracle's Java distribution, for example the
<code>LispList&lt;E&gt;</code> class given in ADSOOF).  
</p>
<p>
If you decide not to research into more efficient techniques but instead use only the
techniques covered directly in the module, you can still get good marks by concentrating
on doing good presentation.  For guidance, and inefficient but correct implementation 
with a perfect presentation could get a mark of around 80% overall.
<p>
Marks for the presentation will be based on the clarity of 
your explanation, and the presentation of your code and experimental results.
That includes such things as appropriate choice of test data, and layout of the code.
</p>
<p>
Although as an aspect of researching possible implementations and testing your code, you
may produce implementations using different algorithms and data structures, your 
submission must focus on <u>one</u> particular implementation, which you believe to be
the best.  So, if you were to submit a document in which you went over several
different algorithms and data structures in detail, with full timing data presented for
each, it would not gain you extra marks.  A brief mention of others you have considered
would be enough.  I say this because it is important to put an upper limit on what is
required, and no-one should feel under pressure to go beyond that.
</p>

</body>
</html>
