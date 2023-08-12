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

CREATE TABLE Message{
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    roomId      Int,
    authorId    Int,
    MsgText     TEXT NOT NULL,
    sendAt      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN key (authorId) REFERENCES User(userID),
    FOREIGN key (roomId) REFERENCES Chatroom(roomId),
};