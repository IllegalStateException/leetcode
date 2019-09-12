package combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Twitter {
	
	private List<Tweet> tweetList;
	private Map<Integer,Set<Integer>> followMap;
	
	
	/** Initialize your data structure here. */
    public Twitter() {
    	tweetList = new ArrayList<>();
    	followMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new Tweet(tweetId,userId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followSet = followMap.get(userId);
        if(followSet == null)
        	followSet = new HashSet<>();
        
        ListIterator<Tweet> it = tweetList.listIterator(tweetList.size());
        while(it.hasPrevious()){
        	Tweet tweet = it.previous();
        	if((followSet.contains(tweet.userId) || tweet.userId == userId)){
        		if(result.size() < 10){
        			result.add(tweet.tweetId);
        		}
        		else
        			break;
        	}
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.get(followerId);
        
        if(followSet == null){
        	followSet = new HashSet<>();
        	followSet.add(followeeId);
        	followMap.put(followerId, followSet);
        }
        else{
        	followSet.add(followeeId);
        }  
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	Set<Integer> followSet = followMap.get(followerId);
    	
    	if(followSet != null && followSet.contains(followeeId))
    		followSet.remove(followeeId);
    }
    
    static class Tweet{
    	int tweetId;
    	int userId;
    	
		public Tweet(int tweetId, int userId) {
			super();
			this.tweetId = tweetId;
			this.userId = userId;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		System.out.println(twitter.getNewsFeed(1).toString());

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1).toString());

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(twitter.getNewsFeed(1).toString());
	}

}
