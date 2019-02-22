package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class ClientWindow extends Frame {

    private Client client = new Client();
    private Button getBook = new Button("Get book");
    private Button clear = new Button("Clear");
    private Button library = new Button("Get library");
    private JList<String> list = new JList<>();

    public ClientWindow() {
        super("LAB_1");
        setLayout(null);
        setBackground(new Color(0, 200, 0));
        setSize(350, 250);
        add(clear);
        add(getBook);
        add(library);
        add(list);
        getBook.setBounds(110, 215, 100, 20);
        library.setBounds(110, 190, 100, 20);
        list.setBounds(20, 50, 300, 100);
        clear.setBounds(110, 165, 100, 20);
        this.show();
        this.setLocationRelativeTo(null);
        start();
    }

    public void start() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        library.addActionListener(e -> {
            String s[] = client.getFiles();
            list.setListData(s);
        });
        clear.addActionListener(e -> list.setListData(new String[0]));
        getBook.addActionListener(e -> {
            try {
                if (list.isSelectionEmpty() && list.getSelectedValue().equals("")) {
                    JOptionPane.showMessageDialog(this, "Ничего не выбрано");
                } else {
                    ProcessBuilder pb = new ProcessBuilder("Notepad.exe", list.getSelectedValue());
                    pb.start();
                }
            } catch (IOException | NullPointerException el) {
                JOptionPane.showMessageDialog(this, "Ничего не выбрано");
            }
        });
    }


}
