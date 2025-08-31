// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.Color;

class bu implements Runnable
{
    final /* synthetic */ bt es;
    private final /* synthetic */ Application bv;
    
    bu(final bt es, final Application bv) {
        this.es = es;
        this.bv = bv;
    }
    
    @Override
    public void run() {
        bl.a(this.es.er, this.es.er.dR.getSelectedRow());
        if (this.es.er.eq < 0) {
            bl.a(this.es.er, new er[0]);
            bl.b(this.es.er, new er[0]);
            this.es.er.dT.setVisible(false);
            this.es.er.eb.setVisible(false);
            this.es.er.dU.setText("");
            this.es.er.dV.setSelectedIndex(-1);
            this.es.er.dW.setText("");
            this.es.er.dX.setSelectedIndex(-1);
            this.es.er.dY.setText("");
            this.es.er.dZ.setText("");
            for (int i = 0; i < this.es.er.ea.length; ++i) {
                this.es.er.ea[i].setText("");
            }
            this.es.er.ec.setSelectedIndex(-1);
            this.es.er.ed.setSelectedIndex(-1);
            this.es.er.ee.setSelectedIndex(-1);
            this.es.er.ef.setSelectedIndex(-1);
            this.es.er.eg.setSelectedIndex(-1);
            this.es.er.eh.setText("");
            this.es.er.ei.setText("");
            this.es.er.ej.setText("");
            this.es.er.ek.setText("");
            this.es.er.dT.updateUI();
            this.es.er.eb.updateUI();
            this.es.er.el.setText("");
            this.es.er.em.setVisible(false);
            this.es.er.bQ.setEnabled(false);
            this.es.er.dS.setEnabled(false);
            return;
        }
        bl.a(this.es.er, er.a(this.es.er.ep[this.es.er.eq].da()));
        bl.b(this.es.er, er.b(this.es.er.ep[this.es.er.eq].da()));
        this.es.er.dT.setVisible(true);
        this.es.er.eb.setVisible(true);
        this.es.er.dU.setText(this.es.er.ep[this.es.er.eq].getName());
        this.es.er.dV.setSelectedItem(this.es.er.ep[this.es.er.eq].da());
        this.es.er.dW.setText(this.es.er.ep[this.es.er.eq].cW().toString());
        this.es.er.dX.m(this.es.er.ep[this.es.er.eq].db());
        this.es.er.dY.setText(this.es.er.ep[this.es.er.eq].cU());
        this.es.er.dZ.setText(this.es.er.ep[this.es.er.eq].cV());
        for (int j = 0; j < this.es.er.ea.length; ++j) {
            this.es.er.ea[j].setText(Integer.toString(this.es.er.ep[this.es.er.eq].aq(j)));
        }
        this.es.er.ec.setSelectedItem(this.es.er.ep[this.es.er.eq].ar(0));
        this.es.er.ed.setSelectedItem(this.es.er.ep[this.es.er.eq].ar(1));
        this.es.er.ee.setSelectedItem(this.es.er.ep[this.es.er.eq].ar(2));
        this.es.er.ef.setSelectedItem(this.es.er.ep[this.es.er.eq].ar(3));
        this.es.er.eg.setSelectedItem(this.es.er.ep[this.es.er.eq].ar(4));
        this.es.er.eh.setText(Integer.toString(this.es.er.ep[this.es.er.eq].dc()));
        this.es.er.ei.setText(Integer.toString(this.es.er.ep[this.es.er.eq].dd()));
        this.es.er.ej.setText(Integer.toString(this.es.er.ep[this.es.er.eq].de()));
        this.es.er.ek.setText(Integer.toString(this.es.er.ep[this.es.er.eq].df()));
        if (this.bv.j(this.es.er.ep[this.es.er.eq].getIndex())) {
            this.es.er.el.setText("Status: On Mission");
            this.es.er.el.setForeground(Color.BLUE);
            this.es.er.em.setVisible(false);
        }
        else if (this.es.er.ep[this.es.er.eq].dh() > 0) {
            this.es.er.el.setText("Status: Damaged!");
            this.es.er.el.setForeground(Color.RED);
            this.es.er.em.setVisible(true);
        }
        else {
            this.es.er.el.setText("");
            this.es.er.em.setVisible(false);
        }
        this.es.er.dT.updateUI();
        this.es.er.eb.updateUI();
        this.es.er.ec.updateUI();
        this.es.er.ed.updateUI();
        this.es.er.ee.updateUI();
        this.es.er.ef.updateUI();
        this.es.er.eg.updateUI();
        this.es.er.bQ.setEnabled(this.es.er.ep.length > 1);
        this.es.er.dS.setEnabled(this.es.er.ep.length < 30 || en.aS());
    }
}
