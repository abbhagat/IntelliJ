package com.junit.app.testSet1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class NewsLetterSenderTest {

    @Test
    public void constructorAssignsDatabase(){

        MessagingEngine messagingEngine = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsLetterSender newsletterSender = new NewsLetterSender(subscribersDatabase, messagingEngine);

        assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers(){

        SubscribersDatabase subscribersDatabaseMock = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngineMock = mock(MessagingEngine.class);

        NewsLetterSender sender = new NewsLetterSender(subscribersDatabaseMock, messagingEngineMock);

        List<String> subscribersList = Arrays.asList("email1", "email2", "email3");
        when(subscribersDatabaseMock.getSubscribers()).thenReturn(subscribersList);

        assertEquals(3, sender.numberOfSubscribers());
    }

    @Test(expected = ZeroSubscribersException.class)
    public void zeroSubscribersThrown(){
        NewsLetterSender newsletterSender = new NewsLetterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsLetterSender newsLetterSenderSpy = spy(newsletterSender);
        when(newsLetterSenderSpy.numberOfSubscribers()).thenReturn(0);
        newsLetterSenderSpy.sendNewsletter("SUBJECT");
    }
}
