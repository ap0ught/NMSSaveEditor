// 
// Decompiled by Procyon v0.6.0
// 

package nomanssave;

import java.util.zip.ZipEntry;
import java.util.Properties;
import java.io.IOException;
import java.util.zip.ZipFile;
import java.io.File;

class fL implements fs
{
    final int mb;
    final File mc;
    final String mu;
    final String md;
    final fn be;
    final String mv;
    final String description;
    final /* synthetic */ fJ mt;
    
    fL(final fJ mt, final String child, final int mb) {
        this.mt = mt;
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
            this.mu = properties.getProperty("ManifestFile");
            this.md = properties.getProperty("StorageFile");
            if (this.mu == null || this.md == null) {
                throw new IOException("Invalid backup file");
            }
            final String property = properties.getProperty("GameMode");
            this.be = ((property == null) ? null : fn.valueOf(property));
            this.mv = properties.getProperty("SaveName");
            this.description = properties.getProperty("Description");
        }
        catch (final NumberFormatException ex) {
            throw new IOException("Invalid backup file");
        }
        finally {
            zipFile.close();
        }
        zipFile.close();
    }
    
    @Override
    public fn L() {
        return this.be;
    }
    
    @Override
    public String K() {
        return this.mc.getName();
    }
    
    @Override
    public long lastModified() {
        return this.mc.lastModified();
    }
    
    @Override
    public String getName() {
        return this.mv;
    }
    
    @Override
    public String getDescription() {
        return this.description;
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
        //     9: getfield        nomanssave/fL.mc:Ljava/io/File;
        //    12: invokespecial   java/util/zip/ZipFile.<init>:(Ljava/io/File;)V
        //    15: astore_3       
        //    16: aload_3        
        //    17: aload_0        
        //    18: getfield        nomanssave/fL.md:Ljava/lang/String;
        //    21: invokevirtual   java/util/zip/ZipFile.getEntry:(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
        //    24: astore          4
        //    26: aload           4
        //    28: ifnonnull       41
        //    31: new             Ljava/io/IOException;
        //    34: dup            
        //    35: ldc             "Invalid backup file"
        //    37: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    40: athrow         
        //    41: new             Ljava/io/BufferedInputStream;
        //    44: dup            
        //    45: aload_3        
        //    46: aload           4
        //    48: invokevirtual   java/util/zip/ZipFile.getInputStream:(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
        //    51: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    54: astore          5
        //    56: bipush          16
        //    58: newarray        B
        //    60: astore          6
        //    62: aload           5
        //    64: aload           6
        //    66: arraylength    
        //    67: invokevirtual   java/io/InputStream.mark:(I)V
        //    70: aload           5
        //    72: aload           6
        //    74: invokestatic    nomanssave/hk.readFully:(Ljava/io/InputStream;[B)V
        //    77: sipush          255
        //    80: aload           6
        //    82: iconst_0       
        //    83: baload         
        //    84: iand           
        //    85: sipush          229
        //    88: if_icmpne       149
        //    91: sipush          255
        //    94: aload           6
        //    96: iconst_1       
        //    97: baload         
        //    98: iand           
        //    99: sipush          161
        //   102: if_icmpne       149
        //   105: sipush          255
        //   108: aload           6
        //   110: iconst_2       
        //   111: baload         
        //   112: iand           
        //   113: sipush          237
        //   116: if_icmpne       149
        //   119: sipush          255
        //   122: aload           6
        //   124: iconst_3       
        //   125: baload         
        //   126: iand           
        //   127: sipush          254
        //   130: if_icmpne       149
        //   133: new             Lnomanssave/gX;
        //   136: dup            
        //   137: aload           5
        //   139: aload           6
        //   141: invokespecial   nomanssave/gX.<init>:(Ljava/io/InputStream;[B)V
        //   144: astore          5
        //   146: goto            154
        //   149: aload           5
        //   151: invokevirtual   java/io/InputStream.reset:()V
        //   154: aconst_null    
        //   155: astore          7
        //   157: aconst_null    
        //   158: astore          8
        //   160: new             Lnomanssave/ff;
        //   163: dup            
        //   164: aload           5
        //   166: bipush          6
        //   168: invokespecial   nomanssave/ff.<init>:(Ljava/io/InputStream;I)V
        //   171: astore          9
        //   173: aload           9
        //   175: getstatic       nomanssave/eG.jV:Lnomanssave/eG;
        //   178: invokevirtual   nomanssave/ff.a:(Lnomanssave/eG;)Lnomanssave/eY;
        //   181: astore          11
        //   183: aload           9
        //   185: ifnull          193
        //   188: aload           9
        //   190: invokevirtual   nomanssave/ff.close:()V
        //   193: aload           5
        //   195: invokevirtual   java/io/InputStream.close:()V
        //   198: aload_3        
        //   199: ifnull          206
        //   202: aload_3        
        //   203: invokevirtual   java/util/zip/ZipFile.close:()V
        //   206: aload           11
        //   208: areturn        
        //   209: astore          7
        //   211: aload           9
        //   213: ifnull          221
        //   216: aload           9
        //   218: invokevirtual   nomanssave/ff.close:()V
        //   221: aload           7
        //   223: athrow         
        //   224: astore          8
        //   226: aload           7
        //   228: ifnonnull       238
        //   231: aload           8
        //   233: astore          7
        //   235: goto            252
        //   238: aload           7
        //   240: aload           8
        //   242: if_acmpeq       252
        //   245: aload           7
        //   247: aload           8
        //   249: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   252: aload           7
        //   254: athrow         
        //   255: astore          10
        //   257: aload           5
        //   259: invokevirtual   java/io/InputStream.close:()V
        //   262: aload           10
        //   264: athrow         
        //   265: astore_1       
        //   266: aload_3        
        //   267: ifnull          274
        //   270: aload_3        
        //   271: invokevirtual   java/util/zip/ZipFile.close:()V
        //   274: aload_1        
        //   275: athrow         
        //   276: astore_2       
        //   277: aload_1        
        //   278: ifnonnull       286
        //   281: aload_2        
        //   282: astore_1       
        //   283: goto            296
        //   286: aload_1        
        //   287: aload_2        
        //   288: if_acmpeq       296
        //   291: aload_1        
        //   292: aload_2        
        //   293: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   296: aload_1        
        //   297: athrow         
        //    StackMapTable: 00 10 FF 00 29 00 05 00 05 00 07 00 15 07 00 14 00 00 FF 00 6B 00 06 00 05 00 07 00 15 00 07 00 0A 00 00 FF 00 04 00 06 00 05 00 07 00 15 00 07 00 0C 00 00 FF 00 26 00 0C 00 05 00 07 00 15 00 07 00 0C 00 05 00 07 00 1C 00 07 00 18 00 00 0C FF 00 02 00 0A 00 05 00 07 00 15 00 07 00 0C 00 05 00 07 00 1C 00 01 07 00 12 FF 00 0B 00 08 00 05 00 07 00 15 00 07 00 0C 00 07 00 12 00 00 42 07 00 12 FC 00 0D 07 00 12 FA 00 0D FF 00 02 00 06 00 05 00 07 00 15 00 07 00 0C 00 01 07 00 12 FF 00 09 00 04 00 05 00 07 00 15 00 01 07 00 12 FF 00 08 00 02 00 07 00 12 00 00 41 07 00 12 FC 00 09 07 00 12 FA 00 09
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  173    183    209    224    Any
        //  193    209    209    224    Any
        //  160    224    224    255    Any
        //  56     193    255    265    Any
        //  209    255    255    265    Any
        //  16     198    265    276    Any
        //  206    265    265    276    Any
        //  4      276    276    298    Any
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
        if (this.mt.ms[this.mb] != null) {
            s = this.mt.ms[this.mb].b(ey);
        }
        else {
            this.mt.ms[this.mb] = new fM(this.mt, this.mb, ey);
            s = this.mt.ms[this.mb].filename;
        }
        hc.info("Finished.");
        return s;
    }
    
    @Override
    public String toString() {
        return this.mc.getName();
    }
}
