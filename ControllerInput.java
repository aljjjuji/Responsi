
import javax.swing.JOptionPane;

public class ControllerInput {
    
    private ModelInput mo;
    
    public void setMo(ModelInput mo) {
        this.mo = mo;
    }
    
    public void resetForm(ViewInput viewInput) {
        mo.resetForm(viewInput);
    }
    
    public void submitForm(ViewInput viewInput) {
        mo.submitForm(viewInput);
    }
}
