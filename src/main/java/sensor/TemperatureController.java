package sensor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temperature")
public class TemperatureController extends SensorController {
    @RequestMapping("/current")
    public String getTemperature() {
        StringBuffer responseBuffer = new StringBuffer();

        // read temperature from sensor
        DS18B20 temp = new DS18B20();

        // response with data
        responseBuffer.append("<temperature>" + temp.getTemperature() + "</temperature><br>\n");

        return responseBuffer.toString();
    }
}
