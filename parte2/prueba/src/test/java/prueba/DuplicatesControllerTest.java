package prueba;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

@MicronautTest
public class DuplicatesControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    public void testIndex() throws Exception {
        HttpRequest<String> request = HttpRequest.GET("/duplicates/indivisibility");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
    }
}
