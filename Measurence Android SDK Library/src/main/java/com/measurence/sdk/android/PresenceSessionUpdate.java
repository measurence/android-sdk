package com.measurence.sdk.android;

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Measurence Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import com.google.gson.Gson;

import org.joda.time.Interval;

public class PresenceSessionUpdate {

    private String base64HashedDeviceId;
    private Interval interval;
    private Boolean isNewVisitorInStore;
    private String status;
    private String storeKey;
    private UserIdentity userIdentity;

    public static PresenceSessionUpdate fromJson(String sessionUpdateJson) {
        Gson gson = new Gson();
        return gson.fromJson(sessionUpdateJson, PresenceSessionUpdate.class);
    }

    public PresenceSessionUpdate(String base64HashedDeviceId, Interval interval, Boolean isNewVisitorInStore, String status, String storeKey, UserIdentity userIdentity) {
        this.base64HashedDeviceId = base64HashedDeviceId;
        this.interval = interval;
        this.isNewVisitorInStore = isNewVisitorInStore;
        this.status = status;
        this.storeKey = storeKey;
        this.userIdentity = userIdentity;
    }

    public String getBase64HashedDeviceId() {
        return base64HashedDeviceId;
    }

    public void setBase64HashedDeviceId(String base64HashedDeviceId) {
        this.base64HashedDeviceId = base64HashedDeviceId;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public Boolean getIsNewVisitorInStore() {
        return isNewVisitorInStore;
    }

    public void setIsNewVisitorInStore(Boolean isNewVisitorInStore) {
        this.isNewVisitorInStore = isNewVisitorInStore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public void setStoreKey(String storeKey) {
        this.storeKey = storeKey;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }
}
