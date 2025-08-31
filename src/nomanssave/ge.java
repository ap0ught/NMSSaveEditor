// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.Collections;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.List;

public class ge
{
    private final List gT;
    private final List nh;
    private final List ni;
    
    public static ge m(final eY ey) {
        return new ge(ey);
    }
    
    private static Function ap(final int n) {
        return gt -> {
            gt.getName();
            String string = null;
            if (string == null || string.length() == 0 || "BLD_STORAGE_NAME".equals(string)) {
                string = "Chest " + i;
            }
            return new String[] { string };
        };
    }
    
    private static Function cB() {
        return p0 -> new String[] { "Ingredient Storage" };
    }
    
    private ge(final eY ey) {
        int n = 8;
        int n2 = 6;
        if (Application.e().D()) {
            n = 10;
            n2 = 8;
        }
        final ArrayList list = new ArrayList();
        for (int i = 0; i < 10; ++i) {
            list.add(new gt(ap(i), ey.H("Chest" + (i + 1) + "Inventory"), 3584, n, n2, false, false));
        }
        final eY h = ey.H("CookingIngredientsInventory");
        if (h != null) {
            list.add(new gt(cB(), h, 36352, n, n2, false, false));
        }
        this.gT = Collections.unmodifiableList((List<?>)list);
        final ArrayList list2 = new ArrayList();
        final eV d = ey.d("NPCWorkers");
        String s = "";
        for (int n3 = 0; n3 < d.size() && n3 < 5; ++n3) {
            final eY v = d.V(n3);
            if (v.M("HiredWorker")) {
                switch (n3) {
                    case 0: {
                        s = "Armorer";
                        break;
                    }
                    case 1: {
                        s = "Farmer";
                        break;
                    }
                    case 2: {
                        s = "Overseer";
                        break;
                    }
                    case 3: {
                        s = "Technician";
                        break;
                    }
                    case 4: {
                        s = "Scientist";
                        break;
                    }
                }
                list2.add(new gh(this, s, v, null));
            }
        }
        this.nh = Collections.unmodifiableList((List<?>)list2);
        final ArrayList list3 = new ArrayList();
        final eV d2 = ey.d("PersistentPlayerBases");
        for (int j = 0; j < d2.size(); ++j) {
            final eY v2 = d2.V(j);
            if ("HomePlanetBase".equals(v2.getValueAsString("BaseType.PersistentBaseTypes")) && v2.J("BaseVersion") >= 3) {
                list3.add(new gf(this, v2, null));
            }
        }
        this.ni = Collections.unmodifiableList((List<?>)list3);
    }
    
    public List cC() {
        return this.gT;
    }
    
    public List cD() {
        return this.nh;
    }
    
    public List cE() {
        return this.ni;
    }
}
