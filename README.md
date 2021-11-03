### Release: 5pm Wednesday November 3, 2021
### Due: 9am Friday November 5, 2021

**Note that this is released after class Wednesday, and is due before class, not
due in the evening.**

This page details a take-home exam that you will complete over the next few
days. You can’t communicate with anyone about the content of the assignment
until you receive your grade. You can message us privately on Piazza, but the
course staff will not give programming advice or answer most questions about the
problems. If you have technical trouble creating a screencast (detailed below)
feel free to reach out for assistance.

Do not use any online service other than Piazza to ask questions about the
assignment. Do not search for, solicit, or use solutions to the problems that
you find elsewhere for the exam. These are all violations of academic integrity
that students have committed on exams like this in the past.

You can make use of any course notes, online resources about Java and its
libraries, Java tools, and so on to complete the exam, including re-using code
from class notes.

You can review the grading policy for exams in the [syllabus](/syllabus.html).
You will complete the programming task below and submit your work to the `Exam2` Gradescope assignment.

Submission checklist (see long descriptions below for full details):

- `Tweets.java`
- `ExamplesArrays.java`
- `Region.java`
- `WordFilter.java`
- `video.*` (`*` means whatever extension you have; we *really* prefer `mp4`, which is what Zoom produces. If you use an extension other than mp4, check that it plays in Gradescope!)


## Task 1 – Arrays

In the `ExamplesArrays` class, you will use the design recipe to write several methods.

- `averageWithoutLowest` – takes an array of doubles and returns the average
(mean) of them, _leaving out_ the lowest number. So, for example, the average of
`1`, `2`, and `3` according to this scheme is `2.5`. If there are no elements to
average, the method should return `0`. If there is a tie for the lowest, leave out only a
single one of the tied lowest numbers.
- `sumOfPairs` – write a class called `Pair` with the usual field-initializing
constructor and two `int` fields called `a` and `b` outside the `ExamplesArrays`
class. `sumOfPairs` should take an array of `Pair` and return an array of `int`,
where each element of the returned array is the sum of the `a` and `b` fields of
the corresponding `Pair`.
- `regionsWithPoint` – takes an array of `Region` and a `Point` (provided in
`Region.java`, you do not need to copy or move that code) and returns a new
array of those `Region`s in the input that contain the given `Point`.

There are no specific test requirements for these methods other than the one
listed in the video below; we will test them to ensure they are correct and you
should test them thoroughly enough to be confident in their correctness.

Here are some tests to get you started that you can use as you like (and to help make sure we agree on how these methods work).

```
	void testAverageWithoutLowest(Tester t) {
		double[] unique = {1.0,2.0,3.0};
		t.checkExpect(averageWithoutLowest(unique), 2.5);
	};
	void testRegionsWithPoint(Tester t) {
		Region[] regions = {new CircleRegion(new Point(0, 0), 5), new CircleRegion(new Point(0, 0), 10)};
		Region[] result = {new CircleRegion(new Point(0, 0), 10)};
		t.checkExpect(regionsWithPoint(regions, new Point(9, 0)), result);
	};
	void testSumOfPairs(Tester t) {
		Pair[] pairs = {new Pair(1, 2), new Pair(3, 4)};
		int[] result = {3, 7};
		t.checkExpect(sumOfPairs(pairs), result);
	};
```

## Task 2 – Interfaces

We've provided code for `Tweet`, `ReplyTweet`, and `TextTweet` and several
related classes that we've used for PAs in `Tweets.java`.

Your task is to add two methods to the interface and all implementing classes:

- `lengthOfLongestTweetInThread`, which takes no arguments and returns the
_length_ (number of characters) of the `Tweet` in the thread with the longest
`content` among Tweets in that thread.
- `timesAuthorPostedInThread`, which takes a `User` argument and returns
the number of tweets that user made in the thread.

There are no specific test requirements for these methods other than the one
listed in the video below; we will test them to ensure they are correct and you
should test them thoroughly enough to be confident in their correctness.

Here are a few tests to get you started (and make sure we all agree how this
should work):

```
class ExamplesTweets {
  User joe = new User("joepolitz", "Joe Gibbs Politz");
  User greg = new User("gregory_miranda", "Greg Miranda");
  Tweet t1 = new TextTweet(this.joe, "Java 17 has a cool feature called records", 77);
  Tweet t2 = new ReplyTweet(this.greg, "Hmm I wonder if we could use it for CSE11", 12, this.t1);

  void testLongestTweetInThread(Tester t) {
    t.checkExpect(this.t2.lengthOfLongestTweetInThread(), 41);
  }

  void testAuthorPostedInThread(Tester t) {
    t.checkExpect(this.t1.timesAuthorPostedInThread(joe), 1);
    t.checkExpect(this.t1.timesAuthorPostedInThread(greg), 0);
  }
}
```

