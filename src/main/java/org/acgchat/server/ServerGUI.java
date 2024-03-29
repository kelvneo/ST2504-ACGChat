package org.acgchat.server;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The GUI version of Server of the chat server.
 * Authors: Kelvin, Darren, QiuRong, Jonathan
 * Class: DISM/FT/2B/02
 */
public class ServerGUI {
    private JTextField portTextField;
    private JButton startButton;
    private JTextArea chatTextArea;
    private JTextArea consoleTextArea;
    private JTabbedPane tabbedPane1;
    private JTextField credentialFileTextField;
    private JTextField keystoreLocationTextField;
    private JPasswordField keystorePasswordField;
    private JTextField aliasNameTextField;
    private JPasswordField aliasPasswordField;
    private JPanel mainPanel;
    private ServerGUIObject guiObject;

    /**
     * Initialise the ServerGUI
     */
    public ServerGUI() {
        // Start the server when the start button is pressed.
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (guiObject == null) {
                    chatTextArea.setText("");
                    consoleTextArea.setText("");
                    if (!portTextField.getText().matches("^[0-9]{1,5}$"))
                        consoleTextArea.append(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - [ERROR] Invalid port number!\n");
                    else {
                        try {
                            setFieldStates(false);
                            guiObject = new ServerGUIObject(Integer.parseInt(portTextField.getText()),
                                    credentialFileTextField.getText(),
                                    keystoreLocationTextField.getText(),
                                    new String(keystorePasswordField.getPassword()),
                                    aliasNameTextField.getText(),
                                    new String(aliasPasswordField.getPassword()));
                            new ServerGUIThread().start();
                            startButton.setEnabled(true);
                            startButton.setText("Stop");
                        } catch (IOException | KeyStoreException | CertificateException | UnrecoverableKeyException | NoSuchAlgorithmException e1) {
                            consoleTextArea.append(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - [ERROR] An error occurred: " + e1 + "\n");
                            e1.printStackTrace();
                            startButton.setEnabled(true);
                        }
                    }
                } else {
                    guiObject.stop();
                }
            }
        });
    }

    /**
     * Sets the fields and buttons of the GUI to enabled or disabled
     *
     * @param state the state of the buttons and fields
     */
    private void setFieldStates(boolean state) {
        startButton.setEnabled(state);
        portTextField.setEditable(state);
        credentialFileTextField.setEditable(state);
        keystoreLocationTextField.setEditable(state);
        keystorePasswordField.setEditable(state);
        aliasNameTextField.setEditable(state);
        aliasPasswordField.setEditable(state);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(5, 0, 0, 5), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        startButton = new JButton();
        startButton.setText("Start");
        panel2.add(startButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tabbedPane1 = new JTabbedPane();
        panel1.add(tabbedPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(475, 75), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 2, new Insets(0, 5, 0, 5), -1, -1));
        tabbedPane1.addTab("General", panel3);
        final JLabel label1 = new JLabel();
        label1.setText("Port");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        portTextField = new JTextField();
        portTextField.setText("1500");
        panel3.add(portTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 5, 0, 5), -1, -1));
        tabbedPane1.addTab("Credentials", panel4);
        credentialFileTextField = new JTextField();
        credentialFileTextField.setText("Credentials");
        panel4.add(credentialFileTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("File Location");
        panel4.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(2, 2, new Insets(0, 5, 0, 5), -1, -1));
        tabbedPane1.addTab("Keystore", panel5);
        final JLabel label3 = new JLabel();
        label3.setText("Keystore Location");
        panel5.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        keystoreLocationTextField = new JTextField();
        keystoreLocationTextField.setText("ACGChatKeystore.pfx");
        panel5.add(keystoreLocationTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Password");
        panel5.add(label4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        keystorePasswordField = new JPasswordField();
        keystorePasswordField.setText("1qwer$#@!");
        panel5.add(keystorePasswordField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridLayoutManager(2, 2, new Insets(0, 5, 0, 5), -1, -1));
        tabbedPane1.addTab("Alias", panel6);
        final JLabel label5 = new JLabel();
        label5.setText("Alias Name");
        panel6.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aliasNameTextField = new JTextField();
        aliasNameTextField.setText("ACGChatServerSigned");
        panel6.add(aliasNameTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("Alias Password");
        panel6.add(label6, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        aliasPasswordField = new JPasswordField();
        aliasPasswordField.setText("1qwer$#@!");
        panel6.add(aliasPasswordField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel7, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel7.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Chat", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(panel7.getFont().getName(), panel7.getFont().getStyle(), panel7.getFont().getSize()), new Color(-16777216)));
        final JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setHorizontalScrollBarPolicy(31);
        panel7.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(600, 350), null, 0, false));
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setLineWrap(true);
        chatTextArea.setWrapStyleWord(true);
        scrollPane1.setViewportView(chatTextArea);
        final JPanel panel8 = new JPanel();
        panel8.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel8, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Console", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font(panel8.getFont().getName(), panel8.getFont().getStyle(), panel8.getFont().getSize()), new Color(-16777216)));
        final JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setHorizontalScrollBarPolicy(31);
        panel8.add(scrollPane2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(600, 350), null, 0, false));
        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);
        consoleTextArea.setLineWrap(true);
        consoleTextArea.setWrapStyleWord(true);
        scrollPane2.setViewportView(consoleTextArea);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

    /**
     * The thread to handle the connections flowing into the server
     */
    public class ServerGUIThread extends Thread {
        public void run() {
            guiObject.start();
            guiObject = null;
            startButton.setText("Start");
            setFieldStates(true);
            consoleTextArea.append(new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - [WARNING] The server crashed or stopped.\n");
        }
    }

    /**
     * The object to link the GUI and the Server.
     */
    public class ServerGUIObject extends Server {

        /**
         * Initialise the ServerGUIObject
         *
         * @param port             The port number to start the server on
         * @param credentialPath   The path to the credentials file for users
         * @param keystorePath     The path the the keystore where the private keys are located at.
         * @param keystorePassword The password of the keystore.
         * @param alias            The alias of the server's private key
         * @param aliasPassword    The password of the alias
         * @throws IOException               When any file cannot be read or written to properly
         * @throws KeyStoreException         When the keystore cannot be initialized properly
         * @throws CertificateException      When the certificate cannot be initialized properly from the keystore
         * @throws NoSuchAlgorithmException  When the algorithm used is not found
         * @throws UnrecoverableKeyException When the key is stuck in a false vacuum
         */
        protected ServerGUIObject(int port, String credentialPath, String keystorePath, String keystorePassword, String alias, String aliasPassword) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
            super(port, credentialPath, keystorePath, keystorePassword, alias, aliasPassword);
        }

        @Override
        public void log(String type, String message) {
            consoleTextArea.append(simpleDateFormat.format(new Date()) + " - [" + type + "] " + message + "\n");
            consoleTextArea.setCaretPosition(consoleTextArea.getText().length() - 1);
            System.out.println(simpleDateFormat.format(new Date()) + " - [" + type + "] " + message);
        }

        @Override
        public void chat(String message) {
            chatTextArea.append(simpleDateFormat.format(new Date()) + " - " + message + "\n");
            chatTextArea.setCaretPosition(chatTextArea.getText().length() - 1);
        }
    }

    public static void main(String[] args) {
        // Start the program and load the ServerGUI panel.
        JFrame frame = new JFrame("ServerGUI");
        final ServerGUI serverGUI = new ServerGUI();
        frame.setContentPane(serverGUI.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        // Ensure that the server shuts down properly when the window closes.
        frame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (serverGUI.guiObject != null) {
                    serverGUI.guiObject.stop();
                }
                serverGUI.guiObject = null;
                System.exit(0);
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });
    }


}
