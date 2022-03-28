package com.springjpadata.Spring.Jpa.data.repository;

import com.springjpadata.Spring.Jpa.data.model.User;

public interface CustomUserRepository {

    User customFindMethod(Long id);

}