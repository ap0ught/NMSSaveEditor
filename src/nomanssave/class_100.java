// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.Properties;
import java.io.IOException;
import java.util.zip.ZipFile;
import java.io.File;

class fV implements fs
{
    final fW mO;
    final int mb;
    final File mc;
    final String mP;
    final fS mQ;
    final String mR;
    final String mS;
    final fn be;
    final /* synthetic */ fT mN;
    
    fV(final fT mn, final String child, final int mb) {
        this.mN = mn;
        this.mb = mb;
        this.mc = new File(aH.cG, child);
        final ZipFile zipFile = new ZipFile(this.mc);
        try {
            final ZipEntry entry = zipFile.getEntry("saveinfo.txt");
            if (entry == null) {
                throw new IOException("Invalid backup file");
            }
            final Properties properties = new Properties();
            properties.load(zipFile.getInputStream(entry));
            this.mP = properties.getProperty("MetaFile");
            this.mR = properties.getProperty("DataFile");
            this.mS = properties.getProperty("ContainerFile");
            final String property = properties.getProperty("IndexData");
            if (this.mP == null || this.mR == null || this.mS == null || property == null) {
                throw new IOException("Invalid backup file");
            }
            final String property2 = properties.getProperty("GameMode");
            this.be = ((property2 == null) ? null : fn.valueOf(property2));
            this.mO = new fW(mn, property);
            final ZipEntry entry2 = zipFile.getEntry(this.mP);
            if (entry2 == null) {
                throw new IOException("Invalid backup file");
            }
            (this.mQ = new fS(null)).read(zipFile.getInputStream(entry2));
        }
        catch (final NumberFormatException ex) {
            throw new IOException("Invalid backup file");
        }
        finally {
            zipFile.close();
        }
        zipFile.close();
    }
    
    void a(final FileOutputStream fileOutputStream) {
        final ZipFile zipFile = new ZipFile(this.mc);
        try {
            final ZipEntry entry = zipFile.getEntry(this.mS);
            if (entry == null) {
                throw new IOException("Invalid backup file");
            }
            final InputStream inputStream = zipFile.getInputStream(entry);
            try {
                final byte[] array = new byte[1024];
                int read;
                while ((read = inputStream.read(array)) > 0) {
                    fileOutputStream.write(array, 0, read);
                }
            }
            finally {
                inputStream.close();
            }
            inputStream.close();
        }
        finally {
            zipFile.close();
        }
        zipFile.close();
    }
    
    @Override
    public String K() {
        return this.mO.filename;
    }
    
    @Override
    public fn L() {
        return this.be;
    }
    
