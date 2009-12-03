package com.jcheype.pasteasy.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import javax.annotation.Resource;
import java.io.Writer;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Julien Cheype
 *         Date: Dec 1, 2009
 *         Time: 5:32:48 PM
 */

@Controller
public class PasteController {
    @Autowired
    Cache pastedataCache;

    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public @ModelAttribute("dataBean") DataBean show(Integer id) {
        Element e = pastedataCache.get(id);
        if(e == null){
            DataBean dataBean = new DataBean();
            dataBean.setLanguage("java");
            dataBean.setData("import java.util.Map;\n\nclass Gava{");
            return dataBean;
        }
        return (DataBean) e.getObjectValue();
    }

    @RequestMapping(value = "/add.do")
    public void add(String data, String language, Integer lineNumber, Writer out ) throws IOException {
        DataBean dataBean = new DataBean();
        dataBean.setLanguage(language);
        dataBean.setData(data);
        dataBean.setFirstLineNumber(lineNumber);
        Integer code = Math.abs(dataBean.hashCode());
        pastedataCache.put(new Element(code, dataBean));
        out.write(""+code);
    }
}
