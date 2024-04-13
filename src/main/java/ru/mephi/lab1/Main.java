package ru.mephi.lab1;

import ru.mephi.lab1.books.Book;
import ru.mephi.lab1.human.LibraryUser;
import ru.mephi.lab1.library.Subscription;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        setTitle("Library");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Users");

        DefaultMutableTreeNode studentsNode = new DefaultMutableTreeNode("Students", true);
        DefaultMutableTreeNode teachersNode = new DefaultMutableTreeNode("Teachers", true);
        for (LibraryUser user : Simulator.getLibraryUsers()) {
            DefaultMutableTreeNode userNode = new DefaultMutableTreeNode(user.getFullName());
            addBooksToNode(userNode, user);
            if (user.isStudent()) {
                studentsNode.add(userNode);
            } else if (user.isTeacher()) {
                teachersNode.add(userNode);
            }
        }
        rootNode.add(studentsNode);
        rootNode.add(teachersNode);

        JTree tree = new JTree(rootNode);
        JScrollPane treeScrollPane = new JScrollPane(tree);

        JLabel imageLabel = new JLabel();
        ImageIcon icon = createImageIcon();
        imageLabel.setIcon(new ImageIcon(icon.getImage().getScaledInstance( 200, 193, Image.SCALE_DEFAULT)));
        JLabel titleLabel = new JLabel("Library", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(imageLabel);
        rightPanel.add(centerPanel, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScrollPane, rightPanel);
        splitPane.setDividerLocation(2000);
        getContentPane().add(splitPane, BorderLayout.CENTER);
    }

    protected static ImageIcon createImageIcon() {
        return new ImageIcon("src\\main\\resources\\unnamed.png");
    }

    private void addBooksToNode(DefaultMutableTreeNode userNode, LibraryUser user) {
        Subscription subscription = user.getSubscription();
        for (Book book : subscription.getRentBooks()) {
            userNode.add(new DefaultMutableTreeNode(book.getName()));
        }
    }

    public static void main(String[] args) {
        Simulator.simulate();
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }

}