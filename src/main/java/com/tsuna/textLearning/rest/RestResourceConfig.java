/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : ResourceConfig.java
 *  Date : 18-6-10 下午4:22
 */

package com.tsuna.textLearning.rest;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api/*")
public class RestResourceConfig extends ResourceConfig {
    public RestResourceConfig() {
        packages("com.tsuna.textLearning.rest.resource");
    }
}
