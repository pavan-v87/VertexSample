package com.wnxt.example.vertx;

import org.junit.Assert;
import org.junit.Test;
import org.mockserver.client.netty.NettyHttpClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.mockserver.model.HttpRequest.request;

/**
 *
 */
public class VertexHttpServerTest {

    protected NettyHttpClient nettyHttpClient = new NettyHttpClient();

    private final String host = "localhost";
    private final int port = 9999;

    /*@Before
    public void startProxy() {
        client = new ProxyClient("localhost", 9999);
    }*/

    @Test
    public void isRunning() {

        HttpRequest request = request().withMethod("GET").withHeader(HOST.toString(), host + ":" + port).withPath("/users");
        HttpResponse response = nettyHttpClient.sendRequest(request);

        Assert.assertTrue(OK.code() == response.getStatusCode());
    }
}