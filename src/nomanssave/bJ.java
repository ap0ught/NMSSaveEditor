// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

class bJ extends G
{
    final gs ez;
    final int type;
    final /* synthetic */ bE ey;
    private static /* synthetic */ int[] eA;
    
    bJ(final bE ey, final gs ez, final boolean enabled) {
        this.ey = ey;
        this.ez = ez;
        switch (ad()[ez.ordinal()]) {
            case 24: {
                this.type = 1;
                break;
            }
            default: {
                this.type = 0;
                break;
            }
        }
        this.setEnabled(enabled);
    }
    
    @Override
    protected String g(String s) {
        if (this.ey.cp == null) {
            return "";
        }
        String anObject = null;
        switch (this.type) {
            case 0: {
                anObject = Integer.toString(this.ey.cp.a(this.ez));
                break;
            }
            case 1: {
                anObject = Double.toString(this.ey.cp.b(this.ez));
                break;
            }
            default: {
                return "";
            }
        }
        if (s.equals(anObject)) {
            return s;
        }
        try {
            switch (this.type) {
                case 0: {
                    final int b = hf.b(s, 0, Integer.MAX_VALUE);
                    this.ey.cp.a(this.ez, b);
                    s = Integer.toString(b);
                    break;
                }
                case 1: {
                    final double double1 = Double.parseDouble(s);
                    this.ey.cp.a(this.ez, double1);
                    s = Double.toString(double1);
                    break;
                }
            }
            this.ey.a(this.ez, s);
            if (this.ez == gs.pL || this.ez == gs.pM) {
                final int i = this.ey.cp.a(gs.pL) + this.ey.cp.a(gs.pM);
                this.ey.cp.a(gs.pR, i);
                this.ey.a(gs.pR, Integer.toString(i));
            }
            if (this.ez == gs.pI || this.ez == gs.pK || this.ez == gs.pJ) {
                final int j = this.ey.cp.a(gs.pI) + this.ey.cp.a(gs.pK) + this.ey.cp.a(gs.pJ);
                this.ey.cp.a(gs.pS, j);
                this.ey.a(gs.pS, Integer.toString(j));
            }
            return s;
        }
        catch (final RuntimeException ex) {
            return anObject;
        }
    }
    
    void ac() {
        String text = null;
        if (this.ey.cp == null) {
            text = "";
        }
        else {
            switch (this.type) {
                case 0: {
                    text = Integer.toString(this.ey.cp.a(this.ez));
                    break;
                }
                case 1: {
                    text = Double.toString(this.ey.cp.b(this.ez));
                    break;
                }
                default: {
                    text = "";
                    break;
                }
            }
        }
        this.setText(text);
    }
    
    static /* synthetic */ int[] ad() {
        final int[] ea = bJ.eA;
        if (ea != null) {
            return ea;
        }
        final int[] ea2 = new int[gs.values().length];
        try {
            ea2[gs.pO.ordinal()] = 25;
        }
        catch (final NoSuchFieldError noSuchFieldError) {}
        try {
            ea2[gs.pU.ordinal()] = 31;
        }
        catch (final NoSuchFieldError noSuchFieldError2) {}
        try {
            ea2[gs.pN.ordinal()] = 24;
        }
        catch (final NoSuchFieldError noSuchFieldError3) {}
        try {
            ea2[gs.pT.ordinal()] = 30;
        }
        catch (final NoSuchFieldError noSuchFieldError4) {}
        try {
            ea2[gs.pI.ordinal()] = 19;
        }
        catch (final NoSuchFieldError noSuchFieldError5) {}
        try {
            ea2[gs.pC.ordinal()] = 13;
        }
        catch (final NoSuchFieldError noSuchFieldError6) {}
        try {
            ea2[gs.pF.ordinal()] = 16;
        }
        catch (final NoSuchFieldError noSuchFieldError7) {}
        try {
            ea2[gs.pE.ordinal()] = 15;
        }
        catch (final NoSuchFieldError noSuchFieldError8) {}
        try {
            ea2[gs.pR.ordinal()] = 28;
        }
        catch (final NoSuchFieldError noSuchFieldError9) {}
        try {
            ea2[gs.pD.ordinal()] = 14;
        }
        catch (final NoSuchFieldError noSuchFieldError10) {}
        try {
            ea2[gs.pB.ordinal()] = 12;
        }
        catch (final NoSuchFieldError noSuchFieldError11) {}
        try {
            ea2[gs.pQ.ordinal()] = 27;
        }
        catch (final NoSuchFieldError noSuchFieldError12) {}
        try {
            ea2[gs.pL.ordinal()] = 22;
        }
        catch (final NoSuchFieldError noSuchFieldError13) {}
        try {
            ea2[gs.pv.ordinal()] = 6;
        }
        catch (final NoSuchFieldError noSuchFieldError14) {}
        try {
            ea2[gs.pM.ordinal()] = 23;
        }
        catch (final NoSuchFieldError noSuchFieldError15) {}
        try {
            ea2[gs.pH.ordinal()] = 18;
        }
        catch (final NoSuchFieldError noSuchFieldError16) {}
        try {
            ea2[gs.pK.ordinal()] = 21;
        }
        catch (final NoSuchFieldError noSuchFieldError17) {}
        try {
            ea2[gs.pG.ordinal()] = 17;
        }
        catch (final NoSuchFieldError noSuchFieldError18) {}
        try {
            ea2[gs.pS.ordinal()] = 29;
        }
        catch (final NoSuchFieldError noSuchFieldError19) {}
        try {
            ea2[gs.pr.ordinal()] = 2;
        }
        catch (final NoSuchFieldError noSuchFieldError20) {}
        try {
            ea2[gs.pu.ordinal()] = 5;
        }
        catch (final NoSuchFieldError noSuchFieldError21) {}
        try {
            ea2[gs.pt.ordinal()] = 4;
        }
        catch (final NoSuchFieldError noSuchFieldError22) {}
        try {
            ea2[gs.pq.ordinal()] = 1;
        }
        catch (final NoSuchFieldError noSuchFieldError23) {}
        try {
            ea2[gs.ps.ordinal()] = 3;
        }
        catch (final NoSuchFieldError noSuchFieldError24) {}
        try {
            ea2[gs.pJ.ordinal()] = 20;
        }
        catch (final NoSuchFieldError noSuchFieldError25) {}
        try {
            ea2[gs.pw.ordinal()] = 7;
        }
        catch (final NoSuchFieldError noSuchFieldError26) {}
        try {
            ea2[gs.px.ordinal()] = 8;
        }
        catch (final NoSuchFieldError noSuchFieldError27) {}
        try {
            ea2[gs.pA.ordinal()] = 11;
        }
        catch (final NoSuchFieldError noSuchFieldError28) {}
        try {
            ea2[gs.pz.ordinal()] = 10;
        }
        catch (final NoSuchFieldError noSuchFieldError29) {}
        try {
            ea2[gs.pP.ordinal()] = 26;
        }
        catch (final NoSuchFieldError noSuchFieldError30) {}
        try {
            ea2[gs.py.ordinal()] = 9;
        }
        catch (final NoSuchFieldError noSuchFieldError31) {}
        return bJ.eA = ea2;
    }
}
