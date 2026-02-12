package linkedlist;

/*
Problem Statement:
Create a system to manage social media friend connections using a singly linked list.
Each node represents a user with User ID, Name, Age, and List of Friend IDs.

Operations:
- Add a friend connection between two users.
- Remove a friend connection.
- Find mutual friends between two users.
- Display all friends of a specific user.
- Search for a user by Name or User ID.
- Count the number of friends for each user.
*/

class SocialMediaSystem {

    // Friend node representing friend ID list
    static class FriendNode {
        int friendId;
        FriendNode next;

        FriendNode(int friendId) {
            this.friendId = friendId;
        }
    }

    // User node representing each user
    static class User {
        int userId;
        String name;
        int age;
        FriendNode friendHead;
        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
        }
    }

    private User head;

    // Add new user
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Search user by ID
    public User searchById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    public User searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection between two users
    public void addFriendConnection(int id1, int id2) {
        User user1 = searchById(id1);
        User user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        addFriend(user1, id2);
        addFriend(user2, id1);
        System.out.println("Friend connection added.");
    }

    // Helper to add friend ID to user's friend list
    private void addFriend(User user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;
    }

    // Remove friend connection
    public void removeFriendConnection(int id1, int id2) {
        User user1 = searchById(id1);
        User user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        removeFriend(user1, id2);
        removeFriend(user2, id1);
        System.out.println("Friend connection removed.");
    }

    // Helper to remove friend ID
    private void removeFriend(User user, int friendId) {
        FriendNode temp = user.friendHead;
        FriendNode prev = null;

        while (temp != null) {
            if (temp.friendId == friendId) {
                if (prev == null)
                    user.friendHead = temp.next;
                else
                    prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = searchById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friendHead;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends
    public void findMutualFriends(int id1, int id2) {
        User user1 = searchById(id1);
        User user2 = searchById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Mutual Friends: ");
        FriendNode temp1 = user1.friendHead;

        while (temp1 != null) {
            FriendNode temp2 = user2.friendHead;
            while (temp2 != null) {
                if (temp1.friendId == temp2.friendId) {
                    System.out.print(temp1.friendId + " ");
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        System.out.println();
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode friendTemp = temp.friendHead;
            while (friendTemp != null) {
                count++;
                friendTemp = friendTemp.next;
            }
            System.out.println("User " + temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }

    // Main method for testing
    public static void main(String[] args) {

        SocialMediaSystem system = new SocialMediaSystem();

        system.addUser(1, "Alice", 22);
        system.addUser(2, "Bob", 24);
        system.addUser(3, "Charlie", 23);
        system.addUser(4, "David", 25);

        system.addFriendConnection(1, 2);
        system.addFriendConnection(1, 3);
        system.addFriendConnection(2, 3);

        system.displayFriends(1);
        system.displayFriends(2);

        system.findMutualFriends(1, 2);

        system.countFriends();

        system.removeFriendConnection(1, 2);
        system.displayFriends(1);
    }
}

