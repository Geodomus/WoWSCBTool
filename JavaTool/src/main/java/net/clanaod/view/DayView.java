package net.clanaod.view;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import net.clanaod.domain.Day;
import net.clanaod.domain.Player;
import net.clanaod.domain_helper.DayHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DayView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel upperPanel;
    private TimePickerSettings timeSettings;
    private TimePicker[] fromArray;
    private TimePicker[] toArray;
    private JCheckBox[] cbArray;
    private Player player;

    public DayView(Player player) {
        this.player = player;
        upperPanel.setLayout(new GridLayout(0,5));
        timeSettings = new TimePickerSettings();
        timeSettings.use24HourClockFormat();
        timeSettings.generatePotentialMenuTimes(TimePickerSettings.TimeIncrement.FifteenMinutes, null, null);
        initializeArrays();

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void initializeArrays(){
        fromArray = new TimePicker[7];
        toArray = new TimePicker[7];
        cbArray = new JCheckBox[7];
        for(Day day : DayHelper.getAllDays()){
            if(day.getWeekday().equals("Monday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[0] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[0] = tpTo;
                JCheckBox cb = new JCheckBox("Mondays");
                cbArray[0] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }
            if(day.getWeekday().equals("Tuesday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[1] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[1] = tpTo;
                JCheckBox cb = new JCheckBox("Tuesdays");
                cbArray[1] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }
            if(day.getWeekday().equals("Wednesday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[2] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[2] = tpTo;
                JCheckBox cb = new JCheckBox("Wednesd.");
                cbArray[2] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }
            if(day.getWeekday().equals("Thursday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[3] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[3] = tpTo;
                JCheckBox cb = new JCheckBox("Thursdays");
                cbArray[3] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }
            if(day.getWeekday().equals("Friday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[4] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[4] = tpTo;
                JCheckBox cb = new JCheckBox("Fridays");
                cbArray[4] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }
            if(day.getWeekday().equals("Saturday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[5] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[5] = tpTo;
                JCheckBox cb = new JCheckBox("Saturdays");
                cbArray[5] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }

            if(day.getWeekday().equals("Sunday")){
                TimePicker tpFrom = new TimePicker(timeSettings);
                fromArray[6] = tpFrom;
                TimePicker tpTo = new TimePicker(timeSettings);
                toArray[6] = tpTo;
                JCheckBox cb = new JCheckBox("Sundays");
                cbArray[6] = cb;
                JLabel l1 = new JLabel("here From: ");
                l1.setHorizontalAlignment(JLabel.RIGHT);
                JLabel l2 = new JLabel("here To: ");
                l2.setHorizontalAlignment(JLabel.RIGHT);
                upperPanel.add(cb);
                upperPanel.add(l1);
                upperPanel.add(tpFrom);
                upperPanel.add(l2);
                upperPanel.add(tpTo);
            }
        }
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        DayView dialog = new DayView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
