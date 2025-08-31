// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.regex.Matcher;
import java.io.IOException;

class fY extends fX implements fs
{
    final int lO;
    fn me;
    String na;
    final /* synthetic */ fT mN;
    
    fY(final fT mn, final int lo) {
        this.mN = mn;
        super(mn, "Slot" + (lo / 2 + 1) + ((lo % 2 == 0) ? "Auto" : "Manual"));
        this.lO = lo;
        try {
            final String input = new String(this.ah(1048576));
            final Matcher matcher = fT.mJ.matcher(input);
            if (matcher.find()) {
                this.na = matcher.group(3);
            }
            this.me = fn.T(input);
        }
        catch (final IOException ex) {
            hc.a("Could not read game mode from " + this.mO.name, ex);
        }
    }
    
    fY(final fT mn, final fV fv, final eY ey) {
        this.mN = mn;
        super(mn, fv);
        this.lO = fv.mb;
        this.mZ.a(fv.mQ);
        final int ao = an(ey.J("Version"));
        if (ao != 0) {
            this.mZ.setVersion(ao);
        }
        this.na = ey.getValueAsString("CommonStateData.SaveName");
        if (this.na != null) {
            this.mZ.Y(this.na);
        }
        this.me = fn.i(ey);
        final long k = ey.K("PlayerStateData.TotalPlayTime");
        if (k != 0L) {
            this.mZ.d(k);
        }
        this.h(ey);
    }
    
    @Override
    public fn L() {
        return this.me;
    }
    
    @Override
    public long lastModified() {
        return this.mO.timestamp;
    }
    
    @Override
    public eY M() {
        return this.a(eG.jV);
    }
    
    @Override
    public String b(final eY ey) {
        this.a((this.lO == 0) ? "wgsbackup" : ("wgsbackup" + (this.lO + 1)), this.me);
        final int ao = an(ey.J("Version"));
        if (ao != 0) {
            this.mZ.setVersion(ao);
        }
        this.na = ey.getValueAsString("CommonStateData.SaveName");
        if (this.na != null) {
            this.mZ.Y(this.na);
        }
        this.me = fn.i(ey);
        final long k = ey.K("PlayerStateData.TotalPlayTime");
        if (k != 0L) {
            this.mZ.d(k);
        }
        this.h(ey);
        return this.mO.filename;
    }
    
    @Override
    public String toString() {
        return this.mO.name;
    }
    
    @Override
    public String getName() {
        return this.na;
    }
    
    @Override
    public String getDescription() {
        return this.mZ.getDescription();
    }
}
