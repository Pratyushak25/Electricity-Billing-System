package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class bill_details extends JFrame {
    String meter;
    bill_details(String meter){
        setSize(700,650);
        setLocation( 400,150);
        setLayout(null);
        getContentPane().setBackground(new Color(206, 150, 191));

        JTable table = new JTable();
        table.setBackground(new Color(206, 150, 191)); // Match frame background
        table.setForeground(Color.WHITE); // Set text color for better contrast
        table.setGridColor(Color.WHITE); // Optional: Change grid color

        try{
            database c = new database();
            String query_bill = "select * from bill where meter_no = '"+meter+"'";
            ResultSet resultSet = c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,650);
        sp.getViewport().setBackground(new Color(206, 150, 191)); // Match frame background
        add(sp);

        setVisible(true);

    }

    public static void main(String[] args) {
        new bill_details("");
    }
}
