package com.akalea.ftx;

import org.junit.Assert;

import com.akalea.ftx.impl.FtxApiBase;

import junit.framework.TestCase;

public class SignatureTest extends TestCase {

    public void test() {
        String my = "1588591511721GET/api/markets";
        String key = "T4lPid48QtjNxjLUFOcUZghD7CUJ7sTVsfuvQZF2";
        String signature = "dbc62ec300b2624c580611858d94f2332ac636bb86eccfa1167a7777c496ee6f";
        Assert.assertEquals(
            signature,
            FtxApiBase.guavaHmacSha256Base64(my, key));
        Assert.assertEquals(
            signature,
            FtxApiBase.hmacSha256Base64(my, key));
    }
}
