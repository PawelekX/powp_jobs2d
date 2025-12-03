package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.powp.jobs2d.AbstractDriver;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DriverFeature;

/**
 * This allows using AbstractDriver-based scripts with any Job2dDriver implementation.
 */
public class AbstractDriverAdapter extends AbstractDriver {

    public AbstractDriverAdapter() {
        super(0, 0);
    }

    public AbstractDriverAdapter(int x, int y) {
        super(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        Job2dDriver currentDriver = DriverFeature.getDriverManager().getCurrentDriver();
        
        currentDriver.setPosition(getX(), getY());
        
        currentDriver.operateTo(x, y);
        
        setPosition(x, y);
    }

    @Override
    public String toString() {
        return "AbstractDriverAdapter (delegates to: " + 
               DriverFeature.getDriverManager().getCurrentDriver().toString() + ")";
    }
}