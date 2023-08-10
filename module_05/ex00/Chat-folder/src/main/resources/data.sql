-- Inserting data into User table
INSERT INTO User (userLogin, userPassword) VALUES ('john_doe', 'password123');
INSERT INTO User (userLogin, userPassword) VALUES ('jane_smith', 'securepass');
INSERT INTO User (userLogin, userPassword) VALUES ('user123', 'pass456');
INSERT INTO User (userLogin, userPassword) VALUES ('test_user', 'test123');
INSERT INTO User (userLogin, userPassword) VALUES ('admin', 'adminpass');

-- Inserting data into Chatroom table
INSERT INTO Chatroom (roomName, ownerId) VALUES ('General Chat', 1);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Tech Discussion', 2);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Random Room', 3);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Private Chat', 4);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Announcements', 1);

-- Inserting data into userChatRoom table
INSERT INTO userChatRoom (user_id, chatroom_id) VALUES (1, 1);
INSERT INTO userChatRoom (user_id, chatroom_id) VALUES (2, 1);
INSERT INTO userChatRoom (user_id, chatroom_id) VALUES (3, 2);
INSERT INTO userChatRoom (user_id, chatroom_id) VALUES (4, 3);
INSERT INTO userChatRoom (user_id, chatroom_id) VALUES (5, 4);

-- Inserting data into Message table
INSERT INTO Message (roomId, ownerId, MsgText) VALUES (1, 1, 'Hello, everyone!');
INSERT INTO Message (roomId, ownerId, MsgText) VALUES (2, 2, 'Any ideas for the new project?');
INSERT INTO Message (roomId, ownerId, MsgText) VALUES (3, 3, 'Just dropping by to say hi.');
INSERT INTO Message (roomId, ownerId, MsgText) VALUES (4, 4, 'Let''s discuss the upcoming event.');
INSERT INTO Message (roomId, ownerId, MsgText) VALUES (5, 1, 'Important announcement: Server maintenance tomorrow.');
