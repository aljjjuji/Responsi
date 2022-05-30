
import javax.swing.*;
import java.awt.event.*;

public class ViewInput extends JFrame implements ActionListener, ListenerBarang{
    public static void main(String[] args) {
        ViewInput viewInput = new ViewInput();
    }

    JLabel lInput        = new JLabel("Input Barang");
    JLabel lNama        = new JLabel("Nama");
    JLabel lMassa        = new JLabel("Massa (gr)");
    JLabel lHarga        = new JLabel("Harga satuan");
    JTextField tfNama   = new JTextField(10);
    JTextField tfMassa   = new JTextField(10);
    JTextField tfHarga   = new JTextField(10);
    JButton btnSubmit   = new JButton("Submit");
    JButton btnReset    = new JButton("Reset");
    JButton btnKembali    = new JButton("Kembali");
    ControllerInput controllerInput;
    ModelInput modelInput;
    
    public ViewInput() {
        setTitle("Menu");
        setDefaultCloseOperation(3);
        setSize(330,250);
        
        setLayout(null);
        add(lInput);
        add(lNama);
        add(lMassa);
        add(lHarga);
        add(tfNama);
        add(tfMassa);
        add(tfHarga);
        add(btnSubmit);
        add(btnReset);
        add(btnKembali);
        
        lInput.setBounds(10, 10, 120, 20);
        lNama.setBounds(10, 40, 120, 20);
        lMassa.setBounds(10, 70, 120, 20);
        lHarga.setBounds(10, 100, 120, 20);
        tfNama.setBounds(100, 40, 200, 20);
        tfMassa.setBounds(100, 70, 200, 20);
        tfHarga.setBounds(100, 100, 200, 20);
        btnSubmit.setBounds(100, 130, 90, 20);
        btnReset.setBounds(210, 130, 90, 20);
        btnKembali.setBounds(10, 175, 290, 20);
        
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        btnKembali.addActionListener(this);
        
        setVisible(true);
        
        controllerInput = new ControllerInput();
        modelInput      = new ModelInput();
        modelInput.setBarangListener((ListenerBarang) this);
        controllerInput.setMo(modelInput);
    }
    
    public String getFnama() {
        return tfNama.getText();
    }
    
    public String getFmassa() {
        return tfMassa.getText();
    }
    
    public String getFharga() {
        return tfHarga.getText();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            controllerInput.submitForm(this);
        }
        if (e.getSource() == btnReset) {
            controllerInput.resetForm(this);
        }
        if (e.getSource() == btnKembali) {
            setVisible(false);
        }
    }
    
    public void onChange(ModelInput modelInput) {
        tfNama.setText(modelInput.getNama());
        tfMassa.setText(modelInput.getMassa());
        tfHarga.setText(modelInput.getHarga());
    }
}