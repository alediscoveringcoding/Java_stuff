package ex2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Vers {

    private final String vers;

    public Vers(String vers) {
        this.vers = vers;
    }

    public long getNumarCuvinte() {
        return Arrays.stream(vers.split("\\s+")).filter(s -> !s.isEmpty()).count();
    }

    public long getNumarVocale() {
        return vers.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count();
    }

    public boolean seIncheieCu(String grupare) {
        return vers.endsWith(grupare);
    }

    @Override
    public String toString() {
        return vers;
    }
}
