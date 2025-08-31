// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class w implements Runnable
{
    private final /* synthetic */ boolean ba;
    
    w(final boolean ba) {
        this.ba = ba;
    }
    
    @Override
    public void run() {
        try {
            Application.g(new Application(this.ba, null));
            Application.L.N.setVisible(true);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
