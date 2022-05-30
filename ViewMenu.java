


import javax.swing.*;
import java.awt.event.*;

public class ViewMenu extends JFrame implements ActionListener{
    public static void main(String[] args) {
        ViewMenu viewMenu = new ViewMenu();
    }

    JLabel lMenu        = new JLabel("Main Menu");
    JButton btnTambah   = new JButton("Tambah Barang");
    JButton btnLihat    = new JButton("Lihat Barang");
    ControllerMenu controllerMenu;
//    ModelOrang modelOrang;
    
    public ViewMenu() {
        setTitle("Menu");
        setDefaultCloseOperation(3);
        setSize(200,175);
        
        setLayout(null);
        add(lMenu);
        add(btnTambah);
        add(btnLihat);
        
        lMenu.setBounds(60, 10, 120, 20);
        btnTambah.setBounds(15, 50, 150, 20);
        btnLihat.setBounds(15, 75 ,150, 20);
        
        btnTambah.addActionListener(this);
        btnLihat.addActionListener(this);
        
        setVisible(true);
        
        controllerMenu = new ControllerMenu();
//        modelOrang      = new ModelOrang();
//        modelOrang.setOrangListener(this);
//        controllerOrang.setMo(modelOrang);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTambah) {
            controllerMenu.tambahBarang(this);
        }
        if (e.getSource() == btnLihat) {
            controllerMenu.lihatBarang(this);
        }
    }
}
