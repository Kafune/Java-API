package sensor;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
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

//    @RequestMapping("/tocsv")
//    public void convertToCsv() {
//        List<Sensor> sensors = new CsvToBeanBuilder(FileReader("yourfile.csv"))
//                .withType(Sensor.class).build().parse();
//        Writer writer = new FileWriter("yourfile.csv");
//        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder<>(writer).build();
//        beanToCsv.write(sensors);
//        writer.close();
//    }
}
