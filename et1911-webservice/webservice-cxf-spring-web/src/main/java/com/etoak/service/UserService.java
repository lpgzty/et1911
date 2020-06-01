package com.etoak.service;

import com.etoak.bean.User;

import javax.jws.WebService;

/**
 * Created by LPG on 2020-06-01.
 */
@WebService
public interface UserService {
    User getById(int id);


}
