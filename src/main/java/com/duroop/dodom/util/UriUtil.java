package com.duroop.dodom.util;

import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriUtil {

    public static URI createUri(String defaultUri, Long Id){
        return UriComponentsBuilder.newInstance()
                .path(defaultUri + "/{id}")
                .buildAndExpand(Id).toUri();

    }
}
