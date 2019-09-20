package prueba;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Singleton;

@Singleton
public class DuplicatesService {

    /**
	 * Count alphabetic characters and numeric digits 
     * that occur more than once in a string
	 * 
	 * @param String
	 * 
	 * @return int
    **/
	public int gettingRepeated(String text) {
		String newText = text.toLowerCase();
        List<String> list = Arrays.asList(newText.split(""));
        List<String> result = list.stream().filter(i -> Collections.frequency(list, i) > 1).distinct().collect(Collectors.toList());
		return result.size();
    }

    /**
	 * Transform the parameters into a map structure
	 * 
	 * @param String, int
	 * 
	 * @return Map<String,String>
    **/

    public Map<String, String> toMap(String text, int quantity){
        Map<String, String> set = new HashMap<String, String>();
        set.put("Word", text);
        set.put("Number of duplicates", Integer.toString(quantity));
        return set;
    }

}