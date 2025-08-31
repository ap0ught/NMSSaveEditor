package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;

// $VF: renamed from: nomanssave.ff
public class class_96 implements Closeable {
   // $VF: renamed from: kO int
   public static final int field_294 = 1;
   // $VF: renamed from: kP int
   public static final int field_295 = 2;
   // $VF: renamed from: kQ int
   public static final int field_296 = 4;
   // $VF: renamed from: in java.io.InputStream
   private final InputStream field_297;
   private final int flags;
   // $VF: renamed from: kR int
   private int field_298;
   // $VF: renamed from: kS java.nio.charset.CharsetDecoder
   private final CharsetDecoder field_299;

   // $VF: renamed from: a (byte[]) java.lang.Object
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static Object method_552(byte[] var0) {
      Throwable var1 = null;
      Object var2 = null;

      try {
         class_96 var3 = new class_96(new ByteArrayInputStream(var0), 0);

         Throwable var10000;
         label125: {
            try {
               var10000 = (Throwable)var3.method_557();
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var10001 = false;
               break label125;
            }

            if (var3 != null) {
               var3.close();
            }

            label114:
            try {
               return var10000;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var17 = false;
               break label114;
            }
         }

         var1 = var10000;
         if (var3 != null) {
            var3.close();
         }

         throw var1;
      } catch (Throwable var15) {
         if (var1 == null) {
            var1 = var15;
         } else if (var1 != var15) {
            var1.addSuppressed(var15);
         }

         throw var1;
      }
   }

   // $VF: renamed from: b (byte[]) nomanssave.eY
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static class_137 method_553(byte[] var0) {
      Throwable var1 = null;
      Object var2 = null;

      try {
         class_96 var3 = new class_96(new ByteArrayInputStream(var0), 0);

         Throwable var10000;
         label125: {
            try {
               var16 = var3.method_558();
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var10001 = false;
               break label125;
            }

            if (var3 != null) {
               var3.close();
            }

            label114:
            try {
               return var16;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var17 = false;
               break label114;
            }
         }

         var1 = var10000;
         if (var3 != null) {
            var3.close();
         }

         throw var1;
      } catch (Throwable var15) {
         if (var1 == null) {
            var1 = var15;
         } else if (var1 != var15) {
            var1.addSuppressed(var15);
         }

         throw var1;
      }
   }

   // $VF: renamed from: c (byte[]) nomanssave.eV
   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static class_142 method_554(byte[] var0) {
      Throwable var1 = null;
      Object var2 = null;

      try {
         class_96 var3 = new class_96(new ByteArrayInputStream(var0), 0);

         Throwable var10000;
         label125: {
            try {
               var16 = var3.method_560();
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var10001 = false;
               break label125;
            }

            if (var3 != null) {
               var3.close();
            }

            label114:
            try {
               return var16;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var17 = false;
               break label114;
            }
         }

         var1 = var10000;
         if (var3 != null) {
            var3.close();
         }

         throw var1;
      } catch (Throwable var15) {
         if (var1 == null) {
            var1 = var15;
         } else if (var1 != var15) {
            var1.addSuppressed(var15);
         }

         throw var1;
      }
   }

   public class_96(InputStream var1) {
      this(var1, 0);
   }

   public class_96(InputStream var1, int var2) {
      this.field_297 = var1;
      this.flags = var2;
      this.field_298 = -1;
      this.field_299 = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
   }

   private int read() {
      if (this.field_298 >= 0) {
         int var1 = this.field_298;
         this.field_298 = -1;
         return var1;
      } else {
         return this.field_297.read();
      }
   }

   // $VF: renamed from: a (java.util.function.Predicate) int
   private int method_555(Predicate var1) {
      if (this.field_298 < 0) {
         this.field_298 = this.field_297.read();
      }

      if (this.field_298 >= 0 && var1.test(this.field_298)) {
         int var2 = this.field_298;
         this.field_298 = -1;
         return var2;
      } else {
         return -1;
      }
   }

   // $VF: renamed from: bI () int
   private int method_556() {
      if ((this.flags & 1) != 0) {
         return this.read();
      } else {
         if (this.field_298 < 0) {
            this.field_298 = this.field_297.read();
         }

         while (this.field_298 == 32 || this.field_298 == 13 || this.field_298 == 10 || this.field_298 == 9) {
            this.field_298 = this.field_297.read();
         }

         if (this.field_298 >= 0) {
            int var1 = this.field_298;
            this.field_298 = -1;
            return var1;
         } else {
            return -1;
         }
      }
   }

