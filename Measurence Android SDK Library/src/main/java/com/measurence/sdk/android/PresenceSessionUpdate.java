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

import java.util.List;

public class PresenceSessionUpdate {

    private String base64HashedDeviceId;
    private PresenceSessionInterval interval;
    private Boolean isNewVisitorInStore;
    private String status;
    private String storeKey;
    private List<UserIdentity> userIdentities;
    private String updateUUID;

    public static PresenceSessionUpdate fromJson(String sessionUpdateJson) {
        Gson gson = new Gson();
        return gson.fromJson(sessionUpdateJson, PresenceSessionUpdate.class);
    }

    public PresenceSessionUpdate(String base64HashedDeviceId, String updateUUID, PresenceSessionInterval interval, Boolean isNewVisitorInStore, String status, String storeKey, List<UserIdentity> userIdentities) {
        this.base64HashedDeviceId = base64HashedDeviceId;
        this.updateUUID = updateUUID;
        this.interval = interval;
        this.isNewVisitorInStore = isNewVisitorInStore;
        this.status = status;
        this.storeKey = storeKey;
        this.userIdentities = userIdentities;
    }

    public String getBase64HashedDeviceId() {
        return base64HashedDeviceId;
    }

    public PresenceSessionInterval getInterval() {
        return interval;
    }

    public Boolean getIsNewVisitorInStore() {
        return isNewVisitorInStore;
    }

    public String getStatus() {
        return status;
    }

    public String getStoreKey() {
        return storeKey;
    }

    public List<UserIdentity> getUserIdentities() {
        return userIdentities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PresenceSessionUpdate that = (PresenceSessionUpdate) o;

        if (!base64HashedDeviceId.equals(that.base64HashedDeviceId)) return false;
        if (!interval.equals(that.interval)) return false;
        if (!isNewVisitorInStore.equals(that.isNewVisitorInStore)) return false;
        if (!status.equals(that.status)) return false;
        if (!updateUUID.equals(that.updateUUID)) return false;
        if (!storeKey.equals(that.storeKey)) return false;
        if (userIdentities != null ? !userIdentities.equals(that.userIdentities) : that.userIdentities != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = base64HashedDeviceId.hashCode();
        result = 31 * result + interval.hashCode();
        result = 31 * result + isNewVisitorInStore.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + updateUUID.hashCode();
        result = 31 * result + storeKey.hashCode();
        result = 31 * result + (userIdentities != null ? userIdentities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PresenceSessionUpdate{" +
                "base64HashedDeviceId='" + base64HashedDeviceId + '\'' +
                ", updateUUID='"  + updateUUID + '\'' +
                ", interval=" + interval +
                ", isNewVisitorInStore=" + isNewVisitorInStore +
                ", status='" + status + '\'' +
                ", storeKey='" + storeKey + '\'' +
                ", userIdentities=" + userIdentities +
                '}';
    }

    public String getUpdateUUID() {
        return updateUUID;
    }
}
