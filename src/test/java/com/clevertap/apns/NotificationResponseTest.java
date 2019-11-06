package com.clevertap.apns;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static com.clevertap.apns.NotificationErrorReason.BadDeviceToken;
import static com.clevertap.apns.NotificationErrorReason.Unknown;
import static com.clevertap.apns.NotificationRequestError.BadRequest;
import static org.junit.Assert.*;

public class NotificationResponseTest {

    @Test
    public void itShouldParseReasonsForFailure() {
        NotificationResponse response = new NotificationResponse(BadRequest, 400, "{\"reason\":\"BadDeviceToken\"}", null);
        assertThat(response.getReason(), CoreMatchers.is(BadDeviceToken));
    }

    @Test
    public void itShouldNotTripOverUnknownReasons() {
        NotificationResponse response = new NotificationResponse(BadRequest, 400, "{\"reason\":\"GarbageInGarbageOut\"}", null);
        assertThat(response.getReason(), CoreMatchers.is(Unknown));
    }
}