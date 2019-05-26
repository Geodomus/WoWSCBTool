package net.clanaod.view;

import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import net.clanaod.domain.Day;
import net.clanaod.domain.Player;
import net.clanaod.domain.PlayerPlaysDay;
import net.clanaod.domain_helper.DayHelper;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.sql.Time;
import java.util.Collections;

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
        List<Day> dayList = DayHelper.getAllDays();
        Collections.sort(dayList);
        for(int i = 0;i<7; i++){
            PlayerPlaysDay ppd = DayHelper.getTimeByPlayerAndDayNumber(player, (byte)i);
            TimePicker tpFrom = new TimePicker(timeSettings);
            TimePicker tpTo = new TimePicker(timeSettings);
            JCheckBox cb = new JCheckBox(dayList.get(i).getWeekday()+"s");
            cb.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    for(int i=0;i<7;i++){
                        if(cbArray[i]==e.getItem()){
                            if(e.getStateChange() == ItemEvent.SELECTED){
                                toArray[i].setEnabled(true);
                                fromArray[i].setEnabled(true);
                            } else {
                                toArray[i].setEnabled(false);
                                fromArray[i].setEnabled(false);
                            }
                        }
                    }
                }
            });
            if(ppd != null){
                cb.setSelected(true);
                tpTo.setEnabled(true);
                tpFrom.setEnabled(true);
                if(ppd.getTimefrom() != null){
                    tpFrom.setTime(ppd.getTimefrom().toLocalTime());
                }
                if(ppd.getTimeTo() != null){
                    tpTo.setTime(ppd.getTimeTo().toLocalTime());
                }
            } else{
                cb.setSelected(false);
                tpTo.setEnabled(false);
                tpFrom.setEnabled(false);
            }
            toArray[i] = tpTo;
            fromArray[i] = tpFrom;
            cbArray[i] = cb;
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

    private void onOK() {
        for(int i = 0; i<7; i++){
            if(cbArray[i].isSelected()){
                PlayerPlaysDay pd = new PlayerPlaysDay();
                pd.setDay(DayHelper.getDayByNumber((byte)i));
                pd.setPlayer(player);
                if(fromArray[i].getTime() != null){
                    Time fromTime = Time.valueOf(fromArray[i].getTime());
                    pd.setTimefrom(fromTime);
                }
                if(toArray[i].getTime() != null){
                    Time toTime = Time.valueOf(toArray[i].getTime());
                    pd.setTimeTo(toTime);
                }
                DayHelper.savePlayerPlaysDay(pd);
            } else {
                DayHelper.deletePlayerPlaysDayByNumber(player,i);
            }
        }
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    /*public static void main(String[] args) {
        DayView dialog = new DayView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }*/
}
