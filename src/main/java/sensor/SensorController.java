package sensor;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/sensors")
public class SensorController {

    private static final String template = "Dit is sensor %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/index")
    public Sensor sensor(@RequestParam(value = "name", defaultValue = "Geen sensor") String name) {
        return new Sensor(counter.incrementAndGet(),
                String.format(template, name));
    }
}