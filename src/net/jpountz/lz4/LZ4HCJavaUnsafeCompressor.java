package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.util.Arrays;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.UnsafeUtils;

final class LZ4HCJavaUnsafeCompressor extends LZ4Compressor {
   public static final LZ4Compressor INSTANCE = new LZ4HCJavaUnsafeCompressor();
   private final int maxAttempts;
   final int compressionLevel;

   LZ4HCJavaUnsafeCompressor() {
      this(9);
   }

   LZ4HCJavaUnsafeCompressor(int compressionLevel) {
      this.maxAttempts = 1 << compressionLevel - 1;
      this.compressionLevel = compressionLevel;
   }

   @Override
   public int compress(byte[] src, int srcOff, int srcLen, byte[] dest, int destOff, int maxDestLen) {
      UnsafeUtils.checkRange(src, srcOff, srcLen);
      UnsafeUtils.checkRange(dest, destOff, maxDestLen);
      int srcEnd = srcOff + srcLen;
      int destEnd = destOff + maxDestLen;
      int mfLimit = srcEnd - 12;
      int matchLimit = srcEnd - 5;
      int dOff = destOff;
      int sOff = srcOff + 1;
      int anchor = srcOff;
      LZ4HCJavaUnsafeCompressor.HashTable ht = new LZ4HCJavaUnsafeCompressor.HashTable(srcOff);
      LZ4Utils.Match match0 = new LZ4Utils.Match();
      LZ4Utils.Match match1 = new LZ4Utils.Match();
      LZ4Utils.Match match2 = new LZ4Utils.Match();
      LZ4Utils.Match match3 = new LZ4Utils.Match();

      label105:
      while (sOff < mfLimit) {
         if (!ht.insertAndFindBestMatch(src, sOff, matchLimit, match1)) {
            sOff++;
         } else {
            LZ4Utils.copyTo(match1, match0);

            label101:
            while ($assertionsDisabled || match1.start >= anchor) {
               if (match1.method_56() < mfLimit
                  && ht.insertAndFindWiderMatch(src, match1.method_56() - 2, match1.start + 1, matchLimit, match1.field_29, match2)) {
                  if (match0.start < match1.start && match2.start < match1.start + match0.field_29) {
                     LZ4Utils.copyTo(match0, match1);
                  }

                  assert match2.start > match1.start;

                  if (match2.start - match1.start < 3) {
                     LZ4Utils.copyTo(match2, match1);
                     continue;
                  }

                  while (true) {
                     if (match2.start - match1.start < 18) {
                        int newMatchLen = match1.field_29;
                        if (newMatchLen > 18) {
                           newMatchLen = 18;
                        }

                        if (match1.start + newMatchLen > match2.method_56() - 4) {
                           newMatchLen = match2.start - match1.start + match2.field_29 - 4;
                        }

                        int correction = newMatchLen - (match2.start - match1.start);
                        if (correction > 0) {
                           match2.method_55(correction);
                        }
                     }

                     if (match2.start + match2.field_29 >= mfLimit
                        || !ht.insertAndFindWiderMatch(src, match2.method_56() - 3, match2.start, matchLimit, match2.field_29, match3)) {
                        if (match2.start < match1.method_56()) {
                           match1.field_29 = match2.start - match1.start;
                        }

                        dOff = LZ4UnsafeUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                        anchor = match1.method_56();
                        dOff = LZ4UnsafeUtils.encodeSequence(src, anchor, match2.start, match2.field_28, match2.field_29, dest, dOff, destEnd);
                        anchor = sOff = match2.method_56();
                        continue label105;
                     }

                     if (match3.start < match1.method_56() + 3) {
                        if (match3.start >= match1.method_56()) {
                           if (match2.start < match1.method_56()) {
                              int correction = match1.method_56() - match2.start;
                              match2.method_55(correction);
                              if (match2.field_29 < 4) {
                                 LZ4Utils.copyTo(match3, match2);
                              }
                           }

                           dOff = LZ4UnsafeUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                           anchor = match1.method_56();
                           LZ4Utils.copyTo(match3, match1);
                           LZ4Utils.copyTo(match2, match0);
                           continue label101;
                        }

                        LZ4Utils.copyTo(match3, match2);
                     } else {
                        if (match2.start < match1.method_56()) {
                           if (match2.start - match1.start < 15) {
                              if (match1.field_29 > 18) {
                                 match1.field_29 = 18;
                              }

                              if (match1.method_56() > match2.method_56() - 4) {
                                 match1.field_29 = match2.method_56() - match1.start - 4;
                              }

                              int correction = match1.method_56() - match2.start;
                              match2.method_55(correction);
                           } else {
                              match1.field_29 = match2.start - match1.start;
                           }
                        }

                        dOff = LZ4UnsafeUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                        anchor = match1.method_56();
                        LZ4Utils.copyTo(match2, match1);
                        LZ4Utils.copyTo(match3, match2);
                     }
                  }
               }

               dOff = LZ4UnsafeUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
               anchor = sOff = match1.method_56();
               continue label105;
            }

            throw new AssertionError();
         }
      }

      dOff = LZ4UnsafeUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
      return dOff - destOff;
   }