    @Override
    public eY M() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: aconst_null    
        //     3: astore_2       
        //     4: new             Ljava/util/zip/ZipFile;
        //     7: dup            
        //     8: aload_0        
        //     9: getfield        nomanssave/fV.mc:Ljava/io/File;
        //    12: invokespecial   java/util/zip/ZipFile.<init>:(Ljava/io/File;)V
        //    15: astore_3       
        //    16: aload_3        
        //    17: aload_0        
        //    18: getfield        nomanssave/fV.mR:Ljava/lang/String;
        //    21: invokevirtual   java/util/zip/ZipFile.getEntry:(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
        //    24: astore          4
        //    26: aload           4
        //    28: ifnonnull       41
        //    31: new             Ljava/io/IOException;
        //    34: dup            
        //    35: ldc             "Invalid backup file"
        //    37: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    40: athrow         
        //    41: aconst_null    
        //    42: astore          5
        //    44: aconst_null    
        //    45: astore          6
        //    47: new             Lnomanssave/ff;
        //    50: dup            
        //    51: aload_3        
        //    52: aload           4
        //    54: invokevirtual   java/util/zip/ZipFile.getInputStream:(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
        //    57: aload_0        
        //    58: getfield        nomanssave/fV.mQ:Lnomanssave/fS;
        //    61: invokevirtual   nomanssave/fS.ch:()I
        //    64: invokestatic    nomanssave/fT.b:(Ljava/io/InputStream;I)Ljava/io/InputStream;
        //    67: iconst_2       
        //    68: invokespecial   nomanssave/ff.<init>:(Ljava/io/InputStream;I)V
        //    71: astore          7
        //    73: aload           7
        //    75: getstatic       nomanssave/eG.jV:Lnomanssave/eG;
        //    78: invokevirtual   nomanssave/ff.a:(Lnomanssave/eG;)Lnomanssave/eY;
        //    81: aload           7
        //    83: ifnull          91
        //    86: aload           7
        //    88: invokevirtual   nomanssave/ff.close:()V
        //    91: aload_3        
        //    92: ifnull          99
        //    95: aload_3        
        //    96: invokevirtual   java/util/zip/ZipFile.close:()V
        //    99: areturn        
        //   100: astore          5
        //   102: aload           7
        //   104: ifnull          112
        //   107: aload           7
        //   109: invokevirtual   nomanssave/ff.close:()V
        //   112: aload           5
        //   114: athrow         
        //   115: astore          6
        //   117: aload           5
        //   119: ifnonnull       129
        //   122: aload           6
        //   124: astore          5
        //   126: goto            143
        //   129: aload           5
        //   131: aload           6
        //   133: if_acmpeq       143
        //   136: aload           5
        //   138: aload           6
        //   140: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   143: aload           5
        //   145: athrow         
        //   146: astore_1       
        //   147: aload_3        
        //   148: ifnull          155
        //   151: aload_3        
        //   152: invokevirtual   java/util/zip/ZipFile.close:()V
        //   155: aload_1        
        //   156: athrow         
        //   157: astore_2       
        //   158: aload_1        
        //   159: ifnonnull       167
        //   162: aload_2        
        //   163: astore_1       
        //   164: goto            177
        //   167: aload_1        
        //   168: aload_2        
        //   169: if_acmpeq       177
        //   172: aload_1        
        //   173: aload_2        
        //   174: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   177: aload_1        
        //   178: athrow         
        //    StackMapTable: 00 0D FF 00 29 00 05 07 00 1B 05 00 07 00 15 07 00 14 00 00 FF 00 31 00 08 00 05 00 07 00 15 00 05 00 07 00 1E 00 01 07 00 18 47 07 00 18 40 07 00 12 FF 00 0B 00 06 00 05 00 07 00 15 00 07 00 12 00 00 42 07 00 12 FC 00 0D 07 00 12 FA 00 0D FF 00 02 00 04 00 05 00 07 00 15 00 01 07 00 12 FF 00 08 00 02 00 07 00 12 00 00 41 07 00 12 FC 00 09 07 00 12 FA 00 09
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  73     81     100    115    Any
        //  91     100    100    115    Any
        //  47     115    115    146    Any
        //  16     91     146    157    Any
        //  99     146    146    157    Any
        //  4      157    157    179    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.ClassCastException: class com.strobel.assembler.metadata.VariableDefinitionCollection$UnknownVariableReference cannot be cast to class [Ljava.lang.Object; (com.strobel.assembler.metadata.VariableDefinitionCollection$UnknownVariableReference is in unnamed module of loader 'app'; [Ljava.lang.Object; is in module java.base of loader 'bootstrap')
        //     at com.strobel.decompiler.InstructionHelper.reverseLoadOrStore(InstructionHelper.java:339)
        //     at com.strobel.decompiler.ast.AstBuilder$FinallyInlining.processNodes(AstBuilder.java:4595)
        //     at com.strobel.decompiler.ast.AstBuilder$FinallyInlining.processFinally(AstBuilder.java:4439)
        //     at com.strobel.decompiler.ast.AstBuilder$FinallyInlining.runCore(AstBuilder.java:4395)
        //     at com.strobel.decompiler.ast.AstBuilder$FinallyInlining.run(AstBuilder.java:4357)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:100)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:334)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:255)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:130)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public String b(final eY ey) {
        hc.info("Writing new save file...");
        String s;
        if (this.mN.mE[this.mb] != null) {
            this.mN.mE[this.mb].mZ.a(this.mQ);
            s = this.mN.mE[this.mb].b(ey);
        }
        else {
            this.mN.mE[this.mb] = new fY(this.mN, this, ey);
            s = this.mN.mE[this.mb].K();
        }
        hc.info("Finished.");
        return s;
    }
    
    @Override
    public long lastModified() {
        return this.mO.timestamp;
    }
    
    @Override
    public String toString() {
        return this.mc.getName();
    }
    
    @Override
    public String getName() {
        return this.mQ.getName();
    }
    
    @Override
    public String getDescription() {
        return this.mQ.getDescription();
    }
}
