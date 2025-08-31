// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

public class gw extends gv
{
    private final eY oI;
    
    gw(final eY oi, final eY ey) {
        super(0, null, ey);
        this.oI = oi;
    }
    
    @Override
    public String getName() {
        return this.oI.getValueAsString("PlayerWeaponName");
    }
    
    @Override
    public void setName(final String s) {
        this.oI.b("PlayerWeaponName", s);
    }
    
    @Override
    public String cT() {
        return gx.qH.K();
    }
    
    @Override
    public void ag(final String anObject) {
        if (!gx.qH.K().equals(anObject)) {
            throw new RuntimeException("Only standard types allowed");
        }
    }
    
    public gx dI() {
        return gx.qH;
    }
    
    public void a(final gx gx) {
        if (gx != gx.qH) {
            throw new RuntimeException("Only standard types allowed");
        }
    }
    
    @Override
    public String cK() {
        return this.oI.d("CurrentWeapon.GenerationSeed").X(1);
    }
    
    @Override
    public void aa(final String s) {
        this.oI.d("CurrentWeapon.GenerationSeed").a(1, s);
    }
    
    @Override
    public String cW() {
        return this.oI.getValueAsString("WeaponInventory.Class.InventoryClass");
    }
    
    @Override
    public void aj(final String s) {
        this.oI.b("WeaponInventory.Class.InventoryClass", s);
    }
    
    @Override
    public String toString() {
        final String name = this.getName();
        if (name != null && name.length() != 0) {
            return name;
        }
        return "Multitool";
    }
}
