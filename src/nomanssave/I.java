// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.List;
import java.util.Collections;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class I extends em
{
    private JComboBox bh;
    private JTextField bi;
    private G bj;
    private JComboBox bk;
    private G bl;
    private JTextField bm;
    private JButton bn;
    private JButton bo;
    private JButton bp;
    private bO bq;
    private ge br;
    
    I(final Application application) {
        (this.bh = new JComboBox()).setModel(new J(this));
        this.a("Base NPC", true, this.bh);
        (this.bi = new JTextField()).setEnabled(false);
        this.a("Race", this.bi);
        (this.bj = new K(this)).setEnabled(false);
        this.a("Seed", this.bj);
        this.Y();
        (this.bk = new JComboBox()).setModel(new L(this));
        this.a("Base Info", true, this.bk);
        this.a("Name", (JComponent)(this.bl = new M(this)));
        (this.bm = new JTextField()).setEnabled(false);
        this.a("Items", this.bm);
        final JPanel panel = new JPanel();
        (this.bn = new JButton("Backup")).addActionListener(new N(this, application));
        panel.add(this.bn);
        (this.bo = new JButton("Restore")).addActionListener(new O(this, application));
        panel.add(this.bo);
        (this.bp = new JButton("Move Base Computer")).addActionListener(new P(this, application));
        panel.add(this.bp);
        this.a(panel);
        this.b(this.bq = new bO(application));
    }
    
    void w() {
        this.bq.w();
    }
    
    void x() {
        this.bq.x();
    }
    
    void y() {
        this.bq.y();
    }
    
    void A() {
        this.bq.A();
    }
    
    void a(final gt gt) {
        this.bq.a(gt);
    }
    
    ge O() {
        return this.br;
    }
    
    void a(final ge br) {
        this.br = br;
        List<Object> list;
        if (br == null) {
            list = Collections.emptyList();
            this.bh.setSelectedIndex(-1);
            this.bk.setSelectedIndex(-1);
        }
        else {
            list = br.cC();
            this.bh.setSelectedIndex((br.cD().size() == 0) ? -1 : 0);
            this.bk.setSelectedIndex((br.cE().size() == 0) ? -1 : 0);
        }
        this.bh.updateUI();
        this.bk.updateUI();
        this.bq.a(list);
    }
}
