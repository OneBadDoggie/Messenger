package io.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.javabrains.messenger.models.Comment;
import io.javabrains.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long msgId) {
		return commentService.getAllComments(msgId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long msgId, Comment comment) {
		return commentService.addComment(msgId, comment);
	}	
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long msgId, @PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return commentService.updateComment(msgId, comment);
	}	
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long msgId, @PathParam("commentId") long commentId) {
		commentService.removeComment(msgId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long msgId, @PathParam("commentId") long commentId) {
		return commentService.getComment(msgId, commentId);
	}
}
