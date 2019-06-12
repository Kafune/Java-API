package sensor;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.repository.CrudRepository;

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

//    @RequestMapping("/sensor")
//    public Sensor sensor(@RequestParam(value="name", defaultValue="Geen sensor") String name) {
//        return new Sensor(counter.incrementAndGet(),
//                String.format(template, name));
//    }

//    public function test() {
//        StringBuffer responseBuffer = new StringBuffer();
//
//        // read temperature from sensor
//        DS18B20 temp = new DS18B20();
//
//        // response with data
//        responseBuffer.append("<temperature>" + temp.getTemperature() + "</temperature><br>\n");
//
//        sendResponse(200, responseBuffer.toString());
//    }


//    private static final String template = "Dit is sensor %s!";
//    private final AtomicLong counter = new AtomicLong();
//
//    private static GpioPinDigitalOutput pin;
//
//
//    @RequestMapping("/sensor")
//    public String toggle() {
//        W1Master master = new W1Master();
//        List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);
//        for (W1Device device : w1Devices) {
//            //this line is enought if you want to read the temperature
//            System.out.println("Temperature: " + ((TemperatureSensor) device).getTemperature());
//            //returns the temperature as double rounded to one decimal place after the point
//
//            try {
//                System.out.println("1-Wire ID: " + device.getId() +  " value: " + device.getValue());
//                //returns the ID of the Sensor and the  full text of the virtual file
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return "OK";
//    }
//
//    public GpioPinDigitalOutput getPin() {
//        if (pin == null) {
//            GpioController gpio = GpioFactory.getInstance();
//            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
//        }
//
//        return pin;
//    }