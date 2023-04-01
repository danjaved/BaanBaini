package com.baanBaini.BaanBaini.configuration.security.service;

import com.baanBaini.BaanBaini.configuration.security.model.ActiveTokensEntity;
import com.baanBaini.BaanBaini.configuration.security.repository.ActiveTokensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveTokenServiceImplementation implements ActiveTokenService{
    @Autowired
    ActiveTokensRepository activeTokensRepository;
    @Override
    public void addToken(String userId, String token) {
        ActiveTokensEntity activeTokens =activeTokensRepository.findByUserId(userId);
        if(activeTokens==null)
            activeTokens=new ActiveTokensEntity(userId,token);
        else{
            activeTokens.getTokens().add(token);
        }
        activeTokensRepository.save(activeTokens);
    }

    @Override
    public boolean validateToken(String userId, String token) {
        ActiveTokensEntity activeTokens =activeTokensRepository.findByUserId(userId);
        if(activeTokens !=null && activeTokens.getTokens().contains(token))
            return true;
        return false;
    }

    @Override
    public boolean removeToken(String userId, String token) {
        ActiveTokensEntity activeTokens =activeTokensRepository.findByUserId(userId);
        if (activeTokens !=null) {
            activeTokens.getTokens().remove(token);
            activeTokensRepository.save(activeTokens);
        }
        return true;
    }

    @Override
    public boolean removeAllTokens(String userId) {
        activeTokensRepository.deleteByUserId(userId);
        return true;
    }

}
