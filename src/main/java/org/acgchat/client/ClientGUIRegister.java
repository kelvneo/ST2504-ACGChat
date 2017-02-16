package org.acgchat.client;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * The register panel for users
 * Authors: Kelvin, Darren, QiuRong, Jonathan
 * Class: DISM/FT/2B/02
 */
public class ClientGUIRegister {
    private JPanel registerPanel;
    private JTextField registerServerIPTextField;
    private JTextField registerUsernameTextField;
    private JPasswordField registerPasswordField;
    private JPasswordField registerCfmPasswordField;
    private JButton registerButton;
    private JButton backToLoginButton;
    private JTextField registerServerPortTextField;
    private JFrame init;
    private ClientGUILogin loginPanel;

    /**
     * Initialize the login panel
     *
     * @param init       The {@link JFrame} that holds all the JPanels. Used for switching the JPanels.
     * @param loginPanel The {@link ClientGUILogin} object to switch back to if needed.
     */
    public ClientGUIRegister(final JFrame init, final ClientGUILogin loginPanel) {
        this.init = init;
        this.loginPanel = loginPanel;

        // Set the action listener of the text field and register button to registerActionListener
        RegisterActionListener registerActionListener = new RegisterActionListener();
        registerServerIPTextField.addActionListener(registerActionListener);
        registerUsernameTextField.addActionListener(registerActionListener);
        registerPasswordField.addActionListener(registerActionListener);
        registerCfmPasswordField.addActionListener(registerActionListener);
        registerServerPortTextField.addActionListener(registerActionListener);
        registerButton.addActionListener(registerActionListener);

        // Switch the panel to Login when the Back to Login button is pressed.
        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init.setContentPane(loginPanel.getLoginPanel());
                init.setTitle("ACG Chat Client Login");
                init.pack();
            }
        });
    }

    /**
     * Get the register panel
     *
     * @return The register panel
     */
    public JPanel getRegisterPanel() {
        return registerPanel;
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
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayoutManager(5, 4, new Insets(5, 5, 5, 5), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Server IP");
        registerPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registerServerIPTextField = new JTextField();
        registerServerIPTextField.setText("localhost");
        registerPanel.add(registerServerIPTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(250, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Username");
        registerPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registerUsernameTextField = new JTextField();
        registerPanel.add(registerUsernameTextField, new GridConstraints(1, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Password");
        registerPanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registerPasswordField = new JPasswordField();
        registerPanel.add(registerPasswordField, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Confirm Password");
        registerPanel.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registerCfmPasswordField = new JPasswordField();
        registerPanel.add(registerCfmPasswordField, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        registerPanel.add(panel1, new GridConstraints(4, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        registerButton = new JButton();
        registerButton.setText("Register");
        panel1.add(registerButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        backToLoginButton = new JButton();
        backToLoginButton.setText("Back to Login");
        panel1.add(backToLoginButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Port");
        registerPanel.add(label5, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        registerServerPortTextField = new JTextField();
        registerServerPortTextField.setText("1500");
        registerPanel.add(registerServerPortTextField, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(50, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return registerPanel;
    }

    /**
     * Used for detecting when the enter key is pressed in any text field or the register button is pressed.
     */
    private class RegisterActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Check for empty fields
            if (registerServerIPTextField.getText().isEmpty() || registerUsernameTextField.getText().isEmpty() ||
                    registerPasswordField.getPassword().length == 0 || registerCfmPasswordField.getPassword().length == 0 ||
                    registerServerPortTextField.getText().isEmpty()) {
                JOptionPane.showConfirmDialog(init, "Please field in all the fields!", "Error",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }

            // Check password complexity through regex
            else if (!String.valueOf(registerPasswordField.getPassword()).matches(Client.regexPassword)) {
                JOptionPane.showConfirmDialog(init, "Invalid password combination! Password requires a combination of letters, digit and a special character", "Error",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }

            // Check if password and confirm password match
            else if (!Arrays.equals(registerPasswordField.getPassword(), registerCfmPasswordField.getPassword())) {
                JOptionPane.showConfirmDialog(init, "Passwords do not match!", "Error",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            } else {
                // Initialise all the input values
                String serverIP = registerServerIPTextField.getText();
                String username = registerUsernameTextField.getText();
                String password = new String(registerPasswordField.getPassword());
                int port = -1;

                // Check if port number is valid
                if (registerServerPortTextField.getText().matches("^[0-9]{1,5}$") &&
                        (port = Integer.parseInt(registerServerPortTextField.getText())) > 0 && port < 65535) {
                    try {
                        // Start the client GUI and switch to it.
                        ClientGUI clientGUIObject = new ClientGUI(init, loginPanel, serverIP, port, "ACGChatCA.cert", false, username, password);
                    } catch (CertificateException | IOException | NoSuchAlgorithmException e1) {
                        JOptionPane.showConfirmDialog(init, "An internal error occurred.", "Error",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showConfirmDialog(init, "Invalid port number!", "Error",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
