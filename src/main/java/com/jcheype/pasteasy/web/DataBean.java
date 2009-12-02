package com.jcheype.pasteasy.web;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Julien Cheype
 *         Date: Dec 1, 2009
 *         Time: 5:43:09 PM
 */
public class DataBean implements Serializable {
    private String language;
    private String data;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + language.hashCode();
        result = prime * result + data.hashCode();
        return result;
    }
}
