package prueba;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

import java.util.Map;

import javax.inject.Inject;

@Controller("/duplicates")
public class DuplicatesController {

    @Inject
    protected DuplicatesService duplicatesService;

    /**
	 * Returns a JSON with the word and the quantity of alphabetic characters and 
     * numeric digits that occur more than once in a string
	 * 
	 * @param String
	 * 
	 * @return Map<String,String>
    **/
    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{text}")
    public Map<String, String> index(String text) {
        int quantity = duplicatesService.gettingRepeated(text);
        return duplicatesService.toMap(text, quantity);
    }
}