   @Override
   public int compress(ByteBuffer src, int srcOff, int srcLen, ByteBuffer dest, int destOff, int maxDestLen) {
      if (src.hasArray() && dest.hasArray()) {
         return this.compress(src.array(), srcOff + src.arrayOffset(), srcLen, dest.array(), destOff + dest.arrayOffset(), maxDestLen);
      } else {
         src = ByteBufferUtils.inNativeByteOrder(src);
         dest = ByteBufferUtils.inNativeByteOrder(dest);
         ByteBufferUtils.checkRange(src, srcOff, srcLen);
         ByteBufferUtils.checkRange(dest, destOff, maxDestLen);
         int srcEnd = srcOff + srcLen;
         int destEnd = destOff + maxDestLen;
         int mfLimit = srcEnd - 12;
         int matchLimit = srcEnd - 5;
         int dOff = destOff;
         int sOff = srcOff + 1;
         int anchor = srcOff;
         LZ4HCJavaUnsafeCompressor.HashTable ht = new LZ4HCJavaUnsafeCompressor.HashTable(srcOff);
         LZ4Utils.Match match0 = new LZ4Utils.Match();
         LZ4Utils.Match match1 = new LZ4Utils.Match();
         LZ4Utils.Match match2 = new LZ4Utils.Match();
         LZ4Utils.Match match3 = new LZ4Utils.Match();

         label111:
         while (sOff < mfLimit) {
            if (!ht.insertAndFindBestMatch(src, sOff, matchLimit, match1)) {
               sOff++;
            } else {
               LZ4Utils.copyTo(match1, match0);

               label107:
               while ($assertionsDisabled || match1.start >= anchor) {
                  if (match1.method_56() < mfLimit
                     && ht.insertAndFindWiderMatch(src, match1.method_56() - 2, match1.start + 1, matchLimit, match1.field_29, match2)) {
                     if (match0.start < match1.start && match2.start < match1.start + match0.field_29) {
                        LZ4Utils.copyTo(match0, match1);
                     }

                     assert match2.start > match1.start;

                     if (match2.start - match1.start < 3) {
                        LZ4Utils.copyTo(match2, match1);
                        continue;
                     }

                     while (true) {
                        if (match2.start - match1.start < 18) {
                           int newMatchLen = match1.field_29;
                           if (newMatchLen > 18) {
                              newMatchLen = 18;
                           }

                           if (match1.start + newMatchLen > match2.method_56() - 4) {
                              newMatchLen = match2.start - match1.start + match2.field_29 - 4;
                           }

                           int correction = newMatchLen - (match2.start - match1.start);
                           if (correction > 0) {
                              match2.method_55(correction);
                           }
                        }

                        if (match2.start + match2.field_29 >= mfLimit
                           || !ht.insertAndFindWiderMatch(src, match2.method_56() - 3, match2.start, matchLimit, match2.field_29, match3)) {
                           if (match2.start < match1.method_56()) {
                              match1.field_29 = match2.start - match1.start;
                           }

                           dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                           anchor = match1.method_56();
                           dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match2.start, match2.field_28, match2.field_29, dest, dOff, destEnd);
                           anchor = sOff = match2.method_56();
                           continue label111;
                        }

                        if (match3.start < match1.method_56() + 3) {
                           if (match3.start >= match1.method_56()) {
                              if (match2.start < match1.method_56()) {
                                 int correction = match1.method_56() - match2.start;
                                 match2.method_55(correction);
                                 if (match2.field_29 < 4) {
                                    LZ4Utils.copyTo(match3, match2);
                                 }
                              }

                              dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                              anchor = match1.method_56();
                              LZ4Utils.copyTo(match3, match1);
                              LZ4Utils.copyTo(match2, match0);
                              continue label107;
                           }

                           LZ4Utils.copyTo(match3, match2);
                        } else {
                           if (match2.start < match1.method_56()) {
                              if (match2.start - match1.start < 15) {
                                 if (match1.field_29 > 18) {
                                    match1.field_29 = 18;
                                 }

                                 if (match1.method_56() > match2.method_56() - 4) {
                                    match1.field_29 = match2.method_56() - match1.start - 4;
                                 }

                                 int correction = match1.method_56() - match2.start;
                                 match2.method_55(correction);
                              } else {
                                 match1.field_29 = match2.start - match1.start;
                              }
                           }

                           dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                           anchor = match1.method_56();
                           LZ4Utils.copyTo(match2, match1);
                           LZ4Utils.copyTo(match3, match2);
                        }
                     }
                  }

                  dOff = LZ4ByteBufferUtils.encodeSequence(src, anchor, match1.start, match1.field_28, match1.field_29, dest, dOff, destEnd);
                  anchor = sOff = match1.method_56();
                  continue label111;
               }

               throw new AssertionError();
            }
         }

         dOff = LZ4ByteBufferUtils.lastLiterals(src, anchor, srcEnd - anchor, dest, dOff, destEnd);
         return dOff - destOff;
      }
   }

   private class HashTable {
      static final int MASK = 65535;
      int nextToUpdate;
      private final int base;
      private final int[] hashTable;
      private final short[] chainTable;

      HashTable(int base) {
         this.base = base;
         this.nextToUpdate = base;
         this.hashTable = new int[32768];
         Arrays.fill(this.hashTable, -1);
         this.chainTable = new short[65536];
      }

      private int hashPointer(byte[] bytes, int off) {
         int v = UnsafeUtils.readInt(bytes, off);
         return this.hashPointer(v);
      }

      private int hashPointer(ByteBuffer bytes, int off) {
         int v = ByteBufferUtils.readInt(bytes, off);
         return this.hashPointer(v);
      }

      private int hashPointer(int v) {
         int h = LZ4Utils.hashHC(v);
         return this.hashTable[h];
      }

      private int next(int off) {
         return off - (this.chainTable[off & 65535] & 65535);
      }

      private void addHash(byte[] bytes, int off) {
         int v = UnsafeUtils.readInt(bytes, off);
         this.addHash(v, off);
      }

      private void addHash(ByteBuffer bytes, int off) {
         int v = ByteBufferUtils.readInt(bytes, off);
         this.addHash(v, off);
      }

      private void addHash(int v, int off) {
         int h = LZ4Utils.hashHC(v);
         int delta = off - this.hashTable[h];

         assert delta > 0 : delta;

         if (delta >= 65536) {
            delta = 65535;
         }

         this.chainTable[off & 65535] = (short)delta;
         this.hashTable[h] = off;
      }

      void insert(int off, byte[] bytes) {
         while (this.nextToUpdate < off) {
            this.addHash(bytes, this.nextToUpdate);
            this.nextToUpdate++;
         }
      }

      void insert(int off, ByteBuffer bytes) {
         while (this.nextToUpdate < off) {
            this.addHash(bytes, this.nextToUpdate);
            this.nextToUpdate++;
         }
      }

      boolean insertAndFindBestMatch(byte[] buf, int off, int matchLimit, LZ4Utils.Match match) {
         match.start = off;
         match.field_29 = 0;
         int delta = 0;
         int repl = 0;
         this.insert(off, buf);
         int ref = this.hashPointer(buf, off);
         if (ref >= off - 4 && ref <= off && ref >= this.base) {
            if (LZ4UnsafeUtils.readIntEquals(buf, ref, off)) {
               delta = off - ref;
               repl = match.field_29 = 4 + LZ4UnsafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
               match.field_28 = ref;
            }

            ref = this.next(ref);
         }

         for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; i++) {
            if (LZ4UnsafeUtils.readIntEquals(buf, ref, off)) {
               int matchLen = 4 + LZ4UnsafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
               if (matchLen > match.field_29) {
                  match.field_28 = ref;
                  match.field_29 = matchLen;
               }
            }

            ref = this.next(ref);
         }

         if (repl != 0) {
            int ptr = off;

            int end;
            for (end = off + repl - 3; ptr < end - delta; ptr++) {
               this.chainTable[ptr & 65535] = (short)delta;
            }

            do {
               this.chainTable[ptr & 65535] = (short)delta;
               this.hashTable[LZ4Utils.hashHC(UnsafeUtils.readInt(buf, ptr))] = ptr++;
            } while (ptr < end);

            this.nextToUpdate = end;
         }

         return match.field_29 != 0;
      }

      boolean insertAndFindWiderMatch(byte[] buf, int off, int startLimit, int matchLimit, int minLen, LZ4Utils.Match match) {
         match.field_29 = minLen;
         this.insert(off, buf);
         int delta = off - startLimit;
         int ref = this.hashPointer(buf, off);

         for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; i++) {
            if (LZ4UnsafeUtils.readIntEquals(buf, ref, off)) {
               int matchLenForward = 4 + LZ4UnsafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
               int matchLenBackward = LZ4UnsafeUtils.commonBytesBackward(buf, ref, off, this.base, startLimit);
               int matchLen = matchLenBackward + matchLenForward;
               if (matchLen > match.field_29) {
                  match.field_29 = matchLen;
                  match.field_28 = ref - matchLenBackward;
                  match.start = off - matchLenBackward;
               }
            }

            ref = this.next(ref);
         }

         return match.field_29 > minLen;
      }

      boolean insertAndFindBestMatch(ByteBuffer buf, int off, int matchLimit, LZ4Utils.Match match) {
         match.start = off;
         match.field_29 = 0;
         int delta = 0;
         int repl = 0;
         this.insert(off, buf);
         int ref = this.hashPointer(buf, off);
         if (ref >= off - 4 && ref <= off && ref >= this.base) {
            if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
               delta = off - ref;
               repl = match.field_29 = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
               match.field_28 = ref;
            }

            ref = this.next(ref);
         }

         for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; i++) {
            if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
               int matchLen = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
               if (matchLen > match.field_29) {
                  match.field_28 = ref;
                  match.field_29 = matchLen;
               }
            }

            ref = this.next(ref);
         }

         if (repl != 0) {
            int ptr = off;

            int end;
            for (end = off + repl - 3; ptr < end - delta; ptr++) {
               this.chainTable[ptr & 65535] = (short)delta;
            }

            do {
               this.chainTable[ptr & 65535] = (short)delta;
               this.hashTable[LZ4Utils.hashHC(ByteBufferUtils.readInt(buf, ptr))] = ptr++;
            } while (ptr < end);

            this.nextToUpdate = end;
         }

         return match.field_29 != 0;
      }

      boolean insertAndFindWiderMatch(ByteBuffer buf, int off, int startLimit, int matchLimit, int minLen, LZ4Utils.Match match) {
         match.field_29 = minLen;
         this.insert(off, buf);
         int delta = off - startLimit;
         int ref = this.hashPointer(buf, off);

         for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; i++) {
            if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
               int matchLenForward = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
               int matchLenBackward = LZ4ByteBufferUtils.commonBytesBackward(buf, ref, off, this.base, startLimit);
               int matchLen = matchLenBackward + matchLenForward;
               if (matchLen > match.field_29) {
                  match.field_29 = matchLen;
                  match.field_28 = ref - matchLenBackward;
                  match.start = off - matchLenBackward;
               }
            }

            ref = this.next(ref);
         }

         return match.field_29 > minLen;
      }
   }
}
