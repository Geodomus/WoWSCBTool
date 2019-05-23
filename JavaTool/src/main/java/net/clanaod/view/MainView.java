package net.clanaod.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

import net.clanaod.domain.Player;
import net.clanaod.domain.Ship;
import net.clanaod.domain_helper.PlayerHelper;
import net.clanaod.domain_helper.ShipHelper;

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
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JComboBox comboBox8;
    private JButton loadButton;
    private JButton newButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JTextField playerName;
    private JTextArea playerNotes;
    private JPanel shipPanel;
    private Player player;
    private ArrayList<JToggleButton> buttonList;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainView");
        frame.setContentPane(new MainView().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void refreshComboBoxes(){

        List<Player> playerList = PlayerHelper.getPlayers();
        Collections.sort(playerList);
        Object[] oa = new Object[playerList.size() + 1];
        oa[0] = " - ";
        for (int i = 0; i < playerList.size(); i++) {
            oa[i + 1] = playerList.get(i);
        }
        comboBox1.setModel(new DefaultComboBoxModel(oa));
        comboBox2.setModel(new DefaultComboBoxModel(oa));
        comboBox3.setModel(new DefaultComboBoxModel(oa));
        comboBox4.setModel(new DefaultComboBoxModel(oa));
        comboBox5.setModel(new DefaultComboBoxModel(oa));
        comboBox6.setModel(new DefaultComboBoxModel(oa));
        comboBox7.setModel(new DefaultComboBoxModel(oa));
        comboBox8.setModel(new DefaultComboBoxModel(oa));
    }

    public void loadShips(){
        ShipHelper.addShip("Des Moines","CA");
        ShipHelper.addShip("Montana","BB");
        ShipHelper.addShip("Midway","CV");
        ShipHelper.addShip("Z-52","DD");
        ShipHelper.addShip("Hindenburg","CA");
        ShipHelper.addShip("GK","BB");
        ShipHelper.addShip("Shimakaze","DD");
        ShipHelper.addShip("Harugumo","DD");
        ShipHelper.addShip("Yoshino","CA");
        ShipHelper.addShip("Zao","CA");
        ShipHelper.addShip("Yamato","BB");
        ShipHelper.addShip("Hakuryu","CV");
        ShipHelper.addShip("Khabarovsk","DD");
        ShipHelper.addShip("Grozovoi","DD");
        ShipHelper.addShip("Stalingrad","CA");
        ShipHelper.addShip("Moskva","CA");
        ShipHelper.addShip("Kreml","BB");
        ShipHelper.addShip("Daring","DD");
        ShipHelper.addShip("Minotaur","CL");
        ShipHelper.addShip("Conqueror","BB");
        ShipHelper.addShip("Audacious","CV");
        ShipHelper.addShip("Kléber","DD");
        ShipHelper.addShip("Henri IV","CA");
        ShipHelper.addShip("République","BB");
        ShipHelper.addShip("Bourgogne","BB");
        ShipHelper.addShip("Yueyang","DD");
    }

    public MainView() {
        if(ShipHelper.getAllShips().size() == 0){
            loadShips();
        }
        List<Ship> shipList = ShipHelper.getAllShips();
        Collections.sort(shipList);
        label1.setText("");
        label2.setText("");
        label3.setText("");
        label4.setText("");
        label5.setText("");
        label6.setText("");
        label7.setText("");
        label8.setText("");
        label9.setText("");
        label10.setText("");
        label11.setText("");
        label12.setText("");
        label13.setText("");
        label14.setText("");
        refreshComboBoxes();
        shipPanel.setLayout(new GridLayout(0,4));
        buttonList = new ArrayList<JToggleButton>();
        for(Ship ship : shipList){
            JToggleButton jtb = new JToggleButton(ship.getShipName() + "(" + ship.getShipType()+ ")");
            jtb.setEnabled(false);
            jtb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JToggleButton jtb1 = (JToggleButton)e.getSource();
                    if(jtb1.isSelected()){
                        player.addShip(ShipHelper.getShipByString(jtb1.getText()));
                    }else {
                        player.removeShip(ShipHelper.getShipByString(jtb1.getText()));
                    }
                }
            });
            shipPanel.add(jtb);
            buttonList.add(jtb);
        }



        comboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label2.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label1.setText(sb.toString());
                    }
                } else {
                    label1.setText("");
                }
            }
        });
        comboBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label4.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px}table {border-spacing: 10px 0;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td style=\"padding-left:71px\">"  + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td style=\"padding-left:35px\">" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td style=\"padding-left:35px\">" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label3.setText(sb.toString());
                    }
                } else {
                    label3.setText("");
                }
            }
        });
        comboBox3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label6.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label5.setText(sb.toString());
                    }
                } else {
                    label5.setText("");
                }
            }
        });
        comboBox4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label8.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label7.setText(sb.toString());
                    }
                } else {
                    label7.setText("");
                }
            }
        });
        comboBox5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label10.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label9.setText(sb.toString());
                    }
                } else {
                    label9.setText("");
                }
            }
        });
        comboBox6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label13.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label11.setText(sb.toString());
                    }
                } else {
                    label11.setText("");
                }
            }
        });
        comboBox7.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        Set<Ship> shipSet = p1.getShips();
                        ArrayList<Ship> shipList = new ArrayList<Ship>(shipSet);
                        Collections.sort(shipList);
                        label14.setText("<html>"+p1.getPlayerNote()+"</html>");
                        StringBuilder sb = new StringBuilder();
                        sb.append("<html>");
                        if (shipList.size() < 8) {
                            for (Ship ship : shipList) {
                                sb.append(ship.getShipName() + "(" + ship.getShipType() + ")<br>");
                            }
                        } else if (shipList.size() < 15) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 2 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else if (shipList.size() < 22) {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 3 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 3 == 1) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        } else {
                            sb.append("<style> table, th, td {border: 0px;padding: 0px;}table {border-spacing: 0px;}</style>");
                            sb.append("<table>");
                            for (int i = 0; i < shipList.size(); i++) {
                                if (i % 4 == 0) {
                                    sb.append("<tr><td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else if (i % 4 != 3) {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td>");
                                } else {
                                    sb.append("<td>" + shipList.get(i).getShipName() + "(" + shipList.get(i).getShipType() + ")</td></tr>");
                                }
                            }
                            sb.append("</table>");
                        }
                        sb.append("</html>");
                        label12.setText(sb.toString());
                    }
                } else {
                    label12.setText("");
                }
            }
        });
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for(JToggleButton button : buttonList){
                        button.setSelected(false);
                        button.setEnabled(true);
                }
                player = (Player)comboBox8.getSelectedItem();
                playerName.setText(player.getPlayerName());
                playerName.setEnabled(true);
                playerNotes.setText(player.getPlayerNote());
                playerNotes.setEnabled(true);
                saveButton.setEnabled(true);
                deleteButton.setEnabled(true);
                for(Ship ship : player.getShips()){
                    for(JToggleButton button : buttonList){
                        if(button.getText().equals(ship.getShipName() + "(" + ship.getShipType()+ ")")){
                            button.setSelected(true);
                        }
                    }
                }
            }
        });
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player = new Player();
                for(JToggleButton button : buttonList){
                    button.setSelected(false);
                    button.setEnabled(true);
                }
                player.setShips(new HashSet<Ship>());
                playerName.setEnabled(true);
                playerName.setText("");
                playerNotes.setEnabled(true);
                playerNotes.setText("");
                deleteButton.setEnabled(false);
                saveButton.setEnabled(true);
            }
        });
        comboBox8.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        loadButton.setEnabled(true);
                    } else {
                        loadButton.setEnabled(false);
                    }
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PlayerHelper.deletePlayer(player);
                refreshComboBoxes();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setPlayerName(playerName.getText());
                player.setPlayerNote(playerNotes.getText());
                PlayerHelper.savePlayer(player);
                playerName.setText("");
                playerNotes.setText("");
                refreshComboBoxes();
                loadButton.setEnabled(false);
                saveButton.setEnabled(false);
                deleteButton.setEnabled(false);
                for(JToggleButton button : buttonList){
                    button.setSelected(false);
                    button.setEnabled(true);
                }
            }
        });
    }
}
