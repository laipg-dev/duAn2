/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookstore.gui.main;



import com.bookstore.controller.PermissionController;
import javax.swing.*;
import com.bookstore.gui.main.LoginGUI;


import com.bookstore.model.User;
import com.bookstore.service.PermissionService;




import com.bookstore.ui.PermissionPanel;
import com.bookstore.util.SessionManager;
import java.sql.SQLException;
import java.util.Map;

/**
 * Lớp khởi động ứng dụng
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        /*SessionManager sessionManager = SessionManager.getInstance();
        User adminUser = new User(3, "admin1", "123", 3, true);
        sessionManager.setCurrentUser(adminUser);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Quản lý phân quyền");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            PermissionPanel panel = new PermissionPanel();
            PermissionService service = new PermissionService();
            new PermissionController(panel, service);
            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });*/
        
        SessionManager session = SessionManager.getInstance();
        User adminUser = new User(1, "admin1", "123", 3, true);
        session.setCurrentUser(adminUser);
try {
    String[][] permissions = session.getAllPermissions();
    String[] moduleNames = {
        "user_management",
        "invoice_management",
        "product_management",
        "order_management",
        "statistics_management",
        "permission_management"
    };
    System.out.println("Quyền của người dùng:");
    for (int i = 0; i < permissions.length; i++) {
        System.out.print(moduleNames[i] + ": ");
        if (permissions[i].length == 0) {
            System.out.println("[]");
        } else {
            System.out.println("[" + String.join(", ", permissions[i]) + "]");
        }
    }
} catch (SQLException e) {
    System.err.println("Lỗi lấy quyền: " + e.getMessage());
}
    }
}
