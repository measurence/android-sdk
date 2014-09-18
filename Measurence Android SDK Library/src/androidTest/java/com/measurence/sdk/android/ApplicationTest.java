package com.measurence.sdk.android;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testJsonDeserialization() {

        String base64HashedDeviceId = "S92SjFwolIn5YJJlQ5U44QTaO5NOrNQvCudxg7i/p8s=";
        PresenceSessionInterval presenceSessionInterval = new PresenceSessionInterval(new Date(), new Date());
        boolean isNewVisitorInStore = true;
        String status = "end";
        String storeKey = "example_store";
        final UserIdentity userIdentity = new UserIdentity("example_identity");
        List<UserIdentity> userIdentities = new ArrayList<UserIdentity>() {{
            add(userIdentity);
        }};

        String sessionUpdateJsonSerialization = "{\n" +
                "    \"base64HashedDeviceId\": \"" + base64HashedDeviceId + "\",\n" +
                "    \"interval\": {\n" +
                "        \"end\": " + presenceSessionInterval.getEnd().getTime() + ",\n" +
                "        \"start\": " + presenceSessionInterval.getStart().getTime() + "\n" +
                "    },\n" +
                "    \"isNewVisitorInStore\": " + isNewVisitorInStore + ",\n" +
                "    \"status\": \"" + status + "\",\n" +
                "    \"storeKey\": \"" + storeKey + "\",\n" +
                "    \"userIdentities\": [\n" +
                "        {\n" +
                "            \"id\": \"" + userIdentity.getId() + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        PresenceSessionUpdate presenceSessionUpdate = PresenceSessionUpdate.fromJson(sessionUpdateJsonSerialization);
        PresenceSessionUpdate expectedPresenceSessionUpdate = new PresenceSessionUpdate(
                base64HashedDeviceId,
                presenceSessionInterval,
                isNewVisitorInStore,
                status,
                storeKey,
                userIdentities
                );
        assertEquals(expectedPresenceSessionUpdate, presenceSessionUpdate);
    }
}