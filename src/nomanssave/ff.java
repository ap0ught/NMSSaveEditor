package nomanssave;

<<<<<<< HEAD
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

class fF implements FileFilter {
   fF(fE var1, ArrayList var2) {
      this.mf = var1;
      this.mg = var2;
=======
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;

public class ff implements Closeable {
   public static final int kO = 1;
   public static final int kP = 2;
   public static final int kQ = 4;
   private final InputStream in;
   private final int flags;
   private int kR;
   private final CharsetDecoder kS;

   // $VF: Inserted dummy exception handlers to handle obfuscated exceptions
   public static Object a(byte[] var0) throws IOException {
      ff reader = new ff(new ByteArrayInputStream(var0), 0);
      try {
         return reader.bJ();
      } finally {
         if (reader != null) {
            reader.close();
         }
      }
   }

   public static eY b(byte[] var0) throws IOException {
      ff reader = new ff(new ByteArrayInputStream(var0), 0);
      try {
         return reader.bK();
      } finally {
         if (reader != null) {
            reader.close();
         }
      }
   }

   public static eV c(byte[] var0) throws IOException {
      ff reader = new ff(new ByteArrayInputStream(var0), 0);
      try {
         return reader.bL();
      } finally {
         if (reader != null) {
            reader.close();
         }
      }
   }

   public ff(InputStream var1) {
      this(var1, 0);
   }

   public ff(InputStream var1, int var2) {
      this.in = var1;
      this.flags = var2;
      this.kR = -1;
      this.kS = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
   }

   private int read() {
      if (this.kR >= 0) {
         int var1 = this.kR;
         this.kR = -1;
         return var1;
      } else {
         return this.in.read();
      }
   }

   private int a(Predicate var1) {
      if (this.kR < 0) {
         this.kR = this.in.read();
      }

      if (this.kR >= 0 && var1.test(this.kR)) {
         int var2 = this.kR;
         this.kR = -1;
         return var2;
      } else {
         return -1;
      }
   }

   private int bI() {
      if ((this.flags & 1) != 0) {
         return this.read();
      } else {
         if (this.kR < 0) {
            this.kR = this.in.read();
         }

         while (this.kR == 32 || this.kR == 13 || this.kR == 10 || this.kR == 9) {
            this.kR = this.in.read();
         }

         if (this.kR >= 0) {
            int var1 = this.kR;
            this.kR = -1;
            return var1;
         } else {
            return -1;
         }
      }
>>>>>>> origin
   }

   @Override
   public boolean accept(File var1) {
      Matcher var2 = fA.cb().matcher(var1.getName());
      if (var2.matches()) {
         int var3 = var2.group(1).length() == 0 ? 0 : Integer.parseInt(var2.group(1)) - 1;
         if (var3 / 2 == this.mf.lT) {
            try {
               this.mg.add(new fC(fE.a(this.mf), var1.getName(), var3));
            } catch (IOException var5) {
               hc.a("Cannot load " + var1.getName(), var5);
            }
         }
      }

      return false;
   }
}
