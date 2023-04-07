package com.baanBaini.BaanBaini.admin.serviceImplementation;

import com.baanBaini.BaanBaini.admin.model.dto.AdminDTO;
import com.baanBaini.BaanBaini.admin.model.entity.AdminEntity;
import com.baanBaini.BaanBaini.admin.repository.AdminRepository;
import com.baanBaini.BaanBaini.admin.service.AdminLoginService;
import com.baanBaini.BaanBaini.configuration.security.Authority;
import com.baanBaini.BaanBaini.shared.utility.MapperUtility;
import com.baanBaini.BaanBaini.shared.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminLoginServiceImplementation implements AdminLoginService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    MapperUtility mapperUtility;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utility utility;

    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        AdminEntity adminEntity = mapperUtility.mapModel(adminDTO, AdminEntity.class);
        adminEntity.setPassword(bCryptPasswordEncoder.encode(adminDTO.getPassword()));
        adminEntity.setPublicAdminId(utility.getRandomString("ADM",12));
        adminEntity.setAccountEnabled(true);
        ArrayList<String> auths = new ArrayList<>();
        auths.add(Authority.ROLE_ADMIN);
        adminEntity.setAuthorities(auths);
        adminEntity = adminRepository.save(adminEntity);
        return mapperUtility.mapModel(adminEntity, AdminDTO.class);
    }

    @Override
    public AdminDTO getAdminByEmail(String email) {
        AdminEntity admin = adminRepository.findByEmail(email);
        if (admin != null)
            return mapperUtility.mapModel(admin, AdminDTO.class);
        else
            return null;
    }

    @Override
    public AdminDTO getAdminByPublicUserId(String publicUserId) {
        AdminEntity admin = adminRepository.findByPublicAdminId(publicUserId);
        if (admin != null)
            return mapperUtility.mapModel(admin, AdminDTO.class);
        else
            return null;
    }
}
