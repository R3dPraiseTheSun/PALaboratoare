package commands;

import catalog.Catalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public interface Info {
    static void info(Catalog catalog) throws IOException, TikaException, SAXException {
        File file = new File(catalog.getPath());

        Parser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = new FileInputStream(file);
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);

        System.out.println( " metadata elements and values of the given file :");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }
}
