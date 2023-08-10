CREATE DATABASE MyDb;

CREATE TABLE User{
    userID          BIGINT AUTO_INCREMENT PRIMARY KEY,
    userLogin       VARCHAR(255) UNIQUE NOT NULL,
    userPassword    VARCHAR(255) NOT NULL,
};

CREATE TABLE Chatroom{
    roomId          BIGINT AUTO_INCREMENT PRIMARY KEY,
    roomName    VARCHAR(255) UNIQUE NOT NULL,
    ownerId     BIGINT,
    FOREIGN key (ownerId) REFERENCES User(userID),
};


CREATE TABLE userChatRoom{
    user_id BIGINT,
    chatroom_id BIGINT,
    PRIMARY KEY (user_id, chatroom_id),
    FOREIGN KEY (user_id) REFERENCES User(userID),
    FOREIGN  KEY (chatroom_id) REFERENCES Chatroom(roomId),
};

CREATE TABLE Message{
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    roomId      Int,
    authorId    Int,
    MsgText     TEXT NOT NULL,
    sendAt      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN key (authorId) REFERENCES User(userID),
    FOREIGN key (roomId) REFERENCES Chatroom(roomId),
};
