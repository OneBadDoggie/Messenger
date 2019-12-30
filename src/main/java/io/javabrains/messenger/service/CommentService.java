package io.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.javabrains.messenger.database.MyDatabase;
import io.javabrains.messenger.models.Comment;
import io.javabrains.messenger.models.Message;

public class CommentService {
	private Map<Long, Message> messages = MyDatabase.getMessages();
	
	public List<Comment> getAllComments(long msgId){
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long msgId, long commentId) {
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long msgId, Comment comment) {
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		comment.setId(comments.size() + 1);
		comment.setCreated(new Date());
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long msgId, Comment comment) {
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long msgId, long commentId) {
		Map<Long, Comment> comments = messages.get(msgId).getComments();
		return comments.remove(commentId);
	}
}
