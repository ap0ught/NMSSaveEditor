// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class c extends JPanel
{
    private final f c;
    private final f d;
    private final f e;
    
    c(final Application application) {
        this.setLayout(new GridLayout(2, 3));
        final JPanel comp = new JPanel();
        this.add(comp);
        comp.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp2 = new JLabel("Season Rewards");
        comp2.putClientProperty("FlatLaf.styleClass", "semibold");
        comp.add(comp2, "2, 2");
        final JScrollPane comp3 = new JScrollPane();
        comp.add(comp3, "2, 4, fill, fill");
        comp3.setViewportView(this.c = new f(this, application, eI::bq, eI::P));
        final JPanel comp4 = new JPanel();
        this.add(comp4);
        comp4.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp5 = new JLabel("Twitch Rewards");
        comp5.putClientProperty("FlatLaf.styleClass", "semibold");
        comp4.add(comp5, "2, 2");
        final JScrollPane comp6 = new JScrollPane();
        comp4.add(comp6, "2, 4, fill, fill");
        comp6.setViewportView(this.d = new f(this, application, eI::br, eI::Q));
        comp4.add(new JLabel("NOTE: To use twitch drops, you must go offline before you start the game."), "2, 6, fill, fill");
        comp4.add(new JLabel("You can claim them at the Synthesis vendor in the Anomaly."), "2, 7, fill, fill");
        final JPanel comp7 = new JPanel();
        this.add(comp7);
        comp7.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC }));
        final JLabel comp8 = new JLabel("Platform Rewards");
        comp8.putClientProperty("FlatLaf.styleClass", "semibold");
        comp7.add(comp8, "2, 2");
        final JScrollPane comp9 = new JScrollPane();
        comp7.add(comp9, "2, 4, fill, fill");
        comp9.setViewportView(this.e = new f(this, application, eI::bs, eI::R));
        this.add(new JPanel());
        this.add(new JPanel());
        this.add(new JPanel());
    }
    
    void a(final eY ey) {
        if (ey == null) {
            this.c.a(null);
            this.d.a(null);
            this.e.a(null);
        }
        else {
            this.c.a(ey.d("UserSettingsData.UnlockedSeasonRewards"));
            this.d.a(ey.d("UserSettingsData.UnlockedTwitchRewards"));
            this.e.a(ey.d("UserSettingsData.UnlockedPlatformRewards"));
        }
        this.updateUI();
    }
}
