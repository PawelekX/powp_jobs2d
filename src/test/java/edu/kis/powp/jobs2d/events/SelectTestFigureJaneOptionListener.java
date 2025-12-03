package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.drivers.adapter.AbstractDriverAdapter;
import edu.kis.powp.jobs2d.magicpresets.FiguresJane;

/**
 * Listener for testing FiguresJane patterns using AbstractDriverAdapter.
 */
public class SelectTestFigureJaneOptionListener implements ActionListener {

    private DriverManager driverManager;

    public SelectTestFigureJaneOptionListener(DriverManager driverManager) {
        this.driverManager = driverManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractDriverAdapter adapter = new AbstractDriverAdapter();
        FiguresJane.figureScript(adapter);
    }
}