package sensor;

import com.pi4j.component.temperature.TemperatureSensor;
import com.pi4j.component.temperature.impl.TmpDS18B20DeviceType;
import com.pi4j.io.w1.W1Device;
import com.pi4j.io.w1.W1Master;

import java.io.IOException;
import java.util.List;

public class DS18B20 {
    // method to test DS18B20 temperature sensor
    public void test()
    {

        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

        for (W1Device device : w1Devices)
        {
            // this line is enought if you want to read the temperature
            // returns the temperature as double rounded to one decimal place after the point
            System.out.println("Temperature: " + ((TemperatureSensor) device).getTemperature());

            try
            {
                // returns the ID of the Sensor and the  full text of the virtual file
                System.out.println("1-Wire ID: " + device.getId() + " value: " + device.getValue());
            } catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    // method to get temperature
    double getTemperature()
    {
        // default -1 as error status;
        double value = - 1.0;

        W1Master master = new W1Master();
        List<W1Device> w1Devices = master.getDevices(TmpDS18B20DeviceType.FAMILY_CODE);

        for (W1Device device : w1Devices)
        {
            // this line is enought if you want to read the temperature
            // returns the temperature as double rounded to one decimal place after the point
            value = ((TemperatureSensor) device).getTemperature();
        }

        return value;
    }

}