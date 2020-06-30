// 
// Decompiled by Procyon v0.5.36
// 

package bot.utils;

import java.util.Objects;

public class Pair<F, S>
{
    public final F first;
    public final S second;
    
    public Pair(final F first, final S second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        final Pair<?, ?> p = (Pair<?, ?>)o;
        return Objects.equals(p.first, this.first) && Objects.equals(p.second, this.second);
    }
    
    @Override
    public int hashCode() {
        return ((this.first == null) ? 0 : this.first.hashCode()) ^ ((this.second == null) ? 0 : this.second.hashCode());
    }
    
    @Override
    public String toString() {
        return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
    }
    
    public static <A, B> Pair<A, B> create(final A a, final B b) {
        return new Pair<A, B>(a, b);
    }
}
