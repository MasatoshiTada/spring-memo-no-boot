package com.example.springmemo;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.File;

public class SpringMemoApplication {

    public static void main(String[] args) throws Exception {
        // jul-to-slf4jのインストール
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        
        // 組み込みTomcatの起動
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9000);
        StandardContext ctx = (StandardContext) tomcat.addWebapp("", new File("src/main/webapp/").getAbsolutePath());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(
                resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);
        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();
    }

}
