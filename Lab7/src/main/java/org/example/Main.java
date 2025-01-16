package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void scriere(List<InstrumentMuzical> lista) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/muzica.json");

            // din lab ne zice sa scriem
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<InstrumentMuzical> citire() {
        try {
            File file=new File("src/main/resources/muzica.json");
            ObjectMapper mapper=new ObjectMapper();
            List<InstrumentMuzical> persoane = mapper
                    .readValue(file, new TypeReference<List<InstrumentMuzical>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Set<InstrumentMuzical> instrumente = new HashSet<>();

        Chitara chitara1 = new Chitara("AAA", 1500, TipChitara.ELECTRICA, 6);
        Chitara chitara2 = new Chitara("BBB", 2000, TipChitara.ACUSTICA, 6);
        Chitara chitara3 = new Chitara("CCC", 1200, TipChitara.CLASICA, 7);

        SetTobe setTobe1 = new SetTobe("DDD", 2500, TipTobe.ACUSTICE, 5, 2);
        SetTobe setTobe2 = new SetTobe("EEE", 3000, TipTobe.ELECTRONICE, 6, 3);
        SetTobe setTobe3 = new SetTobe("FFF", 2800, TipTobe.ACUSTICE, 4, 2);

        instrumente.add(chitara1);
        instrumente.add(chitara2);
        instrumente.add(chitara3);
        instrumente.add(setTobe1);
        instrumente.add(setTobe2);
        instrumente.add(setTobe3);


        for (InstrumentMuzical instrument : instrumente) {
            System.out.println(instrument);
        }
    }
}