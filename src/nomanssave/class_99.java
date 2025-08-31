package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

// $VF: renamed from: nomanssave.fW
class class_99 {
   final String name;
   final String filename;
   // $VF: renamed from: id java.lang.String
   final String field_303;
   // $VF: renamed from: mT int
   int field_304;
   // $VF: renamed from: lL int
   final int field_305;
   // $VF: renamed from: mU java.lang.String
   String field_306;
   long timestamp;
   // $VF: renamed from: mV long
   final long field_307;
   // $VF: renamed from: mW long
   long field_308;

   class_99(class_104 var1, InputStream var2) {
      this.field_309 = var1;
      this.name = class_50.method_316(var2);
      class_37.info("  " + this.name);
      this.filename = class_50.method_316(var2);
      class_37.debug("    filename: " + this.filename);
      this.field_303 = class_50.method_316(var2);
      class_37.debug("    id: " + this.field_303);
      this.field_304 = var2.read();
      if (this.field_304 < 0) {
         throw new IOException("short read");
      } else {
         class_37.debug("    suffix: " + this.field_304);
         this.field_305 = class_31.readInt(var2);
         if (this.field_305 != 0) {
            class_37.debug("    unknown1: " + Integer.toHexString(this.field_305));
         }

         this.field_306 = class_50.method_309(var2);
         class_37.debug("    containerPath: " + this.field_306);
         this.timestamp = class_50.method_314(var2);
         class_37.debug("    timestamp: " + new Date(this.timestamp));
         this.field_307 = class_31.method_119(var2);
         if (this.field_307 != 0L) {
            class_37.debug("    unknown2: " + Long.toHexString(this.field_307));
         }

         this.field_308 = class_31.method_119(var2);
         class_37.debug("    totalSize: " + this.field_308);
      }
   }

   class_99(class_104 var1, String var2) {
      this(var1, new ByteArrayInputStream(class_31.method_117(var2)));
   }

   class_99(class_104 var1, class_99 var2) {
      this.field_309 = var1;
      this.name = var2.name;
      this.filename = var2.filename;
      this.field_303 = var2.field_303;
      this.field_304 = var2.field_304;
      this.field_305 = var2.field_305;
      this.field_306 = class_104.method_586(var1);
      this.timestamp = var2.timestamp;
      this.field_307 = var2.field_307;
      this.field_308 = var2.field_308;
   }

   void write(OutputStream var1) {
      class_50.method_317(var1, this.name);
      class_50.method_317(var1, this.filename);
      class_50.method_317(var1, this.field_303);
      var1.write(this.field_304);
      class_31.method_118(var1, this.field_305);
      class_50.method_313(var1, this.field_306);
      class_50.method_315(var1, this.timestamp);
      class_31.method_120(var1, this.field_307);
      class_31.method_120(var1, this.field_308);
   }

   // $VF: renamed from: cz () java.lang.String
   String method_572() {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      this.write(var1);
      return class_31.method_116(var1.toByteArray());
   }
}
