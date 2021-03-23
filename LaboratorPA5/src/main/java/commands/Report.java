package commands;

import catalog.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public interface Report {
    static void report(Catalog catalog) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\paula\\Desktop\\LaboratorPA5\\src\\main\\java\\resources"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);

        /* Create a data-model */
        Map root = new HashMap();


        root.put("name", catalog.getName());
        root.put("items", catalog.getItemList());

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("template.ftl");

        /* Merge data-model with template */
        Writer outputFile = new FileWriter(new File(catalog.getPath() + catalog.getName() + ".html"));
        temp.process(root, outputFile);
    }
}
