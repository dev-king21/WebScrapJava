// 
// Decompiled by Procyon v0.5.36
// 

package bot.network;

import java.util.Set;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Headers implements Map<String, List<String>>
{
    HashMap<String, List<String>> map;
    
    public Headers() {
        this.map = new HashMap<String, List<String>>(32);
    }
    
    public List<String> values(final String name) {
        List<String> result = null;
        for (final Entry<String, List<String>> entry : this.entrySet()) {
            if (name.equalsIgnoreCase(entry.getKey())) {
                if (result == null) {
                    result = new ArrayList<String>(2);
                }
                result.addAll(entry.getValue());
            }
        }
        return (result != null) ? Collections.unmodifiableList((List<? extends String>)result) : Collections.emptyList();
    }
    
    private String normalize(final String var1) {
        if (var1 == null) {
            return null;
        }
        final int var2 = var1.length();
        if (var2 == 0) {
            return var1;
        }
        final char[] var3 = var1.toCharArray();
        if (var3[0] >= 'a' && var3[0] <= 'z') {
            var3[0] -= ' ';
        }
        for (int var4 = 1; var4 < var2; ++var4) {
            if (var3[var4] >= 'A' && var3[var4] <= 'Z') {
                var3[var4] += ' ';
            }
        }
        return new String(var3);
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    @Override
    public boolean containsKey(final Object var1) {
        return var1 != null && var1 instanceof String && this.map.containsKey(this.normalize((String)var1));
    }
    
    @Override
    public boolean containsValue(final Object var1) {
        return this.map.containsValue(var1);
    }
    
    @Override
    public List<String> get(final Object var1) {
        return this.map.get(this.normalize((String)var1));
    }
    
    public String getFirst(final String var1) {
        final List<String> var2 = this.map.get(this.normalize(var1));
        return (var2 == null) ? null : var2.get(0);
    }
    
    @Override
    public List<String> put(final String var1, final List<String> var2) {
        return this.map.put(this.normalize(var1), var2);
    }
    
    public void add(final String var1, final String var2) {
        final String var3 = this.normalize(var1);
        List var4 = this.map.get(var3);
        if (var4 == null) {
            var4 = new LinkedList();
            this.map.put(var3, var4);
        }
        var4.add(var2);
    }
    
    public void set(final String var1, final String var2) {
        final LinkedList var3 = new LinkedList();
        var3.add(var2);
        this.put(var1, (List<String>)var3);
    }
    
    @Override
    public List<String> remove(final Object var1) {
        return this.map.remove(this.normalize((String)var1));
    }
    
    @Override
    public void putAll(final Map<? extends String, ? extends List<String>> var1) {
        this.map.putAll(var1);
    }
    
    @Override
    public void clear() {
        this.map.clear();
    }
    
    @Override
    public Set<String> keySet() {
        return this.map.keySet();
    }
    
    @Override
    public Collection<List<String>> values() {
        return this.map.values();
    }
    
    @Override
    public Set<Entry<String, List<String>>> entrySet() {
        return this.map.entrySet();
    }
    
    @Override
    public boolean equals(final Object var1) {
        return this.map.equals(var1);
    }
    
    @Override
    public int hashCode() {
        return this.map.hashCode();
    }
}
