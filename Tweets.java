// EXAM INSTRUCTIONS:
// All of your code for Task 2 goes in this file.
// Add new method headers and implementations as appropriate to these classes
// Add examples to the ExamplesTweets class.

import tester.*;

interface Tweet
{
	public int lengthOfLongestTweetInThread();
	public int timesAuthorPostedInThread(User author);
}

class User
{
	String username, displayName;

	User(String username, String displayName)
	{
		this.username = username;
		this.displayName = displayName;
	}
}

class TextTweet implements Tweet
{
	User author;
	String contents;
	int likes;

	TextTweet(User author, String contents, int likes)
	{
		this.author = author;
		this.contents = contents;
		this.likes = likes;
	}

	public int lengthOfLongestTweetInThread()
	{
		return contents.length();	// original tweet so no others to compare
	}

	public int timesAuthorPostedInThread(User author)
	{
		int timesPosted = 0;
		
		if (this.author == author)
		{
			return timesPosted += 1;
		}

		return timesPosted;
	}
}

class ReplyTweet implements Tweet
{
	User author;
	String contents;
	int likes;
	Tweet replyTo;

	ReplyTweet(User author, String contents, int likes, Tweet replyTo)
	{
		this.author = author;
		this.contents = contents;
		this.likes = likes;
		this.replyTo = replyTo;
	}

	public int lengthOfLongestTweetInThread()
	{
		// check length of this tweet against all others that came before via recursion
		if (contents.length() < replyTo.lengthOfLongestTweetInThread())
		{
			return replyTo.lengthOfLongestTweetInThread();
		}
		else // this.contents.length() >= replyTo.lengthOfLongestTweetInThread()
		{
			return contents.length();
		}
	}

	public int timesAuthorPostedInThread(User author)
	{
		int timesPosted = 0;
		
		if (this.author == author)
		{
			return timesPosted += 1;	// author posted at least once
		}
		else
			return timesPosted;
	}
}

class ExamplesTweets
{
	User joe = new User("joepolitz", "Joe Gibbs Politz");
	User greg = new User("gregory_miranda", "Greg Miranda");
	Tweet t1 = new TextTweet(this.joe, "Java 17 has a cool feature called records", 77);
	Tweet t2 = new ReplyTweet(this.greg, "Hmm I wonder if we could use it for CSE11", 12, this.t1);
	
	void testLongestTweetInThread(Tester t)
	{
		t.checkExpect(this.t2.lengthOfLongestTweetInThread(), 41);
	}

	void testAuthorPostedInThread(Tester t)
	{
		t.checkExpect(this.t1.timesAuthorPostedInThread(joe), 1);
		t.checkExpect(this.t1.timesAuthorPostedInThread(greg), 0);
	}
}
    
