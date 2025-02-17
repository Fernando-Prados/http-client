package org.fprados.views;

import org.fprados.HttpCall;
import org.fprados.data.HttpMethods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.HttpResponse;

public class RequestPanel extends JPanel {
    private JComboBox<HttpMethods> methodComboBox;
    private JTextField urlField;

    public RequestPanel() {
        super();
        setLayout(new GridLayout(3, 1));

        methodComboBox = new JComboBox<>(HttpMethods.values());
        add(methodComboBox);

        urlField = new JTextField();
        add(urlField);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        add(sendButton);
    }

    private class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String method = (String) methodComboBox.getSelectedItem();
            String url = urlField.getText();

            HttpResponse<String> response = HttpCall.execute(method.toUpperCase(), url, null);

            assert response != null;
            System.out.println(response.body());
        }
    }
}