## Task 3 – Main and Command-Line Arguments

Your task is to write a program `WordFilter.java` that has a WordFilter method
with the following behavior:

```
$ javac WordFilter.java
$ java WordFilter an apple banana panama orangutan pizza
banana
panama
orangutan
$ java WordFilter not-a-substring apple banana panama
0 words contained "not-a-substring"
$ java WordFilter app apple banana app panama orangutan pizza
apple
app
$ java WordFilter
Provide at least one command-line argument
$ java WordFilter something
0 words contained "something"
```

That is, it treats the _first_ command-line argument specially – it searches for
that word in the other words after it the command-line, and prints those words
out, one on each line. If there are no words found, it prints the message `0
words contained "str"` where `str` is the search term. If no command-line
arguments are provided, it prints `Provide at least one command-line argument`

There are no requirements on writing specific tests for this program, but
include a `WordFilter-transcript.txt` to help us understand what you did (we
won't grade it, but it helps us know what happened if something goes wrong).

## Video Task

You will record a short video of no more than 6 minutes. Include:

- Show only your face and a picture ID (your student ID is preferred but any
picture ID with your name on it will work) for a few seconds at the beginning.
You don’t have to be on camera the whole time, though it’s fine if you are. Just
a brief confirmation that it’s you creating the video/doing the work attached to
the work itself is what we want. If you do not have a webcam, take a picture of
yourself (and your picture ID) with your phone and display that picture at the
start of your screen share.
- `averageWithoutLowest`
  - Choose an example of calling `averageWithoutLowest` with an array of at length
  4 where the lowest element is not the first or last element in the array.
  - Write down a table corresponding to **one** loop you wrote in the body of
  the method that shows, for each variable, what its value is at the start and
  end of each loop iteration. Write your table in a comment next to the loop, as
  shown in the example below.
  - Pre-write the header row of the table, but you **must** fill in the
  contents of the table on the video. As you fill in the “end” value for each
  variable, indicate which statement(s) in the program caused its value to
  change.
  - If a `return` statement happens in the loop, note that in the row as well.

  ```
  int z = 0;
  for(int i = 1; i < 6; i += 2) {
    z += i;
  }
  /*
  i start   i end   z start   z end
  1      	  3       0         1
  3         5       1         4		
  5         7       4         9
  */
  ```


- Choose a test for `lengthOfLongestTweetInThread` where the thread has at least 2
`ReplyTweet`s and 1 `TextTweet`, where the object is stored in a field of
`ExamplesTweets`. Run the program and show the output for that object, and the
objects it references, at the terminal. Then, next to the example, describe the
stack in a comment, where in each line you indicate:
  - The *class* of the method called
  - The *name* of the method called
  - The *reference* of the `this` parameter (use the reference numbers shown in the output of `./run`)
  - The *return value* of that method call

  Put the call that happens first on the last line of your stack trace (so it's
  at the bottom, as we've drawn in problem sessions and in the notes and
  videos). Only include calls to the `lengthOfLongestTweetInThread` method.

  As an example, consider this program, output, and test:

  ```
  interface I { boolean m(); }
  class C { public boolean m() { return false; } }
  class D {
    I i;
    D(I i) { this.i = i; }
    public boolean m() { return !this.i.m(); }
  }
  class Examples {
    C c = new C();
    C c2 = new C();
    D d1 = new D(this.c);
    D d2 = new D(this.c2);
    D d3 = new D(this.d1);
    boolean ans1 = this.d2.m();
    boolean ans2 = this.d3.m();
    /*

    class	method	reference   return value
    C		  m	  :2        false
    D		  m       :4        true
    D		  m	  :6        false
    */
  }
  $ ./run Examples
  Tester Library v.3.0
  -----------------------------------
  Tests defined in the class: Examples:
  ---------------------------
  Examples:
  ---------------
  new Examples:1(
   this.c = new C:2()
   this.c2 = new C:3()
   this.d1 = new D:4(
    this.i = C:2)
   this.d2 = new D:5(
    this.i = C:3)
   this.d3 = new D:6(
    this.i = D:4)
   this.ans1 = true
   this.ans2 = false)
  ---------------
  No test methods found.
  ```

## Study

We are conducting a study related to remote exams. The details are embedded below; if you choose not to opt out your exam submission may be used as part of a research project.

<iframe src="https://drive.google.com/file/d/1U6naucU4rT5tmes2saYRsmghToH7VgGD/preview" width="640" height="480" allow="autoplay"></iframe>


