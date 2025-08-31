// 
// Decompiled by Procyon v0.6.0
// 

package net.jpountz.lz4;

import java.nio.ByteBuffer;

public class LZ4DecompressorWithLength
{
    private final LZ4FastDecompressor fastDecompressor;
    private final LZ4SafeDecompressor safeDecompressor;
    
    public static int getDecompressedLength(final byte[] src) {
        return getDecompressedLength(src, 0);
    }
    
    public static int getDecompressedLength(final byte[] src, final int srcOff) {
        return (src[srcOff] & 0xFF) | (src[srcOff + 1] & 0xFF) << 8 | (src[srcOff + 2] & 0xFF) << 16 | src[srcOff + 3] << 24;
    }
    
    public static int getDecompressedLength(final ByteBuffer src) {
        return getDecompressedLength(src, src.position());
    }
    
    public static int getDecompressedLength(final ByteBuffer src, final int srcOff) {
        return (src.get(srcOff) & 0xFF) | (src.get(srcOff + 1) & 0xFF) << 8 | (src.get(srcOff + 2) & 0xFF) << 16 | src.get(srcOff + 3) << 24;
    }
    
    public LZ4DecompressorWithLength(final LZ4FastDecompressor fastDecompressor) {
        this.fastDecompressor = fastDecompressor;
        this.safeDecompressor = null;
    }
    
    public LZ4DecompressorWithLength(final LZ4SafeDecompressor safeDecompressor) {
        this.fastDecompressor = null;
        this.safeDecompressor = safeDecompressor;
    }
    
    public int decompress(final byte[] src, final byte[] dest) {
        return this.decompress(src, 0, dest, 0);
    }
    
    public int decompress(final byte[] src, final int srcOff, final byte[] dest, final int destOff) {
        if (this.safeDecompressor != null) {
            return this.decompress(src, srcOff, src.length - srcOff, dest, destOff);
        }
        final int destLen = getDecompressedLength(src, srcOff);
        return this.fastDecompressor.decompress(src, srcOff + 4, dest, destOff, destLen) + 4;
    }
    
    public int decompress(final byte[] src, final int srcOff, final int srcLen, final byte[] dest, final int destOff) {
        if (this.safeDecompressor == null) {
            return this.decompress(src, srcOff, dest, destOff);
        }
        final int destLen = getDecompressedLength(src, srcOff);
        return this.safeDecompressor.decompress(src, srcOff + 4, srcLen - 4, dest, destOff, destLen);
    }
    
    public byte[] decompress(final byte[] src) {
        return this.decompress(src, 0);
    }
    
    public byte[] decompress(final byte[] src, final int srcOff) {
        if (this.safeDecompressor != null) {
            return this.decompress(src, srcOff, src.length - srcOff);
        }
        final int destLen = getDecompressedLength(src, srcOff);
        return this.fastDecompressor.decompress(src, srcOff + 4, destLen);
    }
    
    public byte[] decompress(final byte[] src, final int srcOff, final int srcLen) {
        if (this.safeDecompressor == null) {
            return this.decompress(src, srcOff);
        }
        final int destLen = getDecompressedLength(src, srcOff);
        return this.safeDecompressor.decompress(src, srcOff + 4, srcLen - 4, destLen);
    }
    
    public void decompress(final ByteBuffer src, final ByteBuffer dest) {
        final int destLen = getDecompressedLength(src, src.position());
        if (this.safeDecompressor == null) {
            final int read = this.fastDecompressor.decompress(src, src.position() + 4, dest, dest.position(), destLen);
            src.position(src.position() + 4 + read);
            dest.position(dest.position() + destLen);
        }
        else {
            final int written = this.safeDecompressor.decompress(src, src.position() + 4, src.remaining() - 4, dest, dest.position(), destLen);
            src.position(src.limit());
            dest.position(dest.position() + written);
        }
    }
    
    public int decompress(final ByteBuffer src, final int srcOff, final ByteBuffer dest, final int destOff) {
        if (this.safeDecompressor != null) {
            return this.decompress(src, srcOff, src.remaining() - srcOff, dest, destOff);
        }
        final int destLen = getDecompressedLength(src, srcOff);
        return this.fastDecompressor.decompress(src, srcOff + 4, dest, destOff, destLen) + 4;
    }
    
    public int decompress(final ByteBuffer src, final int srcOff, final int srcLen, final ByteBuffer dest, final int destOff) {
        if (this.safeDecompressor == null) {
            return this.decompress(src, srcOff, dest, destOff);
        }
        final int destLen = getDecompressedLength(src, srcOff);
        return this.safeDecompressor.decompress(src, srcOff + 4, srcLen - 4, dest, destOff, destLen);
    }
}
