// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import org.w3c.dom.Element;

public class ez
{
    final String id;
    final int jK;
    final /* synthetic */ ey jL;
    
    ez(final ey jl, final Element element) {
        this.jL = jl;
        this.id = element.getAttribute("id");
        this.jK = Integer.parseInt(element.getAttribute("quantity"));
    }
    
    public String getID() {
        return this.id;
    }
    
    public int bo() {
        return this.jK;
    }
}
