
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ModelInput {
    
    private String nama, massa, harga;
    private ListenerBarang listenerBarang;
    
    protected void fireOnChange() {
        if (listenerBarang != null) {
            listenerBarang.onChange(this);
        }
    }
    
    public ListenerBarang getBarangListener() {
        return listenerBarang;
    }
    
    public void setBarangListener(ListenerBarang listenerBarang) {
        this.listenerBarang = listenerBarang;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
        fireOnChange();
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
        fireOnChange();
    }
    
    public void resetForm(ViewInput viewInput) {
        setNama("");
        setMassa("");
        setHarga("");
    }
    
    public void submitForm(ViewInput viewInput) {
        Connector connector = new Connector();
        
        try {
            if (viewInput.getFnama().trim().equals("") || viewInput.getFmassa().trim().equals("") || viewInput.getFharga().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Lengkapi data terlebih dahulu.");
            }
            else{
                String query = "INSERT INTO barang (`nama`, `massa`, 'harga') VALUES '"+viewInput.getFnama()+"','"+viewInput.getFmassa()+"','"+viewInput.getFharga()+"')";
                connector.statement = connector.koneksi.createStatement();
                ResultSet rs = connector.statement.executeQuery(query);
                if(rs.next()){
                    JOptionPane.showMessageDialog(null,"Berhasil memasukkan data.");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Gagal memasukkan data.");
                }
            }  
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}