   @Override
   public void close() {
      try {
         if (this.field_298 < 0) {
            this.field_298 = this.field_297.read();
         }

         if ((this.flags & 1) == 0) {
            while (this.field_298 == 32 || this.field_298 == 13 || this.field_298 == 10 || this.field_298 == 9) {
               this.field_298 = this.field_297.read();
            }
         }

         if ((this.flags & 2) != 0) {
            if (this.field_298 != 0) {
               throw new class_140("Missing null terminator");
            }

            this.field_298 = -1;
         }

         if (this.field_298 >= 0) {
            throw new class_140("Unexpected termination: " + this.field_298);
         }
      } finally {
         if ((this.flags & 4) == 0) {
            this.field_297.close();
         }
      }
   }

   // $VF: renamed from: bJ () java.lang.Object
   public Object method_557() {
      return this.method_561(this.method_556(), null);
   }

   // $VF: renamed from: bK () nomanssave.eY
   public class_137 method_558() {
      int var1 = this.method_556();
      if (var1 < 0) {
         throw new class_140("Short read");
      } else if (var1 != 123) {
         throw new class_140("Unexpected token");
      } else {
         return this.method_563(null);
      }
   }

   // $VF: renamed from: a (nomanssave.eG) nomanssave.eY
   public class_137 method_559(class_297 var1) {
      int var2 = this.method_556();
      if (var2 < 0) {
         throw new class_140("Short read");
      } else if (var2 != 123) {
         throw new class_140("Unexpected token");
      } else {
         Object var3 = null;
         class_161 var4 = null;
         int var5 = this.method_556();
         if (var5 != 34) {
            if (var5 != 125) {
               throw new class_140("Invalid token");
            }
         } else {
            while (true) {
               String var6 = this.method_566();
               if (var3 == null) {
                  if (var1 != null && (var4 = class_161.method_814(var1, var6)) != null) {
                     var3 = new class_138(var4);
                  } else {
                     var3 = new class_137();
                  }
               }

               if (var4 != null) {
                  var6 = var4.method_817(var6);
               }

               if (this.method_556() != 58) {
                  throw new class_140("Invalid token");
               }

               Object var7 = this.method_561(this.method_556(), var4);
               ((class_137)var3).method_691(var6, var7);
               var5 = this.method_556();
               if (var5 == 125) {
                  break;
               }

               if (var5 != 44) {
                  throw new class_140("Invalid token");
               }

               var5 = this.method_556();
               if (var5 != 34) {
                  throw new class_140("Invalid token");
               }
            }
         }

         if (var3 == null) {
            var3 = new class_137();
         }

         if (((class_137)var3).method_702("PlayerStateData") == null) {
            ((class_137)var3).method_690("PlayerStateData", ff::f);
         }

         return (class_137)var3;
      }
   }

   // $VF: renamed from: bL () nomanssave.eV
   public class_142 method_560() {
      int var1 = this.method_556();
      if (var1 < 0) {
         throw new class_140("Short read");
      } else if (var1 != 91) {
         throw new class_140("Unexpected token");
      } else {
         return this.method_564(null);
      }
   }

   // $VF: renamed from: a (int, nomanssave.eC) java.lang.Object
   private Object method_561(int var1, class_161 var2) {
      if (var1 < 0) {
         throw new class_140("Short read");
      } else if (var1 == 123) {
         return this.method_563(var2);
      } else if (var1 == 91) {
         return this.method_564(var2);
      } else if (var1 == 34) {
         return this.method_567();
      } else if (var1 == 116) {
         if (this.read() != 114) {
            throw new class_140("Invalid token");
         } else if (this.read() != 117) {
            throw new class_140("Invalid token");
         } else if (this.read() != 101) {
            throw new class_140("Invalid token");
         } else {
            return Boolean.TRUE;
         }
      } else if (var1 == 102) {
         if (this.read() != 97) {
            throw new class_140("Invalid token");
         } else if (this.read() != 108) {
            throw new class_140("Invalid token");
         } else if (this.read() != 115) {
            throw new class_140("Invalid token");
         } else if (this.read() != 101) {
            throw new class_140("Invalid token");
         } else {
            return Boolean.FALSE;
         }
      } else if (var1 == 110) {
         if (this.read() != 117) {
            throw new class_140("Invalid token");
         } else if (this.read() != 108) {
            throw new class_140("Invalid token");
         } else if (this.read() != 108) {
            throw new class_140("Invalid token");
         } else {
            return null;
         }
      } else if (var1 != 45 && (var1 < 48 || var1 > 57)) {
         throw new class_140("Invalid token");
      } else {
         return this.method_562(var1);
      }
   }

