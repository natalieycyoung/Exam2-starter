// EXAM INSTRUCTIONS:
// Add new method headers and implementations as appropriate to these classes
// Add examples to the ArrayExamples class.

interface Tweet {
}
class User {
  String username, displayName;
  User(String username, String displayName) {
    this.username = username;
    this.displayName = displayName;
  }
}
class TextTweet implements Tweet {
  User author;
  String contents;
  int likes;
  TextTweet(User author, String contents, int likes) {
    this.author = author;
    this.contents = contents;
    this.likes = likes;
  }
}
class ReplyTweet implements Tweet {
  User author;
  String contents;
  int likes;
  Tweet replyTo;
  ReplyTweet(User author, String contents, int likes, Tweet replyTo) {
    this.author = author;
    this.contents = contents;
    this.likes = likes;
    this.replyTo = replyTo;
  }
}

class ExamplesTweets {

}
    