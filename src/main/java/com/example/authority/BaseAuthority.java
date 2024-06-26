package com.example.authority;

import com.example.util.JwtUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * author:Ben
 */
public class BaseAuthority implements AuthorityVerify{
    @Override
    public Boolean authorityVerify(HttpServletRequest request, String[] permissions) {
        if(!JwtUtils.checkToken(request)){
            return false;
        }
        Long uId = JwtUtils.getUserId(request);
        for (String permission : permissions) {
            if(!AuthorityUtils.verify(uId,permission)){
                return false;
            }
        }
        return true;
    }
}
