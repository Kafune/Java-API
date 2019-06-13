package sensor;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/temperature")
public class TemperatureController extends SensorController {
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

