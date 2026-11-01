package impl.symbol;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    protected final Map<String, Symbol> symbols = new LinkedHashMap<>();
    private final Scope parent;
    public Scope(Scope parent) { this.parent = parent; }
    public Scope getParent() { return parent; }
    public Collection<Symbol> getLocalSymbols() {
        return Collections.unmodifiableCollection(symbols.values());
    }

    public boolean define(Symbol symbol) {
        String name = symbol.getName();
        if (symbols.containsKey(name)) {
            return false;
        }
        symbols.put(name, symbol);
        return true;
    }


    public Symbol resolveLocal(String name) {
        return symbols.get(name);
    }

    
    public Symbol resolve(String name) {
        for (Scope s = this; s != null; s = s.getParent()) {
            Symbol sym = s.resolveLocal(name);
            if (sym != null) {
                return sym;
            }
        }
        return null;
    }
}