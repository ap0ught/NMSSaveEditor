// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.Clipboard;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.datatransfer.ClipboardOwner;
import javax.swing.text.TextAction;

class cH extends TextAction implements ClipboardOwner
{
    final /* synthetic */ cy gg;
    
    public cH(final cy gg) {
        this.gg = gg;
        super("Paste From Clipboard");
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ((JTextArea)actionEvent.getSource()).replaceSelection(ay());
    }
    
    @Override
    public void lostOwnership(final Clipboard clipboard, final Transferable transferable) {
    }
}
