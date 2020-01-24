package com.examples.examples;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@DisplayName( "Configure the returned HTTP response" )
//@TestInstance( TestInstance.Lifecycle.PER_CLASS)
public class StubbingTest
{
    private RestTemplate restTemplate;
    private WireMockServer wireMockServer;

    /**
     * This configuration creates a WireMock server that listens to 127.0.0.1 and the port 9090.
     */
    @BeforeEach
    void configureSystemUnderTest()
    {
        this.wireMockServer = new WireMockServer( WireMockConfiguration.options().bindAddress( ( "127.0.0.1" ) ).port( 9090 ) );
        this.wireMockServer.start();
    }


    @AfterEach
    void stopWireMockServer()
    {
        this.wireMockServer.stop();
    }

    @Test
    @DisplayName( "Should return the configured HTTP response" )
    void testReturnConfiguredHttpResponse()
    {
        //Identify the HTTP request
        WireMock.givenThat( WireMock.get( WireMock.urlEqualTo( "/api/message" ) ).willReturn( WireMock.aResponse().withStatus( HttpStatus.SC_OK ) ) );

        String serverUrl = buildApiMethodUrl();
        ResponseEntity<String> response = restTemplate.getForEntity( serverUrl, String.class );

        Assert.assertEquals( response.getStatusCode(), HttpStatus.SC_OK );
    }

    private String buildApiMethodUrl()
    {
        return String.format( "http://localhost:%d/api/message",
            this.wireMockServer.port()
        );
    }
}
