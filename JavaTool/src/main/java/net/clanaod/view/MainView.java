package net.clanaod.view;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import net.clanaod.domain_helper.PlayerHelper;

public class MainView {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainView");
        frame.setContentPane(new MainView().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public MainView() {
        comboBox1.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
        comboBox2.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
        comboBox3.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
        comboBox4.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
        comboBox5.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
        comboBox6.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
        comboBox7.setModel(new DefaultComboBoxModel(PlayerHelper.getPlayers().toArray()));
    }
}
