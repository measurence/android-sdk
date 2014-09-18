package com.measurence.sdk.android.api_subscriptions;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * The MIT License (MIT)

 Copyright (c) 2014 Measurence Inc.

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.

 */

public class MeasurenceAPISubscriptions {

    public static final String API_SUBSCRIPTION_HOST = "api.us-east-1.measurence.com";
    public static final String API_SUBSCRIPTION_PORT = "80";
    public static final String ANDROID_API_SUBSCRIPTION_PATH = "/api/android/apply_subscription";
    public static final String HTTP_POST_API_SUBSCRIPTION_PATH = "/api/http_post/apply_subscription/";

    public enum SubscriptionResult {
        SUBSCRIBED,
        ALREADY_SUBSCRIBED
    }

    private class UnknownSubscriptionResultException extends Exception {
        private String subscriptionResultMessage;

        UnknownSubscriptionResultException(String subscriptionResultMessage) {
            this.subscriptionResultMessage = subscriptionResultMessage;
        }

        public String getSubscriptionResultMessage() {
            return subscriptionResultMessage;
        }
    }

    private String getMeasurenceApiBaseURL() {
        return "http://" + API_SUBSCRIPTION_HOST + ":" + API_SUBSCRIPTION_PORT;
    }

    private URI createSubscriptionURI(HttpPostSubscription httpPostSubscription) {
        return URI.create(getMeasurenceApiBaseURL() + HTTP_POST_API_SUBSCRIPTION_PATH + "/" +
                httpPostSubscription.getPartnerId() + "/" +
                httpPostSubscription.getUserIdentity() + "/" +
                httpPostSubscription.getDeviceMacAddress());
    }

    private URI createSubscriptionURI(AndroidPushSubscription androidPushSubscription) {
        return URI.create(getMeasurenceApiBaseURL() + ANDROID_API_SUBSCRIPTION_PATH + "/" +
                androidPushSubscription.getPartnerId() + "/" +
                androidPushSubscription.getUserIdentity() + "/" +
                androidPushSubscription.getGCMRegistrationId() + "/" +
                androidPushSubscription.getDeviceMacAddress());
    }

    private String invokeApiSubscriptionEndPoint(URI apiSubscriptionURI) throws IOException {
        InputStream apiSubscriptionRequestStream = null;
        try {
            apiSubscriptionRequestStream = apiSubscriptionURI.toURL().openStream();
            return IOUtils.toString(apiSubscriptionRequestStream);
        } finally {
            IOUtils.closeQuietly(apiSubscriptionRequestStream);
        }
    }

    private SubscriptionResult parseSubscriptionResult(String subscriptionResult) throws UnknownSubscriptionResultException {

        if (subscriptionResult.indexOf("already subscribed") >= 0) return SubscriptionResult.ALREADY_SUBSCRIBED;
        if (subscriptionResult.indexOf("succeeded") >= 0) return SubscriptionResult.SUBSCRIBED;

        throw new UnknownSubscriptionResultException(subscriptionResult);
    }

    public SubscriptionResult applyToAndroidPushNotification(AndroidPushSubscription androidPushSubscription) throws AndroidPushSubscriptionException {
        try {
            return parseSubscriptionResult(invokeApiSubscriptionEndPoint(createSubscriptionURI(androidPushSubscription)));
        } catch (IOException e) {
            throw new AndroidPushSubscriptionException(e, androidPushSubscription);
        } catch (UnknownSubscriptionResultException e) {
            throw new AndroidPushSubscriptionException(e, androidPushSubscription);
        }
    }

    public SubscriptionResult applyToBackEndHttpPostNotification(HttpPostSubscription httpPostSubscription) throws HttpPostSubscriptionException {
        try {
            return parseSubscriptionResult(invokeApiSubscriptionEndPoint(createSubscriptionURI(httpPostSubscription)));
        } catch (IOException e) {
            throw new HttpPostSubscriptionException(e, httpPostSubscription);
        } catch (UnknownSubscriptionResultException e) {
            throw new HttpPostSubscriptionException(e, httpPostSubscription);
        }
    }

}