   // $VF: renamed from: ad (int) java.lang.Number
   private Number method_562(int var1) {
      boolean var3 = false;
      if (var1 == 45) {
         var1 = this.method_555(class_94.field_287);
         if (var1 < 0) {
            throw new class_140("Invalid token");
         }

         var3 = true;
      }

      BigDecimal var2 = new BigDecimal(var1 - 48);
      if (var1 != 48) {
         while ((var1 = this.method_555(class_94.field_287)) >= 0) {
            var2 = var2.multiply(BigDecimal.TEN).add(new BigDecimal(var1 - 48));
         }
      }

      boolean var4 = true;
      if (this.method_555(class_94.field_288) >= 0) {
         var4 = false;
         var1 = this.method_555(class_94.field_287);
         if (var1 < 0) {
            throw new class_140("Invalid token");
         }

         int var5 = 0;

         do {
            var2 = var2.add(new BigDecimal(var1 - 48).scaleByPowerOfTen(--var5));
         } while ((var1 = this.method_555(class_94.field_287)) >= 0);
      }

      if (this.method_555(class_94.field_289) >= 0) {
         var4 = false;
         var1 = this.method_555(class_94.field_290);
         boolean var12 = false;
         if (var1 == 43 || var1 == 45) {
            var12 = var1 == 45;
            var1 = this.method_555(class_94.field_287);
         }

         if (var1 < 0) {
            throw new class_140("Invalid token");
         }

         int var6 = 0;

         do {
            var6 *= 10;
            var6 += var1 - 48;
         } while ((var1 = this.method_555(class_94.field_287)) >= 0);

         if (var12) {
            var6 = -var6;
         }

         var2 = var2.scaleByPowerOfTen(var6);
      }

      if (var3) {
         var2 = var2.negate();
      }

      if (var4) {
         try {
            return var2.intValueExact();
         } catch (ArithmeticException var8) {
            try {
               return var2.longValueExact();
            } catch (ArithmeticException var7) {
            }
         }
      }

      return var2;
   }

   // $VF: renamed from: a (nomanssave.eC) nomanssave.eY
   private class_137 method_563(class_161 var1) {
      class_137 var2 = new class_137();
      int var3 = this.method_556();
      if (var3 != 34) {
         if (var3 != 125) {
            throw new class_140("Invalid token");
         }
      } else {
         while (true) {
            String var4 = this.method_566();
            if (var1 != null) {
               var4 = var1.method_817(var4);
            }

            if (this.method_556() != 58) {
               throw new class_140("Invalid token");
            }

            Object var5 = this.method_561(this.method_556(), var1);
            var2.method_691(var4, var5);
            var3 = this.method_556();
            if (var3 == 125) {
               break;
            }

            if (var3 != 44) {
               throw new class_140("Invalid token");
            }

            var3 = this.method_556();
            if (var3 != 34) {
               throw new class_140("Invalid token");
            }
         }
      }

      return var2;
   }

   // $VF: renamed from: b (nomanssave.eC) nomanssave.eV
   private class_142 method_564(class_161 var1) {
      class_142 var2 = new class_142();
      int var3;
      if ((var3 = this.method_556()) != 93) {
         while (true) {
            Object var4 = this.method_561(var3, var1);
            var2.method_727(var4);
            var3 = this.method_556();
            if (var3 == 93) {
               break;
            }

            if (var3 != 44) {
               throw new class_140("Invalid token");
            }

            var3 = this.method_556();
         }
      }

      return var2;
   }

   // $VF: renamed from: bM () byte[]
   private byte[] method_565() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();

      int var2;
      while ((var2 = this.read()) != 34) {
         if (var2 < 0) {
            throw new class_140("Short read");
         }

         if (var2 == 92) {
            var2 = this.read();
            if (var2 < 0) {
               throw new class_140("Short read");
            }

            switch (var2) {
               case 98:
                  var2 = 8;
                  break;
               case 102:
                  var2 = 12;
                  break;
               case 110:
                  var2 = 10;
                  break;
               case 114:
                  var2 = 13;
                  break;
               case 116:
                  var2 = 9;
                  break;
               case 117:
                  var2 = class_94.method_539(this.read()) << 12
                     | class_94.method_539(this.read()) << 8
                     | class_94.method_539(this.read()) << 4
                     | class_94.method_539(this.read());
                  if (var2 > 255) {
                     throw new class_140("Unexpected unicode escape: " + var2);
                  }
            }
         }

         var1.write(var2);
      }

      return var1.toByteArray();
   }

   // $VF: renamed from: bN () java.lang.String
   private String method_566() {
      byte[] var1 = this.method_565();

      try {
         return this.field_299.decode(ByteBuffer.wrap(var1)).toString();
      } catch (CharacterCodingException var3) {
         throw new class_140("Invalid string");
      }
   }

   // $VF: renamed from: bO () java.lang.Object
   private Object method_567() {
      byte[] var1 = this.method_565();

      try {
         return this.field_299.decode(ByteBuffer.wrap(var1)).toString();
      } catch (CharacterCodingException var3) {
         return new class_95(var1);
      }
   }
}
