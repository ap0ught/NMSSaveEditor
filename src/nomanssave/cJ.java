// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class cJ
{
    final cJ gi;
    final int gj;
    final String name;
    Object value;
    final /* synthetic */ cy gg;
    
    cJ(final cy gg, final cJ gi, final int gj, final String name, final Object value) {
        this.gg = gg;
        this.gi = gi;
        this.value = value;
        this.name = name;
        this.gj = gj;
    }
    
    boolean isLeaf() {
        return this.value == null || (!(this.value instanceof eY) && !(this.value instanceof eV));
    }
    
    int getChildCount() {
        if (this.value == null) {
            return 0;
        }
        if (this.value instanceof eY) {
            return ((eY)this.value).names().size();
        }
        if (this.value instanceof eV) {
            return ((eV)this.value).size();
        }
        return 0;
    }
    
    Object x(final int i) {
        if (this.value == null) {
            throw new RuntimeException("No children for null");
        }
        if (this.value instanceof eY) {
            final String s = ((eY)this.value).names().get(i);
            return new cJ(this.gg, this, i, s, ((eY)this.value).getValue(s));
        }
        if (this.value instanceof eV) {
            return new cJ(this.gg, this, i, "[" + i + "]", ((eV)this.value).getValue(i));
        }
        throw new RuntimeException("No children for " + this.value.getClass().getName());
    }
    
    int indexOf(final Object o) {
        if (o instanceof cJ && ((cJ)o).gi == this) {
            return ((cJ)o).gj;
        }
        return -1;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public String getText() {
        return fh.a(this.value, 1, c -> c < '\u0080');
    }
    
    public void setText(final String s) {
        if (this.gi == null) {
            this.value = eY.E(s);
            this.gg.fT.d((eY)this.value);
        }
        else {
            this.value = fh.P(s);
            if (this.gi.value instanceof eY) {
                ((eY)this.gi.value).b(this.name, this.value);
            }
            else if (this.gi.value instanceof eV) {
                ((eV)this.gi.value).a(this.gj, this.value);
            }
        }
        cy.a(this.gg, false);
        cy.b(this.gg, true);
    }
    
    public void remove() {
        if (this.gi == null) {
            throw new RuntimeException("Cannot remove root node");
        }
        this.value = null;
        if (this.gi.value instanceof eY) {
            ((eY)this.gi.value).N(this.name);
        }
        else if (this.gi.value instanceof eV) {
            ((eV)this.gi.value).ac(this.gj);
        }
        cy.a(this.gg, false);
        cy.b(this.gg, true);
    }
}
