package com.example.demo.service;

import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.UserEntity;

@Service
public class UserService {
        
        @Autowired
        private UserRepository userRepository;
        
        public String createUser() {
                UserEntity userEntity = new UserEntity();
                userEntity.setFirstName("太郎");
                userEntity.setLastName("田中");
                userEntity.setEmail("hoge@hoge.com");
                userRepository.save(userEntity);
                return "ユーザ追加をしました。";
        }
        
        public List<UserEntity> getUser() {
                return userRepository.findAll();
        }
}