-- Inserting data into User table
INSERT INTO User (userLogin, userPassword) VALUES ('user1', 'password123');
INSERT INTO User (userLogin, userPassword) VALUES ('user2', 'securepass');
INSERT INTO User (userLogin, userPassword) VALUES ('user3', 'pass456');
INSERT INTO User (userLogin, userPassword) VALUES ('user4', 'test123');
INSERT INTO User (userLogin, userPassword) VALUES ('user5', 'adminpass');

-- Inserting data into Chatroom table
INSERT INTO Chatroom (roomName, ownerId) VALUES ('General Chat', 1);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Tech Discussion', 2);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Random Room', 3);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Private Chat', 4);
INSERT INTO Chatroom (roomName, ownerId) VALUES ('Announcements', 1);

-- Inserting data into Message table
INSERT INTO Message (roomId, authorId, MsgText) VALUES (1, 1, 'Hello, everyone!');
INSERT INTO Message (roomId, authorId, MsgText) VALUES (2, 2, 'Has anyone seen the latest movie?');
INSERT INTO Message (roomId, authorId, MsgText) VALUES (3, 3, 'I am excited about the upcoming event!');
INSERT INTO Message (roomId, authorId, MsgText) VALUES (4, 4, 'Just wanted to share some great news!');
INSERT INTO Message (roomId, authorId, MsgText) VALUES (5, 5, 'How is everyone doing today?');