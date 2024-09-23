package com.junit.app.testSet1;

import lombok.Getter;

import java.util.List;

@Getter
public class NewsLetterSender {

    private final SubscribersDatabase subscribersDatabase;
    private final MessagingEngine messagingEngine;

    public NewsLetterSender(SubscribersDatabase subscribersDatabase, MessagingEngine messagingEngine) {
        this.subscribersDatabase = subscribersDatabase;
        this.messagingEngine = messagingEngine;
    }

    public void sendNewsletter(String subject) {
        List<String> emails = subscribersDatabase.getSubscribers();
        if (numberOfSubscribers() == 0) {
            throw new ZeroSubscribersException();
        }
        messagingEngine.sendEmail(subject, emails);
    }

    public int numberOfSubscribers() {
        return subscribersDatabase.getSubscribers().size();
    }

}
