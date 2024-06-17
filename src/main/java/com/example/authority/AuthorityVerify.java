package com.example.authority;

import javax.servlet.http.HttpServletRequest;

/**
 * author:Ben
 */
public interface AuthorityVerify {
    Boolean authorityVerify(HttpServletRequest request,String[] permissions);
}
