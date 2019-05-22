package net.clanaod.view;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import net.clanaod.domain.Player;
import net.clanaod.domain.Ship;
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainView");
        frame.setContentPane(new MainView().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainView() {
        List<Player> playerList = PlayerHelper.getPlayers();
        Object[] oa = new Object[playerList.size() + 1];
        oa[0] = " - ";
        for (int i = 0; i < playerList.size(); i++) {
            oa[i + 1] = playerList.get(i);
        }
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
        comboBox1.setModel(new DefaultComboBoxModel(oa));
        comboBox2.setModel(new DefaultComboBoxModel(oa));
        comboBox3.setModel(new DefaultComboBoxModel(oa));
        comboBox4.setModel(new DefaultComboBoxModel(oa));
        comboBox5.setModel(new DefaultComboBoxModel(oa));
        comboBox6.setModel(new DefaultComboBoxModel(oa));
        comboBox7.setModel(new DefaultComboBoxModel(oa));





        comboBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!e.getItem().toString().equals(" - ")) {
                        Player p1 = (Player) e.getItem();
                        List<Ship> shipList = p1.getShips();
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
                        List<Ship> shipList = p1.getShips();
                        label4.setText("<html>"+p1.getPlayerNote()+"</html>");
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
                        List<Ship> shipList = p1.getShips();
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
                        List<Ship> shipList = p1.getShips();
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
                        List<Ship> shipList = p1.getShips();
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
                        List<Ship> shipList = p1.getShips();
                        label12.setText("<html>"+p1.getPlayerNote()+"</html>");
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
                        List<Ship> shipList = p1.getShips();
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
                        label13.setText(sb.toString());
                    }
                } else {
                    label13.setText("");
                }
            }
        });
    }
}
