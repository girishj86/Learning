package com.learning.design.patterns.behavioral;

import java.util.HashMap;
import java.util.Map;

public class MediatorPatternDemo {
	public static void main(String[] args) {
		IChatRoom chatroom = new ChatRoom();

		User user1 = new User(chatroom, "1", "Alex");
		User user2 = new User(chatroom, "2", "Brian");
		User user3 = new User(chatroom, "3", "Charles");
		User user4 = new User(chatroom, "4", "David");

		chatroom.addUser(user1);
		chatroom.addUser(user2);
		chatroom.addUser(user3);
		chatroom.addUser(user4);

		user1.send("Hello brian", "2");
		user2.send("Hey buddy", "1");
		
		//Java examples
		//java.util.concurrent.Executor.execute() method
		// DispatcherServlet in SpringMVC
	}

}

interface IChatRoom {
	public void sendMessage(String msg, String userId);

	void addUser(User user);
}

class ChatRoom implements IChatRoom {

	private Map<String, User> usersMap = new HashMap<>();

	@Override
	public void sendMessage(String msg, String userId) {
		User u = usersMap.get(userId);
		u.receive(msg);
	}

	@Override
	public void addUser(User user) {
		this.usersMap.put(user.getId(), user);
	}
}

class User {
	private IChatRoom mediator;

	private String id;
	private String name;

	public User(IChatRoom room, String id, String name) {
		this.mediator = room;
		this.name = name;
		this.id = id;
	}

	public void send(String msg, String userId) {
		System.out.println(this.getName() + " :: Sending Message : " + msg);
		getMediator().sendMessage(msg, userId);

	}

	public void receive(String msg) {
		System.out.println(this.getName() + " :: Received Message : " + msg);
	}

	public IChatRoom getMediator() {
		return mediator;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}