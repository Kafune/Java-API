package sensor;

import org.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/temperature")
public class TemperatureController extends SensorController {
    // Get the value back from the temperature in XML Format
    @RequestMapping(value = "/current")
    public String getTemperature() {
        StringBuffer responseBuffer = new StringBuffer();

        // read temperature from sensor
        DS18B20 temp = new DS18B20();

        // response with data
        responseBuffer.append("<temperature>" + temp.getTemperature() + "</temperature><br>\n");

        return responseBuffer.toString();
    }


    @RequestMapping(value = "/currentjson", produces = "application/json", method = RequestMethod.GET)
    public String getTemperatureToJSON() {
        StringBuffer responseBuffer = new StringBuffer();
        // read temperature from sensor
        DS18B20 temp = new DS18B20();

        // response with data
        responseBuffer.append("{ \n temperature : " + temp.getTemperature() + "}\n");
        JSONObject json = new JSONObject(responseBuffer.toString());

        return json.toString();
    }
}
